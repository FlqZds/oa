package com.fcfz.oa.service;


import com.fcfz.oa.common.ErrInfo;
import com.fcfz.oa.common.utils.MySqlSessionFactory;
import com.fcfz.oa.entity.User;
import com.fcfz.oa.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

public class login {

    public User loginUser(String username, String passWord) {
        SqlSession session = MySqlSessionFactory.getSession();

        try {
//用户

//           通过account名称 获得user 信息
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.selectByUserName(username);


//密码
//            String userPwdsStr = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());

            if (passWord.equals(user.getPassword()) == false) {
                throw new ErrInfo("0002","用户密码不正确");
            }

            return user;

        } catch (Exception e) {
            throw e;
        } finally {
            MySqlSessionFactory.closeSession();
        }

    }
}


