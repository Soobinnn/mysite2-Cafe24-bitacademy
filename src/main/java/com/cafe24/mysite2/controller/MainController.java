package com.cafe24.mysite2.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite2.exception.GlobalExceptionHandler;
import com.cafe24.mysite2.vo.UserVo;

@Controller
public class MainController {

	//private static final Log LOG = LogFactory.getLog(MainController.class);
	
	@RequestMapping( {"/", "/main"} )
	public String main() {
		return "main/index";
	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello()
	{
		return "<h1>안녕하세요</h1>";
	}
	
	@ResponseBody
	@RequestMapping("/hello2")
	public UserVo hello2()
	{
		UserVo vo = new UserVo();
		vo.setNo(10L);
		vo.setName("임수빈");
		vo.setEmail("isb9082@naver.com");
		return vo;
	}
}
