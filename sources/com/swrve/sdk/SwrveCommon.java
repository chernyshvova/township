package com.swrve.sdk;

public class SwrveCommon {
    public static ISwrveCommon instance;
    public static Runnable toRunIfNull;

    public static void checkInstanceCreated() throws RuntimeException {
        Runnable runnable;
        if (instance == null && (runnable = toRunIfNull) != null) {
            runnable.run();
        }
        if (instance == null) {
            SwrveLogger.m2754e("Please call SwrveSDK.createInstance first in your Application class.", new Object[0]);
            throw new RuntimeException("Please call SwrveSDK.createInstance first in your Application class.");
        }
    }

    public static ISwrveCommon getInstance() {
        return instance;
    }

    public static void setRunnable(Runnable runnable) {
        toRunIfNull = runnable;
    }

    public static void setSwrveCommon(ISwrveCommon iSwrveCommon) {
        instance = iSwrveCommon;
    }
}
