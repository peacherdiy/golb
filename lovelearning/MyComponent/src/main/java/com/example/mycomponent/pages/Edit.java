package com.example.mycomponent.pages;

import java.util.List;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.ajax.MultiZoneUpdate;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.example.mycomponent.entity.Entry;
import com.example.mycomponent.entity.PhoneBook;

public class Edit {

	@Property
	private String name;

	@Property(write = false)
	private Entry entry = new Entry();

	@Inject
	private Block viewBlock;

	@Property
	private String oldName;

	@Component
	private Form editForm;

	@SessionState
	private PhoneBook phoneBook;

	@Component
	private Zone loadZone;

	Form onActionFromEdit(String aName) {
		oldName = aName;
		entry = phoneBook.selectByName(aName);
		return editForm;
	}

	List<String> onProvideCompletionsFromName(String key) {
		return phoneBook.selectNamesByKey(key);
	}

	Block onSuccessFromLoadForm() {
		entry = phoneBook.selectByName(name);
		return viewBlock;
	}

	/**
	 * 
	 * @return
	 *TODO 返回 多个 更新区域 , 有问题,估计是新版本有变化 查查API  
	 */
	Block onSuccessFromEditForm() {
		phoneBook.update(oldName, entry);
		//return viewBlock;
		name = entry.getName(); 
		return (Block) new MultiZoneUpdate("theZone", viewBlock).add("loadZone", loadZone.getBody());
	}
}
