package com.doldam.mini.controller;

import java.util.List;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doldam.mini.dto.MyPageDTO;
import com.doldam.mini.dto.MyPagePagingVO;
import com.doldam.mini.dto.PagingVO;
import com.doldam.mini.dto.SeasonDTO;
import com.doldam.mini.dto.SeasonReplyDTO;
import com.doldam.mini.dto.UserDTO;
import com.doldam.mini.service.MyPageService;
import com.doldam.mini.service.SeasonService;
import com.doldam.mini.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyPageController {
	@Autowired
	UserService service;
	@Autowired
	MyPageService myPageservice;

	// 마이페이지로 이동
	@GetMapping("/mypage/mypage")
	public ModelAndView myPage(@RequestParam(value = "page", defaultValue = "1") int page,
							   @RequestParam(value = "tab", defaultValue = "post") String tab,
							   HttpSession session) {

		String logId = (String) session.getAttribute("logId");
		if (logId == null) {
			return new ModelAndView("redirect:/user/login"); // 로그인 안 됨
		}

		ModelAndView mav = new ModelAndView("mypage/mypage");

		// 회원 정보 조회
		UserDTO dto = myPageservice.userSelect(logId);
		mav.addObject("dto", dto);

		// 작성글 페이징 처리
		MyPagePagingVO seasonPageVO = new MyPagePagingVO();
		seasonPageVO.setNowPage(page);

		int totalSeasonRecord = myPageservice.getMySeasonCount(logId);
		seasonPageVO.setTotalRecord(totalSeasonRecord);

		List<SeasonDTO> mySeasonList = myPageservice.selectMySeasonPaging(logId, seasonPageVO);
		System.out.println("총 글 수: " + totalSeasonRecord);
		System.out.println("총 페이지: " + seasonPageVO.getTotalPage() + ", 현재 페이지: " + seasonPageVO.getNowPage());
		mav.addObject("mySeasonList", mySeasonList);
		mav.addObject("seasonPageVO", seasonPageVO); // JSP에서 반복문에 사용

		// 댓글 페이징 처리 (선택적으로)
		MyPagePagingVO commentPageVO = new MyPagePagingVO();
		commentPageVO.setNowPage(page);

		int totalCommentRecord = myPageservice.getMyCommentCount(logId);
		commentPageVO.setTotalRecord(totalCommentRecord);

		List<SeasonReplyDTO> myCommentList = myPageservice.selectMyCommentPaging(logId, commentPageVO);
		mav.addObject("myCommentList", myCommentList);
		mav.addObject("commentPageVO", commentPageVO); // JSP에서 반복문에 사용
		
		//좋아요한 게시글 지도 데이터
		List<SeasonDTO> likeMapList = myPageservice.selectLikeMap(logId);
		mav.addObject("likeMapList", likeMapList);
		// 현재 활성 탭을 JSP로 전달
	    mav.addObject("activeTab", tab);
	    
		return mav;
	}

	// 회원정보수정으로 이동
	@GetMapping("mypage/userEdit")
	public ModelAndView userEdit(HttpSession session) {
		String userID = (String) session.getAttribute("logId");
		UserDTO dto = myPageservice.userSelect(userID);

		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("mypage/userEdit");

		return mav;
	}

	// 회원정보수정(DB업데이트) : 아이디와 비번이 같은 회원의 정보를 수정
    @PostMapping("/mypage/userEditOk")
    public ModelAndView userEditOk(UserDTO dto, HttpSession session, RedirectAttributes rttr) {

        String logId = (String) session.getAttribute("logId");
        if (logId == null) {
            return new ModelAndView("redirect:/users/logid"); // 로그인 안되어있으면 로그인페이지로
        }

        // 현재 로그인 유저 정보 가져오기
        UserDTO dbUser = myPageservice.userSelect(logId);

        // 비밀번호 확인
        if (!dbUser.getUserpwd().equals(dto.getUserpwd())) {
            rttr.addFlashAttribute("msg", "비밀번호가 틀렸습니다.");
            return new ModelAndView("redirect:/mypage/userEdit");
        }

        dto.setUserID(logId);

        int result = myPageservice.userUpdate(dto);

        ModelAndView mav = new ModelAndView();
        if (result < 1) {// 수정 실패 -> 수정폼으로 이동
            mav.setViewName("redirect:userEdit");
            rttr.addFlashAttribute("msg", "수정에 실패하였습니다.");
        } else {// 수정 성공 -> 홈
            rttr.addFlashAttribute("msg", "회원정보가 수정되었습니다!");
            mav.setViewName("redirect:/");
        }
        return mav;
    }

	// 메일서비스를 할 수 있는 객체를 생성
	@Autowired
	private JavaMailSenderImpl javaMail;

	// 문의하기로 이동
	@GetMapping("mypage/mypageQna")
	public String mypageQna() {
		return "mypage/mypageQna";
	}

	// 메일 전송
	@PostMapping("/mypage/qna")
	public String emailSend(String to, String subject, String content, HttpSession session, RedirectAttributes rttr) {
		UUID uuid = UUID.randomUUID();
		log.info("UUID=>" + uuid.toString());

		String logId = (String) session.getAttribute("logId");

		UserDTO user = myPageservice.userSelect(logId);
		String userEmail = user.getEmail();

		try {
			MimeMessage message = javaMail.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");

			messageHelper.setFrom("eogh8995@naver.com", logId + "(돌담회원)"); // 보내는 사람 이메일 주소
			messageHelper.setTo("eogh8995@naver.com"); // 받는 사람 이메일 주소

			messageHelper.setReplyTo(userEmail); // 보내는 사람?
			messageHelper.setSubject("[돌담 문의]" + subject); // 메일제목

			/*
			 * content = "<div><img src='${ctx}/resources/image/qnaImg.jpg'/>작성자 ID : " +
			 * logId + "<br>" + "작성자 이메일 : " + userEmail + "<br><br>" + "문의내용<br>" +
			 * content+"</div>";
			 */
			
			String imgUrl = "https://i.pinimg.com/236x/25/06/5a/25065a742f08f6a26afc678b8d887942.jpg";

			String mailContent = 
			    "<table width='600' cellpadding='0' cellspacing='0' border='0' "
			  + "style='font-family:Arial, sans-serif; color:white; text-shadow:0 0 5px black;'>"
			  + "  <tr>"
			  + "    <td background='" + imgUrl + "' height='350' "
			  + "        style='background-size:cover; padding:30px;'>"

			  + "      <h2 style='margin:0; font-size:26px;'>[돌담 문의] " + subject + "</h2>"
			  + "      <p style='margin-top:20px; font-size:16px;'>"
			  + "        <strong>작성자 ID:</strong> " + logId + "<br>"
			  + "        <strong>작성자 이메일:</strong> " + userEmail + "<br>"
			  + "      </p>"

			  + "      <h3 style='margin-top:20px; font-size:18px;'>문의 내용</h3>"
			  + "      <p style='white-space:pre-line; font-size:16px; margin:0;'>"
			  +          content
			  + "      </p>"

			  + "    </td>"
			  + "  </tr>"
			  + "</table>";
			
			
			messageHelper.setText(mailContent, true); // 메일내용

			// 메일 보내기
			javaMail.send(message);
			rttr.addFlashAttribute("msg", "문의가 정상적으로 접수되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			log.info("메일발송 실패" + e.getMessage());
			rttr.addFlashAttribute("msg", "문의 전송에 실패했습니다.");
		}

		return "redirect:/mypage/mypage";
	}

}