package com.zl.spbm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class A8Form {
    private Long tempId;

    /**
    * 查询语句
    */
    private String tempSql;

    /**
    * 表单类型
    */
    private String tempType;

    public A8Form(String tempSql, String tempType) {
        this.tempSql = tempSql;
        this.tempType = tempType;
    }
}