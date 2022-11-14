package com.iab.omid.library.applovin;

import android.content.Context;

public final class Omid {
    public static C2840b INSTANCE = new C2840b();

    public static void activate(Context context) {
        INSTANCE.mo36706a(context.getApplicationContext());
    }

    public static String getVersion() {
        return INSTANCE.mo36705a();
    }

    public static boolean isActive() {
        return INSTANCE.mo36708b();
    }
}
