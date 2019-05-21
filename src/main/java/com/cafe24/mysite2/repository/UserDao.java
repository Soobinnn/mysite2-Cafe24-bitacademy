package com.cafe24.mysite2.repository;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite2.controller.MainController;
import com.cafe24.mysite2.exception.UserDaoException;
import com.cafe24.mysite2.vo.UserVo;

@Repository
public class UserDao 
{
	private static final Log LOG = LogFactory.getLog(UserDao.class);
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo get(String email) {
		LOG.info("UserDao[email]:["+email+"]");
		return sqlSession.selectOne("user.getByEmail", email);
	}
	
	public UserVo get(Long no){
		return sqlSession.selectOne("user.getByNo", no);
	}
	
	public UserVo get(String email, String password) throws UserDaoException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		UserVo userVo = sqlSession.selectOne("user.getByEmailAndPassword", map);
		
		return userVo;
	}	
	
	public Boolean insert(UserVo vo) {
		System.out.println(vo);
		int count = sqlSession.insert("user.insert", vo);
		System.out.println(vo);
		return 1 == count;
	}
	
	public int update( UserVo userVo ) {
		return sqlSession.update( "user.update", userVo );
	}
}
