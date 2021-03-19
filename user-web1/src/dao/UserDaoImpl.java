package dao;

import org.springframework.stereotype.Repository;

import vo.User;
@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public void addUser(User user) {
		System.out.println("UserDaoImpl: addUser : Start");
		System.out.println("UserDaoImpl: addUser : End");	
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
