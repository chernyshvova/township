package com.swrve.sdk;

public final class SwrveRunnables {
    public static Runnable withoutExceptions(final Runnable runnable) {
        return new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    SwrveLogger.m2753e("Error executing runnable: ", e, new Object[0]);
                }
            }
        };
    }
}
