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
import com.dubeniot.pojo.IotScene;
import com.dubeniot.service.SceneService;
import com.taotao.common.utils.ExceptionUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author BUB-4
 *
 */
@Api(tags = "场景", description = "场景相关操作接口")
@Controller
@RequestMapping("scene")
public class SceneController {

	@Autowired
	private SceneService sceneService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "添加场景")
	public DubeniotResult addScene(@RequestBody IotScene scene) {
		try {
			DubeniotResult result = sceneService.addScene(scene);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	@RequestMapping(value = "/delete/{sceneId}", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "删除场景")
	public DubeniotResult delScene(@PathVariable int sceneId) {
		try {
			DubeniotResult result = sceneService.delScene(sceneId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "更新场景")
	public DubeniotResult updateScene(@RequestBody IotScene scene) {
		try {
			DubeniotResult result = sceneService.updateScene(scene);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	@RequestMapping(value = "/list/{houseId}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取场景列表",notes="根据房屋ID获取场景列表")
	public DubeniotResult getSceneList(@PathVariable int houseId) {
		try {
			List<IotScene> list = sceneService.getSceneList(houseId);
			if(list==null||list.size()==0){
				return DubeniotResult.build(1,"没有数据，请添加");
			}
			return DubeniotResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
