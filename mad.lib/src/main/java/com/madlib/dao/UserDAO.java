package com.madlib.dao;

public interface UserDAO {
	
	public UserModel getUser(String username, String password);
	
	public  void createUser(UserModel user);
	
	public void updateUser(UserModel user);
	
	

}
