package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.ads.BuildConfig;

@Keep
public class BuildConfigApi {
    public static final String UNITY_SHARED_PREFERENCES_SUFIX = ".v2.playerprefs";
    public static final String UNITY_TAG = "an_isUnitySDK";
    public static final String UNITY_VERSION_SUFIX = "-unity";

    public static String getVersionName(Context context) {
        if (isUnity(context)) {
            return GeneratedOutlineSupport.outline18(new StringBuilder(), BuildConfig.VERSION_NAME, UNITY_VERSION_SUFIX);
        }
        return BuildConfig.VERSION_NAME;
    }

    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    public static boolean isUnity(Context context) {
        if (context.getSharedPreferences(context.getPackageName() + UNITY_SHARED_PREFERENCES_SUFIX, 0).contains(UNITY_TAG) || context.getSharedPreferences(context.getPackageName(), 0).contains(UNITY_TAG)) {
            return true;
        }
        return false;
    }
}
