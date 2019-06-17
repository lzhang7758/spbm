package com.zl.spbm.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zl.spbm.dao.InfoLevelMapper;
import com.zl.spbm.entity.InfoLevel;
import com.zl.spbm.service.inter.InfoLevelService;

import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
@Service
public class InfoLevelServiceImpl implements InfoLevelService{

    @Resource
    private InfoLevelMapper infoLevelMapper;

    @Override
    public int deleteByPrimaryKey(Long lvId) {
        return infoLevelMapper.deleteByPrimaryKey(lvId);
    }

    @Override
    public int insert(InfoLevel record) {
        return infoLevelMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(InfoLevel record) {
        return infoLevelMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(InfoLevel record) {
        return infoLevelMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(InfoLevel record) {
        return infoLevelMapper.insertSelective(record);
    }

    @Override
    public InfoLevel selectByPrimaryKey(Long lvId) {
        return infoLevelMapper.selectByPrimaryKey(lvId);
    }

    @Override
    public int updateByPrimaryKeySelective(InfoLevel record) {
        return infoLevelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(InfoLevel record) {
        return infoLevelMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<InfoLevel> list) {
        return infoLevelMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<InfoLevel> list) {
        return infoLevelMapper.batchInsert(list);
    }

}
