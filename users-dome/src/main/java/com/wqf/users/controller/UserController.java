package com.wqf.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wqf.users.service.UserService;
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	
    @RequestMapping("/user/showAllUser")
    public ModelAndView showAllUser(ModelAndView mv) {
        mv.addObject("users", userService.findAllUser());
        mv.setViewName("showAllUser");
        return mv;
        
        
//	@RequestMapping(value="/user/showAllUser",method=RequestMethod.GET)
//	public ResponseEntity showAllUser() {
//		List<User> a = userService.findAllUser();
//		return new ResponseEntity(a,HttpStatus.OK);
	}
}