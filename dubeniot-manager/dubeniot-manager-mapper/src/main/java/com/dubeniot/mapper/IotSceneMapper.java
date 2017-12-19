package com.dubeniot.mapper;

import com.dubeniot.pojo.IotScene;
import com.dubeniot.pojo.IotSceneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IotSceneMapper {
    int countByExample(IotSceneExample example);

    int deleteByExample(IotSceneExample example);

    int deleteByPrimaryKey(Integer sceneid);

    int insert(IotScene record);

    int insertSelective(IotScene record);

    List<IotScene> selectByExample(IotSceneExample example);

    IotScene selectByPrimaryKey(Integer sceneid);

    int updateByExampleSelective(@Param("record") IotScene record, @Param("example") IotSceneExample example);

    int updateByExample(@Param("record") IotScene record, @Param("example") IotSceneExample example);

    int updateByPrimaryKeySelective(IotScene record);

    int updateByPrimaryKey(IotScene record);
}