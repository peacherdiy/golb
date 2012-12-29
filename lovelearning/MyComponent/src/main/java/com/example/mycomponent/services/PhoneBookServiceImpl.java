package com.example.mycomponent.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.mycomponent.entity.Entry;

public class PhoneBookServiceImpl implements PhoneBookService {

	private final ConnectionPool connectionPool;

	public PhoneBookServiceImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	public void save(Entry entry) {
//		try {
//			Class.forName("org.gjt.mm.mysql.Driver");
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
		Connection conn = null;
		PreparedStatement st = null;
		try {
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myexample", "root", "111");
			//st = conn.prepareStatement("insert into phonebook(name, number) values (?, ?)");
			conn = connectionPool.getConnection();
			st = conn.prepareStatement("insert into phonebook(name, number) values (?, ?)");
			st.setString(1, entry.getName());
			st.setString(2, entry.getNumber());
			st.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				st.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}
