package com.zl.spbm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zl.spbm.entity.InfoEmployee;
import com.zl.spbm.service.inter.IInfoEmployeeService;

/**   
 * Author: qk203   Date: 2018年2月8日  
 * Copyright @ 2018 Corpration Name   
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {
	Logger logger = LoggerFactory.getLogger(TransactionTest.class);
	@Autowired
	IInfoEmployeeService infoEmployeeService;
	
	@Test
	public void testTransaction() {
		InfoEmployee emp = infoEmployeeService.selectByPrimaryKey(950L);
		emp.setEmpAccount("张琴1");
		int resultCount = infoEmployeeService.updateByPrimaryKey(emp);
		logger.info(" update resultCount="+resultCount);
	}

}
