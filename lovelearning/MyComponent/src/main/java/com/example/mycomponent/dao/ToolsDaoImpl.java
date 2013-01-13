package com.example.mycomponent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.example.mycomponent.entity.Tools;

public class ToolsDaoImpl extends JdbcDaoSupport implements ToolsDao {

	public List<Tools> findAll() {
		final List<Tools> entries = new ArrayList<Tools>();
		getJdbcTemplate().query("select name, description, downUrl from tools",
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						do {
							Tools entry = new Tools(rs.getString("name"), rs.getString("description"), rs.getString("downUrl"));
							entries.add(entry);
						} while (rs.next());
					}
				});
		return entries;
	}
}
