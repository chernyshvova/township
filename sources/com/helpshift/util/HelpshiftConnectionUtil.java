package com.helpshift.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class HelpshiftConnectionUtil {
    public static final String TAG = "Helpshift_ConnectUtil";

    public static String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getTypeName();
            }
            return "Unknown";
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Exception while getting system connectivity service", e);
            return "Unknown";
        }
    }

    public static boolean isOnline(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Exception while getting system connectivity service", e);
            return false;
        }
    }
}
