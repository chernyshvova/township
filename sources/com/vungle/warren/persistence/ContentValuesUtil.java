package com.vungle.warren.persistence;

import android.content.ContentValues;
import com.facebook.appevents.AppEventsConstants;

public class ContentValuesUtil {
    public static boolean getBoolean(ContentValues contentValues, String str) {
        Object obj = contentValues.get(str);
        if (obj == null) {
            return false;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            if (obj instanceof CharSequence) {
                if (Boolean.valueOf(obj.toString()).booleanValue() || AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(obj)) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Number) || ((Number) obj).intValue() == 0) {
                return false;
            } else {
                return true;
            }
        }
    }
}
