package com.cafe24.mysite2.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite2.repository.UserDao;
import com.cafe24.mysite2.vo.UserVo;



@Service
public class UserService {
	
	private static final Log LOG = LogFactory.getLog(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	public Boolean existEmail(String email) {
		UserVo userVo = userDao.get(email);
		LOG.info("UserService[userVo]:["+userVo+"]");
		return userVo != null;
	}
	
	public Boolean join(UserVo userVo) {
		return userDao.insert(userVo);
	}

	public UserVo getUser(Long no) {
		return userDao.get(no) ;
	}
	
	public UserVo getUser(UserVo userVo) {
		return userDao.get(userVo.getEmail(), userVo.getPassword());
	}
	
	public boolean updateUser( UserVo userVo ) {
		return userDao.update( userVo ) == 1;
	}
	
}
