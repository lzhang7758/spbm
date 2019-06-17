package com.zl.spbm.controller;

import com.zl.spbm.entity.A8Form;
import com.zl.spbm.service.inter.A8FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: lzhang
 * @Date: 2019/4/11 17:29
 */
@Controller
public class A8FormServiceController {

    @Autowired
    A8FormService a8FormService;

    @GetMapping("/batchInsert")
    @ResponseBody
    public int batchInsert() {
        List<A8Form> list = Stream.of(new A8Form("sql=1","type=1"),
                new A8Form("sql=1","type=2"),
                new A8Form("sql=1","type=3")
                ).collect(Collectors.toList());
        int result = a8FormService.batchInsert(list);
        return result;
    }


}
