package com.zl.spbm.dao;

import com.zl.spbm.entity.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

	UserInfo selectUserInfoByUserName(String userName);
}