package com.example.mycomponent.pages;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;

import com.example.mycomponent.dao.PhoneBookDao;
import com.example.mycomponent.entity.Entry;

public class ShowAll {
	@Inject
	private PhoneBookDao phoneBookDao;

	public List<Entry> getEntries() {
		return phoneBookDao.findAll();
	}
}
