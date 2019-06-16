package cn.idragonboat.controller;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.idragonboat.service.UserService;
import cn.idragonboat.vo.UserVO;

@Controller
public class UserContorller {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/findUserInfo/{uid}")
	@ResponseBody
	public UserVO findUserInfo(@PathVariable String uid) throws ApplicationException {
		return userService.findUserInfo(uid);
	}
	
}
