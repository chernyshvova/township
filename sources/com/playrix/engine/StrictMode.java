package com.playrix.engine;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;

public class StrictMode {
    public static StrictMode.ThreadPolicy NewPermissiveThreadPolicy() {
        return new StrictMode.ThreadPolicy.Builder().permitAll().build();
    }

    @TargetApi(28)
    public static StrictMode.VmPolicy NewStrictAndroidPVmPolicy() {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(android.os.StrictMode.getVmPolicy());
        if (Build.VERSION.SDK_INT >= 28) {
            builder.detectNonSdkApiUsage();
        }
        return builder.build();
    }

    public static StrictMode.ThreadPolicy NewStrictThreadPolicy() {
        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder();
        builder.detectAll();
        builder.penaltyLog();
        builder.penaltyFlashScreen();
        return builder.build();
    }

    @TargetApi(28)
    public static StrictMode.VmPolicy NewStrictVmPolicy() {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        builder.detectActivityLeaks();
        builder.detectLeakedClosableObjects();
        builder.detectLeakedSqlLiteObjects();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            builder.detectCleartextNetwork();
        }
        if (i >= 26) {
            builder.detectContentUriWithoutPermission();
        }
        builder.detectFileUriExposure();
        builder.detectLeakedRegistrationObjects();
        if (i >= 28) {
            builder.detectNonSdkApiUsage();
        }
        if (i >= 26) {
            builder.detectUntaggedSockets();
        }
        builder.penaltyLog();
        return builder.build();
    }

    public static StrictMode.ThreadPolicy SwitchThreadPolicy(StrictMode.ThreadPolicy threadPolicy) {
        StrictMode.ThreadPolicy threadPolicy2 = android.os.StrictMode.getThreadPolicy();
        android.os.StrictMode.setThreadPolicy(threadPolicy);
        return threadPolicy2;
    }

    public static StrictMode.VmPolicy SwitchVmPolicy(StrictMode.VmPolicy vmPolicy) {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        StrictMode.VmPolicy vmPolicy2 = android.os.StrictMode.getVmPolicy();
        android.os.StrictMode.setVmPolicy(vmPolicy);
        return vmPolicy2;
    }
}
