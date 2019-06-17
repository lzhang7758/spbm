package com.zl.spbm.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zl.spbm.entity.InfoPosition;
import com.zl.spbm.dao.InfoPositionMapper;
import com.zl.spbm.service.inter.InfoPositionService;

import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
@Service
public class InfoPositionServiceImpl implements InfoPositionService{

    @Resource
    private InfoPositionMapper infoPositionMapper;

    @Override
    public int deleteByPrimaryKey(Long postId) {
        return infoPositionMapper.deleteByPrimaryKey(postId);
    }

    @Override
    public int insert(InfoPosition record) {
        return infoPositionMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(InfoPosition record) {
        return infoPositionMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(InfoPosition record) {
        return infoPositionMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(InfoPosition record) {
        return infoPositionMapper.insertSelective(record);
    }

    @Override
    public InfoPosition selectByPrimaryKey(Long postId) {
        return infoPositionMapper.selectByPrimaryKey(postId);
    }

    @Override
    public int updateByPrimaryKeySelective(InfoPosition record) {
        return infoPositionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(InfoPosition record) {
        return infoPositionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<InfoPosition> list) {
        return infoPositionMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<InfoPosition> list) {
        return infoPositionMapper.batchInsert(list);
    }

}
