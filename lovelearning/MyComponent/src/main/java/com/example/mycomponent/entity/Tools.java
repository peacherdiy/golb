package com.example.mycomponent.entity;

public class Tools {
	private String name;
	private String desc;
	private String downUrl;

	public Tools() {
		
	}

	public Tools(String name, String desc, String downUrl) {
		this.name = name;
		this.desc = desc;
		this.downUrl = downUrl;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDownUrl() {
		return downUrl;
	}

	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}
	
	
}
