package com.fcfz.oa.service;

import com.fcfz.oa.common.info;
import com.fcfz.oa.entity.User;

public interface i_login {

    /***
     * 用户登录1
     * @param username 用户名称
     * @param passWord  用户密码
     * @return  用户对象
     */
    public User loginUser(String username, String passWord);


    /***
     * 注册用户
     * @param username
     * @param passWord
     * @param userAcount
     * @param userTel
     * @return
     */
    public info registerUser(String username, String passWord, String userAcount, String userTel);
}
