package com.oriansolution.dwt.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by madhawa on 12/10/16.
 */
public class DateUtil {
    public static Date getDateInGivenFormat(String dateString,String formatString) {
        Date date = null;
        try {
            final DateFormat sdf = new SimpleDateFormat(formatString, Locale.ENGLISH);
            sdf.setTimeZone(TimeZone.getTimeZone("IST"));
            date = sdf.parse(dateString);
        }catch(Exception e) {
            date = null;
        }
        return date;
    }



    // overloaded method
    public static Date getDateInGivenFormat(Date dateObject,String formatString) {
        Date date = null;
        String dateString = null;
        try {
            final DateFormat sdf = new SimpleDateFormat(formatString, Locale.ENGLISH);
            sdf.setTimeZone(TimeZone.getTimeZone("IST"));
            dateString = sdf.format(dateObject);
            date = sdf.parse(dateString);
        }catch(Exception e) {
            date = null;
        }
        return date;
    }
}
