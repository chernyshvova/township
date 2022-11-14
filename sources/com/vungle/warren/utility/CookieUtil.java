package com.vungle.warren.utility;

import android.util.Log;
import androidx.annotation.NonNull;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;

public class CookieUtil {
    public static final String TAG = "CookieUtil";

    public static void update(@NonNull Repository repository, String str, String str2, Object obj) {
        Cookie cookie = repository.load(str, Cookie.class).get();
        if (cookie == null) {
            cookie = new Cookie(str);
        }
        cookie.putValue(str2, obj);
        try {
            repository.save(cookie);
        } catch (DatabaseHelper.DBException e) {
            Log.e(TAG, "DB Exception deleting advertisement", e);
        }
    }
}
