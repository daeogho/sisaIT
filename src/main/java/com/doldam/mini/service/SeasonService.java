package com.doldam.mini.service;

import java.util.List;

import com.doldam.mini.dto.PagingVO;
import com.doldam.mini.dto.SeasonDTO;

public interface SeasonService {
	public int seasonInsert(SeasonDTO dto);
	public int totalRecord(PagingVO pVO);
	public List<SeasonDTO> seasonPageSelect(PagingVO pVO);
	public SeasonDTO seasonSelect(int no);
	public void hitCount(int no);
	public int seasonUpdate(SeasonDTO dto);
	public int seasonDelete(int no);
}