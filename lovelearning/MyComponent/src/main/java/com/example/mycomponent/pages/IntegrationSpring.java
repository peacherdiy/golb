package com.example.mycomponent.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.tapestry5.annotations.Property;

import com.example.mycomponent.entity.Entry;

public class IntegrationSpring {

	@Property
	private Entry entry = new Entry();

	void onSuccess() throws ClassNotFoundException, SQLException {
		Class.forName("org.gjt.mm.mysql.Driver");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myexample", "root", "111");
			st = conn.prepareStatement("insert into phonebook(name, number) values (?, ?)");
			st.setString(1, entry.getName());
			st.setString(2, entry.getNumber());
			st.execute();
		} finally {
			st.close();
			conn.close();
		}
	}
}
