package com.cafe24.mysite2.vo;

import java.util.Date;

public class BoardVo 
{
	private Long board_no;
	private String title;
	private String contents;
	private Long hit;
	private Date reg_date;
	private Long group_no;
	private Long order_no;
	private Long depth_no;
	private Long no;
	
	public Long getBoard_no() {
		return board_no;
	}
	public void setBoard_no(Long board_no) {
		this.board_no = board_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Long getGroup_no() {
		return group_no;
	}
	public void setGroup_no(Long group_no) {
		this.group_no = group_no;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Long getDepth_no() {
		return depth_no;
	}
	public void setDepth_no(Long depth_no) {
		this.depth_no = depth_no;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	
	
}
