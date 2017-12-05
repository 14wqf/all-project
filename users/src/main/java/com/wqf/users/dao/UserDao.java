package com.wqf.users.dao;

import java.util.List;

import com.wqf.users.domain.User;

public interface UserDao {
	
	
	/**
     * 查询所有的用户
     * @return 用户列表
     */
	List<User> selectAll();
	
	
	 /**
     * 根据用户名查询，用作检查注册
     * @param user
     * @return
     */
    User selectByUsername(User user);
    

    /**
     * 根据用户名和密码查询用户,用作检查登录
     * @return 用户
     */
    User selectByUsernameAndPassword(User user);
    

    /**
     * 插入一个用户
     * @param user
     */
    void insert(User user);
    

    /**
     * 根据删除用户
     * @param id
     */
    void deleteById(Integer id);

}
