package com.cafe24.mysite2.util;

public class Paging 
{
	private long listSize = 10;                //초기값으로 목록개수를 10으로 셋팅
	private long rangeSize = 10;            //초기값으로 페이지범위를 10으로 셋팅
	private long page;
	private long range;
	private long listCnt;
	private long pageCnt;
	private long startPage;
	private long startList;
	private long endPage;
	
	private boolean prev;
	private boolean next;

	public long getRangeSize() {

		return rangeSize;

	}

	public long getPage() {

		return page;

	}

	public void setPage(long page) {

		this.page = page;

	}

	public long getRange() {

		return range;

	}

	public void setRange(long range) {

		this.range = range;

	}

	public long getStartPage() {

		return startPage;

	}

	public void setStartPage(long startPage) {

		this.startPage = startPage;

	}

	public long getEndPage() {

		return endPage;

	}

	public void setEndPage(long endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;

	}

	public boolean isNext() {

		return next;

	}

	public void setNext(boolean next) {

		this.next = next;

	}

	public long getListSize() {

		return listSize;

	}

	public void setListSize(long listSize) {

		this.listSize = listSize;

	}

	public long getListCnt() {

		return listCnt;

	}

	public void setListCnt(long listCnt) {

		this.listCnt = listCnt;

	}

	

	public long getStartList() {

		return startList;

	}

	public void pageInfo(long page, long range, long listCnt) 
	{

		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		//전체 페이지수 
		System.out.println("------------뭐야아아"+listCnt);
		this.pageCnt = (long) Math.ceil((double)listCnt/(double)listSize);
		//시작 페이지
		this.startPage = (range - 1) * rangeSize + 1 ;

		//끝 페이지
		this.endPage = range * rangeSize;

		//게시판 시작번호
		this.startList = (page - 1) * listSize;

		//이전 버튼 상태
		this.prev = range == 1 ? false : true;

		//다음 버튼 상태
		this.next = endPage > pageCnt ? false : true;
		if (this.endPage > this.pageCnt) 
		{
			this.endPage = this.pageCnt;
			this.next = false;
		}

	}

	@Override
	public String toString() {
		return "Paging [listSize=" + listSize + ", rangeSize=" + rangeSize + ", page=" + page + ", range=" + range
				+ ", listCnt=" + listCnt + ", pageCnt=" + pageCnt + ", startPage=" + startPage + ", startList="
				+ startList + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + "]";
	}
	
}
