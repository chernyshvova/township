package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;

/* renamed from: com.appsflyer.internal.a */
public final class C1375a {
    public IntentFilter valueOf = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: com.appsflyer.internal.a$c */
    public static final class C1376c {
        public static final C1375a values = new C1375a();
    }

    /* renamed from: com.appsflyer.internal.a$d */
    public static final class C1377d {
        public final float AFInAppEventParameterName;
        public final String AFInAppEventType;

        public C1377d(float f, String str) {
            this.AFInAppEventParameterName = f;
            this.AFInAppEventType = str;
        }
    }

    @NonNull
    public final C1377d AFInAppEventType(Context context) {
        String str = null;
        float f = 0.0f;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, this.valueOf);
            if (registerReceiver != null) {
                if (2 == registerReceiver.getIntExtra("status", -1)) {
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    str = intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "other" : "wireless" : "usb" : "ac";
                } else {
                    str = "no";
                }
                int intExtra2 = registerReceiver.getIntExtra("level", -1);
                int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra2 || -1 == intExtra3)) {
                    f = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
                }
            }
        } catch (Throwable unused) {
        }
        return new C1377d(f, str);
    }
}
