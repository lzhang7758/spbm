package com.zl.spbm.common;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zl.spbm.utils.DateUtil;

/**
 * 定时任务
 * @author qk203
 *
 */
@Component
public class SchedulerTask {

	Logger logger = LoggerFactory.getLogger(Scheduled.class);
    private int count=0;

    @Scheduled(cron="*/50 * * * * ?")
    private void process(){
    	logger.info("this is scheduler task runing count={} date={}",count++,DateUtil.DateToStr(new Date(), DateUtil.YYMMDDHHMMSS_));
    }

}
