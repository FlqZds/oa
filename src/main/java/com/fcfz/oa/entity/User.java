package com.fcfz.oa.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @JSONField(ordinal = 1)
    private Integer userId;

    @JSONField(ordinal = 2)
    private String userName;

    @JSONField(ordinal = 3)
    private String userCount;

    @JSONField(ordinal = 4)
    private String password;

    @JSONField(ordinal = 5)
    private Date createTime;

    @JSONField(ordinal = 6)
    private String usertel;
}