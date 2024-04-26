package com.fcfz.oa.mapper;

import com.fcfz.oa.entity.Log;
import com.fcfz.oa.entity.LogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogMapper {
    int countByExample(LogExample example);

    int deleteByExample(LogExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExample(LogExample example);

    Log selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

    int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}