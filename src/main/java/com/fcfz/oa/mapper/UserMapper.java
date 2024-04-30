package com.fcfz.oa.mapper;

import com.fcfz.oa.entity.Log;
import com.fcfz.oa.entity.User;
import com.fcfz.oa.entity.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

//    根据userID拿到日志表中对应所有日志信息
    List<Log> selectAllLogByUserId(Integer userId);

    List<User> selectAllUser();

    User selectByUsercount(@Param("account")String usercount);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}