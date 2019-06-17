package com.zl.spbm.dao;

import com.zl.spbm.entity.InfoGroup;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public interface InfoGroupMapper {
    int deleteByPrimaryKey(Long usgId);

    int insert(InfoGroup record);

    int insertOrUpdate(InfoGroup record);

    int insertOrUpdateSelective(InfoGroup record);

    int insertSelective(InfoGroup record);

    InfoGroup selectByPrimaryKey(Long usgId);

    int updateByPrimaryKeySelective(InfoGroup record);

    int updateByPrimaryKey(InfoGroup record);

    int updateBatch(List<InfoGroup> list);

    int batchInsert(@Param("list") List<InfoGroup> list);
}