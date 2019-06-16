package cn.idragonboat.service;

import org.omg.CORBA.portable.ApplicationException;

import cn.idragonboat.vo.UserVO;

public interface UserService {
	
	UserVO findUserInfo(String uid) throws ApplicationException;
	
}
