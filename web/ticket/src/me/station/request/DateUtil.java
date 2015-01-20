package me.station.request;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * 参数：日期增量increment
 * 返回值："YYYY-MM-DD"格式的日期字符串
 *
 */

public class DateUtil {

	public static String createDate(int increment) {

		Date date = new Date(); 
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, increment);// increment为正,日期后延;为负,日期前推
		date = calendar.getTime(); 
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		String dateString = formatter.format(date);
		return dateString;

	}

}
