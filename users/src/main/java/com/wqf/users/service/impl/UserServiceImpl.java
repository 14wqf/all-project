package com.wqf.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public User checkLogin(User user) {
        return userDao.selectByUsernameAndPassword(user);
    }

    @Override
    public User checkRegist(User user) {
        return userDao.selectByUsername(user);
    }


	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}  
    
}
