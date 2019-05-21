package com.cafe24.mysite2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.mysite2.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController 
{
	@RequestMapping("")
	public String list()
	{
		return "board/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write()
	{
		return "board/write";
	}

	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute BoardVo boardVo, Model model)
	{
		return "redirect:/board/list";
	}
}
