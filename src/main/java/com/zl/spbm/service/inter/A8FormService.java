package com.zl.spbm.service.inter;

import com.zl.spbm.entity.A8Form;

import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:00
 */
public interface A8FormService{


    int deleteByPrimaryKey(Long tempId);

    int insert(A8Form record);

    int insertOrUpdate(A8Form record);

    int insertOrUpdateSelective(A8Form record);

    int insertSelective(A8Form record);

    A8Form selectByPrimaryKey(Long tempId);

    int updateByPrimaryKeySelective(A8Form record);

    int updateByPrimaryKey(A8Form record);

    int updateBatch(List<A8Form> list);

    int batchInsert(List<A8Form> list);

}
