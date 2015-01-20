package me.station.request;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * ��������������increment
 * ����ֵ��"YYYY-MM-DD"��ʽ�������ַ���
 *
 */

public class DateUtil {

	public static String createDate(int increment) {

		Date date = new Date(); 
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, increment);// incrementΪ��,���ں���;Ϊ��,����ǰ��
		date = calendar.getTime(); 
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		String dateString = formatter.format(date);
		return dateString;

	}

}
