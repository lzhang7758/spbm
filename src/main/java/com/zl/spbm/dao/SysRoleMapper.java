package com.zl.spbm.dao;

import com.zl.spbm.entity.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
	/**
	 * 根据roleId 查询 角色及对应权限
	 * @param roleId
	 * @return
	 */
	SysRole selectSysRoleById(Integer roleId);
}