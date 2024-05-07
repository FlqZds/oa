package com.fcfz.oa.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.util.DateUtils;
import com.fcfz.oa.common.ErrInfo;
import com.fcfz.oa.common.info;
import com.fcfz.oa.service.impl.PowerRoleShow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "showRoleServlet", value = "/showRole")
public class showRoleServlet extends HttpServlet {
    PowerRoleShow powerRoleShow=new PowerRoleShow();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isLogin = request.getParameter("isLogin");
        String userId = request.getParameter("userId");

        System.out.println("查看该用户的权限     进入时间：" + DateUtils.format(new Date()));

        ErrInfo errInfo = new ErrInfo();
        info info = null;

        try {

           info = powerRoleShow.showRole(isLogin, userId);

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
