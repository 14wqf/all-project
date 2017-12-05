package com.wqf.users;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.wqf.users.dao.UserDao;
import com.wqf.users.domain.User;
import com.wqf.users.service.UserService;

@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UsersApplicationTests {
	
	private Logger logger = Logger.getLogger(UsersApplicationTests.class);
	
	 @Autowired
	 UserDao userdao;
	 	 
	@Test
	public void contextLoads() {
		 List<User> users = userdao.selectAll();
		 logger.info(JSON.toJSONString(users));
//	        System.out.println(users.get(0).getUsername());
	}
}
