package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.StrictMode;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.internal.WebDialog;
import com.unity3d.services.banners.UnityBannerSize;
import com.vungle.warren.VisionController;

/* renamed from: com.applovin.impl.sdk.utils.g */
public class C1263g {
    /* renamed from: a */
    public static Point m2503a(Context context) {
        Point point = new Point();
        point.x = WebDialog.NO_PADDING_SCREEN_WIDTH;
        point.y = UnityBannerSize.BannerSize.STANDARD_WIDTH;
        WindowManager windowManager = (WindowManager) context.getSystemService(VisionController.WINDOW);
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (m2506b()) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
        }
        return point;
    }

    /* renamed from: a */
    public static void m2504a() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static boolean m2505a(String str, Context context) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    /* renamed from: b */
    public static boolean m2506b() {
        return true;
    }

    /* renamed from: c */
    public static boolean m2507c() {
        return true;
    }

    /* renamed from: d */
    public static boolean m2508d() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* renamed from: e */
    public static boolean m2509e() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* renamed from: f */
    public static boolean m2510f() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: g */
    public static boolean m2511g() {
        return Build.VERSION.SDK_INT >= 28;
    }

    /* renamed from: h */
    public static boolean m2512h() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
