package com.zl.spbm.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.util.StringUtils;


/**
 * 日期
 * @author
 *
 */
public class DateUtil {

	public static final String YYMMDD = "yyMMdd";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYMMDDHHMMSS = "yyMMddHHmmss";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	

	public static final String HHMMSS_ = "HH:mm:ss";
	public static final String YYMMDD_ = "yy-MM-dd";
	public static final String YYYYMMDD_ = "yyyy-MM-dd";
	public static final String YYYYMMDDHHMM_ = "yyyy-MM-dd HH:mm";
	public static final String YYYYMMDDHHMM_STR = "yyyy年MM月dd日 HH:mm";
	public static final String YYYYMMDD_STR = "yyyy年MM月dd日";
	
	public static final String YYMMDDHHMMSS_ = "yy-MM-dd HH:mm:ss";
	public static final String YYYYMMDDHHMMSS_ = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDDHHMMSSSSS_ = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String YYYYMMDDHHMMSSSSS_STR = "yyyyMMddHHmmssSSS";
	public static final String YYYYMM_ = "yyyy-MM";
	public static final String HHMM_ = "HH:mm";

	public static final String YYMMDD_B = "yy/MM/dd";
	public static final String YYYYMMDD_B = "yyyy/MM/dd";
	public static final String YYMMDDHHMMSS_B = "yy/MM/dd HH:mm:ss";
	public static final String YYYYMMDDHHMMSS_B = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @return str
	 */
	public static String DateToStr(Date date, String fmt) {

		SimpleDateFormat format = new SimpleDateFormat(fmt);
		String str = format.format(date);
		return str;
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param str
	 * @return date
	 */
	public static Date StrToDate(String str, String fmt) {
		if(StringUtils.isEmpty(str)){
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(fmt);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}

	/**
	 * Get next day
	 * 
	 * @param date
	 *            　Date String(yyyy-MM-dd)
	 * @param day
	 *            (-1,last day,+1,next day)
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String nextDay(String date, int day) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD_);
			Date dt = (Date) (sdf.parseObject(date));
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(dt);
			calendar.add(calendar.DATE, day);
			dt = calendar.getTime();
			date = sdf.format(dt);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * Get next Year
	 * 
	 * @param date
	 *            　Date String(yyyy-MM-dd)
	 * @param day
	 *            (-1,last year,+1,next year)
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String nextYear(String date, int year) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD_);
			Date dt = (Date) (sdf.parseObject(date));
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(dt);
			calendar.add(calendar.YEAR, year);
			dt = calendar.getTime();
			date = sdf.format(dt);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	

	/**
	 * Get next day
	 * 
	 * @param date
	 *            　Date Type(java.util.Date,yyyy-MM-dd)
	 * @param day
	 *            (-1,last day,+1,next day)
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String nextDay(Date dt, int day) {
		String date = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD_);
			//dt = (Date) (sdf.parseObject(date));
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(dt);
			calendar.add(calendar.DATE, day);
			dt = calendar.getTime();
			date = sdf.format(dt);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	/**
	 * Get next day
	 * 
	 * @param date
	 *            　Date String(yyyy-MM-dd)
	 * @param day
	 *            (-1,last day,+1,next day)
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Date nextDayDate(String date, int day) {
		Date dt =null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD_);
			dt = (Date) (sdf.parseObject(date));
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(dt);
			calendar.add(calendar.DATE, day);
			dt = calendar.getTime();
			

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	/**
	 * Get next day
	 * 
	 * @param date
	 *            　Date (yyyy-MM-dd)
	 * @param day
	 *            (-1,last day,+1,next day)
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Date nextDayDate(Date date, int day) {
		try {
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(calendar.DATE, day);
			date = calendar.getTime();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/** 获取该Date中的日 */
	public static int getDay(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		String day = sdf.format(date);
		return Integer.parseInt(day);
	}
	/** 获取该Date中的时间(09:00) */
	public static String getTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(HHMM_);
		String day = sdf.format(date);
		return day;
	}
	/**获取指定时间中的日期(去掉时分秒至00:00)*/
	public static Date getDate(Date date){
		SimpleDateFormat fmt = new SimpleDateFormat(YYYYMMDD_); 
		String dt=fmt.format(date);
		return StrToDate(dt, YYYYMMDD_);
	}
	/**获取指定时间中的日期(去掉时分秒至00:00)*/
	public static String getDateStr(Date date){
		SimpleDateFormat fmt = new SimpleDateFormat(YYYYMMDD_); 
		String dt=fmt.format(date);
		return dt.substring(0, 10);
	}
	
	/**
	 * 获取该Date中的时间(09:00)
	 * @param date {2015-04-15 11:50:27}
	 * @return
	 */
	public static String getTime(String date) {
		
		return date.substring(11, 16);
	}
	
	/**获取当天日期*/
	public static int getTodayNum(){
		Calendar cal = Calendar.getInstance();
		//cal.setTime(dt);
		
	    
		return cal.get(Calendar.DAY_OF_MONTH);
		
		//String today=new Timestamp(System.currentTimeMillis()).toString().substring(0, 10);
		//return StrToDate(today, YYYYMMDD_);
	}
	
	/**获取当天日期*/
	public static Date getToday(){
		String today=new Timestamp(System.currentTimeMillis()).toString().substring(0, 10);
		return StrToDate(today, YYYYMMDD_);
	}
	/**获取当天日期字符串*/
	public static String getTodayStr(){
		String today=new Timestamp(System.currentTimeMillis()).toString().substring(0, 10);
		return today;
	}
	/**获取当天时间*/
	public static Date getTodayTime(){
		String today=getTodayTimeStr();//new Timestamp(System.currentTimeMillis()).toString().substring(0, 18);
		return StrToDate(today, YYYYMMDDHHMMSS_);
	}
	/**获取当天字符串*/
	public static String getTodayTimeStr(){
		String today=new Timestamp(System.currentTimeMillis()).toString().substring(0, 18);
		return today;
	}

	
	public static int getHour(Date dt){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		
	    
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 获取某年某月的天数
	 */
	public static int getDaysOfMonth(String str,String fmt){
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat(fmt);     
        try {
          rightNow.setTime(simpleDate.parse(str)); 
        } catch (ParseException e) {
          e.printStackTrace();
        }
        int days = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }
	
	/**
	 * 获取本月总共天数
	 * @return
	 */
	public static int getDaysOfMonth(){
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat(YYYYMMDD_);     
        try {
          rightNow.setTime(simpleDate.parse(getTodayStr())); 
        } catch (ParseException e) {
          e.printStackTrace();
        }
        int days = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }
	
	/**
	 * 获取今天到月底的天数
	 * @param str
	 * @param fmt
	 * @return
	 */
	public static int getDaysTTM(){
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat(YYYYMMDD_);     
		try {
			rightNow.setTime(simpleDate.parse(getTodayStr())); 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//getTodayStr()
		int days = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
		return days;
	}
	
	
	/**
	 * 获取两个日期相差的时间(b-a)
	 * @param a
	 * @param b
	 * @return 返回时间 (单位:秒s)
	 */
	public static long getSubtract(Date a,Date b){
		Calendar aDate=Calendar.getInstance(),bDate=Calendar.getInstance();
		aDate.setTime(a);
		bDate.setTime(b);
		long timeA=aDate.getTimeInMillis();
		long timeB=bDate.getTimeInMillis();
		//long 相隔天数=(timeNow-timeOld)/(1000*60*60*24);//
		return (timeB-timeA)/1000;
	}
	
	/**
	 * 获取两个日期相差的时间(b-a)
	 * @param a
	 * @param b
	 * @return 返回时间 (单位:秒s)
	 */
	public static long getSubtract(String a1,String b1,String fmt){
		Date a=StrToDate(a1, fmt);
		Date b=StrToDate(b1, fmt);
		return getSubtract(a, b);
	}
	
	/**获取当前月份*/
	public static String getMonth(){
		return DateToStr(getTodayTime(), YYYYMM_);
	}
	
	/**
	 * 获取当前月
	 * @return
	 */
	public static Date getMonthDate(){
		SimpleDateFormat fmt = new SimpleDateFormat(YYYYMM_); 
		String dt=fmt.format(new Date());
		return StrToDate(dt, YYYYMM_);
		
	}
	/**
	 * 获取当前月
	 * @return
	 */
	public static Date getMonthDate(Date date){
		SimpleDateFormat fmt = new SimpleDateFormat(YYYYMM_); 
		String dt=fmt.format(date);
		return StrToDate(dt, YYYYMM_);
		
	}
	/**
	 * 获取指定月
	 * @return
	 */
	public static Date getNextMonthDate(Date date,int num){
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.MONTH, num);
		return cal.getTime();
		
	}
	
	/**
	 * 获取指定月
	 * @return YYYY-MM
	 */
	public static String getNextMonth(Date date,int num){
		date=getNextMonthDate(date, num);
		return DateToStr(date, YYYYMM_);
		
	}
	/***
	 * 获取指定日期的月份
	 * @param dt
	 * @return YYYY-MM
	 */
	public static String getMonthByDate(Date dt){
		return DateToStr(dt, YYYYMM_);
	}
	
	/**
	 * 获取指定日期为周几
	 * @param dt
	 * @return
	 */
	public static int getWeekNum(Date dt){
		int week=0;
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dt);
	    week=cal.get(Calendar.DAY_OF_WEEK);
	    
	    return week;
	}
	
	
	/**
	 * 获取某年某月某天是星期几
	 */
	public static String getWeek(String str,String fmt){
		Calendar time =Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(fmt);
		Date date = null;
		int week=0;
		try {
			date = format.parse(str);
			time.setTime(date);
			int day=time.get(Calendar.DAY_OF_WEEK);
			week=day-1;
			//大小写转换
		} catch (Exception e) {
			e.printStackTrace();
		}
		switch (week) {
		case 1:
			return "一";
		case 2:
			return "二";
		case 3:
			return "三";
		case 4:
			return "四";
		case 5:
			return "五";
		case 6:
			return "六";
		default:
			return "日";
		}
	}
	

	/**时间段排序*/
	public static List<String> sortDate(List<String> list) {
		List<String > newList = new ArrayList<String>();
		for (String str : list) {
			if(!str.contains("N")){
				newList.add(str);
			}else{
				if(str.contains("~N")&&!str.contains("N~N")){
					String tmp=str.substring(0, str.indexOf("~N"));
					str=str.replaceAll("~N", "~"+tmp);
					newList.add(str);
				}
			}
		}
		String[] result = new String[newList.size()];
		Arrays.sort(newList.toArray(result));
		return Arrays.asList(result);
	}
	
	/**b-a*/
	public static long timeRangeNum(String atime,String btime){
		long num=getSubtract(atime, btime, HHMM_);
		if(num<0){
			return 0;
		}
		return num/60;
	}
	
	/** 两个时间段  返回间隔时间list  添加人：gcs */
	public static List<Date> TimeInterval(Date dt1, Date dt2) {
		String date1=DateToStr(dt1, YYYYMMDDHHMMSS_);
		String date2=DateToStr(dt2, YYYYMMDDHHMMSS_);
		SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMMSS_);
		List<Date> list = new ArrayList<Date>();
		if (date1.equals(date2)) {
			return null;
		}
		String tmp;
		if (date1.compareTo(date2) > 0) { // 确保 date1的日期不晚于date2
			tmp = date1;
			date1 = date2;
			date2 = tmp;
		}
		tmp = sdf.format(StrToDate(date1,YYYYMMDD_).getTime() + 3600 * 24 * 1000);
		list.add(StrToDate(date1, YYYYMMDDHHMMSS_));
		int num = 0;
		while (tmp.compareTo(date2) < 0) {
			if(StrToDate(tmp,YYYYMMDD_).getTime()==StrToDate(date2,YYYYMMDD_).getTime()){
				list.add(StrToDate(date2, YYYYMMDDHHMMSS_));
			}else{
				list.add(StrToDate(tmp, YYYYMMDDHHMMSS_));
			}
			num++;
			tmp = sdf.format(StrToDate(tmp,YYYYMMDD_).getTime() + 3600 * 24 * 1000);
		}
		if (num == 0) {
			return null;
		}
		return list;
	}
	
	/**
	 * 起止 时间相隔 月份
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return
	 */
	public static Integer getMonthSub(Date start, Date end) {
		if (start.after(end)) {
			Date t = start;
			start = end;
			end = t;
		}
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(start);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		Calendar temp = Calendar.getInstance();
		temp.setTime(end);
		temp.add(Calendar.DATE, 1);

		int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

		if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month + 1;
		} else if ((startCalendar.get(Calendar.DATE) != 1) && (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month;
		} else if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) != 1)) {
			return year * 12 + month;
		} else {
			return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
		}
	}
	
	/**
	 * 获取两个日期相差的时间(b-a)
	 * @param a(08:00)
	 * @param b(09:00)
	 * @return 返回时间 (单位:秒s[3600])
	 */
	public static long getSubtract(String a,String b){
		Calendar aDate=Calendar.getInstance(),bDate=Calendar.getInstance();

		String tdStr=DateUtil.getTodayStr();
		String afDt=tdStr+" "+a;
		String bfDt=tdStr+" "+b;
		
		Date chkAF=DateUtil.StrToDate(afDt, DateUtil.YYYYMMDDHHMM_);
		Date chkBF=DateUtil.StrToDate(bfDt, DateUtil.YYYYMMDDHHMM_);
		
		if(chkAF.after(chkBF)){
			chkBF = DateUtil.nextDayDate(chkBF, +1);
		}
		
		aDate.setTime(chkAF);
		bDate.setTime(chkBF);
		long timeA=aDate.getTimeInMillis();
		long timeB=bDate.getTimeInMillis();
		//long 相隔天数=(timeNow-timeOld)/(1000*60*60*24);//
		return (timeB-timeA)/1000;
	}
	public static void main(String[] args) {
		System.out.println(getDaysTTM());
		System.out.println(getTodayNum());
	}
}
