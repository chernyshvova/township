package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.browser.customtabs.CustomTabsService;
import com.android.billingclient.api.zzam;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTabUtils.kt */
public final class CustomTabUtils {
    public static final String[] CHROME_PACKAGES = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    public static final CustomTabUtils INSTANCE = new CustomTabUtils();

    public static final String getChromePackage() {
        Class<CustomTabUtils> cls = CustomTabUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            List<ResolveInfo> queryIntentServices = applicationContext.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
            if (queryIntentServices != null) {
                String[] strArr = CHROME_PACKAGES;
                Intrinsics.checkNotNullParameter(strArr, "$this$toHashSet");
                HashSet hashSet = new HashSet(zzam.mapCapacity(strArr.length));
                zzam.toCollection(strArr, hashSet);
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                        return serviceInfo.packageName;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final String getDefaultRedirectURI() {
        Class<CustomTabUtils> cls = CustomTabUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return Intrinsics.stringPlus(Validate.CUSTOM_TAB_REDIRECT_URI_PREFIX, FacebookSdk.getApplicationContext().getPackageName());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final String getValidRedirectURI(String str) {
        Class<CustomTabUtils> cls = CustomTabUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "developerDefinedRedirectURI");
            Validate validate = Validate.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), str)) {
                return str;
            }
            Validate validate2 = Validate.INSTANCE;
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            return Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), getDefaultRedirectURI()) ? getDefaultRedirectURI() : "";
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
