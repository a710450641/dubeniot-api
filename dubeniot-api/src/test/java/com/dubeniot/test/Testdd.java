/**
 * 
 */
package com.dubeniot.test;

import java.util.UUID;

import org.junit.Test;

import com.dubeniot.common.utils.SendSMSUtil;

/**
 * @author BUB-4
 *
 */
public class Testdd {

	@Test 
	public void sms(){
		String validatecode = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
		String statuCode=new SendSMSUtil("18826224430", validatecode).Send().toString();
		System.out.println("statuCode :"+statuCode);
	}
}
