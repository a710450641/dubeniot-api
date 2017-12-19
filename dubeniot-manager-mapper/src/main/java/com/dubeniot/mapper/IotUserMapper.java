package com.dubeniot.mapper;

import com.dubeniot.pojo.IotUser;
import com.dubeniot.pojo.IotUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IotUserMapper {
    int countByExample(IotUserExample example);

    int deleteByExample(IotUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(IotUser record);

    int insertSelective(IotUser record);

    List<IotUser> selectByExample(IotUserExample example);

    IotUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") IotUser record, @Param("example") IotUserExample example);

    int updateByExample(@Param("record") IotUser record, @Param("example") IotUserExample example);

    int updateByPrimaryKeySelective(IotUser record);

    int updateByPrimaryKey(IotUser record);
}