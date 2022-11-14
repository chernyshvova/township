package com.helpshift.common.util;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.platform.Platform;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HSSimpleDateFormat;
import com.helpshift.util.ValuePair;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HSDateFormatSpec {
    public static final String DISPLAY_DATE_PATTERN = "EEEE, MMMM dd, yyyy";
    public static final String DISPLAY_TIME_PATTERN_12HR = "h:mm a";
    public static final String DISPLAY_TIME_PATTERN_24HR = "H:mm";
    public static final HSSimpleDateFormat STORAGE_TIME_FORMAT = new HSSimpleDateFormat(STORAGE_TIME_PATTERN, "GMT");
    public static final String STORAGE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String TAG = "Helpshift_DFSpec";
    public static final Map<String, HSSimpleDateFormat> formatterCache = new HashMap();

    public static String addMilliSeconds(HSSimpleDateFormat hSSimpleDateFormat, String str, int i) {
        try {
            Date parse = hSSimpleDateFormat.parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            return hSSimpleDateFormat.format(new Date(instance.getTimeInMillis() + ((long) i)));
        } catch (ParseException e) {
            HSLogger.m3242e(TAG, "Parsing exception on adding millisecond", e);
            return str;
        }
    }

    public static float calculateTimeDelta(String str) {
        Double valueOf = Double.valueOf(Double.parseDouble(str));
        double currentTimeMillis = (double) System.currentTimeMillis();
        Double.isNaN(currentTimeMillis);
        return (float) (valueOf.doubleValue() - Double.valueOf(currentTimeMillis / 1000.0d).doubleValue());
    }

    public static long convertToEpochTime(String str) {
        try {
            return STORAGE_TIME_FORMAT.parse(str).getTime();
        } catch (ParseException e) {
            HSLogger.m3242e(TAG, "Parsing exception on converting storageTimeFormat to epochTime", e);
            return -1;
        }
    }

    public static Date getCurrentAdjustedTime(Platform platform) {
        return new Date(getCurrentAdjustedTimeInMillis(platform));
    }

    public static ValuePair<String, Long> getCurrentAdjustedTimeForStorage(Platform platform) {
        Long valueOf = Long.valueOf(getCurrentAdjustedTimeInMillis(platform));
        return new ValuePair<>(STORAGE_TIME_FORMAT.format(new Date(valueOf.longValue())), valueOf);
    }

    public static long getCurrentAdjustedTimeInMillis(Platform platform) {
        float serverTimeDelta = platform.getNetworkRequestDAO().getServerTimeDelta();
        return System.currentTimeMillis() + ((serverTimeDelta <= -0.001f || serverTimeDelta >= 0.001f) ? (long) (serverTimeDelta * 1000.0f) : 0);
    }

    public static HSSimpleDateFormat getDateFormatter(String str, Locale locale, String str2) {
        StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, "_");
        outline26.append(locale.getLanguage());
        outline26.append("_");
        outline26.append(str2);
        String sb = outline26.toString();
        HSSimpleDateFormat hSSimpleDateFormat = formatterCache.get(sb);
        if (hSSimpleDateFormat != null) {
            return hSSimpleDateFormat;
        }
        HSSimpleDateFormat hSSimpleDateFormat2 = new HSSimpleDateFormat(str, locale, str2);
        formatterCache.put(sb, hSSimpleDateFormat2);
        return hSSimpleDateFormat2;
    }

    public static HSSimpleDateFormat getDateFormatter(String str, Locale locale) {
        StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, "_");
        outline26.append(locale.getLanguage());
        String sb = outline26.toString();
        HSSimpleDateFormat hSSimpleDateFormat = formatterCache.get(sb);
        if (hSSimpleDateFormat != null) {
            return hSSimpleDateFormat;
        }
        HSSimpleDateFormat hSSimpleDateFormat2 = new HSSimpleDateFormat(str, locale);
        formatterCache.put(sb, hSSimpleDateFormat2);
        return hSSimpleDateFormat2;
    }
}
