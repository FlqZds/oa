package com.fcfz.oa.mapper;

import com.fcfz.oa.entity.RoletopowerExample;
import com.fcfz.oa.entity.RoletopowerKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoletopowerMapper {
    int countByExample(RoletopowerExample example);

    int deleteByExample(RoletopowerExample example);

    int deleteByPrimaryKey(RoletopowerKey key);

    int insert(RoletopowerKey record);

    int insertSelective(RoletopowerKey record);

    List<RoletopowerKey> selectByExample(RoletopowerExample example);

    int updateByExampleSelective(@Param("record") RoletopowerKey record, @Param("example") RoletopowerExample example);

    int updateByExample(@Param("record") RoletopowerKey record, @Param("example") RoletopowerExample example);
}