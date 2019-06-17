package com.zl.spbm.service.inter;

import com.zl.spbm.dao.InfoEmployeeMapper;
import com.zl.spbm.entity.InfoEmployee;

import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public interface InfoEmployeeService{


    int deleteByPrimaryKey(Long empId);

    int insert(InfoEmployee record);

    int insertOrUpdate(InfoEmployee record);

    int insertOrUpdateSelective(InfoEmployee record);

    int insertSelective(InfoEmployee record);

    InfoEmployee selectByPrimaryKey(Long empId);

    int updateByPrimaryKeySelective(InfoEmployee record);

    int updateByPrimaryKey(InfoEmployee record);

    int updateBatch(List<InfoEmployee> list);

    int batchInsert(List<InfoEmployee> list);

}
