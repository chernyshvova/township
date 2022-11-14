package com.facebook.bolts;

import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppLinks.kt */
public final class AppLinks {
    public static final AppLinks INSTANCE = new AppLinks();
    public static final String KEY_NAME_APPLINK_DATA = "al_applink_data";
    public static final String KEY_NAME_EXTRAS = "extras";

    public static final Bundle getAppLinkData(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return intent.getBundleExtra("al_applink_data");
    }

    public static final Bundle getAppLinkExtras(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData == null) {
            return null;
        }
        return appLinkData.getBundle("extras");
    }
}
