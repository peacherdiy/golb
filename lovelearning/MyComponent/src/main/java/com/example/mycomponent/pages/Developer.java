package com.example.mycomponent.pages;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;

import com.example.mycomponent.dao.ToolsDao;
import com.example.mycomponent.entity.Tools;

public class Developer {
	@Inject
	private ToolsDao toolsDao;

	public List<Tools> getEntries() {
		return toolsDao.findAll();
	}
}
