package com.doldam.mini.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.doldam.mini.dto.PagingVO;
import com.doldam.mini.dto.SeasonDTO;

@Mapper
@Repository
public interface SeasonDAO {
	//뉴스 등록
	public int seasonInsert(SeasonDTO dto);
	//총 레코드 수
	public int totalRecord(PagingVO pVO);
	//해당 페이지 레코드 선택
	public List<SeasonDTO> seasonPageSelect(PagingVO pVO);
	//해당 레코드 선택
	public SeasonDTO seasonSelect(int no);
	//조회수 증가
	public void hitCount(int no);
	//수정
	public int seasonUpdate(SeasonDTO dto);
	//삭제
	public int seasonDelete(int no);
}
