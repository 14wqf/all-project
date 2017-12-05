package com.wqf.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wqf.users.domain.User;
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
    @RequestMapping("/user/login")
    @ResponseBody
    public Boolean loginUser(@RequestBody User user, Model model) {
        Boolean result = false;
        if (userService.checkLogin(user) != null) {
            model.addAttribute("user", user);
            result = true;
        }

        return result;
    }
    
    @RequestMapping("/user/regist")
    @ResponseBody
    public Boolean registUser(@RequestBody User user, Model model) {
        Boolean result = false;
        if (userService.checkRegist(user) == null) {
            userService.addUser(user);
            model.addAttribute("user", user);
            result = true;
        }
        return result;
    }
    
}