package com.zl.spbm.service.inter;

import com.zl.spbm.entity.SysPermission;

/**   
 * Author: qk203   Date: 2018年1月29日  
 * Copyright @ 2018 Corpration Name   
 */
public interface ISysPermissionService {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}
