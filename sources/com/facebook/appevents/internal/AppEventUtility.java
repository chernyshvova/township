package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.vungle.warren.downloader.AssetDownloader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppEventUtility.kt */
public final class AppEventUtility {
    public static final AppEventUtility INSTANCE = new AppEventUtility();
    public static final String PRICE_REGEX = "[-+]*\\d+([.,]\\d+)*([.,]\\d+)?";

    public static final void assertIsMainThread() {
    }

    public static final void assertIsNotMainThread() {
    }

    public static final String bytesToHex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, AssetDownloader.BYTES);
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            byte b = bArr[i];
            i++;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            stringBuffer.append(format);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }

    public static final String getAppVersion() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            String str = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "{\n      val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)\n      packageInfo.versionName\n    }");
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static final View getRootView(Activity activity) {
        Class<AppEventUtility> cls = AppEventUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return window.getDecorView().getRootView();
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006e, code lost:
        if (kotlin.text.CharsKt__CharKt.startsWith$default(r0, "generic", false, 2) == false) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isEmulator() {
        /*
            java.lang.String r0 = android.os.Build.FINGERPRINT
            java.lang.String r1 = "FINGERPRINT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r2 = "generic"
            r3 = 0
            r4 = 2
            boolean r0 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r2, r3, r4)
            if (r0 != 0) goto L_0x0078
            java.lang.String r0 = android.os.Build.FINGERPRINT
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "unknown"
            boolean r0 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r1, r3, r4)
            if (r0 != 0) goto L_0x0078
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "MODEL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r5 = "google_sdk"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r5, r3, r4)
            if (r0 != 0) goto L_0x0078
            java.lang.String r0 = android.os.Build.MODEL
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r6 = "Emulator"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r6, r3, r4)
            if (r0 != 0) goto L_0x0078
            java.lang.String r0 = android.os.Build.MODEL
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "Android SDK built for x86"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r1, r3, r4)
            if (r0 != 0) goto L_0x0078
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "MANUFACTURER"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "Genymotion"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r1, r3, r4)
            if (r0 != 0) goto L_0x0078
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = "BRAND"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r2, r3, r4)
            if (r0 == 0) goto L_0x0070
            java.lang.String r0 = android.os.Build.DEVICE
            java.lang.String r1 = "DEVICE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r2, r3, r4)
            if (r0 != 0) goto L_0x0078
        L_0x0070:
            java.lang.String r0 = android.os.Build.PRODUCT
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r0 == 0) goto L_0x0079
        L_0x0078:
            r3 = 1
        L_0x0079:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.AppEventUtility.isEmulator():boolean");
    }

    public static final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final double normalizePrice(String str) {
        try {
            Matcher matcher = Pattern.compile(PRICE_REGEX, 8).matcher(str);
            if (!matcher.find()) {
                return RoundRectDrawableWithShadow.COS_45;
            }
            String group = matcher.group(0);
            Utility utility = Utility.INSTANCE;
            return NumberFormat.getNumberInstance(Utility.getCurrentLocale()).parse(group).doubleValue();
        } catch (ParseException unused) {
            return RoundRectDrawableWithShadow.COS_45;
        }
    }
}
