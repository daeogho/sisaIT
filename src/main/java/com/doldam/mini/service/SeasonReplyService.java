package com.doldam.mini.service;

import java.util.List;

import com.doldam.mini.dto.SeasonReplyDTO;

public interface SeasonReplyService {
	public List<SeasonReplyDTO> replySelect(int no);
	public int replyWrite(SeasonReplyDTO dto);
	public int replyUpdate(SeasonReplyDTO dto);
	public int replyDelete(int comment_no, String userID);
}
