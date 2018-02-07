package com.zl.spbm.dao;

import java.util.List;

import com.zl.spbm.entity.InfoEmployee;

public interface InfoEmployeeMapper {
    int deleteByPrimaryKey(Long empId);

    int insert(InfoEmployee record);

    int insertSelective(InfoEmployee record);

    InfoEmployee selectByPrimaryKey(Long empId);

    int updateByPrimaryKeySelective(InfoEmployee record);

    int updateByPrimaryKey(InfoEmployee record);

	List<InfoEmployee> selectAllInfoEmployee();
}