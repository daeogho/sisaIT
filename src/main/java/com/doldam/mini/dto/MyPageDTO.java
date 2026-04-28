package com.doldam.mini.dto;

import lombok.Data;

@Data
public class MyPageDTO {
	private int no;
	private String subject;
	private String context;
	private String userID;
	private String writedate;
	private int hit;
	private String season;
	
	// 마이페이지 추가
	private String thumbnail;
	private int mapno;
	private String comment;
	private String commentDate;
	private String addrtitle;
	
	// 마이페이지 지도 DTO
	private double lat;
	private double lng;
}