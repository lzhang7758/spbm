package com.zl.spbm.controller;

import com.zl.spbm.annotaion.RepeatAccess;
import com.zl.spbm.common.ResultMessage;
import com.zl.spbm.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: lzhang
 * @Date: 2019/6/28 14:03
 */
@Controller
@Slf4j
public class RepeatAccessCotroller {

    @ResponseBody
    @RequestMapping(path = "/redisTest")
    @RepeatAccess(key = "#userInfo")
    public Object redisTest(UserInfo userInfo){
        return new ResultMessage(0,"ok",userInfo);
    }
}
