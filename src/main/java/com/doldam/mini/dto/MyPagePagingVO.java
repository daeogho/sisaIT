package com.doldam.mini.dto;

import lombok.ToString;

@ToString
public class MyPagePagingVO {
	private int nowPage=1;
	private int onePageRecord= 9;
	private int totalRecord;
	private int totalPage;
	private int offsetPoint;
	//한 번에 표시할 번호 개수
	private int onePageNumCount = 9;
	//시작 페이지 번호
	private int startPage = 1;
	private String season;
	private String searchKey;
    private String searchWord;
	
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		//레코드 선택 시 시작 위치 계산
		offsetPoint = (nowPage-1)*onePageRecord;
		//paging 출력 시 시작 페이지 계산
		startPage=(nowPage-1)/onePageNumCount*onePageNumCount+1;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		//총 페이지 수 계산
		// 32 ->7
		if(totalRecord%onePageRecord==0) {
			totalPage = totalRecord / onePageRecord;
		}else {
			totalPage = totalRecord / onePageRecord + 1;
		}
	}

	
	
	public int getNowPage() {
		return nowPage;
	}
	public int getOnePageRecord() {
		return onePageRecord;
	}
	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getOffsetPoint() {
		return offsetPoint;
	}
	public void setOffsetPoint(int offsetPoint) {
		this.offsetPoint = offsetPoint;
	}
	public int getOnePageNumCount() {
		return onePageNumCount;
	}
	public void setOnePageNumCount(int onePageNumCount) {
		this.onePageNumCount = onePageNumCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
}