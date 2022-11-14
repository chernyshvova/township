package com.iab.omid.library.applovin.p047d;

import android.os.Build;
import com.swrve.sdk.rest.RESTClient;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.d.a */
public final class C2855a {
    /* renamed from: a */
    public static String m3351a() {
        return Build.MANUFACTURER + RESTClient.SEMICOLON_SEPARATOR + Build.MODEL;
    }

    /* renamed from: b */
    public static String m3352b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    /* renamed from: c */
    public static String m3353c() {
        return "Android";
    }

    /* renamed from: d */
    public static JSONObject m3354d() {
        JSONObject jSONObject = new JSONObject();
        C2856b.m3362a(jSONObject, "deviceType", m3351a());
        C2856b.m3362a(jSONObject, "osVersion", m3352b());
        C2856b.m3362a(jSONObject, "os", m3353c());
        return jSONObject;
    }
}
