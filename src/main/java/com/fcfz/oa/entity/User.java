package com.fcfz.oa.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer userId=-1;

    private String userName="-1";

    private String userCount="-1";

    private String password="-1";

    private Integer userRole=-1;

    private Date createTime=new Date();

}