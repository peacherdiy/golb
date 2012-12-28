package com.example.tutorial.pages;

import org.apache.tapestry5.annotations.SessionState;

import com.example.tutorial.services.IState;

public class Welcome {
	@SessionState
	private String theUser;
	
	@SessionState 
	private IState iState;
	
	private boolean theUserExists;

	public String getTheUser() {
		return theUser;
	}

	void onActionFromLogout() {
		theUser = null;
	}
	
	public boolean isTheUserExists() {
		return theUserExists;
	}

	public IState getiState() {
		return iState;
	}

	public void setiState(IState iState) {
		this.iState = iState;
	}
}
