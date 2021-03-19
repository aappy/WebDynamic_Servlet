package dao;

import vo.User;

  public interface UserDao {
	public void addUser(User user);
	public User getUser(int id);
	public void updateUser(User user);
	public void deleteUser(int id);

}
