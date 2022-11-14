package com.helpshift.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class HSSimpleDateFormat {
    public SimpleDateFormat simpleDateFormat;

    public HSSimpleDateFormat(String str, String str2) {
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str);
        this.simpleDateFormat = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone(str2));
    }

    public synchronized String format(Date date) {
        return this.simpleDateFormat.format(date);
    }

    public synchronized Date parse(String str) throws ParseException {
        return this.simpleDateFormat.parse(str);
    }

    public synchronized String format(long j) {
        return this.simpleDateFormat.format(Long.valueOf(j));
    }

    public HSSimpleDateFormat(String str, Locale locale) {
        this.simpleDateFormat = new SimpleDateFormat(str, locale);
    }

    public HSSimpleDateFormat(String str, Locale locale, String str2) {
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str, locale);
        this.simpleDateFormat = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone(str2));
    }
}
