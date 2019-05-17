package com.cafe24.mysite2.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler (UserDaoException.class)
	public String handleUserDaoException(HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException 
	{
		//1. 로깅
		e.printStackTrace();
		StringWriter errors = new StringWriter();
		
		e.printStackTrace(new PrintWriter(errors));
		//logger.error(errors.toString());
		System.out.println(errors.toString());
		
		//2. 안내페이지 가기 + 정상종료(response)
		request.setAttribute("uri",request.getRequestURI());
		request.setAttribute("exception",errors.toString());
		
		request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(request, response);
		
		return "error/exception";
	
	}
}