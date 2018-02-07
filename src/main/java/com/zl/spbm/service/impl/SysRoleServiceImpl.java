package com.zl.spbm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.spbm.dao.SysRoleMapper;
import com.zl.spbm.entity.SysRole;
import com.zl.spbm.service.inter.ISysRoleService;

/**   
 * Author: qk203   Date: 2018年1月29日  
 * Copyright @ 2018 Corpration Name   
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements ISysRoleService {

	@Autowired
	SysRoleMapper sysRoleMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer roleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysRole selectByPrimaryKey(Integer roleId) {
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public int updateByPrimaryKeySelective(SysRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysRole selectSysRoleById(Integer roleId) {
		return sysRoleMapper.selectSysRoleById(roleId);
	}

}
