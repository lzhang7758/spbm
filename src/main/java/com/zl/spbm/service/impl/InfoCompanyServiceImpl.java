package com.zl.spbm.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zl.spbm.entity.InfoCompany;
import com.zl.spbm.dao.InfoCompanyMapper;
import com.zl.spbm.service.inter.InfoCompanyService;

import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
@Service
public class InfoCompanyServiceImpl implements InfoCompanyService{

    @Resource
    private InfoCompanyMapper infoCompanyMapper;

    @Override
    public int deleteByPrimaryKey(Long comId) {
        return infoCompanyMapper.deleteByPrimaryKey(comId);
    }

    @Override
    public int insert(InfoCompany record) {
        return infoCompanyMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(InfoCompany record) {
        return infoCompanyMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(InfoCompany record) {
        return infoCompanyMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(InfoCompany record) {
        return infoCompanyMapper.insertSelective(record);
    }

    @Override
    public InfoCompany selectByPrimaryKey(Long comId) {
        return infoCompanyMapper.selectByPrimaryKey(comId);
    }

    @Override
    public int updateByPrimaryKeySelective(InfoCompany record) {
        return infoCompanyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(InfoCompany record) {
        return infoCompanyMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<InfoCompany> list) {
        return infoCompanyMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<InfoCompany> list) {
        return infoCompanyMapper.batchInsert(list);
    }

}
