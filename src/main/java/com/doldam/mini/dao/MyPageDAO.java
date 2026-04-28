package com.doldam.mini.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.doldam.mini.dto.MyPageDTO;
import com.doldam.mini.dto.SeasonDTO;
import com.doldam.mini.dto.SeasonReplyDTO;
import com.doldam.mini.dto.UserDTO;

@Mapper
@Repository
public interface MyPageDAO {
	// 마이페이지 내가쓴 글
	public List<SeasonDTO> selectMySeason(String userID);
	// 마이페이지 내가쓴 댓글
	public List<SeasonReplyDTO> selectMyCommentList(String userID);
	// 회원선택
	public UserDTO userSelect(String userID);
	// 회원정보수정(DB)
	public int userUpdate(UserDTO dto);
	// 페이징용
	public int selectMySeasonCount(@Param("userID") String userID); // 총 글 수
    List<SeasonDTO> selectMySeasonPaging(@Param("userID") String userID,
            @Param("offset") int offset,
            @Param("limit") int limit);
    // 댓글 총 갯수
    public int selectMyCommentCount(@Param("userID") String userID);
    // 페이지별 댓글 조회
    List<SeasonReplyDTO> selectMyCommentPaging(@Param("userID") String userID,
                                          @Param("offset") int offset,
                                          @Param("limit") int limit);
    // 지도
    public List<SeasonDTO> selectLikeMap(String userID);
}