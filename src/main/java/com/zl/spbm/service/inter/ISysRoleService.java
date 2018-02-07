package com.zl.spbm.service.inter;

import com.zl.spbm.entity.SysRole;

/**
 * Author: qk203 Date: 2018年1月29日 Copyright @ 2018 Corpration Name
 */
public interface ISysRoleService {
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
