package com.applovin.impl.sdk;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdContentRating;
import com.applovin.sdk.AppLovinGender;
import com.applovin.sdk.AppLovinTargetingData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.f */
public class C1167f implements AppLovinTargetingData {

    /* renamed from: a */
    public final Map<String, String> f2099a = new HashMap();

    /* renamed from: b */
    public final Object f2100b = new Object();
    @Nullable

    /* renamed from: c */
    public Integer f2101c = null;
    @Nullable

    /* renamed from: d */
    public AppLovinGender f2102d = null;
    @Nullable

    /* renamed from: e */
    public AppLovinAdContentRating f2103e = null;
    @Nullable

    /* renamed from: f */
    public String f2104f = null;
    @Nullable

    /* renamed from: g */
    public String f2105g = null;
    @Nullable

    /* renamed from: h */
    public List<String> f2106h = null;
    @Nullable

    /* renamed from: i */
    public List<String> f2107i = null;

    /* renamed from: a */
    private void m1992a(String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f2100b) {
                if (StringUtils.isValidString(str2)) {
                    this.f2099a.put(str, str2);
                } else {
                    this.f2099a.remove(str);
                }
            }
        }
    }

    /* renamed from: a */
    public Map<String, String> mo10868a() {
        HashMap hashMap;
        synchronized (this.f2100b) {
            hashMap = new HashMap(this.f2099a);
        }
        return hashMap;
    }

    public void clearAll() {
        synchronized (this.f2100b) {
            this.f2099a.clear();
        }
    }

    @Nullable
    public String getEmail() {
        return this.f2104f;
    }

    @Nullable
    public AppLovinGender getGender() {
        return this.f2102d;
    }

    @Nullable
    public List<String> getInterests() {
        return this.f2107i;
    }

    @Nullable
    public List<String> getKeywords() {
        return this.f2106h;
    }

    @Nullable
    public AppLovinAdContentRating getMaximumAdContentRating() {
        return this.f2103e;
    }

    @Nullable
    public String getPhoneNumber() {
        return this.f2105g;
    }

    @Nullable
    public Integer getYearOfBirth() {
        return this.f2101c;
    }

    public void setEmail(@Nullable String str) {
        m1992a("email", str != null ? StringUtils.toFullSHA1Hash(str.toLowerCase().trim()) : str);
        this.f2104f = str;
    }

    public void setGender(@Nullable AppLovinGender appLovinGender) {
        String str;
        if (appLovinGender != null) {
            if (appLovinGender == AppLovinGender.FEMALE) {
                str = "F";
            } else if (appLovinGender == AppLovinGender.MALE) {
                str = "M";
            } else if (appLovinGender == AppLovinGender.OTHER) {
                str = "O";
            }
            m1992a("gender", str);
            this.f2102d = appLovinGender;
        }
        str = null;
        m1992a("gender", str);
        this.f2102d = appLovinGender;
    }

    public void setInterests(@Nullable List<String> list) {
        m1992a("interests", list == null ? null : CollectionUtils.implode(list, list.size()));
        this.f2107i = list;
    }

    public void setKeywords(@Nullable List<String> list) {
        m1992a("keywords", list == null ? null : CollectionUtils.implode(list, list.size()));
        this.f2106h = list;
    }

    public void setMaximumAdContentRating(@Nullable AppLovinAdContentRating appLovinAdContentRating) {
        m1992a("maximum_ad_content_rating", (appLovinAdContentRating == null || appLovinAdContentRating == AppLovinAdContentRating.NONE) ? null : Integer.toString(appLovinAdContentRating.ordinal()));
        this.f2103e = appLovinAdContentRating;
    }

    public void setPhoneNumber(@Nullable String str) {
        m1992a("phone_number", str != null ? StringUtils.toFullSHA1Hash(str.replaceAll("[^0-9]", "")) : str);
        this.f2105g = str;
    }

    public void setYearOfBirth(@Nullable Integer num) {
        m1992a("year_of_birth", num == null ? null : Integer.toString(num.intValue()));
        this.f2101c = num;
    }
}
