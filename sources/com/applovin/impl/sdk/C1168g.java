package com.applovin.impl.sdk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinUserSegment;

/* renamed from: com.applovin.impl.sdk.g */
public class C1168g implements AppLovinUserSegment {
    @Nullable

    /* renamed from: a */
    public String f2108a;

    @Nullable
    public String getName() {
        return this.f2108a;
    }

    public void setName(@Nullable String str) {
        if (str != null) {
            if (str.length() > 32) {
                C1314v.m2663i("AppLovinUserSegment", "Setting name greater than 32 characters: " + str);
            }
            if (!StringUtils.isAlphaNumeric(str)) {
                C1314v.m2663i("AppLovinUserSegment", "Setting name that is not alphanumeric: " + str);
            }
        }
        this.f2108a = str;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinUserSegment{name=");
        outline24.append(getName());
        outline24.append('}');
        return outline24.toString();
    }
}
