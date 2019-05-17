package com.cafe24.mysite2.exception;

public class UserDaoException extends RuntimeException
{
	private static final long serialVersionUID =1L;
	
	public UserDaoException()
	{
		
	}
	
	public UserDaoException(String message)
	{
		super(message);
	}
}
