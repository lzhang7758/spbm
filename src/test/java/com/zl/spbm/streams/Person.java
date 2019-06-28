package com.zl.spbm.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: lzhang
 * @Date: 2019/6/26 14:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private String job;
    private String gender;
    private int age;
    private int salary;
}
