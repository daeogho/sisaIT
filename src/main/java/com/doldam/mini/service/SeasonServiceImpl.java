package com.doldam.mini.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doldam.mini.dao.LikeDAO;
import com.doldam.mini.dao.SeasonDAO;
import com.doldam.mini.dao.SeasonReplyDAO;
import com.doldam.mini.dto.PagingVO;
import com.doldam.mini.dto.SeasonDTO;

@Service
public class SeasonServiceImpl implements SeasonService {
	@Autowired
	SeasonDAO dao;
	
	@Autowired
	SeasonReplyDAO rdao;
	
	@Autowired
	LikeDAO ldao;
	
	@Override
	public int seasonInsert(SeasonDTO dto) {
		return dao.seasonInsert(dto);
	}

	@Override
	public int totalRecord(PagingVO pVO) {
		return dao.totalRecord(pVO);
	}

	@Override
	public List<SeasonDTO> seasonPageSelect(PagingVO pVO) {
		return dao.seasonPageSelect(pVO);
	}

	@Override
	public SeasonDTO seasonSelect(int no) {
		return dao.seasonSelect(no);
	}

	@Override
	public void hitCount(int no) {
		dao.hitCount(no);
	}

	@Override
	public int seasonUpdate(SeasonDTO dto) {
		return dao.seasonUpdate(dto);
	}
	
	@Override
    @Transactional
    public int seasonDelete(int no) {
        // 1. 댓글부터 싹 지우기 (댓글 DAO의 메서드 호출)
		rdao.replyDeleteAllByBoardNo(no);
		
		// 라이크 지우기
		ldao.likeDeleteAllByBoardNo(no);
        
        // 2. 그 다음 게시글 지우기 (게시글 DAO의 메서드 호출)
		return dao.seasonDelete(no);
    }
}