package com.zl.spbm;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author: lzhang
 * @Date: 2019/6/26 15:50
 */
public class ClockTest {

    @Test
    public void clock(){
        Clock c = Clock.systemDefaultZone();
        System.out.println(System.currentTimeMillis());
        System.out.println(c.millis());

        Date date = Date.from(c.instant());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

        //纳秒
        Instant in = Instant.now();
        System.out.println(in);

        // 将现在的时间增加3小时2分,将产生新的实例
        Instant in1 = in.plus(Duration.ofHours(3).plusMillis(2));
        System.out.println(in1);
        System.out.println(in1 == in);

        Instant inBefor5_01 = in.minus(5, ChronoUnit.DAYS);
        Instant inBefor5_02 = in.minus(Duration.ofDays(5));

        //比较分钟数
        long diffAsMinutes1 = ChronoUnit.MINUTES.between(inBefor5_01,inBefor5_02);
        System.out.println(diffAsMinutes1);

        // instant是可比较的，有isAfter和isBefore
        System.out.println(in.isAfter(in1));
        System.out.println(in.isBefore(in1));

    }
}
