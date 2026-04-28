package com.doldam.mini.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LikeDAO {
	int likeCheck(@Param("no") int no, @Param("logId") String logId);
    int likeInsert(@Param("no") int no, @Param("logId") String logId);
    int likeDelete(@Param("no") int no, @Param("logId") String logId);
    //글 삭제하면 라이크도 같이 삭제
  	public int likeDeleteAllByBoardNo(int no);
}