package com.zl.spbm.service.inter;

import com.zl.spbm.entity.InfoCompany;

import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public interface InfoCompanyService{


    int deleteByPrimaryKey(Long comId);

    int insert(InfoCompany record);

    int insertOrUpdate(InfoCompany record);

    int insertOrUpdateSelective(InfoCompany record);

    int insertSelective(InfoCompany record);

    InfoCompany selectByPrimaryKey(Long comId);

    int updateByPrimaryKeySelective(InfoCompany record);

    int updateByPrimaryKey(InfoCompany record);

    int updateBatch(List<InfoCompany> list);

    int batchInsert(List<InfoCompany> list);

}
