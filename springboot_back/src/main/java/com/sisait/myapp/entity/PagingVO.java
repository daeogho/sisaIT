package com.sisait.myapp.entity;

import lombok.ToString;

// 페이징시 필요한  변수
// 검색기능 구현에 필요한 변수
@ToString
public class PagingVO {
	// 현재 페이지 번호
	private int nowPage = 1;
	
	
	private int onePageRecord = 5;// 한페이지에 표시할 레코드 수
	private int totalRecord; // 총레코드 수 : db조회
	private int totalPage; // 총레코드수와 한 페이지에 표시하는 레코드 수로 계산
	
	// 레코드 선택시 시작위치 offset계산하기
	private int offsetPoint ;
	
	// 한번에 표시할 페이지 번호 갯수
	private int onePageNumCount =5;
	
	// 페이지 번호 만들 때 필요한 시작페이지 번호
	private int startPage = 1;
	
	// 검색어
	private String searchKey;
	private String searchWord;
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		offsetPoint = (nowPage - 1) * onePageRecord;
		// paging 출력시 시작페이지 계산
		startPage = (nowPage-1)/onePageNumCount * onePageNumCount + 1;
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
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// 총페이지 수
		if(totalRecord % onePageRecord == 0) {
			totalPage = totalRecord / onePageRecord;		
		}else {
			totalPage = totalRecord / onePageRecord + 1;
		}
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
	public void pageSetting() {
		// TODO Auto-generated method stub
		
	}
	
	
}
