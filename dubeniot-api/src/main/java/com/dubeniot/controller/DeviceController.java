/**
 * 
 */
package com.dubeniot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dubeniot.common.utils.DubeniotResult;
import com.dubeniot.common.utils.ExceptionUtil;
import com.dubeniot.pojo.IotDevice;
import com.dubeniot.service.DeviceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author BUB-4
 *
 */
@Api(tags = "设备", description = "设备接口")
@Controller
@RequestMapping("device")
public class DeviceController {
		
	@Autowired 
	private DeviceService deviceService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "添加设备",hidden=true)
	public DubeniotResult addDevice(@RequestBody IotDevice device){
		try{
			DubeniotResult result = deviceService.addDevice(device);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	
	}
	
	
	@RequestMapping(value="/del",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "删除设备",hidden=true)
	public DubeniotResult delDevice(@PathVariable int deviceId){
		try{
			DubeniotResult result = deviceService.delDevice(deviceId);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		
	}
	
	@RequestMapping(value="/更新设备",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "图片上传",hidden=true)
	public DubeniotResult updateDevice(IotDevice device){
		try{
			DubeniotResult result = deviceService.updateDevice(device);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		
	}
	
	
	@RequestMapping(value="/list/{sceneId}",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "获取设备列表",hidden=true)
	public DubeniotResult getListDevice(@PathVariable int sceneId){
		try{
			List<IotDevice> list = deviceService.getListDevice(sceneId);
			return  DubeniotResult.ok(list);
		}catch(Exception e){
			e.printStackTrace();
			
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
	
	
}
