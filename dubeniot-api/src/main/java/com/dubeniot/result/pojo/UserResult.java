/**
 * 
 */
package com.dubeniot.result.pojo;

import com.dubeniot.pojo.IotUser;

/**
 * @author BUB-4
 *
 */
public class UserResult {
		
	 /**
	 * @return the appVersion
	 */
	public String getAppVersion() {
		return appVersion;
	}
	/**
	 * @param appVersion the appVersion to set
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	private Integer id;

	    private String username;

	    private String phone;
	    
	    private String appVersion;

	    public UserResult(IotUser user){
	    	this.id=user.getUserid();
	    	this.username=user.getUsername();
	    	this.phone=user.getPhone();
	    	this.appVersion=user.getAppversion();
	    	
	    }
	    public UserResult(){
	    	
	    }
	    public static UserResult getUser(IotUser user){
			return new UserResult(user) ;
	    	
	    }
		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}

		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}


		/**
		 * @return the phone
		 */
		public String getPhone() {
			return phone;
		}

		/**
		 * @param phone the phone to set
		 */
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		
}
