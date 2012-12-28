package com.example.mycomponent.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneBook {
	public List<Entry> entries;

	public PhoneBook() {
		entries = new ArrayList<Entry>();
		entries.add(new Entry("xuebaocha", "11111111"));
		entries.add(new Entry("LinDaiYu", "22222222"));
		entries.add(new Entry("JiaYingChun", "33333333"));
		entries.add(new Entry("JiaTanChun", "44444444"));
		entries.add(new Entry("JiaXiChun", "55555555"));
		entries.add(new Entry("ShiXiangYun", "66666666"));
		entries.add(new Entry("LiWan", "77777777"));
	}

	public List<String> selectNamesByKey(String key) {
		List<String> matches = new ArrayList<String>();
		for (Iterator<Entry> iter = entries.iterator(); iter.hasNext();) {
			Entry entry = iter.next();
			if (entry.getName().toLowerCase().startsWith(key.toLowerCase())) {
				matches.add(entry.getName());
			}
		}
		return matches;
	}

	public Entry selectByName(String name) {
		for (Iterator<Entry> iter = entries.iterator(); iter.hasNext();) {
			Entry entry = iter.next();
			if (entry.getName().equals(name)) {
				return entry;
			}
		}
		return null;
	}

	public void update(String key, Entry newEntry) {
		for (Iterator<Entry> iter = entries.iterator(); iter.hasNext();) {
			Entry e = iter.next();
			if (e.getName().equals(key)) {
				e.setName(newEntry.getName());
				e.setNumber(newEntry.getNumber());
			}
		}
	}
}
