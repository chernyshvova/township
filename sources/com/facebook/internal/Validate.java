package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.SavedStateHandle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.vungle.warren.log.LogEntry;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Validate.kt */
public final class Validate {
    public static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
    public static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
    public static final String CUSTOM_TAB_REDIRECT_URI_PREFIX = "fbconnect://cct.";
    public static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    public static final Validate INSTANCE = new Validate();
    public static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    public static final String TAG;

    static {
        String name = Validate.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "Validate::class.java.name");
        TAG = name;
    }

    public static final void containsNoNullOrEmpty(Collection<String> collection, String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, "container");
        Intrinsics.checkNotNullParameter(str, "name");
        for (String next : collection) {
            if (next != null) {
                if (next.length() > 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline17("Container '", str, "' cannot contain empty values").toString());
                }
            } else {
                throw new NullPointerException(GeneratedOutlineSupport.outline17("Container '", str, "' cannot contain null values"));
            }
        }
    }

    public static final <T> void containsNoNulls(Collection<? extends T> collection, String str) {
        Intrinsics.checkNotNullParameter(collection, "container");
        Intrinsics.checkNotNullParameter(str, "name");
        for (Object obj : collection) {
            if (obj == null) {
                throw new NullPointerException(GeneratedOutlineSupport.outline17("Container '", str, "' cannot contain null values"));
            }
        }
    }

    public static final String hasAppID() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId != null) {
            return applicationId;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.".toString());
    }

    public static final boolean hasBluetoothPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        return hasPermission(context, "android.permission.BLUETOOTH") && hasPermission(context, "android.permission.BLUETOOTH_ADMIN");
    }

    public static final boolean hasChangeWifiStatePermission(Context context) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        return hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
    }

    public static final String hasClientToken() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken != null) {
            return clientToken;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token. Please follow https://developers.facebook.com/docs/android/getting-started/#client-access-token to get the token and fill it in AndroidManifest.xml".toString());
    }

    public static final void hasContentProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        String hasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String stringPlus = Intrinsics.stringPlus(CONTENT_PROVIDER_BASE, hasAppID);
            if (packageManager.resolveContentProvider(stringPlus, 0) == null) {
                throw new IllegalStateException(GeneratedOutlineSupport.outline21(new Object[]{stringPlus}, 1, CONTENT_PROVIDER_NOT_FOUND_REASON, "java.lang.String.format(format, *args)").toString());
            }
        }
    }

    public static final boolean hasCustomTabRedirectActivity(Context context, String str) {
        List<ResolveInfo> list;
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(str, "redirectURI");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            list = packageManager.queryIntentActivities(intent, 64);
        } else {
            list = null;
        }
        if (list == null) {
            return false;
        }
        boolean z = false;
        for (ResolveInfo resolveInfo : list) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!Intrinsics.areEqual(activityInfo.name, "com.facebook.CustomTabActivity") || !Intrinsics.areEqual(activityInfo.packageName, context.getPackageName())) {
                return false;
            }
            z = true;
        }
        return z;
    }

    public static final void hasFacebookActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        hasFacebookActivity(context, true);
    }

    public static final void hasInternetPermissions(Context context) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        hasInternetPermissions(context, true);
    }

    public static final boolean hasLocationPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        return hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || hasPermission(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    public static final boolean hasPermission(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(str, "permission");
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static final boolean hasWiFiPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        return hasPermission(context, "android.permission.ACCESS_WIFI_STATE");
    }

    public static final <T> void notEmpty(Collection<? extends T> collection, String str) {
        Intrinsics.checkNotNullParameter(collection, "container");
        Intrinsics.checkNotNullParameter(str, "name");
        if (!(!collection.isEmpty())) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline17("Container '", str, "' cannot be empty").toString());
        }
    }

    public static final <T> void notEmptyAndContainsNoNulls(Collection<? extends T> collection, String str) {
        Intrinsics.checkNotNullParameter(collection, "container");
        Intrinsics.checkNotNullParameter(str, "name");
        containsNoNulls(collection, str);
        notEmpty(collection, str);
    }

    public static final void notNull(Object obj, String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (obj == null) {
            throw new NullPointerException(GeneratedOutlineSupport.outline17("Argument '", str, "' cannot be null"));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        if ((r2.length() > 0) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String notNullOrEmpty(java.lang.String r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 1
            if (r2 == 0) goto L_0x0014
            int r1 = r2.length()
            if (r1 <= 0) goto L_0x0010
            r1 = 1
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            if (r1 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x0018
            return r2
        L_0x0018:
            java.lang.String r2 = "Argument '"
            java.lang.String r0 = "' cannot be null or empty"
            java.lang.String r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline17(r2, r3, r0)
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r2.toString()
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Validate.notNullOrEmpty(java.lang.String, java.lang.String):java.lang.String");
    }

    public static final void oneOf(Object obj, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(objArr, SavedStateHandle.VALUES);
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj2 = objArr[i];
            i++;
            if (Intrinsics.areEqual(obj2, obj)) {
                return;
            }
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline17("Argument '", str, "' was not one of the allowed values"));
    }

    public static final void runningOnUiThread() {
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            throw new FacebookException("This method should be called from the UI thread");
        }
    }

    public static final void sdkInitialized() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void hasFacebookActivity(android.content.Context r4, boolean r5) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            r1 = 1
            if (r0 == 0) goto L_0x0018
            android.content.ComponentName r2 = new android.content.ComponentName
            java.lang.String r3 = "com.facebook.FacebookActivity"
            r2.<init>(r4, r3)
            android.content.pm.ActivityInfo r4 = r0.getActivityInfo(r2, r1)     // Catch:{ NameNotFoundException -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r4 = 0
        L_0x0019:
            if (r4 != 0) goto L_0x0031
            r4 = r5 ^ 1
            java.lang.String r5 = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info."
            if (r4 == 0) goto L_0x0027
            java.lang.String r4 = TAG
            android.util.Log.w(r4, r5)
            goto L_0x0031
        L_0x0027:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Validate.hasFacebookActivity(android.content.Context, boolean):void");
    }

    public static final void hasInternetPermissions(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != -1) {
            return;
        }
        if (!z) {
            Log.w(TAG, NO_INTERNET_PERMISSION_REASON);
            return;
        }
        throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON.toString());
    }

    public static final void notEmpty(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "arg");
        Intrinsics.checkNotNullParameter(str2, "name");
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline17("Argument '", str2, "' cannot be empty").toString());
        }
    }
}
