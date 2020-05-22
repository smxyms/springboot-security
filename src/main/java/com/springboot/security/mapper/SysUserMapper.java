package com.springboot.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.security.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author 荼蘼
 * @Date 2020/5/22 23:53
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
