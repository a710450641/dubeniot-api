/**
 * 
 */
package com.dubeniot.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.dubeniot.common.utils.DubeniotResult;
import com.dubeniot.common.utils.ExceptionUtil;
import com.dubeniot.common.utils.JsonUtils;
import com.dubeniot.dao.JedisClient;
import com.dubeniot.mapper.IotDeviceMapper;
import com.dubeniot.pojo.IotDevice;
import com.dubeniot.pojo.IotDeviceExample;
import com.dubeniot.service.DeviceService;

/**
 * @author BUB-4
 *
 */
@Service
public class DeviceServiceImpl implements DeviceService {

	
	@Autowired
	private IotDeviceMapper deviceMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_DEVICE_REDIS_KEY}")
	private String INDEX_DEVICE_REDIS_KEY;
	/* (non-Javadoc)
	 * @see com.dubeniot.service.DeviceService#addDevice(com.dubeniot.pojo.IotDevice)
	 */
	@Override
	public DubeniotResult addDevice(IotDevice device) {
		try{
			deviceMapper.insert(device);
			return DubeniotResult.ok(device);
		}catch(Exception e){
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}     

	/* (non-Javadoc)
	 * @see com.dubeniot.service.DeviceService#delDevice(java.lang.Integer)
	 */
	@Override
	public DubeniotResult delDevice(Integer deviceId) {
		deviceMapper.deleteByPrimaryKey(deviceId);
		return DubeniotResult.build(1, "删除成功");
	}

	/* (non-Javadoc)
	 * @see com.dubeniot.service.DeviceService#updateDevice(com.dubeniot.pojo.IotDevice)
	 */
	@Override
	public DubeniotResult updateDevice(IotDevice device) {
		deviceMapper.updateByPrimaryKey(device);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dubeniot.service.DeviceService#getListDevice(java.lang.Integer)
	 */
	@Override
	public List<IotDevice> getListDevice(Integer sceneId) {
		
		try{
			String result = jedisClient.hget(INDEX_DEVICE_REDIS_KEY, sceneId+"");
			if(!StringUtils.isBlank(result)){
				List<IotDevice> resultList= JsonUtils.jsonToList(result, IotDevice.class);
				return resultList;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		
		}
		
		IotDeviceExample example = new IotDeviceExample();
		IotDeviceExample.Criteria criteria = example.createCriteria();
		List<IotDevice> list =deviceMapper.selectByExample(example);
		return  list;
	}

	/* (non-Javadoc)
	 * @see com.dubeniot.service.DeviceService#addDevice(com.dubeniot.pojo.IotScene)
	 */


}
