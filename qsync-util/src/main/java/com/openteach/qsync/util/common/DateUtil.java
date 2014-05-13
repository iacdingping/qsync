package com.openteach.qsync.util.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

public class DateUtil {
	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 数据库中分组查询
	 * <pre>
	 * 	<code>
	 * 	SQL:where (YEAR, MONTH) in ((1988, 1), (1988, 2))
	 * 	</code>
	 * </pre>
	 */
	public static final String GROUP_YEAR_MONTH_FORMAT = "(yyyy, MM)";
	public static final int SECONDS_OF_MINUTE = 60;
	public static final int SECONDS_OF_HOUR = SECONDS_OF_MINUTE * 60;
	public static final int SECONDS_OF_DAY = SECONDS_OF_HOUR * 24;
	public static final long MILLI_SECONDS_OF_DAY = 1000L * SECONDS_OF_DAY;

	public static Date parse(String dateStr) {
		return parse(dateStr, null);
	}

	public static Date parse(String dateStr, String format) {
		SimpleDateFormat df = new SimpleDateFormat(StringUtils.defaultIfEmpty(
				format, DEFAULT_FORMAT));
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("error format :" + format);
		}
	}

	public static Date parseSeconds(int seconds) {
		int hour = seconds / SECONDS_OF_HOUR;
		int minute = seconds / SECONDS_OF_MINUTE;
		int second = seconds % SECONDS_OF_MINUTE;
		Calendar day = Calendar.getInstance();
		day.set(Calendar.HOUR, hour);
		day.set(Calendar.MINUTE, minute);
		day.set(Calendar.SECOND, second);
		return day.getTime();
	}
	
	public static String formatSeconds(Integer seconds, String format) {
		if(seconds == null)
			return "00:00:00";
		int hour = seconds / SECONDS_OF_HOUR;
		int minute = seconds / SECONDS_OF_MINUTE;
		int second = seconds % SECONDS_OF_MINUTE;
		return String.format("%s:%s:%s", hour > 10 ? hour : "0" + hour,
					minute > 10 ? minute : "0" + minute, second > 10 ? second : "0" + second);
	}
	
	public static String format(Date date) {
		return format(date, null);
	}

	public static String format(Date date, String format) {
		if(date == null) return "";
		
		SimpleDateFormat df = new SimpleDateFormat(StringUtils.defaultIfEmpty(format, DEFAULT_FORMAT));
		return df.format(date);
	}
	
	/**
	 * 将一种日期字符串转换为另一种日期字符串 如将2010-05-05 12:12:55 转为2010-05-05
	 * @param dateStr 当前日期字符串
	 * @param dateFormat 转化后的日期字符串模式
	 * @return
	 */
	public final static String getCustomTime(String dateStr,String dataFormat){
		if("".equals(dateStr)){
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat(dataFormat);
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (Exception e) {
			date = null;
		}
		
		return new SimpleDateFormat(dataFormat).format(date);
	}
	/**
	* @Description: 日期按指定格式转换为String格式
	* @author  江龙
	* @version 创建时间：2014-1-12下午11:59:33
	* @param @param date
	* @param @param dataFormat
	* @param @return    
	* @return String
	 */
	public  static String dateFormatFromDate(Date date,String dataFormat){
		if(date==null){
			return "";
		}
		return new SimpleDateFormat(dataFormat).format(date);
	}
	
	/**
	* @Description: 日期按指定格式转换为Date
	* @author  江龙
	* @version 创建时间：2014-2-12上午11:06:08
	* @param dateFormat
	* @return
	* @throws ParseException    
	* @return Date
	 */
	public  static Date getFormatDateTime(String dateFormat,String format){
		 SimpleDateFormat sbf =new SimpleDateFormat(format);
		  Date ddate = null;
		try {
			ddate = sbf.parse(dateFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ddate;
	}
	
	/**
	 * 获得当前时间，格式yyyy-MM-dd hh:mm:ss
	 * 
	 * @return
	 */
	public static String getCurrentDateString() {
		return format(new Date());
	}
	
	/**
	 * 获得日期
	 * @param daysIndex		日期索引值 0 表示当天 -1 昨天 1 明天
	 * @param isStart		true 设置时分秒 00:00:00
	 * 						false 		  23:59:59
	 * @return
	 */
	public static Date getDay(int daysIndex, boolean isStart) {
		Calendar day = Calendar.getInstance();
		day.add(Calendar.DATE, daysIndex);
		if(isStart) {
			day.set(Calendar.HOUR_OF_DAY, 0);
			day.set(Calendar.MINUTE, 0);
			day.set(Calendar.SECOND, 0);
		} else {
			day.set(Calendar.HOUR_OF_DAY, 23);
			day.set(Calendar.MINUTE, 59);
			day.set(Calendar.SECOND, 59);
		}
		return day.getTime();
	}
	/**
	 * 获得日期
	 * @param daysIndex		日期索引值 0 表示当天 -1 昨天 1 明天
	 * @param fromatTime	 指定的时分秒格式	 "hh:mm:ss"  
	 * @return  当天指定时间的DATE
	 */
	public static Date getDay(int daysIndex, String fromatTime) {
		Calendar day = Calendar.getInstance();
		day.add(Calendar.DATE, daysIndex);
		int hh=0;
		int mm=0;
		int ss=0;
		String[] list=fromatTime.split(":");
		hh=Integer.parseInt(list[0]);
		mm=Integer.parseInt(list[1]);
		ss=Integer.parseInt(list[2]);
		day.set(Calendar.HOUR_OF_DAY,hh);
		day.set(Calendar.MINUTE, mm);
		day.set(Calendar.SECOND, ss);
		return day.getTime();
	}

	/**
	 * 获得昨天时间
	 * 
	 * @return
	 */
	public static Date getYesterdayDate() {
		Calendar day = Calendar.getInstance();
		day.add(Calendar.DATE, -1);
		return day.getTime();
	}
	  /**
     * 获取参数时间的上个月1号
     * @param now
     * @return
     */
    public static Date getPreMonth(Calendar now ){
    	Calendar cal = Calendar.getInstance();
    	cal.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH)-1, 1, 0, 0, 0);
    	return cal.getTime();
    }
    /**
    * @Description: 活动Time-1的时间  获取指定时间前一天的时间   例如：2014-1-10 00:00:00 变成 2014-1-9 23:59:59
    * @author  江龙
    * @version 创建时间：2014-1-10下午3:42:56
    * @param DATE   
    * @return Date
     */
	public static Date getYesterdayDate(Date date){
		Calendar day = Calendar.getInstance();
		day.setTime(date);
		day.set(Calendar.HOUR_OF_DAY, 23);
		day.set(Calendar.MINUTE, 59);
		day.set(Calendar.SECOND, 59);
		day.add(Calendar.DATE, -1);
		return day.getTime();
	}
	

	public static int compare(String day1, String day2, String format) {
		format = StringUtils.defaultIfEmpty(format, DEFAULT_FORMAT);
		return parse(day1, format).compareTo(parse(day2, format));
	}
	
	public static int daysBetween(String startDay, String endDay, String format) {
		long start = (startDay == null || startDay.trim().equals("")) ? 
				new Date().getTime() : parse(startDay, format).getTime();
		long end = (endDay == null || endDay.trim().equals("")) ? 
				new Date().getTime() : parse(endDay, format).getTime();
		return (int) ((start - end) / MILLI_SECONDS_OF_DAY);
	}
	
	public static int daysBetween(Date startDay, Date endDay) {
		long start = startDay == null ? 
				new Date().getTime() : startDay.getTime();
		long end = endDay == null ? 
				new Date().getTime() : endDay.getTime();
		return (int) ((start - end) / MILLI_SECONDS_OF_DAY);
	}
	
	/**
	 * 不计算当天
	 * 1号返回0  31 号 30
	 * @return
	 */
	public static int daysFromMonthStart() {
		Calendar c = Calendar.getInstance();
		int now = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, 1);
		int indexMonthStart = c.get(Calendar.DAY_OF_MONTH);
		return now - indexMonthStart;
	}
	
	public static int daysToMonthEnd() {
		Calendar c = Calendar.getInstance();
		int now = c.get(Calendar.DAY_OF_MONTH);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 0);
		int indexMonthEnd = c.get(Calendar.DAY_OF_MONTH);
		return indexMonthEnd - now;
	}

	/**
	 * 判断时间是否符合时间格式
	 */
	public static boolean isDate(String date, String dateFormat) {
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			format.setLenient(false);
			try {
				format.format(format.parse(date));
			} catch (ParseException e) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 实现给定某日期，判断是星期几 date:必须yyyy-MM-dd格式
	 */
	public static String getWeekday(String date, String format) {
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		Date d = parse(date);
		return sdw.format(d);
	}
	
	public static String getWeekday(Date date) {
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		return sdw.format(date);
	}

	public static Date getFirstDayOfMonth() {
		Calendar c = Calendar.getInstance();// 获取当前日期
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	public static Date getFirstDayOfMonth(int months) {
		Calendar c = Calendar.getInstance();// 获取当前日期
		c.add(Calendar.MONTH, months);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
   /**
   * @Description: 活动当月月初最初一天
   * @author  江龙
   * @version 创建时间：2014-3-25上午10:46:47
   * @param @param date
   * @param @return    
   * @return Date
    */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();// 获取当前日期
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	/**
	* @Description: 获当月月末的最后一天
	* @author  江龙
	* @version 创建时间：2013-12-19下午6:05:02
	* @param @param months
	* @param @return    
	* @return Date
	 */
	public static Date getLastDayOfMonth() {
		Calendar c = Calendar.getInstance();// 获取当前日期
		c.add(Calendar.MONTH, +1);
		c.set(Calendar.DAY_OF_MONTH, 0);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	/**
	* @Description: 获取指定月月末的最后一天
	* @author  江龙
	* @version 创建时间：2013-12-19下午6:05:02
	* @param @param months
	* @param @return    
	* @return Date
	 */
	public static Date getLastDayOfMonth(int months) {
		Calendar c = Calendar.getInstance();// 获取当前日期
		c.add(Calendar.MONTH, months + 1);
		c.set(Calendar.DAY_OF_MONTH, 0);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * @Description:判断是否本月第一天
	 * @author yewenqu
	 * @time 2014-4-18 下午6:12:46
	 * @return
	 */
	public static boolean isCurrentMonthFirstDay(){
		
		Calendar c = Calendar.getInstance();
		
		Calendar firstDay = Calendar.getInstance();
		firstDay.set(Calendar.DAY_OF_MONTH, 1);
		firstDay.set(Calendar.HOUR_OF_DAY, 0);
		firstDay.set(Calendar.MINUTE, 0);
		firstDay.set(Calendar.SECOND, 0);
		
		Calendar secondDay = Calendar.getInstance();
		secondDay.set(Calendar.DAY_OF_MONTH, 2);
		secondDay.set(Calendar.HOUR_OF_DAY, 0);
		secondDay.set(Calendar.MINUTE, 0);
		secondDay.set(Calendar.SECOND, 0);
		
		return c.after(firstDay) && c.before(secondDay) ;
	}
	/**
	* @Description: nowDate的月份减1 比如   2014-1-11 1:54:47 变成 2013-12-31 ：23:59:59
	* @author  江龙
	* @version 创建时间：2014-1-11下午1:54:47
	* @param @param nowDate
	* @param @return    
	* @return Date
	 */
	public static Date getLastDayOfMonth(Date nowDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.DAY_OF_MONTH, 0);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	/**
	* @Description: 获取当前时间距离本月最后一天还有**天
	* 算上当天的
	* @author  江龙
	* @version 创建时间：2014-1-9下午12:31:47
	* @return int
	 */
	public static int getRemainingDay(){
		return daysToMonthEnd() + 1;
	}
	
	public static int getDaysOfMonth() {
		Calendar c = Calendar.getInstance();
		return c.getActualMaximum(Calendar.DATE);
	}

	public static int getDaysOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DATE);
	}
	
	public static int getDaysOfMonth(int months) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, months);
		return c.getActualMaximum(Calendar.DATE);
	}
	
	/**
	 * 从1开始
	 * @return
	 */
	public static int getMonth() {
		return getMonth(0);
	}
	
	/**
	 * 从1开始
	 * 1-12
	 * @param monthIndex
	 * @return
	 */
	public static int getMonth(int monthIndex) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, monthIndex);
		return c.get(Calendar.MONTH) + 1;
	}
	
	public static int getYear() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR);
	}
	
	public static int getYear(int years) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, years);
		return c.get(Calendar.YEAR);
	}
	
	/**
	 * 获得当前日期与本周一相差的天数 星期天国外为第一天，国内为最后一天
	 */
	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			return -6;
		} else {
			return 2 - dayOfWeek;
		}
	}

	/**
	 * 获得星期一的日期
	 * 
	 * @param index
	 *            0 本周 1 下周 -1 上周
	 */
	public static String getMonday(String format, int index) {
		int mondayPlus = getMondayPlus();
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * index);
		SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
		String date = sdf.format(currentDate.getTime());
		return date;
	}

	/**
	 * 获得上周星期一的日期
	 */
	public static String getMonday(String format) {
		return getMonday(format, -1);
	}

	/**
	 * 获得本周星期一的日期
	 */
	public static String getCurrentMonday(String format) {
		return getMonday(format, 0);
	}

	/**
	 * 获得下周星期一的日期
	 */
	public static String getNextMonday(String format) {
		return getMonday(format, 1);
	}

	/**
	 * 获得相应周的周日的日期 此方法必须写在getCurrentMonday，getPreviousMonday或getNextMonday方法之后
	 */
	public static String getSunday(String format, int index) {
		int mondayPlus = getMondayPlus();
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.DATE, mondayPlus + 7 * index + 6);
		SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
		String date = sdf.format(currentDate.getTime());
		return date;
	}

	/**
	 * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
	 * 
	 * @param dateString
	 *            需要转换为timestamp的字符串
	 * @return dataTime timestamp
	 */
	public final static java.sql.Timestamp string2Time(String dateString) {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);// 设定格式
		dateFormat.setLenient(false);
		java.util.Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			throw new IllegalArgumentException(String.format("error format %s for String %s", dateFormat, dateString));
		}
		// java.sql.Timestamp dateTime = new java.sql.Timestamp(date.getTime());
		return new java.sql.Timestamp(date.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
	}

	/**
	 * method 将字符串类型的日期转换为一个Date（java.sql.Date）
	 * 
	 * @param dateString
	 *            需要转换为Date的字符串
	 * @return dataTime Date
	 */
	public final static java.sql.Date string2Date(String dateString) {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		dateFormat.setLenient(false);
		java.util.Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			throw new IllegalArgumentException(String.format("error format %s for String %s", dateFormat, dateString));
		}
		// java.sql.Date dateTime = new java.sql.Date(date.getTime());// sql类型
		return new java.sql.Date(date.getTime());
	}

	// 记录考勤， 记录迟到、早退时间
	public static String getState() {
		String state = "正常";
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date d = new Date();
		try {
			Date d1 = df.parse("08:00:00");
			Date d2 = df.parse(df.format(d));
			Date d3 = df.parse("18:00:00");

			int t1 = (int) d1.getTime();
			int t2 = (int) d2.getTime();
			int t3 = (int) d3.getTime();
			if (t2 < t1) {

				long between = (t1 - t2) / 1000;// 除以1000是为了转换成秒
				long hour1 = between % (24 * 3600) / 3600;
				long minute1 = between % 3600 / 60;

				state = "迟到 ：" + hour1 + "时" + minute1 + "分";

			} else if (t2 < t3) {
				long between = (t3 - t2) / 1000;// 除以1000是为了转换成秒
				long hour1 = between % (24 * 3600) / 3600;
				long minute1 = between % 3600 / 60;
				state = "早退 ：" + hour1 + "时" + minute1 + "分";
			}
			return state;
		} catch (Exception e) {
			return state;
		}
	}
	
	public static String getDayDesc(Date date) {
		Calendar c = Calendar.getInstance();
		if(date!=null)
			c.setTime(date);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		if(hour>=5 && hour<7) 
			return "这么早，一起晨练去";
		if(hour>=7 && hour<11) 
			return "早安，祝你一天好心情";
		if(hour>=11 && hour<13) 
			return "来顿丰盛美味的午餐吧";
		if(hour>=13 && hour<14) {
			return "午后小憩，精神倍爽";
		}
		if(hour>=14 && hour<18) {
			if(System.currentTimeMillis() % 2 == 1)
				return "下午稍纵即逝，别偷懒";
			else 
				return "犯困了？快去冲杯咖啡";
		}
		if(hour>=18 && hour<19) 
			return "一天即将结束，好好放松下";
		if(hour>=19 && hour<22) 
			return "晚上好，今晚早点休息吧";
		if(hour>=22 && hour<23) 
			return "快进入梦乡了吗，明早见";
		
		return "早睡早起，身体倍儿棒";
	}
	
	public static long getMillis(java.util.Date date)
    {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }
	
	public static long diffDateToMillis(Date date, Date date1) {
        return (long) ((getMillis(date) - getMillis(date1)));
    }

	public static Date getDate(int yearIncr, int monthIncr) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, yearIncr);
		c.add(Calendar.MONTH, monthIncr);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}
	
	/**
	 * 获取年份与月份 包含当前月份
	 * @param addMonth	0 当前月份, -1 前一个月份 1 后一个月份
	 * @param size	取多少个月份 从当前月份开始
	 * @param traceOrDelay	true 前溯  false 延迟
	 * @param format 默认(yyyy, mm)
	 * @return ((yyyy, mm), (yyyy, mm))
	 */
	public static String getYearAndMonth(Date date, int size, boolean isTraceOrDelay, String format) {
		if(size == 0) 
			throw new IllegalArgumentException("zero in argument size");
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for(int i=0; i<size; i++) {
			int k = 1;
			if(isTraceOrDelay) {
				k = -k;
			}
			c.add(Calendar.MONTH, k);
			
			sb.append(format(c.getTime(), StringUtils.defaultIfEmpty(format, GROUP_YEAR_MONTH_FORMAT)))
					.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(")");
		return sb.toString();
	}
	
	/**
	 * 获取年份与月份 包含当前月份
	 * @param year	年份	小于0 取当前年份
	 * @param month 月份 1-12	小于0 取当前月份
	 * @param size	取多少个月份 从当前月份开始
	 * @param traceOrDelay	true 前溯  false 延迟
	 * @param format 默认(yyyy, mm)
	 * @return ((yyyy, mm), (yyyy, mm))
	 */
	public static String getYearAndMonth(int year, int month, int size, boolean isTraceOrDelay, String format) {
		if(size == 0) 
			throw new IllegalArgumentException("zero in argument size");
		
		Calendar c = Calendar.getInstance();
		if(year >0) {
			c.set(Calendar.YEAR, year);
		}
			
		if(month > 0) {
			c.set(Calendar.MONTH, month);
		} else {
			c.add(Calendar.MONTH, 1);
		}
		c.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println("getYearAndMonth"+format(c.getTime()));
		
		return getYearAndMonth(c.getTime(), size, isTraceOrDelay, format);
	}
	
	/**
	 * 包含当前月份
	 * @param year
	 * @param month	月份 1-12
	 * @param size
	 * @param isTraceOrDelay
	 * @return int[] months 按时间小到大排列月份
	 */
	public static int[] getLastMonths(int year, int month, int size, boolean isTraceOrDelay) {
		if(size == 0) 
			throw new IllegalArgumentException("zero in argument size");
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		int[] months = new int[size];
		int j = 1;
		if(isTraceOrDelay)
			j = -j;
		for(int i=0; i<size; i++) {
			c.add(Calendar.MONTH, j);
			months[size - i - 1] = c.get(Calendar.MONTH) + 1;
		}
		return months;
	}
	
	public static int getHourOfDay() {
		Calendar c = Calendar.getInstance();
		
		return c.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
     * 当前时间是否在start与end之间， 或者相同时返回true
     * 参数为空时不判定
     * @param start
     * @param end
     * @return if now >= start && now <= end return true
     * 		else return false
     */
    public static boolean timeBetween(Date start, Date end) {
    	Date now = new Date();
    	if(start != null && now.compareTo(start) < 0) {
    		return false;
    	}
    	if(end != null && now.compareTo(end) > 0) {
    		return false;
    	}
    	return true;
    }
    
    public static Date max(Date date1, Date date2) {
    	return date1.compareTo(date2) > 0 ? date1 : date2;
    }
    
    public static Date min(Date date1, Date date2) {
    	return date1.compareTo(date2) > 0 ? date2 : date1;
    }
	
    public static boolean isSomeTimeInDay(Date date, int dayIndex) {
    	if(date == null) return false;
    	
    	if(dayIndex >= 0) dayIndex ++;
    	
    	Calendar day = Calendar.getInstance();
		day.set(Calendar.HOUR_OF_DAY, 0);
		day.set(Calendar.MINUTE, 0);
		day.set(Calendar.SECOND, 0);
		
		Date d1, d2;
		if(dayIndex > 0) {
			d1 = day.getTime();
			day.add(Calendar.DATE, dayIndex);
			d2 = day.getTime();
		} else {
			d2 = day.getTime();
			day.add(Calendar.DATE, dayIndex);
			d1 = day.getTime();
		}
		
		return date.compareTo(d1) > 0 && date.compareTo(d2) < 0;
    }
    
    public static boolean isYesterdaySomeTime(Date date) {
    	return isSomeTimeInDay(date, -1);
    }
    
	public static void main(String[] args) {
		System.out.println(timeBetween((new Date()),getLastDayOfMonth()));
		System.out.println("-----------------------");
		System.out.println(DateUtil.format(getFirstDayOfMonth(), "MM月dd日HH时"));//当月最开始一天
		System.out.println(DateUtil.format(getLastDayOfMonth(), "MM月dd日HH时"));//当月最后一天
		//System.out.println(getDay(0,"09:00:00"));
		//System.out.println(getFormatDateTime("2004-05-14 21:29:51"));
		
		//  System.out.println( getCustomTime("Sun Jan 12 14:50:07 CST 2014","yyyy-mm-dd"));
		//getLastMonthDay(new Date());
		//System.out.println(getLastDayOfMonth());//当月最后一天的时间
		//System.out.println(getLastDayOfMonth(-1));
//		System.out.println(DateUtil.format(new Date(), "MM月dd日HH时"));
//		
//		System.out.println(getWeekday(new Date()));
//		System.out.println(format(getFirstDayOfMonth())+ format(getLastDayOfMonth()));
		
//		System.out.println(format(getFirstDayOfMonth(parse("2011-07-11 11:11:12")))
//				+ format(getLastDayOfMonth(parse("2011-07-11 11:11:12"))));
//		System.out.println("getLastDayOfMonth:" + format(getLastDayOfMonth(-1)));
//		System.out.println(daysBetween("2012-09-11", "2012-09-12", "yyyy-MM-dd"));
//		System.out.println(getDaysOfMonth() + " - "  + getDaysOfMonth(parse("2012-09-08 11:11:11")) + " - " + getDaysOfMonth(0));
//		
//		System.out.println(format(parseSeconds(1000000)));
//		
//		System.out.println(format(getDay(-7, true)));
		
//		System.out.println(daysToMonthEnd() + "  " + getRemainingDay());
		
//		System.out.println(getMonth(-1));
//		
		System.out.println(getYearAndMonth(-1, -1, 3, true, null));
//		
//		int[] months = getLastMonths(2013, 1, 3, true);
//		for(int i : months) 
//			System.out.print(i + ", ");
//		
//		System.out.println();
//		
//		System.out.println(format(getDate(0, -1)));
		
		//System.out.println(getYearAndMonth(2014 , 0 , 6, true, null));
		
//		System.out.println("----" + format(getLastDayOfMonth(new Date())));
		
		System.out.println(isYesterdaySomeTime(parse("2014-03-12 19:00:00")));
		System.out.println(isSomeTimeInDay(parse("2014-03-13 19:00:00"), 0));
	}
}
