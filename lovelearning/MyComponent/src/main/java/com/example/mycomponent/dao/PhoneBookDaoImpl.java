package com.example.mycomponent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.example.mycomponent.entity.Entry;

public class PhoneBookDaoImpl extends JdbcDaoSupport implements PhoneBookDao {

	public List<Entry> findAll() {
		final List<Entry> entries = new ArrayList<Entry>();
		getJdbcTemplate().query("select name, number from phonebook",
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						do {
							Entry entry = new Entry(rs.getString("name"), rs.getString("number"));
							entries.add(entry);
						} while (rs.next());
					}
				});
		return entries;
	}
}
