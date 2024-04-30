package com.fcfz.oa.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.util.DateUtils;
import com.fcfz.oa.common.ErrInfo;
import com.fcfz.oa.common.info;
import com.fcfz.oa.entity.User;
import com.fcfz.oa.service.selUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "selUserServlet", value = "/allUser")
public class selUserServlet extends HttpServlet {
    selUser sel=new selUser();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("有屌毛给你发了查看所有用户的请求，是否同意    进入时间：" + DateUtils.format(new Date()));

        ErrInfo errInfo = new ErrInfo();
        info info = null;
        List<User> userList = null;

        try {
            String isLogin = request.getParameter("isLogin");


            userList = sel.selectAllUser(isLogin);


            info = new info("200", "用户登录成功", userList, "true", null);


        } catch (Exception e) {
            if (e instanceof ErrInfo) {

                errInfo = (ErrInfo) e;
                info = new info(errInfo.getCode(), errInfo.getErrMessage(), null, "false", null);
            } else {
                info = new info("00000", "未知后台错误，请重试，或尝试联系管理员/n<br>" + errInfo.getErrMessage(), null, "false", null);
            }
        } finally {
            response.getWriter().write(JSON.toJSONString(info));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
