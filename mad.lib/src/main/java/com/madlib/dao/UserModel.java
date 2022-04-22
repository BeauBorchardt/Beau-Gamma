package com.madlib.dao;

public class UserModel {
	public int userId;
	public String username;
	public String password;
	
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}
	public UserModel(int userId, String username, String password){
		this.userId = userId;
		this.username = username;
		this.password = password;
		}
	public UserModel(){
		
		}

}
