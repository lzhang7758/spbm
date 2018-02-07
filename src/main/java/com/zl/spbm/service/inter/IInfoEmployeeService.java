package com.zl.spbm.service.inter;

import com.github.pagehelper.PageInfo;
import com.zl.spbm.entity.InfoEmployee;

public interface IInfoEmployeeService {
    int deleteByPrimaryKey(Long empId);

    int insert(InfoEmployee record);

    int insertSelective(InfoEmployee record);

    InfoEmployee selectByPrimaryKey(Long empId);

    int updateByPrimaryKeySelective(InfoEmployee record);

    int updateByPrimaryKey(InfoEmployee record);
    
    PageInfo<InfoEmployee> selectAllInfoEmployee(int pageNum,int pageSize);
}
