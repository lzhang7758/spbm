package com.zl.spbm.service.inter;

import com.zl.spbm.entity.InfoDepartment;

import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public interface InfoDepartmentService{


    int deleteByPrimaryKey(Long depId);

    int insert(InfoDepartment record);

    int insertOrUpdate(InfoDepartment record);

    int insertOrUpdateSelective(InfoDepartment record);

    int insertSelective(InfoDepartment record);

    InfoDepartment selectByPrimaryKey(Long depId);

    int updateByPrimaryKeySelective(InfoDepartment record);

    int updateByPrimaryKey(InfoDepartment record);

    int updateBatch(List<InfoDepartment> list);

    int batchInsert(List<InfoDepartment> list);

}
