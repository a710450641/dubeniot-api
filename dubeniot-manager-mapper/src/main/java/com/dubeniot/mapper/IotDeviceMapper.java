package com.dubeniot.mapper;

import com.dubeniot.pojo.IotDevice;
import com.dubeniot.pojo.IotDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IotDeviceMapper {
    int countByExample(IotDeviceExample example);

    int deleteByExample(IotDeviceExample example);

    int deleteByPrimaryKey(Integer deviceid);

    int insert(IotDevice record);

    int insertSelective(IotDevice record);

    List<IotDevice> selectByExample(IotDeviceExample example);

    IotDevice selectByPrimaryKey(Integer deviceid);

    int updateByExampleSelective(@Param("record") IotDevice record, @Param("example") IotDeviceExample example);

    int updateByExample(@Param("record") IotDevice record, @Param("example") IotDeviceExample example);

    int updateByPrimaryKeySelective(IotDevice record);

    int updateByPrimaryKey(IotDevice record);
}