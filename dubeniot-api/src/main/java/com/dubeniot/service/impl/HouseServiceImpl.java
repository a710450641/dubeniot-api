/**
 * 
 */
package com.dubeniot.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dubeniot.common.utils.DubeniotResult;
import com.dubeniot.dao.JedisClient;
import com.dubeniot.mapper.IotHouseMapper;
import com.dubeniot.mapper.IotUserMapper;
import com.dubeniot.pojo.IotHouse;
import com.dubeniot.pojo.IotHouseExample;
import com.dubeniot.pojo.IotUser;
import com.dubeniot.result.pojo.HouseResult;
import com.dubeniot.service.HouseService;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.JsonUtils;

/**
 * @author BUB-4
 *
 */
@Service
public class HouseServiceImpl implements HouseService {

	
	@Autowired
	private IotHouseMapper houseMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${INDEX_HOUSE_REDIS_KEY}")
	private String INDEX_HOUSE_REDIS_KEY;
	
	
	
	/* (non-Javadoc)
	 * @see com.dubeniot.service.HouseService#addHouse(com.dubeniot.pojo.IotHouse)
	 */
	@Override
	public DubeniotResult addHouse(IotHouse house) {
		try{
//			IotUser user =userMapper.selectByPrimaryKey(house.getUserid());
//			if(user!=null){
//				
//			}
			houseMapper.insert(house);
			return DubeniotResult.ok(HouseResult.getHouse(house));
		}catch(Exception e){
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}

	/* (non-Javadoc)
	 * @see com.dubeniot.service.HouseService#getListHouse(java.lang.Integer)
	 */
	@Override
	public List<IotHouse> getHouseList(Integer userId) {
		try{
			
			String result =jedisClient.hget(INDEX_HOUSE_REDIS_KEY, userId+"");
			if(!StringUtils.isBlank(result)){
				List<IotHouse> resultlist =JsonUtils.jsonToList(result, IotHouse.class);
				return resultlist;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		IotHouseExample example = new IotHouseExample();
		IotHouseExample.Criteria criteria =example.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<IotHouse> list =houseMapper.selectByExample(example);
		try{
			String cacheString =JsonUtils.objectToJson(list);
			jedisClient.hset(INDEX_HOUSE_REDIS_KEY, userId+"", cacheString);
			
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
		
	}

	/* (non-Javadoc)
	 * @see com.dubeniot.service.HouseService#DelHouse(java.lang.Integer)
	 */
	@Override
	public DubeniotResult DelHouse(Integer houseId) {
		// TODO Auto-generated method stub
		jedisClient.hdel(INDEX_HOUSE_REDIS_KEY, houseMapper.selectByPrimaryKey(houseId).getUserid()+"");
		houseMapper.deleteByPrimaryKey(houseId);
		return DubeniotResult.build(1, "删除成功",houseId);
	}

	/* (non-Javadoc)
	 * @see com.dubeniot.service.HouseService#UpdateHouse(com.dubeniot.pojo.IotHouse)
	 */
	@Override
	public DubeniotResult UpdateHouse(IotHouse house) {
		houseMapper.updateByPrimaryKey(house);
		return DubeniotResult.build(1,"更新成功",house);
	}
	
}
