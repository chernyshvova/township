package com.google.android.material.circularreveal;

import android.os.Build;

public class CircularRevealHelper {
    public static final int STRATEGY;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            STRATEGY = 2;
        } else {
            STRATEGY = 1;
        }
    }
}
