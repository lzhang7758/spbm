package com.zl.spbm.dao;

import com.zl.spbm.entity.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer urId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer urId);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}