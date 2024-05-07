package com.fcfz.oa.service.impl;


import com.fcfz.oa.common.ErrInfo;
import com.fcfz.oa.common.info;
import com.fcfz.oa.common.utils.MySqlSessionFactory;
import com.fcfz.oa.entity.User;
import com.fcfz.oa.mapper.UserMapper;
import com.fcfz.oa.mapper.UsertoroleMapper;
import com.fcfz.oa.service.i_login;
import org.apache.ibatis.session.SqlSession;

public class login implements i_login {

    public User loginUser(String usercount, String passWord) {
        SqlSession session = MySqlSessionFactory.getSession();

        try {
//用户
//           通过account名称 获得user 信息
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.selectByUsercount(usercount);


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

    @Override
    public info registerUser(String username, String passWord, String userAcount, String userTel) {
        SqlSession session = MySqlSessionFactory.getSession();

        try {
//用户

            UserMapper userMapper = session.getMapper(UserMapper.class);

            UsertoroleMapper usertoroleMapper = session.getMapper(UsertoroleMapper.class);

            User user=User.builder()
                    .userCount(userAcount)
                    .userName(username)
                    .password(passWord)
                    .usertel(userTel)
                    .build();

//            插入结果
            int insertResult = userMapper.insert(user);

//            System.out.println("插入结果："+insertResult);

//            usertoroleMapper.insert()



            if (insertResult!=1) {
                throw new ErrInfo("99999","用户注册失败");
            }

            session.commit();

            return new info("200","用户注册成功",null,null,null);

        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            MySqlSessionFactory.closeSession();
        }
    }





}


