package com.doldam.mini.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.doldam.mini.dao.SeasonReplyDAO;
import com.doldam.mini.dto.PagingVO;
import com.doldam.mini.dto.SeasonDTO;
import com.doldam.mini.service.LikeService;
import com.doldam.mini.service.SeasonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SeasonController {
	
	@Inject
	SeasonService service;
	
	@Inject
	LikeService likeService;
	
	//게시글 목록
	@GetMapping("/season/list")
	public ModelAndView seasonList(PagingVO pVO, @RequestParam(value="season") String season, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List<SeasonDTO> list = service.seasonPageSelect(pVO);
		
		String logId = (String)session.getAttribute("logId");
		if(logId != null) {
	        for(SeasonDTO dto : list) {
	            int isLike = likeService.likeCheck(dto.getNo(), logId); 
	            dto.setIsLike(isLike);
	        }
	    }
		
		pVO.setLogId(logId);
		pVO.setSeason(season);
		pVO.setTotalRecord(service.totalRecord(pVO));
		
		//해당 페이지의 레코드 선택
		mav.addObject("list", list);
		mav.addObject("pVO", pVO);
		mav.addObject("pickSeason", season);
		//---------------------------------------
		mav.setViewName("season/"+season);
		return mav;
	}
	//게시글 이미지 등록
	@PostMapping("/season/imageUpload")
	@ResponseBody
	public Map<String, Object> imageUpload(@RequestParam("image") MultipartFile image,HttpServletRequest request){
		Map<String, Object> result= new HashMap<String, Object>();
		
		// 이미지 저장 서버 경로 설정
		String uploadPath = request.getSession().getServletContext().getRealPath("/resources/upload/");
		File dir = new File(uploadPath);
		if(!dir.exists()) dir.mkdirs(); // 폴더가 없으면 생성
		
		// 파일 이름 중복 방지
		String originalName = image.getOriginalFilename();
		String extension = originalName.substring(originalName.lastIndexOf("."));
		String savedName = UUID.randomUUID().toString()+extension;
		
		try {
			//파일 저장
			image.transferTo(new File(uploadPath, savedName));
			
			//url주소 리턴
			String fileUrl = request.getContextPath()+"/resources/upload/"+savedName;
			result.put("url", fileUrl);
			result.put("uploaded", 1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@GetMapping("/season/{season}View")
	public ModelAndView SpringView(@RequestParam("no") int no,
			@PathVariable("season") String season,
			@RequestParam(value="nowPage", defaultValue="1") int nowPage,
            @RequestParam(value="searchKey", required=false) String searchKey,
            @RequestParam(value="searchWord", required=false) String searchWord,
            HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		//조회수 증가
		service.hitCount(no);
		
		SeasonDTO ss = service.seasonSelect(no);
		
		//좋아요 확인
		String logId = (String)session.getAttribute("logId");
		if(logId != null) {
	        // likeService를 사용하여 이 사용자가 이 글(no)을 좋아하는지 확인
	        int isLike = likeService.likeCheck(no, logId); 
	        ss.setIsLike(isLike);
	    }
		
		//dto(season=ss)에 담기, 글 번호 데이터 가져오기
		PagingVO pVO = new PagingVO();
		pVO.setNowPage(nowPage);
		pVO.setSearchKey(searchKey);
		pVO.setSearchWord(searchWord);
		
		mav.addObject("ss", ss);
		mav.addObject("pVO", pVO);
		mav.addObject("pickSeason", season);
		
		//뷰 이름 설정
		mav.setViewName("season/"+season+"View");
		
		return mav;
	}
	@GetMapping("/season/seasonForm")
	public String seasonForm() {
		return "season/seasonForm";
	}
	//글쓰기 DB연결
	@PostMapping("/season/writeOk")
	public String writeOk(SeasonDTO dto, HttpSession session) {
	    // 1. 세션에서 로그인 아이디 가져오기
	    String logId = (String)session.getAttribute("logId"); 
	    
	    // 2. 로그인 체크
	    if (logId == null) {
	        return "redirect:/login"; 
	    }
	    
	    //썸네일 자동 추출
	    String context = dto.getContext();
	    // context가 null이 아닐 때만 실행하도록 체크 추가
	    if(context != null && context.contains("<img")) {
	        int start = context.indexOf("src=\"") + 5;
	        int end = context.indexOf("\"", start);
	        
	        if (start > 4 && end > start) { // 인덱스 범위 체크
	            String firstImageUrl = context.substring(start, end);
	            String thumbnailName = firstImageUrl.substring(firstImageUrl.lastIndexOf("/") + 1);
	            dto.setThumbnail(thumbnailName);
	        }
	    }
	    
	    // 3. DTO에 아이디 설정 및 DB 저장
	    dto.setUserID(logId);
	    int result = service.seasonInsert(dto);
	    
	    // 4. 결과에 따른 리다이렉트 (ModelAndView 객체 생성 없이 바로 문자열 리턴)
	    if(result > 0) {
	        return "redirect:/season/list?season=" + dto.getSeason();
	    } else {
	        return "redirect:/season/seasonForm";
	    } 
	}
	// 1. 수정 페이지 진입 (기존 데이터 불러오기)
	// 주소 하나로 통일하고, 필요한 pVO 데이터도 함께 가져가도록 구성합니다.
	@GetMapping("/season/seasonEdit")
	public ModelAndView seasonEditForm(@RequestParam("no") int no, PagingVO pVO) {
	    ModelAndView mav = new ModelAndView();
	    
	    // DB에서 기존 글 정보 조회
	    SeasonDTO dto = service.seasonSelect(no); 
	    
	    if(dto == null) {
	        // 데이터가 없으면 리스트로 튕겨내거나 에러 페이지 유도
	        mav.setViewName("redirect:/season/list?season=spring"); 
	        return mav;
	    }
	     
	    mav.addObject("ss", dto);
	    mav.addObject("pVO", pVO);
	    mav.setViewName("season/edit");
	    return mav;
	}
	//2. 수정 정보 보내기
	@PostMapping("/season/editOk")
	public String seasonEditOk(SeasonDTO dto, PagingVO pVO) {
	    // 썸네일 추출 로직 (writeOk에 있는 것과 동일하게 적용 권장)
	    String context = dto.getContext();
	    if(context != null && context.contains("<img")) {
	        int start = context.indexOf("src=\"") + 5;
	        int end = context.indexOf("\"", start);
	        if (start > 4 && end > start) {
	            String firstImageUrl = context.substring(start, end);
	            String thumbnailName = firstImageUrl.substring(firstImageUrl.lastIndexOf("/") + 1);
	            dto.setThumbnail(thumbnailName);
	        }
	    }

	    int result = service.seasonUpdate(dto);
	    
	    if(result > 0) {
	        // 수정 후 상세 페이지로 리다이렉트
	        return "redirect:/season/" + dto.getSeason() + "View?no=" + dto.getNo() + "&nowPage=" + pVO.getNowPage();
	    } else {
	        return "redirect:/season/edit?no=" + dto.getNo();
	    }
	}
	//삭제
	@GetMapping("/season/del")
	public String seasonDel(int no) {
	    SeasonDTO dto = service.seasonSelect(no);
	    
	    String season = dto.getSeason(); 

	    service.seasonDelete(no);
	    
	    return "redirect:/season/list?season=" + season;
	}
}
