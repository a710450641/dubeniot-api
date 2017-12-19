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
import com.dubeniot.pojo.IotHouse;
import com.dubeniot.service.HouseService;
import com.taotao.common.utils.ExceptionUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author BUB-4
 *
 */
@Api(tags = "房屋", description ="房屋相关操作接口")
@Controller
@RequestMapping("house")
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@RequestMapping(value="/list/{userId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取房屋列表",notes="根据用户Id获取房屋列表")
	public DubeniotResult getHouseList(@PathVariable int userId){
		try{
			List<IotHouse> list =houseService.getHouseList(userId);
			if(list==null||list.size()==0){
				return DubeniotResult.build(1,"没有数据，请添加");
			}
			return DubeniotResult.ok(list);
		}catch(Exception e){
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "添加房屋")
	public DubeniotResult addHouse(@RequestBody IotHouse house){
		try{
//			System.err.println("house.userId"+house.getUserid());
			DubeniotResult result = houseService.addHouse(house);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "更新房屋")
	public DubeniotResult updateHouse(@RequestBody IotHouse house){
		try{
			DubeniotResult result = houseService.UpdateHouse(house);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
	
	@RequestMapping(value="/delete/{houseId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "删除房屋")
	public DubeniotResult delHouse(@PathVariable int houseId){
		try{
			DubeniotResult result=houseService.DelHouse(houseId);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		
	}
	
}
