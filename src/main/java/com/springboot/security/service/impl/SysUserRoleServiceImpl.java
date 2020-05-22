package com.springboot.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.entity.SysUserRole;
import com.springboot.security.mapper.SysUserRoleMapper;
import com.springboot.security.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 荼蘼
 * @Date 2020/5/22 23:59
 */
@Service("sysuserroleservice")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {
}
