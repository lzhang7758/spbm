package com.zl.spbm.dao;

import com.zl.spbm.entity.InfoPosition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:03
 */
public interface InfoPositionMapper {
    int deleteByPrimaryKey(Long postId);

    int insert(InfoPosition record);

    int insertOrUpdate(InfoPosition record);

    int insertOrUpdateSelective(InfoPosition record);

    int insertSelective(InfoPosition record);

    InfoPosition selectByPrimaryKey(Long postId);

    int updateByPrimaryKeySelective(InfoPosition record);

    int updateByPrimaryKey(InfoPosition record);

    int updateBatch(List<InfoPosition> list);

    int batchInsert(@Param("list") List<InfoPosition> list);
}