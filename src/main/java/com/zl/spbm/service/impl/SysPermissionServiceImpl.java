package com.zl.spbm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zl.spbm.dao.SysPermissionMapper;
import com.zl.spbm.entity.SysPermission;
import com.zl.spbm.service.inter.ISysPermissionService;

/**   
 * Author: qk203   Date: 2018年2月5日  
 * Copyright @ 2018 Corpration Name   
 */
@Component
public class SysPermissionServiceImpl implements ISysPermissionService {
	@Autowired
	SysPermissionMapper sysPermissionMapper;

	@Override
	public int deleteByPrimaryKey(Integer permissionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysPermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysPermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysPermission selectByPrimaryKey(Integer permissionId) {
		return sysPermissionMapper.selectByPrimaryKey(permissionId);
	}

	@Override
	public int updateByPrimaryKeySelective(SysPermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysPermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
