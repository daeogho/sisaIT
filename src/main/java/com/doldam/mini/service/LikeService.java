package com.doldam.mini.service;

import org.apache.ibatis.annotations.Param;

public interface LikeService {
	int likeCheck(@Param("no") int no, @Param("logId") String logId);
    int likeInsert(@Param("no") int no, @Param("logId") String logId);
    int likeDelete(@Param("no") int no, @Param("logId") String logId);
}
