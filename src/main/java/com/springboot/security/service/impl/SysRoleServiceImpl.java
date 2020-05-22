package com.springboot.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.entity.SysRole;
import com.springboot.security.mapper.SysRoleMapper;
import com.springboot.security.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 荼蘼
 * @Date 2020/5/22 23:58
 */
@Service("sysroleservice")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
}
