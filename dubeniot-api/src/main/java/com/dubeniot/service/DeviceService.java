/**
 * 
 */
package com.dubeniot.service;

import java.util.List;

import com.dubeniot.common.utils.DubeniotResult;
import com.dubeniot.pojo.IotDevice;
import com.dubeniot.pojo.IotScene;

/**
 * @author BUB-4
 *
 */
public interface DeviceService {
	DubeniotResult addDevice(IotDevice device);
	DubeniotResult delDevice(Integer deviceId);
	DubeniotResult updateDevice(IotDevice device);
	List<IotDevice> getListDevice(Integer sceneId);
		
	
}
