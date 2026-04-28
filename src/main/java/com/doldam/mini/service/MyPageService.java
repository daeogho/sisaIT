package com.doldam.mini.service;

import java.util.List;

import com.doldam.mini.dto.MyPagePagingVO;
import com.doldam.mini.dto.SeasonDTO;
import com.doldam.mini.dto.SeasonReplyDTO;
import com.doldam.mini.dto.UserDTO;

public interface MyPageService {
	// 마이페이지 게시글 가져오기
	public List<SeasonDTO> selectMySeason(String userID);
	// 마이페이지 내가 쓴 댓글
	public List<SeasonReplyDTO> selectMyCommentList(String userID);
	//회원정보수정
	public  UserDTO userSelect(String userID);
	//회원정보수정(DB)
	public int userUpdate(UserDTO dto);
	
	// 페이징
    int getMySeasonCount(String userID);  // 작성글 총 갯수
    List<SeasonDTO> selectMySeasonPaging(String userID, MyPagePagingVO pageVO); // 페이지별 글

    int getMyCommentCount(String userID);  // 댓글 총 갯수
    List<SeasonReplyDTO> selectMyCommentPaging(String userID, MyPagePagingVO pageVO); // 페이지별 댓글
    
    // 지도
    public List<SeasonDTO> selectLikeMap(String userID);

}