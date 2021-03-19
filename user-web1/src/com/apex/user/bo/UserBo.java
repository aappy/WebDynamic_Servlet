package com.apex.user.bo;

import vo.User;

public interface UserBo {
    
	public void addUser(User user);
	public User getUser(int id);
	public void updateUser(User user);
	public void deleteUser(int id);
}
