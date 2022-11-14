package com.microsoft.appcenter.ingestion.models.json;

import com.helpshift.common.util.HSDateFormatSpec;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;

public final class JSONDateUtils {
    public static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>() {
        public Object initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(HSDateFormatSpec.STORAGE_TIME_PATTERN, Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };

    public static Date toDate(String str) throws JSONException {
        if (str != null) {
            try {
                return DATE_FORMAT.get().parse(str);
            } catch (ParseException e) {
                throw new JSONException(e.getMessage());
            }
        } else {
            throw new JSONException("date cannot be null");
        }
    }

    public static String toString(Date date) throws JSONException {
        if (date != null) {
            return DATE_FORMAT.get().format(date);
        }
        throw new JSONException("date cannot be null");
    }
}
