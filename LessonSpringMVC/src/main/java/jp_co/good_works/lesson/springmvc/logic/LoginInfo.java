package jp_co.good_works.lesson.springmvc.logic;

import javax.validation.constraints.NotEmpty;

public class LoginInfo {

	@NotEmpty
	private String userId;
	@NotEmpty
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String password) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
