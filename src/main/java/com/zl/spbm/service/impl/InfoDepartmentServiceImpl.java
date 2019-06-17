package com.zl.spbm.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zl.spbm.entity.InfoDepartment;
import com.zl.spbm.dao.InfoDepartmentMapper;
import com.zl.spbm.service.inter.InfoDepartmentService;

import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
@Service
public class InfoDepartmentServiceImpl implements InfoDepartmentService{

    @Resource
    private InfoDepartmentMapper infoDepartmentMapper;

    @Override
    public int deleteByPrimaryKey(Long depId) {
        return infoDepartmentMapper.deleteByPrimaryKey(depId);
    }

    @Override
    public int insert(InfoDepartment record) {
        return infoDepartmentMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(InfoDepartment record) {
        return infoDepartmentMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(InfoDepartment record) {
        return infoDepartmentMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(InfoDepartment record) {
        return infoDepartmentMapper.insertSelective(record);
    }

    @Override
    public InfoDepartment selectByPrimaryKey(Long depId) {
        return infoDepartmentMapper.selectByPrimaryKey(depId);
    }

    @Override
    public int updateByPrimaryKeySelective(InfoDepartment record) {
        return infoDepartmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(InfoDepartment record) {
        return infoDepartmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<InfoDepartment> list) {
        return infoDepartmentMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<InfoDepartment> list) {
        return infoDepartmentMapper.batchInsert(list);
    }

}
