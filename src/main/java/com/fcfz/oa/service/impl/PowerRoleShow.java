package com.fcfz.oa.service.impl;

import com.fcfz.oa.DTO.userDto;
import com.fcfz.oa.common.ErrInfo;
import com.fcfz.oa.common.info;
import com.fcfz.oa.common.utils.MySqlSessionFactory;
import com.fcfz.oa.mapper.UsertoroleMapper;
import com.fcfz.oa.service.i_role;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Objects;

public class PowerRoleShow implements i_role {


    /***
     * 展示用户的角色
     * @param userId 当前用户的id
     * @return 用户持有的角色
     */
    public info showRole(String isLogin,String userId) {
        SqlSession session = MySqlSessionFactory.getSession();
        try {
            if (StringUtils.isEmpty(userId)==true) {
                throw new ErrInfo("852741", "用户id为空");
            }

            if (StringUtils.isNumeric(userId)==false) {
                throw new ErrInfo("741852", "用户id参数不正确");
            }

            int uId = Integer.parseInt(userId);

            UsertoroleMapper userToRole = session.getMapper(UsertoroleMapper.class);

            userDto userDto = userToRole.RoleOfThisUser(uId);


            if (Objects.isNull(userDto) == true) {
                throw new ErrInfo("789789", "无当前角色");
            }


            return new info("200", "用户角色查询成功", userDto, null, userId);

        } catch (Exception e) {
            throw e;
        } finally {
            MySqlSessionFactory.closeSession();
        }

    }
}
