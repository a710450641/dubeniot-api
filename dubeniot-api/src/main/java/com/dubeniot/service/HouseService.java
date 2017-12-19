/**
 * 
 */
package com.dubeniot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dubeniot.common.utils.DubeniotResult;
import com.dubeniot.pojo.IotHouse;

/**
 * @author BUB-4
 *
 */
public interface HouseService {
	List<IotHouse> getHouseList(Integer userId);
	DubeniotResult addHouse(IotHouse house);
	DubeniotResult DelHouse(Integer houseId);
	DubeniotResult UpdateHouse(IotHouse house);
}
