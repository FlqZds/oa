package com.fcfz.oa.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.util.DateUtils;
import com.fcfz.oa.common.ErrInfo;
import com.fcfz.oa.common.info;
import com.fcfz.oa.entity.Log;
import com.fcfz.oa.service.logService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "showLogServlet", value = "/showLog")
public class showLogServlet extends HttpServlet {
    logService logService = new logService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("有人发送了展示日志请求     进入时间：" + DateUtils.format(new Date()));

        ErrInfo errInfo = new ErrInfo();
        info info = null;

        try {
            String isLogin = request.getParameter("isLogin");
            String userId = request.getParameter("userId");

            List<Log> logs = logService.showLog(isLogin, userId);
//            info = new info("200", errInfo.getErrMessage(), user);
            info = new info("200", "查询日志成功", logs, "true", userId);


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
