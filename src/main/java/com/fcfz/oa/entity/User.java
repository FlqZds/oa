package com.fcfz.oa.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @JSONField(ordinal = 1)
    private Integer userId=-1;
    @JSONField(ordinal = 2)
    private String userName="-1";
    @JSONField(ordinal = 3)
    private String userCount="-1";
    @JSONField(ordinal = 4)
    private String password="-1";
    @JSONField(ordinal = 5)
    private Integer userRole=-1;
    @JSONField(ordinal = 6)
    private Date createTime=new Date();



}