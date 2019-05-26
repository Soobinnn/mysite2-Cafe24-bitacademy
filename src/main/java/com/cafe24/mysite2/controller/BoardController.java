package com.cafe24.mysite2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite2.service.BoardService;
import com.cafe24.mysite2.util.Paging;
import com.cafe24.mysite2.util.Search;
import com.cafe24.mysite2.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController 
{
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String list(Model model, @RequestParam(required = false, defaultValue="1") long page, 
			@RequestParam(required=false, defaultValue="1") long range,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String kwd)
	{
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKwd(kwd);
		
		//전체 게시글 개수
		long listCnt = boardService.getListCount(search);

		search.pageInfo(page, range, listCnt);

		List<BoardVo> boardList = boardService.boardList(search);
		
		model.addAttribute("pagination", search);
		model.addAttribute("list",boardList);
		
		System.out.println(search.toString());
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
		System.out.println(boardVo.toString());
		if(boardVo.getGroup_no()==null)
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
	public String view(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("no") Long board_no)
	{	
		int countCheck = 0;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) 
		{
		   for (int i = 0; i < cookies.length; i++) 
		   {
			   if(cookies[i].getName().equals("hitUp"+board_no))
			   {
				   countCheck = 0;
				   break;
			   }
			   else
			   {
				   Cookie cookie = new Cookie("hitUp"+board_no, String.valueOf(board_no));
				   cookie.setMaxAge(60*60*24);
				   cookie.setPath("/");
				   response.addCookie(cookie);

				   countCheck += 1;
			   }
		   }
		 }
		//상세정보 조회시 카운트 증가
		if(countCheck > 0)
		{
			boardService.hitUp(board_no);
		}
		
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
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("n") Long board_no)
	{
		boardService.deleteBoard(board_no);
		return "redirect:/board";
	}
}
