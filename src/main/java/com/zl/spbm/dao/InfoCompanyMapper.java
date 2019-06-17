package com.zl.spbm.dao;

import com.zl.spbm.entity.InfoCompany;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public interface InfoCompanyMapper {
    int deleteByPrimaryKey(Long comId);

    int insert(InfoCompany record);

    int insertOrUpdate(InfoCompany record);

    int insertOrUpdateSelective(InfoCompany record);

    int insertSelective(InfoCompany record);

    InfoCompany selectByPrimaryKey(Long comId);

    int updateByPrimaryKeySelective(InfoCompany record);

    int updateByPrimaryKey(InfoCompany record);

    int updateBatch(List<InfoCompany> list);

    int batchInsert(@Param("list") List<InfoCompany> list);
}