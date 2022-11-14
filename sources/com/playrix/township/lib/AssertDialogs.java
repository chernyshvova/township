package com.playrix.township.lib;

import android.app.Activity;
import android.util.Log;

public class AssertDialogs {
    public static final String TAG = "AssertDialogs";

    public static void assertDialogOnPause() {
    }

    public static void createAsanaTaskDialog(String str, boolean z, Runnable runnable, Runnable runnable2) {
        Log.e(TAG, "createAsanaTaskDialog shouldn't be called in production");
    }

    public static int getDialogState() {
        return 0;
    }

    public static void showAssertDialog(String str, String str2, boolean z) {
        Log.e(TAG, "showAssertDialog shouldn't be called in production");
    }

    public static void showCrashDialog(Activity activity, Runnable runnable) {
        Log.e(TAG, "showCrashDialog shouldn't be called in production");
    }
}
