package com.zl.spbm.proxy;

/**
 * @Author: lzhang
 * @Date: 2019/9/26 13:11
 */
public class UserServiceImpl implements UserService {
    @Override
    public int insert() {
        System.out.println("insert");
        query();
        return 0;
    }

    @Override
    public String query() {
        System.out.println("query");
        return null;
    }
}
