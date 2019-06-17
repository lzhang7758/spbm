package com.zl.spbm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.spbm.dao.InfoEmployeeMapper;
import com.zl.spbm.entity.InfoEmployee;
import com.zl.spbm.service.inter.IInfoEmployeeService;

@Service("infoEmployeeService")
public class InfoEmployeeServiceImpl implements IInfoEmployeeService {

    @Autowired
    InfoEmployeeMapper employeeMapper;

    @Override
    public int deleteByPrimaryKey(Long empId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insert(InfoEmployee record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertSelective(InfoEmployee record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public InfoEmployee selectByPrimaryKey(Long empId) {
        return employeeMapper.selectByPrimaryKey(empId);
    }

    @Override
    public int updateByPrimaryKeySelective(InfoEmployee record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateByPrimaryKey(InfoEmployee record) {
        return employeeMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<InfoEmployee> selectAllInfoEmployee(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<InfoEmployee> empList = employeeMapper.selectAllInfoEmployee();
        PageInfo<InfoEmployee> pageInfo = new PageInfo<InfoEmployee>(empList);
        return pageInfo;
    }


}

