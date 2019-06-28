package com.zl.spbm.service.impl;

import com.zl.spbm.annotaion.RedisLock;
import com.zl.spbm.dao.UserInfoMapper;
import com.zl.spbm.entity.UserInfo;
import com.zl.spbm.service.inter.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return userInfoMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public int insert(UserInfo record) {
		return userInfoMapper.insert(record);
	}

	@Override
	@RedisLock(key = "#userInfoService:insertSelective:UserInfo")
	public int insertSelective(UserInfo record) {
		return userInfoMapper.insertSelective(record);
	}

	@Override
	public UserInfo selectByPrimaryKey(Integer uid) {
		return userInfoMapper.selectByPrimaryKey(uid);
	}

	@Override
	public int updateByPrimaryKeySelective(UserInfo record) {
		return userInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserInfo record) {
		return userInfoMapper.updateByPrimaryKey(record);
	}

	@Override
	public UserInfo selectUserInfoByUserName(String userName) {
		return userInfoMapper.selectUserInfoByUserName(userName);
	}

}
