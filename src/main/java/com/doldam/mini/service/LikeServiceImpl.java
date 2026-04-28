package com.doldam.mini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doldam.mini.dao.LikeDAO;

@Service
public class LikeServiceImpl implements LikeService {
	@Autowired
	LikeDAO dao;

	@Override
	public int likeCheck(int no, String logId) {
		return dao.likeCheck(no, logId);
	}

	@Override
	public int likeInsert(int no, String logId) {
		return dao.likeInsert(no,logId);
	}

	@Override
	public int likeDelete(int no, String logId) {
		return dao.likeDelete(no, logId);
	}
}
