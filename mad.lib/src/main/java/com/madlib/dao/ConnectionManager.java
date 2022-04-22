package com.madlib.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	
	private static Connection connection;
	
	private static String connectionString = "jdbc:postgresql://heffalump.db.elephantsql.com:5432/myfxjpal",
			username = "myfxjpal",
			password = "X1CVwzxQFQTmu9sWiHxxEJ3zr6jVjeD4";
	
	public static Connection getConnection() {
		try {
			if(connection == null || connection.isClosed()) {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(connectionString, username, password);
			}
			return connection;
			} catch (Exception e) {
			
			} return null;
	}

}
