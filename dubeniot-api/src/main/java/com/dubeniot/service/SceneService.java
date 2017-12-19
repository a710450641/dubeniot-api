/**
 * 
 */
package com.dubeniot.service;

import java.util.List;

import com.dubeniot.common.utils.DubeniotResult;
import com.dubeniot.pojo.IotScene;

/**
 * @author BUB-4
 *
 */
public interface SceneService {
	DubeniotResult addScene(IotScene scene);
	DubeniotResult delScene(Integer sceneId);
	DubeniotResult updateScene(IotScene scene);
	List<IotScene> getSceneList(Integer houseId);
}
