package com.zl.spbm.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.spbm.service.inter.ISysPermissionService;
import com.zl.spbm.service.inter.ISysRoleService;
import com.zl.spbm.service.inter.IUserInfoService;

/**  
 * Package: com.zl.spbm.controller  
 *  
 * Author: qk203   Date: 2018年1月26日  
 *  
 * Copyright @ 2018 Corpration Name  
 *   
 */
@Controller
@RequestMapping("userInfo")
public class UserController {
	
	@Autowired
	IUserInfoService userInfoService;
	
	@Autowired
	ISysPermissionService sysPermissionService;
	
	@Autowired
	ISysRoleService sysRoleService;
	
	@ResponseBody
    @RequestMapping(value = "/getUserById/{uid}", produces = {"application/json;charset=UTF-8"})
    public Object getInfoEmployeeByEmpId(@PathVariable("uid") Integer uid){
        return userInfoService.selectByPrimaryKey(uid);
    }
    
	@ResponseBody
    @RequestMapping(value = "/getPermission/{id}", produces = {"application/json;charset=UTF-8"})
    public Object getPermission(@PathVariable("id") Integer id) {
    	return sysPermissionService.selectByPrimaryKey(id);
    }
    
	@ResponseBody
    @RequestMapping(value = "/getRole/{id}", produces = {"application/json;charset=UTF-8"})
    public Object getRole(@PathVariable("id") Integer id) {
    	return sysRoleService.selectByPrimaryKey(id);
    }
	
	@ResponseBody
    @RequestMapping(value = "/getUserByName/{username}", produces = {"application/json;charset=UTF-8"})
    public Object getUserByName(@PathVariable("username") String username) {
    	return userInfoService.selectUserInfoByUserName(username);
    }
    
    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }
    
}
