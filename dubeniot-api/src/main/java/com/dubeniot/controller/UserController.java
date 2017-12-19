/**
 * 
 */
package com.dubeniot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dubeniot.common.utils.DubeniotResult;
import com.dubeniot.pojo.IotUser;
import com.dubeniot.pojo.IotUserExample;
import com.dubeniot.service.UserService;
import com.taotao.common.utils.ExceptionUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/**
 * @author BUB-4 用户接口
 *
 */
@Api(tags = "用户", description = "用户相关操作接口")
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 检测用户
	 */
	@RequestMapping(value = "/get/smsCode/{phone}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取验证码")
	public Object getSmsCode(@PathVariable String phone) {
		DubeniotResult result = null;

		try {
			result = userService.getSmsCode(phone);

		} catch (Exception e) {
			result = DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return result;

	}

	/**
	 * 用户注册
	 */
	@RequestMapping(value = "/register/", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户注册")
	public DubeniotResult createUser(@RequestParam String smsCode, @RequestParam String phone,
			@RequestParam String password) {

		try {

			DubeniotResult result = userService.createUser(smsCode, phone, password);
			return result;
		} catch (Exception e) {
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "用户登录")
	  @ApiImplicitParams({
          @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "password", value = "密     码", required = true, dataType = "string", paramType = "query")
  })
	public DubeniotResult userLogin(@RequestParam String phone, @RequestParam String password,
			HttpServletRequest request, HttpServletResponse response) {
		try {

			DubeniotResult result = userService.userLogin(phone, password, request, response);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}

	/**
	 * 用户退出
	 */

	@RequestMapping(value = "/logout/{userId}", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户退出")
	public DubeniotResult logOut(@PathVariable int userId) {
		try {

			DubeniotResult result = userService.userLogOut(userId);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}

	// 根据token取用户信息
	@RequestMapping(value = "/token/{token}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据token取用户信息")
	public Object getUserByToken(@PathVariable String token, String callback) {
		DubeniotResult result = null;
		try {
			result = userService.getUserByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			result = DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		// 判断是否为jsonp调用
		if (StringUtils.isBlank(callback)) {
			return result;
		} else {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}

	}

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取所有用户信息",hidden=true)
	/*
	 * @ApiOperation(value = "接口说明", httpMethod ="接口请求方式", response ="接口返回参数类型",
	 * notes ="接口发布说明"
	 * 
	 * @ApiParam(required = "是否必须参数", name ="参数名称", value ="参数具体描述"
	 */
	public DubeniotResult getUserList() {
		try {
			List<IotUser> list = userService.getUserList();
			return DubeniotResult.ok(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}
	public DubeniotResult getUserlist(){
		return null;
		
	}
	@RequestMapping(value = "/restPassd", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "忘记密码")
	public DubeniotResult restPassd(@RequestParam String smsCode,@RequestParam String phone,@RequestParam String password) {
		try {
			DubeniotResult result =userService.restPasswd(smsCode,phone,password);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping(value = "/updatePassd", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "更改密码")
	public DubeniotResult updatePasswd(@RequestParam int userId,@RequestParam String oldPassword,@RequestParam String newPassword) {
		try {
			DubeniotResult result =userService.updatePasswd(userId,oldPassword,newPassword);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	@RequestMapping(value = "/udpateUser", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "更新用户信息")
	
	public DubeniotResult updateUser(@RequestBody IotUser iotuser) {
		try {
			DubeniotResult result =userService.updateUser(iotuser);
			return result ;
		} catch (Exception e) {
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
