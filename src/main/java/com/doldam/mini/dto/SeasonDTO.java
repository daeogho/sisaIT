package com.doldam.mini.dto;

import java.util.List;

import lombok.Data;

@Data
public class SeasonDTO {
	private int no;
	private String subject;
	private String context;
	private String userID;
	private String writedate;
	private int hit;
	private String season;
	private String thumbnail;
	private String addrtitle;
	private String username;
	private double lat;
	private double lng;
	private int isLike;
}
