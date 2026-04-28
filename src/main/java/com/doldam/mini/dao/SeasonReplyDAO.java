package com.doldam.mini.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.doldam.mini.dto.SeasonReplyDTO;

@Mapper
@Repository
public interface SeasonReplyDAO {
	//댓글 목록
	public List<SeasonReplyDTO> replySelect(int no);
	//댓글 등록
	public int replyWrite(SeasonReplyDTO dto);
	//댓글 수정
	public int replyUpdate(SeasonReplyDTO dto);
	//댓글 삭제
	public int replyDelete(int comment_no, String userID);
	//글 삭제하면 댓글도 같이 삭제
	public int replyDeleteAllByBoardNo(int no);
}
