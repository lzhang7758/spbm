package com.zl.spbm.dao;

import com.zl.spbm.entity.InfoDepartment;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public interface InfoDepartmentMapper {
    int deleteByPrimaryKey(Long depId);

    int insert(InfoDepartment record);

    int insertOrUpdate(InfoDepartment record);

    int insertOrUpdateSelective(InfoDepartment record);

    int insertSelective(InfoDepartment record);

    InfoDepartment selectByPrimaryKey(Long depId);

    int updateByPrimaryKeySelective(InfoDepartment record);

    int updateByPrimaryKey(InfoDepartment record);

    int updateBatch(List<InfoDepartment> list);

    int batchInsert(@Param("list") List<InfoDepartment> list);
}