package com.wqf.users.dao;

import java.util.List;

import com.wqf.users.domain.User;

public interface UserDao {
	/**
     * 查询所有的用户
     * @return 用户列表
     */
	List<User> selectAll();
}
