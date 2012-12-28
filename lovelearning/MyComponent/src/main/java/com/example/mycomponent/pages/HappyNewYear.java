package com.example.mycomponent.pages;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

import com.example.mycomponent.entity.Country;
import com.example.mycomponent.entity.Gender;
import com.example.mycomponent.entity.User;

public class HappyNewYear {

	@Property
	private User user = new User();

	@Property
	private String password2;

	@Inject
	private Messages messages;

	private boolean login;

	void onSelectedFromRegister() {
		login = false;
	}

	void onSelectedFromRegisterAndLogin() {
		login = true;
	}

	public Gender getMale() {
		return Gender.MALE;
	}

	public Gender getFemale() {
		return Gender.FEMALE;
	}

	public SelectModel getCountries() {
		return new EnumSelectModel(Country.class, messages);
	}

	void onSuccess() {
		System.out.println(user);
		System.out.println("password2:" + password2);
		System.out.println("login:" + login);
	}
}
