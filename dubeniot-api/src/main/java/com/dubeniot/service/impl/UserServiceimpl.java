/**
 * 
 */
package com.dubeniot.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.dubeniot.api.utils.DefaultUserName;
import com.dubeniot.common.utils.CookieUtils;
import com.dubeniot.common.utils.JsonUtils;
import com.dubeniot.common.utils.SendSMSUtil;
import com.dubeniot.common.utils.DubeniotResult;
import com.dubeniot.dao.JedisClient;
import com.dubeniot.mapper.IotUserMapper;
import com.dubeniot.pojo.IotUser;
import com.dubeniot.pojo.IotUserExample;
import com.dubeniot.result.pojo.LoginResultPojo;
import com.dubeniot.result.pojo.UserResult;
import com.dubeniot.service.UserService;
import com.taotao.common.utils.ExceptionUtil;


/**
 * @author BUB-4
 *
 */
@Service
public class UserServiceimpl implements UserService {

	@Autowired
	private IotUserMapper userMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_USER_REDS_KEY}")
	private String INDEX_USER_REDS_KEY;
	@Value("${REDIS_SMS_CODE}")
	private String REDIS_SMS_CODE;

	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;

	@Value("${SSO_SESSION_EXPIRE}")
	private Integer SSO_SESSION_EXPIRE;
	@Value("${SMS_CODE_EXPIRE}")
	private Integer SMS_CODE_EXPIRE;
	@Value("${REDIS_USER_TOKEN_KEY}")
	private String REDIS_USER_TOKEN_KEY;
	/* (non-Javadoc)
	 * @see com.dubeniot.service.UserService#checkData(java.lang.String, java.lang.Integer)
	 * 检测手机号是否已注册
	 */
	@Override
	public DubeniotResult getSmsCode(String phone) {
		
			String validatecode = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
			String statuCode=new SendSMSUtil(phone, validatecode).Send().toString();
			if(statuCode.equals("000000")){
				jedisClient.set(REDIS_SMS_CODE+":"+phone, validatecode);
				jedisClient.expire(REDIS_SMS_CODE+":"+phone, SMS_CODE_EXPIRE);
				return DubeniotResult.build(1, "发送成功");
			}
			 return DubeniotResult.build(0, "超出今日发送上限");
			
			
			
		
	}


	/* (non-Javadoc)
	 * @see com.dubeniot.service.UserService#createUser(com.dubeniot.pojo.IotUser)
	 * 创建用户
	 */
	@Override
	public DubeniotResult createUser(String smsCode,String phone,String password) {
		IotUserExample example=new IotUserExample();
		IotUserExample.Criteria criteria =example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<IotUser> list=userMapper.selectByExample(example);
		if(list==null||list.size()==0){
			String code =jedisClient.get(REDIS_SMS_CODE+":"+phone);
			System.out.printf("code:"+code);
			if(StringUtils.isBlank(code)){
				return DubeniotResult.build(0, "验证码已过期");
			}
			if(smsCode.equals(code)){
				
				IotUser user = new IotUser();
				user.setUpdated(new Date());
				user.setCreated(new Date());
				user.setUsername(DefaultUserName.getDefaultUserName());
				user.setPhone(phone);
				user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
				// md5加密

				userMapper.insert(user);
				return DubeniotResult.build(1,"添加成功");
			}
			else{
				return DubeniotResult.build(0, "验证码错误");
			}
		}else{
			return DubeniotResult.build(0, "手机已注册");
		}

	}


	/* (non-Javadoc)
	 * @see com.dubeniot.service.UserService#userLogin(java.lang.String, java.lang.String, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * 登录
	 */
	@Override
	public DubeniotResult userLogin(String phone, String password, HttpServletRequest request,
			HttpServletResponse response) {
		IotUserExample example = new IotUserExample();
		IotUserExample.Criteria criteria =example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<IotUser> list = userMapper.selectByExample(example);		
		if (list == null || list.size() == 0) {
			return DubeniotResult.build(0,"用户名或密码错误");
		}
		IotUser user=list.get(0);
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			return DubeniotResult.build(0,"用户名或密码错误");          
		}
		String token = UUID.randomUUID().toString().replace("-","");
		user.setPassword(null);
		// 把用户信息写入缓存redis
		jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(UserResult.getUser(user)));
//		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		jedisClient.set(REDIS_USER_TOKEN_KEY+":"+user.getUserid(),token);
//		//设置session的过期时间
//		//添加cookie的逻辑,cookie的有效期是关闭浏览器就失效。
//		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		LoginResultPojo loginResult =new LoginResultPojo(UserResult.getUser(user),token);
		return DubeniotResult.ok(loginResult);
	}
	
	/* (non-Javadoc)
	 * @see com.dubeniot.service.UserService#logOut(java.lang.Integer)
	 */
	@Override
	public DubeniotResult userLogOut(Integer userId) {
		
		if(userId!=null){
			String token =jedisClient.get(REDIS_USER_TOKEN_KEY+":"+userId);
			jedisClient.del(REDIS_USER_TOKEN_KEY+":"+userId);
			jedisClient.del(REDIS_USER_SESSION_KEY + ":" + token);
			return DubeniotResult.build(1,"退出成功");
		}
		return DubeniotResult.build(0,"退出失败");

	}
	

	/* (non-Javadoc)
	 * @see com.dubeniot.service.UserService#getUserByToken(java.lang.String)
	 * 根据token获取用户信息
	 */
	@Override
	public DubeniotResult getUserByToken(String token) {
		String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);
		//判断是否为空
		if (StringUtils.isBlank(json)) {
			return DubeniotResult.build(0, "token已过期,请重新登录");
		}
		//更新过期时间
//		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		//返回用户信息
		return DubeniotResult.ok(JsonUtils.jsonToPojo(json, UserResult.class));
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.dubeniot.service.UserService#getUserList()
	 */
	@Override
	public List<IotUser> getUserList() {
		try {
			String result = jedisClient.hget(INDEX_USER_REDS_KEY,"allUser");
			if (!StringUtils.isBlank(result)) {
				// 把字符串转换成list
				List<IotUser> resultList = JsonUtils.jsonToList(result, IotUser.class);
				return resultList;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 根据内容分类id查询列表
		IotUserExample example = new IotUserExample();
		@SuppressWarnings("unused")
		IotUserExample.Criteria criteria = example.createCriteria();
		// 执行查询
		List<IotUser> list = userMapper.selectByExample(example);

		// 向缓存中添加内容
		try {
			// 把list转成字符串
			String cacheString = JsonUtils.objectToJson(list);
			jedisClient.hset(INDEX_USER_REDS_KEY, "allUser", cacheString);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	/* (non-Javadoc)
	 * @see com.dubeniot.service.UserService#getUser()
	 */
	@Override
	public IotUser getUser(Integer id) {
		// TODO Auto-generated method stub
		IotUser user=userMapper.selectByPrimaryKey(id);
		return user;
	}


	/* (non-Javadoc)
	 * @see com.dubeniot.service.UserService#restPasswd(java.lang.Integer)
	 * 忘记密码
	 */
	@Override
	public DubeniotResult restPasswd(String smsCode,String phone,String password) {
		
		return null;
	}


	/* (non-Javadoc)
	 * @see com.dubeniot.service.UserService#updatePasswd(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public DubeniotResult updatePasswd(Integer userId, String oldPassword, String newPassword) {
		
		try {
			IotUser user =userMapper.selectByPrimaryKey(userId);
			if(!DigestUtils.md5DigestAsHex(oldPassword.getBytes()).equals(user.getPassword())){
				return DubeniotResult.build(0, "密码错误");				
			}
			user.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
			user.setUpdated(new Date());
			userMapper.updateByPrimaryKey(user);
			return DubeniotResult.build(1, "更新成功");
		} catch (Exception e) {
			return DubeniotResult.build(0, ExceptionUtil.getStackTrace(e));
		}
	
	  
	}


	/* (non-Javadoc)
	 * @see com.dubeniot.service.UserService#updateUser(com.dubeniot.pojo.IotUser)
	 */
	@Override
	public DubeniotResult updateUser(IotUser user) {
		try{
//			IotUser updateuser =userMapper.selectByPrimaryKey(user.getId());
//			updateuser.setUsername(user.getUsername());
////			updateuser.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
//			updateuser.setUpdated(new Date());
			if(user.getCreated()==null){
				user.setCreated(userMapper.selectByPrimaryKey(user.getUserid()).getCreated());
				
			}
			user.setUpdated(new Date());
			userMapper.updateByPrimaryKey(user);
			return DubeniotResult.build(1, "更新成功");
		}catch(Exception e){
			return DubeniotResult.build(0, ExceptionUtil.getStackTrace(e));
		}
		
	
		
	}






}
