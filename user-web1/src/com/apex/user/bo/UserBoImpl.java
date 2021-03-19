package com.apex.user.bo;

import org.springframework.stereotype.Service;

import com.apex.user.controller.AutoWired;

import dao.UserDao;
import vo.User;
@Service
public class UserBoImpl implements UserBo{
	@AutoWired
	UserDao userdao = null;
	
	@Override
	public void addUser(User user) {
		System.out.println("UserBoImpl: addUser : Start");
		userdao.addUser(user);
		System.out.println("UserBoImpl: addUser : End");
		
	}
	
	@Override
	public User getUser(int id) {

		return null;
	}

	@Override
	public void updateUser(User user) {
	
		
	}

	@Override
	public void deleteUser(int id) {
		
	}

}
