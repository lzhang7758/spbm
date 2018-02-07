package com.zl.spbm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zl.spbm.entity.InfoEmployee;
import com.zl.spbm.service.inter.IInfoEmployeeService;

@RestController
@EnableAutoConfiguration
@RequestMapping("info")
public class InfoEmployeeController {
	
	@Autowired
	IInfoEmployeeService infoEmpService;
	
	@RequestMapping("/emp")
	public Object getInfoEmp() {
		InfoEmployee employee = new InfoEmployee();
		employee.setEmpName("张三");
		return employee;
	}
	
	
    @RequestMapping(value = "/getEmpById/{empId}", produces = {"application/json;charset=UTF-8"})
    public Object getInfoEmployeeByEmpId(@PathVariable("empId") Long empId){
        return infoEmpService.selectByPrimaryKey(empId);
    }
	
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return infoEmpService.selectAllInfoEmployee(pageNum, pageSize);
    }

}
