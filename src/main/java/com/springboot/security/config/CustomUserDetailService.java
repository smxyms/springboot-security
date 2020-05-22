package com.springboot.security.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.security.entity.SysRole;
import com.springboot.security.entity.SysUser;
import com.springboot.security.entity.SysUserRole;
import com.springboot.security.service.ISysRoleService;
import com.springboot.security.service.ISysUserRoleService;
import com.springboot.security.service.ISysUserService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author 荼蘼
 * @Date 2020/5/22 23:07
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        QueryWrapper userWrapper = new QueryWrapper();
        userWrapper.eq("name",username);
        List<SysUser> users = sysUserService.list(userWrapper);
        if(users == null || users.size() == 0){
            throw new RuntimeException("该用户不存在");
        }
        SysUser sysUser = users.get(0);
        QueryWrapper userRoleWrapper = new QueryWrapper();
        userRoleWrapper.eq("user_id",sysUser.getId());
        List<SysUserRole> list = sysUserRoleService.list(userRoleWrapper);
        if(list == null && list.size() == 0){
           return new User(username,sysUser.getPassword(),authorities);
        }

        List<Integer> roleIds = list.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        for(Integer roleId : roleIds){
            SysRole sysRole = sysRoleService.getById(roleId);
            authorities.add(new SimpleGrantedAuthority(sysRole.getName()));
        }
        return new User(username,sysUser.getPassword(),authorities);
    }

}
