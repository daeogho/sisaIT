package com.doldam.mini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doldam.mini.dao.MyPageDAO;
import com.doldam.mini.dto.MyPagePagingVO;
import com.doldam.mini.dto.SeasonDTO;
import com.doldam.mini.dto.SeasonReplyDTO;
import com.doldam.mini.dto.UserDTO;

@Service
public class MyPageServiceImple implements MyPageService {
	@Autowired
	MyPageDAO dao;

	// 마이페이지 게시글 가져오기
	@Override
	public List<SeasonDTO> selectMySeason(String userID) {
		return dao.selectMySeason(userID);
	}
	// 마이페이지 내가 쓴 댓글
	@Override
	public List<SeasonReplyDTO> selectMyCommentList(String userID) {
		return dao.selectMyCommentList(userID);
	}
	// 회원정보선택
	public UserDTO userSelect(String userID) {
		return dao.userSelect(userID);
	}
	// 회원정보수정
	public int userUpdate(UserDTO dto) {
		return dao.userUpdate(dto);
	}
	// 페이징 처리
	@Override
	public int getMySeasonCount(String userID) {
		return dao.selectMySeasonCount(userID);
	}
	@Override
	public List<SeasonDTO> selectMySeasonPaging(String userID, MyPagePagingVO pageVO) {
		return dao.selectMySeasonPaging(userID, pageVO.getOffsetPoint(), pageVO.getOnePageRecord());
	}
	@Override
	public int getMyCommentCount(String userID) {
		return dao.selectMyCommentCount(userID);
	}
	@Override
	public List<SeasonReplyDTO> selectMyCommentPaging(String userID, MyPagePagingVO pageVO) {
		return dao.selectMyCommentPaging(userID, pageVO.getOffsetPoint(), pageVO.getOnePageRecord());
	}
	@Override
	public List<SeasonDTO> selectLikeMap(String userID) {
		return dao.selectLikeMap(userID);
	}

}