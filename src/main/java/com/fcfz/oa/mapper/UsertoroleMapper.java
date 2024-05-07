package com.fcfz.oa.mapper;

import com.fcfz.oa.DTO.userDto;
import com.fcfz.oa.entity.UsertoroleExample;
import com.fcfz.oa.entity.UsertoroleKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsertoroleMapper {
    int countByExample(UsertoroleExample example);

    int deleteByExample(UsertoroleExample example);

    int deleteByPrimaryKey(UsertoroleKey key);

    int insert(UsertoroleKey record);

    int insertSelective(UsertoroleKey record);

    List<UsertoroleKey> selectByExample(UsertoroleExample example);

    userDto RoleOfThisUser(Integer userId);

    int updateByExampleSelective(@Param("record") UsertoroleKey record, @Param("example") UsertoroleExample example);

    int updateByExample(@Param("record") UsertoroleKey record, @Param("example") UsertoroleExample example);
}