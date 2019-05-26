package com.cafe24.mysite2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite2.repository.BoardDao;
import com.cafe24.mysite2.util.Paging;
import com.cafe24.mysite2.vo.BoardVo;

@Service
public class BoardService 
{
	
	@Autowired
	private BoardDao boardDao;
	
	public void boardWrite(BoardVo boardVo)
	{
		boardDao.write(boardVo);
	}
	
	public List<BoardVo> boardList(Paging pagination)
	{
		return boardDao.getList(pagination);
	}
	
	public BoardVo boardView(Long board_no)
	{
		return boardDao.getView(board_no);
	}	
	
	public BoardVo replyWrite(Long group_no, Long depth, Long order_no)
	{
		boardDao.updateOrderNo(order_no);
		
		BoardVo vo = new BoardVo();
		
		vo.setGroup_no(group_no);
		vo.setOrder_no(order_no+1);
		vo.setDepth(depth+1);
		return vo;
	}
	
	public void modify(BoardVo boardVo)
	{
		boardDao.modify(boardVo);
	}
	
	public void replyBoardInsert(BoardVo boardVo)
	{
		boardDao.replyBoardInsert(boardVo);
	}
	
	
	public void hitUp(Long board_no)
	{
		boardDao.hitUp(board_no);
	}
	
	public void deleteBoard(Long board_no)
	{
		boardDao.delete(board_no);
	}
	
	public long getListCount()
	{
		return boardDao.getListCount();
	}
	
}
