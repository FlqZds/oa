package com.fcfz.oa.service;

import com.fcfz.oa.common.info;
import com.fcfz.oa.entity.Log;

import java.util.List;

public interface i_log {

    List<Log> showLog(String isLogin, String userId);


    info addLog(String isLogin, String userId, String logTitle, String logContent, String logTime);
}
