package com.zl.spbm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zl.spbm.service.inter.IInfoEmployeeService;
import com.zl.spbm.utils.RedisUtils;

/**
 * Author: qk203 Date: 2018年2月8日 Copyright @ 2018 Corpration Name
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheTest {

	Logger logger = LoggerFactory.getLogger(RedisCacheTest.class);

	@Autowired
	private RedisUtils redisUtils;

	@Autowired
	IInfoEmployeeService infoEmpService;

	@Test
	public void redisTest() {
		redisUtils.set("张三", infoEmpService.selectByPrimaryKey(1220L));
		redisUtils.set("张三1", infoEmpService.selectByPrimaryKey(951L));
	}

}
