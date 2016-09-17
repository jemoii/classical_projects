package me.voler.classical.ticket.request;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtil {

    /**
     * @param increment 日期增量
     * @return "YYYY-MM-DD"格式的日期字符串
     */
    public static String createDate(int increment) {

        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, increment);// increment为正,日期后延;为负,日期前推
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        return formatter.format(date);

    }

}
