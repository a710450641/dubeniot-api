package com.dubeniot.mapper;

import com.dubeniot.pojo.IotHouse;
import com.dubeniot.pojo.IotHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IotHouseMapper {
    int countByExample(IotHouseExample example);

    int deleteByExample(IotHouseExample example);

    int deleteByPrimaryKey(Integer houseid);

    int insert(IotHouse record);

    int insertSelective(IotHouse record);

    List<IotHouse> selectByExample(IotHouseExample example);

    IotHouse selectByPrimaryKey(Integer houseid);

    int updateByExampleSelective(@Param("record") IotHouse record, @Param("example") IotHouseExample example);

    int updateByExample(@Param("record") IotHouse record, @Param("example") IotHouseExample example);

    int updateByPrimaryKeySelective(IotHouse record);

    int updateByPrimaryKey(IotHouse record);
}