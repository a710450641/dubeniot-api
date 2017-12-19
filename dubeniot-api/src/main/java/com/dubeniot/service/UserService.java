/**
 * 
 */
package com.dubeniot.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dubeniot.common.utils.DubeniotResult;
import com.dubeniot.pojo.IotUser;


/**
 * @author BUB-4
 *
 */
public interface UserService {
	List<IotUser> getUserList();
	IotUser getUser(Integer Userid);
	DubeniotResult getSmsCode(String phoneNumber);
	DubeniotResult createUser(String smsCode,String phone,String password);
	DubeniotResult updatePasswd(Integer userId,String oldPassword,String newPassword);
	DubeniotResult updateUser(IotUser user);
	DubeniotResult userLogin(String phone,String password,HttpServletRequest request,HttpServletResponse response);
	DubeniotResult userLogOut(Integer userId);
	DubeniotResult getUserByToken(String token);
	DubeniotResult restPasswd(String smsCode,String phone,String password);

	
	
}
