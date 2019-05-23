package com.cafe24.mysite2.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite2.vo.BoardVo;


@Repository
public class BoardDao 
{
	@Autowired
	private SqlSession sqlSession;
	
	public void write(BoardVo boardVo)
	{
		sqlSession.insert("board.insert", boardVo);
	}

	public List<BoardVo> getList()
	{
		return sqlSession.selectList("board.getList");
	}
	
	public BoardVo getView(Long board_no)
	{
		return sqlSession.selectOne("board.getView", board_no);
	}
	
	public void updateOrderNo(Long order_no)
	{
		sqlSession.update("board.updateOrderNo", order_no);
	}
	
	public void modify(BoardVo boardVo)
	{
		sqlSession.update("board.modify", boardVo);
	}
	
	public void replyBoardInsert(BoardVo boardVo)
	{
		sqlSession.insert("board.replyBoardInsert", boardVo);
	}
	
	public void hitUp(Long board_no)
	{
		sqlSession.update("board.hitUp", board_no);
	}
}
