package cn.idragonboat.service.impl;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.idragonboat.dao.UserDao;
import cn.idragonboat.service.UserService;
import cn.idragonboat.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserVO findUserInfo(String uid) throws ApplicationException {
		return userDao.findUserInfo(uid);
	}

}
