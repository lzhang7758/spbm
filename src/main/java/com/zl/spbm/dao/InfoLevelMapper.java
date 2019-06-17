package com.zl.spbm.dao;

import com.zl.spbm.entity.InfoLevel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public interface InfoLevelMapper {
    int deleteByPrimaryKey(Long lvId);

    int insert(InfoLevel record);

    int insertOrUpdate(InfoLevel record);

    int insertOrUpdateSelective(InfoLevel record);

    int insertSelective(InfoLevel record);

    InfoLevel selectByPrimaryKey(Long lvId);

    int updateByPrimaryKeySelective(InfoLevel record);

    int updateByPrimaryKey(InfoLevel record);

    int updateBatch(List<InfoLevel> list);

    int batchInsert(@Param("list") List<InfoLevel> list);
}