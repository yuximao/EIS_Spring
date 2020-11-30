package com.mercury.EconomicalInsuranceSystem.http;

import com.mercury.EconomicalInsuranceSystem.beans.User;

public class UserInfoResponse extends Response {

	private User user;

	public UserInfoResponse(boolean success, User user) {
		super(success);
		this.user = user;
	}

	public User getUserInfo() {
		return user;
	}

	public void setUserInfo(User userInfo) {
		this.user = user;
	}

}
