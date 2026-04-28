package com.doldam.mini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doldam.mini.dao.SeasonReplyDAO;
import com.doldam.mini.dto.SeasonReplyDTO;

@Service
public class SeasonReplyServiceImpl implements SeasonReplyService {
	@Autowired
	SeasonReplyDAO dao;

	@Override
	public List<SeasonReplyDTO> replySelect(int no) {
		return dao.replySelect(no);
	}

	@Override
	public int replyWrite(SeasonReplyDTO dto) {
		return dao.replyWrite(dto);
	}

	@Override
	public int replyUpdate(SeasonReplyDTO dto) {
		return dao.replyUpdate(dto);
	}

	@Override
	public int replyDelete(int comment_no, String userID) {
		return dao.replyDelete(comment_no, userID);
	}
}
