package com.zl.spbm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.zl.spbm.entity.InfoEmployee;
import com.zl.spbm.service.inter.IInfoEmployeeService;
import com.zl.spbm.service.inter.IUserInfoService;
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
	private IInfoEmployeeService infoEmployeeService;

	@Test
	public void redisTest() {
		PageInfo<InfoEmployee> emp = infoEmployeeService.selectAllInfoEmployee(1, 10);
		Map<String, Object> map = new HashMap<String,Object>();
		for (InfoEmployee e : emp.getList()) {
			map.put(e.getEmpId()+"", e);
		}
		
		redisUtils.set("mapInfoEmployee", map);
		logger.debug("redisUtils.set=>进入了方法");
		Map<String, Object> map1 = (Map<String, Object>) redisUtils.get("mapInfoEmployee");
		Gson gson = new Gson();
		logger.debug("redisUtils.get=>result=" + gson.toJson(map1));
		
		if(redisUtils.exists("mapInfoEmployee")) {
			logger.debug("exists~~~~~");
			redisUtils.remove("mapInfoEmployee");
		}
		redisUtils.remove("mapInfoEmployee");
	}

}
