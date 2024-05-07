package com.fcfz.oa.service;

import com.fcfz.oa.entity.User;

import java.util.List;

public interface i_user {


    /***
     * 查找所有用户的用户信息
     * @param isLogin 是否登录了
     * @return 用户信息的列表
     */
    List<User> selectAllUser(String isLogin);


}
