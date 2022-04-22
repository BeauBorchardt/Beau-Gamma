package com.madlib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MadLibDAOImpl implements MadLibDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public void createMadlib(UserModel user, MadLibModel madlib) {
		// TODO Auto-generated method stub
		try {
			// This is our query to be executed
			String query = "INSERT into Mad_Libs (story_name, noun, adjective, verb, adverb, user_id) VALUES (?, ?, ?, ?, ?, ?)";
			
			//Create a prepared statement to run our query through our connection
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			// Set the values for the placeholders in the query
			pstmt.setString(1, madlib.storyName);
			pstmt.setString(2, madlib.noun);
			pstmt.setString(3, madlib.adjective);
			pstmt.setString(4, madlib.verb);
			pstmt.setString(5, madlib.adverb);
			pstmt.setInt(6, user.userId);
			
			pstmt.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public MadLibModel loadMadlib(UserModel user, String name) {
		// TODO Auto-generated method stub
		
		try {
			// Step 1
			String query = "SELECT * FROM Mad_Libs WHERE user_id = ? AND story_name = ?";
			PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);
			
			//Set the username filter value (ie the ?)
			statement.setInt(1, user.userId);
			statement.setString(2, name);
			ResultSet rs = statement.executeQuery();
			
				// user exists
				MadLibModel m = new MadLibModel();
				m.noun = rs.getString("noun");
				m.adverb = rs.getString("adverb");
				m.verb = rs.getString("verb");
				m.adjective = rs.getString("adjective");
				m.storyName = rs.getString("story_name");
				m.user_id = rs.getInt("user_id");
				m.madLibId = rs.getInt("id");
				return m;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
