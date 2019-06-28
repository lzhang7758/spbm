package com.zl.spbm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * Author: qk203   Date: 2018年1月29日  
 * Copyright @ 2018 Corpration Name   
 */
@Controller
public class HomeController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Map<String,String> map) {
		logger.debug(" HomeController => /login");
		String exception = request.getParameter("shiroLoginFailure");
		logger.debug("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
            	logger.error("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
            	logger.error("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
            	logger.error("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                logger.error("else -- >" + exception);
            }
        }
        
        map.put("msg", msg);
        
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
	}
	
}
