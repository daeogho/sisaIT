package com.doldam.mini.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doldam.mini.dao.SeasonReplyDAO;
import com.doldam.mini.dto.SeasonReplyDTO;
import com.doldam.mini.service.SeasonReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SeasonReplyController {
	@Inject
	SeasonReplyService service;

	//댓글 목록
	@GetMapping("/season/reply/list/{no}")
	@ResponseBody
	public List<SeasonReplyDTO> seasonReplyList(@PathVariable("no") int no){
		
	    return service.replySelect(no); 
	}
	//댓글 등록
    @PostMapping("/season/reply/write")
    @ResponseBody
    public String replyWrite(SeasonReplyDTO dto, HttpSession session, Model model) {
        String logId = (String)session.getAttribute("logId");

        model.addAttribute("logId", logId);

        if(logId == null || logId.equals("")) {
            return "2"; // 로그인이 필요하다는 신호를 보냄 (1은 성공, 2는 로그인 필요)
        }
        dto.setUserID(logId);
        int result = service.replyWrite(dto);
        return result + "";
    }
	//댓글 수정(DB update)
	@PostMapping("/season/reply/editOk")
	@ResponseBody
	public String seasonReplyEditOk(SeasonReplyDTO dto) {
		int result = service.replyUpdate(dto);
		return result + "";
	}
	//댓글삭제
	@GetMapping("/season/reply/del/{comment_no}")
	@ResponseBody
	public String SeasonReplyDelete(@PathVariable("comment_no") int comment_no, HttpSession session) {			
		String userID=(String)session.getAttribute("logId");
		
		return service.replyDelete(comment_no, userID)+"";
	}
}

