package com.applovin.impl.sdk.p025ad;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.d */
public final class C1056d {

    /* renamed from: a */
    public static final Map<String, C1056d> f1407a = new HashMap();

    /* renamed from: b */
    public static final Object f1408b = new Object();

    /* renamed from: c */
    public JSONObject f1409c;

    /* renamed from: d */
    public final String f1410d;

    /* renamed from: e */
    public AppLovinAdSize f1411e;

    /* renamed from: f */
    public AppLovinAdType f1412f;

    public C1056d(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str) {
        String str2;
        if (!TextUtils.isEmpty(str) || !(appLovinAdType == null || appLovinAdSize == null)) {
            this.f1411e = appLovinAdSize;
            this.f1412f = appLovinAdType;
            if (StringUtils.isValidString(str)) {
                str2 = str.trim();
            } else {
                str2 = appLovinAdSize.getLabel() + "_" + appLovinAdType.getLabel();
            }
            this.f1410d = str2.toLowerCase(Locale.ENGLISH);
            return;
        }
        throw new IllegalArgumentException("No zone identifier or type or size specified");
    }

    /* renamed from: a */
    public static C1056d m1471a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        return m1472a(appLovinAdSize, appLovinAdType, (String) null);
    }

    /* renamed from: a */
    public static C1056d m1472a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str) {
        C1056d dVar = new C1056d(appLovinAdSize, appLovinAdType, str);
        synchronized (f1408b) {
            String str2 = dVar.f1410d;
            if (f1407a.containsKey(str2)) {
                dVar = f1407a.get(str2);
            } else {
                f1407a.put(str2, dVar);
            }
        }
        return dVar;
    }

    /* renamed from: a */
    public static C1056d m1473a(String str) {
        return m1472a((AppLovinAdSize) null, (AppLovinAdType) null, str);
    }

    /* renamed from: a */
    public static void m1474a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ad_size") && jSONObject.has("ad_type")) {
            synchronized (f1408b) {
                C1056d dVar = f1407a.get(JsonUtils.getString(jSONObject, "zone_id", ""));
                if (dVar != null) {
                    dVar.f1411e = AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", ""));
                    dVar.f1412f = AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", ""));
                }
            }
        }
    }

    /* renamed from: b */
    public static C1056d m1475b(String str) {
        return m1472a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, str);
    }

    /* renamed from: f */
    public static Collection<C1056d> m1476f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(6);
        Collections.addAll(linkedHashSet, new C1056d[]{m1477g(), m1478h(), m1479i(), m1480j(), m1481k(), m1482l()});
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: g */
    public static C1056d m1477g() {
        return m1471a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR);
    }

    /* renamed from: h */
    public static C1056d m1478h() {
        return m1471a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR);
    }

    /* renamed from: i */
    public static C1056d m1479i() {
        return m1471a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR);
    }

    /* renamed from: j */
    public static C1056d m1480j() {
        return m1471a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);
    }

    /* renamed from: k */
    public static C1056d m1481k() {
        return m1471a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED);
    }

    /* renamed from: l */
    public static C1056d m1482l() {
        return m1471a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE);
    }

    /* renamed from: a */
    public String mo10548a() {
        return this.f1410d;
    }

    @Nullable
    /* renamed from: b */
    public MaxAdFormat mo10549b() {
        AppLovinAdSize c = mo10550c();
        if (c == AppLovinAdSize.BANNER) {
            return MaxAdFormat.BANNER;
        }
        if (c == AppLovinAdSize.LEADER) {
            return MaxAdFormat.LEADER;
        }
        if (c == AppLovinAdSize.MREC) {
            return MaxAdFormat.MREC;
        }
        if (c == AppLovinAdSize.CROSS_PROMO) {
            return MaxAdFormat.CROSS_PROMO;
        }
        if (c == AppLovinAdSize.INTERSTITIAL) {
            if (mo10551d() == AppLovinAdType.REGULAR) {
                return MaxAdFormat.INTERSTITIAL;
            }
            if (mo10551d() == AppLovinAdType.INCENTIVIZED) {
                return MaxAdFormat.REWARDED;
            }
            if (mo10551d() == AppLovinAdType.AUTO_INCENTIVIZED) {
                return MaxAdFormat.REWARDED_INTERSTITIAL;
            }
            return null;
        } else if (c == AppLovinAdSize.NATIVE) {
            return MaxAdFormat.NATIVE;
        } else {
            return null;
        }
    }

    /* renamed from: c */
    public AppLovinAdSize mo10550c() {
        if (this.f1411e == null && JsonUtils.valueExists(this.f1409c, "ad_size")) {
            this.f1411e = AppLovinAdSize.fromString(JsonUtils.getString(this.f1409c, "ad_size", (String) null));
        }
        return this.f1411e;
    }

    /* renamed from: d */
    public AppLovinAdType mo10551d() {
        if (this.f1412f == null && JsonUtils.valueExists(this.f1409c, "ad_type")) {
            this.f1412f = AppLovinAdType.fromString(JsonUtils.getString(this.f1409c, "ad_type", (String) null));
        }
        return this.f1412f;
    }

    /* renamed from: e */
    public boolean mo10552e() {
        return m1476f().contains(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1056d.class != obj.getClass()) {
            return false;
        }
        return this.f1410d.equalsIgnoreCase(((C1056d) obj).f1410d);
    }

    public int hashCode() {
        return this.f1410d.hashCode();
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AdZone{id=");
        outline24.append(this.f1410d);
        outline24.append(", zoneObject=");
        outline24.append(this.f1409c);
        outline24.append('}');
        return outline24.toString();
    }
}
