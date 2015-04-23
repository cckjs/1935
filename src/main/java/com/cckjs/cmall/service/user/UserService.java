package com.cckjs.cmall.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cckjs.cmall.dao.user.UserDao;
import com.cckjs.cmall.model.user.UserModel;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public UserModel getUser(Integer id){
		return userDao.findOne(id);
	}
}
