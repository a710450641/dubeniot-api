/**
 * 
 */
package com.dubeniot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dubeniot.common.utils.JsonUtils;
import com.dubeniot.service.PictureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author BUB-4
 *
 */
@Api(hidden=true ,tags = "图片", description = "图片操作接口")
@Controller
@RequestMapping("pic")
public class PictureController {
		
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "图片上传",hidden=true)
	public String pictureUpload(@RequestBody MultipartFile uploadFile){
		Map result = pictureService.uploadPicture(uploadFile);
		String json =JsonUtils.objectToJson(result);
		return json;
		
	}
	
}
