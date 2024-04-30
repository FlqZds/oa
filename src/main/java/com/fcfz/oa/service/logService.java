package com.fcfz.oa.service;

import com.fcfz.oa.common.ErrInfo;
import com.fcfz.oa.common.info;
import com.fcfz.oa.common.utils.MySqlSessionFactory;
import com.fcfz.oa.entity.Log;
import com.fcfz.oa.mapper.LogMapper;
import com.fcfz.oa.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class logService {

    /***
     哪个用户 的 哪个日志界面
     **
     * 查询当前用户所有日志
     * @return 当前用户的所有日志
     * */
    public List<Log> showLog(String isLogin, String userId) {
        SqlSession session = MySqlSessionFactory.getSession();

        try {
            if (StringUtils.isEmpty(isLogin) == true)
                throw new ErrInfo("0000", "登陆状态异常");

            if (isLogin.equals("true") == false)
                throw new ErrInfo("0001", "该用户未登录");

//            判断用户了
            if (StringUtils.isEmpty(userId) == true) {
                throw new ErrInfo("0002", "传参！传参！你他妈倒是传参啊！" +
                        "" + "草！！！");
            }

            if (StringUtils.isNumeric(userId) == false) {
                throw new ErrInfo("0003", "连参数你都发的不是数字是吧，草泥马");
            }

            Integer uId = Integer.valueOf(userId);

            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<Log> logs = userMapper.selectAllLogByUserId(uId);

            if (logs.equals(null) == true || logs.size() <= 0) {
                throw new ErrInfo("0003", "无当前用户日志信息");
            }

            return logs;

        } catch (Exception e) {
            throw e;
        } finally {
            MySqlSessionFactory.closeSession();
        }
    }


    /***
     * 添加日志
     */
    public info addLog(String isLogin, String userId, String logTitle, String logContent, String logTime) {

        SqlSession session = MySqlSessionFactory.getSession();

        try {
            if (StringUtils.isEmpty(isLogin) == true)
                throw new ErrInfo("0000", "登陆状态异常");

            if (isLogin.equals("true") == false)
                throw new ErrInfo("0001", "该用户未登录");

//            判断用户了
            if (StringUtils.isEmpty(userId) == true) {
                throw new ErrInfo("0002", "用户id未找到或为空");
            }

            if (StringUtils.isNumeric(userId) == false) {
                throw new ErrInfo("0003", "用户id你发的不是数字，草泥马");
            }

            if (StringUtils.isEmpty(logTitle) == true) {
                throw new ErrInfo("0003", "标题内容没有，请给我一个标题");
            }

            if (StringUtils.isEmpty(logContent) == true) {
                throw new ErrInfo("0003", "日志内容没有，请填写详细的日志内容");
            }

            if (StringUtils.isEmpty(logTime) == true) {
                throw new ErrInfo("0003", "没有日志创建时间，请填写详细的日志创建时间");
            }


            LogMapper logMapper = session.getMapper(LogMapper.class);

            Log log = new Log();


            int insertResult = logMapper.insertSelective(log);
            session.commit();

            return null;
        } catch (Exception e) {
//事务回滚
            session.rollback();

            throw e;
        } finally {
            MySqlSessionFactory.closeSession();
        }
    }

}
