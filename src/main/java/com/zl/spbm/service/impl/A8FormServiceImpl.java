package com.zl.spbm.service.impl;

import com.zl.spbm.dao.A8FormMapper;
import com.zl.spbm.entity.A8Form;
import com.zl.spbm.service.inter.A8FormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:00
 */
@Service
public class A8FormServiceImpl implements A8FormService{

    @Resource
    private A8FormMapper a8FormMapper;

    @Override
    public int deleteByPrimaryKey(Long tempId) {
        return a8FormMapper.deleteByPrimaryKey(tempId);
    }

    @Override
    public int insert(A8Form record) {
        return a8FormMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(A8Form record) {
        return a8FormMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(A8Form record) {
        return a8FormMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(A8Form record) {
        return a8FormMapper.insertSelective(record);
    }

    @Override
    public A8Form selectByPrimaryKey(Long tempId) {
        return a8FormMapper.selectByPrimaryKey(tempId);
    }

    @Override
    public int updateByPrimaryKeySelective(A8Form record) {
        return a8FormMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(A8Form record) {
        return a8FormMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<A8Form> list) {
        return a8FormMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<A8Form> list) {
        return a8FormMapper.batchInsert(list);
    }

}
