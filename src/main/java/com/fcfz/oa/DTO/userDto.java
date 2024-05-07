package com.fcfz.oa.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userDto {

//    用户状态
    private String userName;
    private String roleName;
//    private String token;
}
