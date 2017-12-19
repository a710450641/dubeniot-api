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
import com.dubeniot.dao.JedisClient;
import com.dubeniot.mapper.IotSceneMapper;
import com.dubeniot.pojo.IotHouse;
import com.dubeniot.pojo.IotHouseExample;
import com.dubeniot.pojo.IotScene;
import com.dubeniot.pojo.IotSceneExample;
import com.dubeniot.service.SceneService;
import com.taotao.common.utils.JsonUtils;

/**
 * @author BUB-4
 *
 */
@Service
public class SceneServiceImpl implements SceneService {

	@Autowired
	private IotSceneMapper sceneMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_SCENE_REDIS_KEY}")
	private String INDEX_SCENE_REDIS_KEY;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dubeniot.service.SceneService#addScene(com.dubeniot.pojo.IotScene)
	 */
	@Override
	public DubeniotResult addScene(IotScene scene) {
		try {
			sceneMapper.insert(scene);
			return DubeniotResult.ok(scene);
		} catch (Exception e) {
			e.printStackTrace();
			return DubeniotResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dubeniot.service.SceneService#delScene(java.lang.Integer)
	 */
	@Override
	public DubeniotResult delScene(Integer sceneId) {
		sceneMapper.deleteByPrimaryKey(sceneId);
		return DubeniotResult.build(1, "删除成功");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dubeniot.service.SceneService#updateScene(com.dubeniot.pojo.IotScene)
	 */
	@Override
	public DubeniotResult updateScene(IotScene scene) {
		// TODO Auto-generated method stub
		sceneMapper.updateByPrimaryKey(scene);
		return DubeniotResult.ok(scene);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dubeniot.service.SceneService#getSceneList(java.lang.Integer)
	 */
	@Override
	public List<IotScene> getSceneList(Integer houseId) {
		try {

			String result = jedisClient.hget(INDEX_SCENE_REDIS_KEY, houseId + "");
			if (!StringUtils.isBlank(result)) {
				List<IotScene> resultlist = JsonUtils.jsonToList(result, IotScene.class);
				return resultlist;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		IotSceneExample example = new IotSceneExample();
		IotSceneExample.Criteria criteria = example.createCriteria();
		criteria.andHouseidEqualTo(houseId);
		List<IotScene> list = sceneMapper.selectByExample(example);
		try {
			String cacheString = JsonUtils.objectToJson(list);
			jedisClient.hset(INDEX_SCENE_REDIS_KEY, houseId + "", cacheString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
