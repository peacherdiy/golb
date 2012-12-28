package com.example.mycomponent.entity;

public class User {

	private String name;

	private String password;

	private String email;

	private int age;

	private Gender gender;

	private Country country;

	private boolean subscribe;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}

	public String toString() {
		return "Name:" + name + "\n" + "Password:" + password + "\n" + "Email:"
				+ email + "\n" + "Age:" + age + "\n" + "Gender:" + gender
				+ "\n" + "Country:" + country + "\n" + "Subscribe:" + subscribe;
	}
}
