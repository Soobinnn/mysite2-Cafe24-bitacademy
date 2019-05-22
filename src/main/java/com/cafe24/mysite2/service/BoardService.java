package com.cafe24.mysite2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite2.repository.BoardDao;
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
	
	public List<BoardVo> boardList()
	{
		return boardDao.getList();
	}
	
	public BoardVo boardView(Long board_no)
	{
		return boardDao.getView(board_no);
	}	
}
