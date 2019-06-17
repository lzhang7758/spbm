package com.zl.spbm.service.inter;

import com.zl.spbm.entity.InfoGroup;

import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public interface InfoGroupService{


    int deleteByPrimaryKey(Long usgId);

    int insert(InfoGroup record);

    int insertOrUpdate(InfoGroup record);

    int insertOrUpdateSelective(InfoGroup record);

    int insertSelective(InfoGroup record);

    InfoGroup selectByPrimaryKey(Long usgId);

    int updateByPrimaryKeySelective(InfoGroup record);

    int updateByPrimaryKey(InfoGroup record);

    int updateBatch(List<InfoGroup> list);

    int batchInsert(List<InfoGroup> list);

}
