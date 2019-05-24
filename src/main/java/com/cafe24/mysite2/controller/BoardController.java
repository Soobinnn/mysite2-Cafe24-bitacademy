package com.cafe24.mysite2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
		if("".equals(boardVo.getGroup_no())||boardVo.getGroup_no()==null)
		{
			boardService.boardWrite(boardVo);
		}
		else
		{
			boardService.replyBoardInsert(boardVo);
		}
		
		return "redirect:/board";
	}
	
	@RequestMapping("/view")
	public String view(Model model, @RequestParam("no") Long board_no)
	{	
		/*//저장된 쿠키 불러오기
		Cookie cookies[] = request.getCookies(); 
		Map mapCookie = new HashMap(); 
		if(request.getCookies() != null)
		{ 
			for (int i = 0; i < cookies.length; i++) 
			{ 
				Cookie obj = cookies[i]; 
				mapCookie.put(obj.getName(),obj.getValue()); 
				} 
			} 
		
		// 저장된 쿠키중에 read_count 만 불러오기 
		String cookie_read_count = (String) mapCookie.get("read_count"); 
		
		// 저장될 새로운 쿠키값 생성 
		String new_cookie_read_count = "|" + board_no; 
		// 저장된 쿠키에 새로운 쿠키값이 존재하는 지 검사 
		if ( StringUtils.indexOfIgnoreCase(cookie_read_count, new_cookie_read_count) == -1 ) 
		{ 
			// 없을 경우 쿠키 생성 
			Cookie cookie = new Cookie("read_count", cookie_read_count + new_cookie_read_count); 
			//cookie.setMaxAge(1000); 
			// 초단위 
			response.addCookie(cookie); 
			// 조회수 업데이트 
			this.bbsDao.updateReadCount(board_no); 
		}*/
		

		/*if(boardService.cookieCheck(board_no))
		{
			boardService.hitUp(board_no);
		}*/
		
		boardService.hitUp(board_no);
		
		BoardVo boardView = boardService.boardView(board_no);
		model.addAttribute("view", boardView);
		return "board/view";
	}
	
	@RequestMapping("/modify")
	public String modify(@ModelAttribute BoardVo boardVo,Model model)
	{
		System.out.println(boardVo.toString());
		model.addAttribute("view",boardVo);
		return "board/modify";
	}
	
	@RequestMapping("/modifySuccess")
	public String modifySuccess(@ModelAttribute BoardVo boardVo,Model model)
	{		
		boardService.modify(boardVo);
		return "redirect:/board/view?no="+boardVo.getBoard_no();
	}
	
	@RequestMapping("/replyBoard")
	public String replayBoard(@RequestParam("g") Long group_no, @RequestParam("d") Long depth,@RequestParam("o") Long order_no, Model model)
	{
		BoardVo replyWrite = boardService.replyWrite(group_no, depth, order_no);
		model.addAttribute("replyBoard", replyWrite);
		
		return "board/write";
	}
	
}
