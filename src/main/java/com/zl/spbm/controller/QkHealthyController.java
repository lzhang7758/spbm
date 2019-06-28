package com.zl.spbm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;

/**
 * @Author: lzhang
 * @Date: 2019/6/28 14:11
 */
@Controller
@Slf4j
public class QkHealthyController {
    @RequestMapping("/ok")
    public String checkOk(){
        InetAddress addr;
        String ip = "";
        String address = "";
        try{
            addr = InetAddress.getLocalHost();
            //获得机器IP　　
            ip = addr.getHostAddress();
            //获得机器名称
            address = addr.getHostName();
        }catch(Exception e){
            log.error("checkOk error:{}", e);
        }
        return ip + "|" + address;
    }
}
