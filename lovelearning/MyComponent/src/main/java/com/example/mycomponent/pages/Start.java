package com.example.mycomponent.pages;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.IncludeStylesheet;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

import com.example.mycomponent.entity.Country;
import com.example.mycomponent.entity.Gender;
import com.example.mycomponent.entity.User;

@IncludeStylesheet("context:layout/main.css")
//@JavascriptSupport.importStylesheet() 
public class Start {

	@Property
	private User user = new User();

	@Property
	private String password2;

	@Inject
	private Messages messages;

	@Component
	private Form regForm;

	@Component(id = "password2")
	private PasswordField password2Field;

	private boolean login;

	void onSelectedFromRegister() {
		login = false;
	}

	void onSelectedFromRegisterAndLogin() {
		login = true;
	}

	void onValidateForm() {
		if (password2 != null && !password2.equals(user.getPassword())) {
			regForm.recordError(password2Field, messages .get("differ-passwords"));
		}
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
