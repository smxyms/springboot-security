package com.springboot.security.entity;

import lombok.Data;

/**
 * @Description
 * @Author 荼蘼
 * @Date 2020/5/22 23:19
 */
@Data
public class SysUser {
    private Integer id;
    private String name;
    private String password;
}
