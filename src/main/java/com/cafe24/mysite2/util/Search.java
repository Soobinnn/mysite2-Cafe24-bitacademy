package com.cafe24.mysite2.util;

public class Search extends Paging
{
	private String searchType;
	private String kwd;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKwd() {
		return kwd;
	}
	public void setKwd(String kwd) {
		this.kwd = kwd;
	}
	@Override
	public String toString() {
		return "Search [searchType=" + searchType + ", kwd=" + kwd + "]";
	}	
	
	
}
