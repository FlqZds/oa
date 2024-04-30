package com.fcfz.oa.service;

import com.alibaba.fastjson2.JSON;
import com.fcfz.oa.common.ErrInfo;
import com.fcfz.oa.common.utils.MySqlSessionFactory;
import com.fcfz.oa.entity.User;
import com.fcfz.oa.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class selUser {

    public List<User> selectAllUser(String isLogin){
        SqlSession session = MySqlSessionFactory.getSession();

        try {
            if (StringUtils.isEmpty(isLogin) == true)
                throw new ErrInfo("0000", "登陆状态异常");

            if (isLogin.equals("true") == false)
                throw new ErrInfo("0001", "该用户未登录");

            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> userList = userMapper.selectAllUser();


            System.out.println(userList);
            if(userList.equals(null)==true||userList.size()<=0){
                throw new ErrInfo("00099", "用户列表不存在");
            }

            return userList;

        } catch (Exception e) {
            throw e;
        } finally {
            MySqlSessionFactory.closeSession();
        }
    }

}
