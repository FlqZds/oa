package com.fcfz.oa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Log {
    private Integer logId;

    private String logTitle="默认标题";

    private String logUploadfilepath;

    private Integer userId;

    private Integer roleId;

    private String logContent;

//    日志提交时间
    private Date logTime;

}