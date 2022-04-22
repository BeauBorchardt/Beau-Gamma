package com.madlib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO{
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public UserModel getUser(String username, String password) {
		try {
			
			String query = "SELECT * FROM users WHERE username = ? AND user_password = ?";
			PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				UserModel user = new UserModel();
				user.userId = rs.getInt("id");
				user.username = rs.getString("username"); 
				user.password = rs.getString("user_password");
				return user;
				
			} else return null; // user does not exist
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
public void createUser(UserModel newUser) {
		
		try {
			// This is our query to be executed
			String query = "INSERT into Users (username, user_password) VALUES (?, ?)";
			
			//Create a prepared statement to run our query through our connection
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			// Set the values for the placeholders in the query
			pstmt.setString(1, newUser.username);
			pstmt.setString(2, newUser.password);
			
			pstmt.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(UserModel user) {
		// TODO Auto-generated method stub
		
	}

}
