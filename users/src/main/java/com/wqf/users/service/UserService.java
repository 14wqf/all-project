package com.wqf.users.service;

import java.util.List;

import com.wqf.users.domain.User;

//Dao的门面
public interface UserService {
	/**
     * 查询出所有用户
     * @return 所有用户列表
     */
	List<User>findAllUser();

	void deleteUserById(Integer id);

	User checkLogin(User user);

	User checkRegist(User user);

	void addUser(User user);



	
	
}
