package com.zl.spbm.service.inter;

import com.zl.spbm.entity.UserInfo;

/**  
 * Package: com.zl.spbm.service.inter  
 *  
 * Author: qk203   Date: 2018年1月26日  
 *  
 * Copyright @ 2018 Corpration Name  
 *   
 */
public interface IUserInfoService {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

	UserInfo selectUserInfoByUserName(String userName);
}
