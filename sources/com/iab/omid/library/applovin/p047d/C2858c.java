package com.iab.omid.library.applovin.p047d;

import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.applovin.C2833a;

/* renamed from: com.iab.omid.library.applovin.d.c */
public final class C2858c {
    /* renamed from: a */
    public static void m3373a(String str) {
        if (C2833a.f3370a.booleanValue() && !TextUtils.isEmpty(str)) {
            Log.i("OMIDLIB", str);
        }
    }

    /* renamed from: a */
    public static void m3374a(String str, Exception exc) {
        if ((C2833a.f3370a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
