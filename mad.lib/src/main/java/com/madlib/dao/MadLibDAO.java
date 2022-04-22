package com.madlib.dao;

public interface MadLibDAO {
	
	public void createMadlib(UserModel user, MadLibModel madlib);
	public MadLibModel loadMadlib(UserModel user,String name);

}
