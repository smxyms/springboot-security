package com.springboot.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.entity.SysUser;
import com.springboot.security.mapper.SysUserMapper;
import com.springboot.security.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 荼蘼
 * @Date 2020/5/22 23:52
 */
@Service("sysuserservice")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
}
