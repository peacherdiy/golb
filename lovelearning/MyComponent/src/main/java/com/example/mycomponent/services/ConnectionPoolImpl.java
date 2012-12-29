package com.example.mycomponent.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPoolImpl implements ConnectionPool {

	public Connection getConnection() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/myexample", "root", "111");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
}