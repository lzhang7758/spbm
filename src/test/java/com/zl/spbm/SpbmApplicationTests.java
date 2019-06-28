package com.zl.spbm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbmApplicationTests {

	@Autowired
    private MockMvc mvc;
	
	@Test
    public void writelog() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/log/writelog"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("ok"));  //测试接口返回内容
    }
	
	@Test
	public void contextLoads() {

	}

}
