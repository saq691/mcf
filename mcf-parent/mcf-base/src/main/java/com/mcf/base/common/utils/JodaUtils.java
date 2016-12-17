package com.mcf.base.common.utils;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Title. <br>
 * Description：日期帮助类工具类
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:29:43
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class JodaUtils {
	/**
	 * 获得当前时间
	 * 
	 * @return
	 */
	public static Date getNowDate() {
		return new Date();
	}

	/**
	 * 从当前日期起，计算指定天数后的日期
	 * 
	 * @param day
	 * @return
	 */
	public static Date calculateDateByPlusDays(int day) {
		DateTime dateTime = new DateTime();
		return dateTime.plusDays(day).toDate();
	}

	/**
	 * 从当前日期起，计算指定年数前的日期
	 * 
	 * @param year
	 * @return
	 */
	public static Date caculateDateByMinusYears(int year) {
		DateTime dateTime = new DateTime();
		return dateTime.minusYears(year).toDate();
	}

	/**
	 * 从当前日期起，计算指定月数后的日期
	 * 
	 * @param month
	 * @return
	 */
	public static Date calculateDateByPlusMonths(int month) {
		DateTime dateTime = new DateTime();
		return dateTime.plusMonths(month).toDate();
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 返回相差天数，如果返回天数小于0，则返回0
	 */
	public static int calculateFate(Date beginDate, Date endDate) {
		DateTime oldbegin = new DateTime(beginDate);
		DateTime oldend = new DateTime(endDate);
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTime begin = new DateTime(DateTime.parse(oldbegin.toString(fmt)));
		DateTime end = new DateTime(DateTime.parse(oldend.toString(fmt), fmt));
		Period p = new Period(begin, end, PeriodType.days());
		return p.getDays();
	}

	public static Date getYestodayStart() {
		DateTime dateTime = new DateTime();
		return dateTime.plusDays(-1).withTimeAtStartOfDay().toDate();
	}

	public static Date getYestodayEnd() {
		DateTime dateTime = new DateTime();
		return dateTime.plusDays(-1).millisOfDay().withMaximumValue().toDate();
	}

	public static Date getAssignDateAfterMinutes(Date date, int minutes) {
		DateTime dateTime = new DateTime(date.getTime());
		return dateTime.plusMinutes(minutes).toDate();
	}

	/**
	 * 根据获得当前日期16
	 * 
	 * @param month
	 * @return
	 */
	public static int getCurrentDay() {
		DateTime dateTime = new DateTime();
		return dateTime.getDayOfMonth();
	}

	/**
	 * 根据指定月份获得月份天数
	 * 
	 * @param month
	 * @return
	 */
	public static int getMonthDayNum(int month) {
		DateTime dateTime = new DateTime();
		return dateTime.withMonthOfYear(month).dayOfMonth().getMaximumValue();
	}

	/**
	 * 获得当前月
	 * 
	 * @return
	 */
	public static int getCurrentMonth() {
		DateTime dateTime = new DateTime();
		return dateTime.getMonthOfYear();
	}

	/**
	 * 获得当前年
	 * 
	 * @return
	 */
	public static int getCurrentYear() {
		DateTime dateTime = new DateTime();
		return dateTime.getYear();
	}

	/**
	 * 根据当前年份后天多少年
	 * 
	 * @param years
	 * @return
	 */
	public static int getYears(int years) {
		DateTime dateTime = new DateTime();
		return dateTime.minusYears(years).getYear();
	}

	/**
	 * 获取昨天是在该月中的几号（即第几天）
	 * 
	 * @return 几号
	 */
	public static int getYestoday() {
		DateTime dateTime = new DateTime();
		return dateTime.minusDays(1).getDayOfMonth();
	}

}