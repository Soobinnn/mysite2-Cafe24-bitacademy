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
	private Long depth;
	private Long no;
	private String name;
	
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
	
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BoardVo [board_no=" + board_no + ", title=" + title + ", contents=" + contents + ", hit=" + hit
				+ ", reg_date=" + reg_date + ", group_no=" + group_no + ", order_no=" + order_no + ", depth=" + depth
				+ ", no=" + no + ", name=" + name + "]";
	}
	
	
}
