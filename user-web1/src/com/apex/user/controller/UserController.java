package com.apex.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.apex.user.bo.UserBo;

import vo.User;
@Controller
public class UserController {
	@AutoWired
	UserBo userBo = null;
	
	@RequestMapping("/entryAddUser.do")//person.do
	public String entrAddUser(@ModelAttribute User user) {
	return "person"; 
	}
	
	@RequestMapping("/processaddUser.do")
	public String processAddUser(@ModelAttribute User user) {
	
	System.out.println("UserController: processaddUser : Start");
	//read	
	System.out.println("The first name:" + user.getFirstName());
    //Step2 processing 
	userBo.addUser(user);
	//step 3 : response back
	System.out.println("UserController: processaddUser : Start");
	return "success"; 
	}
}
