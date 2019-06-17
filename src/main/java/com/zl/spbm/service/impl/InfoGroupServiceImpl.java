package com.zl.spbm.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zl.spbm.entity.InfoGroup;
import com.zl.spbm.dao.InfoGroupMapper;
import com.zl.spbm.service.inter.InfoGroupService;

import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
@Service
public class InfoGroupServiceImpl implements InfoGroupService{

    @Resource
    private InfoGroupMapper infoGroupMapper;

    @Override
    public int deleteByPrimaryKey(Long usgId) {
        return infoGroupMapper.deleteByPrimaryKey(usgId);
    }

    @Override
    public int insert(InfoGroup record) {
        return infoGroupMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(InfoGroup record) {
        return infoGroupMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(InfoGroup record) {
        return infoGroupMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(InfoGroup record) {
        return infoGroupMapper.insertSelective(record);
    }

    @Override
    public InfoGroup selectByPrimaryKey(Long usgId) {
        return infoGroupMapper.selectByPrimaryKey(usgId);
    }

    @Override
    public int updateByPrimaryKeySelective(InfoGroup record) {
        return infoGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(InfoGroup record) {
        return infoGroupMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<InfoGroup> list) {
        return infoGroupMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<InfoGroup> list) {
        return infoGroupMapper.batchInsert(list);
    }

}
