package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.applovin.impl.sdk.C1314v;

/* renamed from: com.applovin.impl.sdk.utils.d */
public class C1259d {

    /* renamed from: a */
    public static C1259d f2434a;

    /* renamed from: b */
    public static final Object f2435b = new Object();

    /* renamed from: c */
    public final Bundle f2436c;

    /* renamed from: d */
    public final int f2437d;

    /* renamed from: e */
    public final boolean f2438e;

    public C1259d(Context context) {
        boolean z;
        Bundle bundle = null;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            C1314v.m2659c("AndroidManifest", "Failed to get meta data.", e);
        } catch (Throwable th) {
            this.f2436c = null;
            throw th;
        }
        this.f2436c = bundle;
        int i = 0;
        try {
            XmlResourceParser openXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
            int eventType = openXmlResourceParser.getEventType();
            int i2 = 0;
            z = false;
            do {
                if (2 == eventType) {
                    try {
                        if (openXmlResourceParser.getName().equals("application")) {
                            for (int i3 = 0; i3 < openXmlResourceParser.getAttributeCount(); i3++) {
                                String attributeName = openXmlResourceParser.getAttributeName(i3);
                                String attributeValue = openXmlResourceParser.getAttributeValue(i3);
                                if (attributeName.equals("networkSecurityConfig")) {
                                    i2 = Integer.valueOf(attributeValue.substring(1)).intValue();
                                } else if (attributeName.equals("usesCleartextTraffic")) {
                                    z = Boolean.valueOf(attributeValue).booleanValue();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i = i2;
                        try {
                            C1314v.m2659c("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
                            this.f2437d = i;
                            this.f2438e = z;
                        } catch (Throwable th3) {
                            this.f2437d = i;
                            this.f2438e = z;
                            throw th3;
                        }
                    }
                }
                eventType = openXmlResourceParser.next();
            } while (eventType != 1);
            this.f2437d = i2;
        } catch (Throwable th4) {
            th = th4;
            z = false;
            C1314v.m2659c("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
            this.f2437d = i;
            this.f2438e = z;
        }
        this.f2438e = z;
    }

    /* renamed from: a */
    public static C1259d m2494a(Context context) {
        C1259d dVar;
        synchronized (f2435b) {
            if (f2434a == null) {
                f2434a = new C1259d(context);
            }
            dVar = f2434a;
        }
        return dVar;
    }

    /* renamed from: a */
    public String mo11272a(String str, String str2) {
        Bundle bundle = this.f2436c;
        return bundle != null ? bundle.getString(str, str2) : str2;
    }

    /* renamed from: a */
    public boolean mo11273a() {
        return this.f2437d != 0;
    }

    /* renamed from: a */
    public boolean mo11274a(String str) {
        Bundle bundle = this.f2436c;
        if (bundle != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo11275a(String str, boolean z) {
        Bundle bundle = this.f2436c;
        return bundle != null ? bundle.getBoolean(str, z) : z;
    }
}
