/**
 * 
 */
package com.dubeniot.api.utils;

import java.util.UUID;

/**
 * @author BUB-4
 *
 */
public class DefaultUserName {

	
	
	public static String getDefaultUserName(){
		String id=UUID.randomUUID().toString();
        String[] idd=id.split("-");
		String defaultUserName ="DUB-"+idd[1];
		return defaultUserName;
		
	}
}
