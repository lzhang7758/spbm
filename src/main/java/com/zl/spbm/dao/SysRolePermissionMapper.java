package com.zl.spbm.dao;

import com.zl.spbm.entity.SysRolePermission;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(Integer rpId);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Integer rpId);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}