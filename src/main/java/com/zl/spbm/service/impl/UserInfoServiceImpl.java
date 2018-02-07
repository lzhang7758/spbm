package com.zl.spbm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.spbm.dao.UserInfoMapper;
import com.zl.spbm.entity.UserInfo;
import com.zl.spbm.service.inter.IUserInfoService;

/**  
 * Author: qk203   Date: 2018年1月26日  
 * Copyright @ 2018 Corpration Name  
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(UserInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(UserInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo selectByPrimaryKey(Integer uid) {
		return userInfoMapper.selectByPrimaryKey(uid);
	}

	@Override
	public int updateByPrimaryKeySelective(UserInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(UserInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo selectUserInfoByUserName(String userName) {
		return userInfoMapper.selectUserInfoByUserName(userName);
	}

}
