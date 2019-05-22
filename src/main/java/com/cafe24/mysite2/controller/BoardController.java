package com.cafe24.mysite2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite2.service.BoardService;
import com.cafe24.mysite2.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController 
{
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String list(Model model)
	{
		List<BoardVo> boardList = boardService.boardList();
		model.addAttribute("list",boardList);
		return "board/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write()
	{
		return "board/write";
	}

	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute BoardVo boardVo)
	{
		boardService.boardWrite(boardVo);
		
		return "redirect:/board";
	}
	
	@RequestMapping("/view")
	public String view(Model model, @RequestParam("no") Long board_no)
	{
		BoardVo boardView = boardService.boardView(board_no);
		model.addAttribute("view", boardView);
		return "board/view";
	}
	
	@RequestMapping("/replyBoard")
	public String replayBoard(@RequestParam("o") Long order_no, @RequestParam("d") Long depth, Model model)
	{
		
		return "board/write";
	}
}
