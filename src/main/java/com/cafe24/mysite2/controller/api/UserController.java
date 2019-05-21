package com.cafe24.mysite2.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite2.dto.JSONResult;
import com.cafe24.mysite2.service.UserService;

@Controller("userAPIController")
@RequestMapping("/user/api")
public class UserController 
{
	private static final Log LOG = LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkemail")
	public JSONResult checkEmail(@RequestParam(value="email", required=true, defaultValue="") String email) {
		Boolean exist = userService.existEmail(email);
		LOG.info("exist:["+exist+"]");
		return JSONResult.success(exist);
	}
}
