package com.example.mycomponent.dao;

import java.util.List;

import com.example.mycomponent.entity.Entry;

public interface PhoneBookDao {
	List<Entry> findAll();
}
