package com.applovin.sdk;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Locale;

public class AppLovinAdSize {
    public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, "BANNER");
    public static final AppLovinAdSize CROSS_PROMO = new AppLovinAdSize(-1, -1, "XPROMO");
    public static final AppLovinAdSize INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
    public static final AppLovinAdSize LEADER = new AppLovinAdSize(-1, 90, "LEADER");
    public static final AppLovinAdSize MREC = new AppLovinAdSize(300, 250, "MREC");
    public static final AppLovinAdSize NATIVE = new AppLovinAdSize(-1, -1, "NATIVE");
    public static final int SPAN = -1;

    /* renamed from: a */
    public final String f2709a;

    /* renamed from: b */
    public final int f2710b;

    /* renamed from: c */
    public final int f2711c;

    public AppLovinAdSize(int i, int i2, String str) {
        this.f2710b = i;
        this.f2711c = i2;
        this.f2709a = str;
    }

    public static AppLovinAdSize fromString(String str) {
        if ("BANNER".equalsIgnoreCase(str)) {
            return BANNER;
        }
        if ("MREC".equalsIgnoreCase(str)) {
            return MREC;
        }
        if ("LEADER".equalsIgnoreCase(str)) {
            return LEADER;
        }
        if ("INTERSTITIAL".equalsIgnoreCase(str) || "INTER".equalsIgnoreCase(str)) {
            return INTERSTITIAL;
        }
        if ("XPROMO".equalsIgnoreCase(str)) {
            return CROSS_PROMO;
        }
        if ("NATIVE".equalsIgnoreCase(str)) {
            return NATIVE;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("Unknown Ad Size: ", str));
    }

    public int getHeight() {
        return this.f2711c;
    }

    public String getLabel() {
        return this.f2709a.toUpperCase(Locale.ENGLISH);
    }

    public int getWidth() {
        return this.f2710b;
    }

    public String toString() {
        return getLabel();
    }
}
