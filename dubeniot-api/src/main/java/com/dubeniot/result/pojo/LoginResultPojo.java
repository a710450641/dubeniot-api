/**
 * 
 */
package com.dubeniot.result.pojo;

import com.dubeniot.pojo.IotUser;

/**
 * @author BUB-4
 *
 */
public class LoginResultPojo {
	
	private UserResult user;
	private String token;
	
	public LoginResultPojo(UserResult user,String token){
		this.user=user;
		this.token=token;
	}
	/**
	 * @return the user
	 */
	public UserResult getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserResult user) {
		this.user = user;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
}
