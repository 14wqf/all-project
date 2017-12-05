package com.wqf.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wqf.users.dao.UserDao;
import com.wqf.users.domain.User;
import com.wqf.users.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserDao userDao;
	
	@Override            
	//重写父类方法
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}
	
}
