package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.C1173j;
import com.applovin.impl.sdk.C1314v;

public class AppLovinPrivacySettings {
    public static boolean hasUserConsent(Context context) {
        C1314v.m2660f("AppLovinPrivacySettings", "hasUserConsent()");
        Boolean a = C1173j.m2018b().mo10902a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUser(Context context) {
        C1314v.m2660f("AppLovinPrivacySettings", "isAgeRestrictedUser()");
        Boolean a = C1173j.m2013a().mo10902a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUserSet(Context context) {
        C1314v.m2660f("AppLovinPrivacySettings", "isAgeRestrictedUserSet()");
        return C1173j.m2013a().mo10902a(context) != null;
    }

    public static boolean isDoNotSell(Context context) {
        C1314v.m2660f("AppLovinPrivacySettings", "isDoNotSell()");
        Boolean a = C1173j.m2020c().mo10902a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static boolean isDoNotSellSet(Context context) {
        C1314v.m2660f("AppLovinPrivacySettings", "isDoNotSellSet()");
        return C1173j.m2020c().mo10902a(context) != null;
    }

    public static boolean isUserConsentSet(Context context) {
        C1314v.m2660f("AppLovinPrivacySettings", "isUserConsentSet()");
        return C1173j.m2018b().mo10902a(context) != null;
    }

    public static void setDoNotSell(boolean z, Context context) {
        C1314v.m2660f("AppLovinPrivacySettings", "setDoNotSell()");
        if (C1173j.m2021c(z, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, (Boolean) null, Boolean.valueOf(z));
        }
    }

    public static void setHasUserConsent(boolean z, Context context) {
        C1314v.m2660f("AppLovinPrivacySettings", "setHasUserConsent()");
        if (C1173j.m2019b(z, context)) {
            AppLovinSdk.reinitializeAll(Boolean.valueOf(z), (Boolean) null, (Boolean) null);
        }
    }

    public static void setIsAgeRestrictedUser(boolean z, Context context) {
        C1314v.m2660f("AppLovinPrivacySettings", "setIsAgeRestrictedUser()");
        if (C1173j.m2017a(z, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, Boolean.valueOf(z), (Boolean) null);
        }
    }
}
