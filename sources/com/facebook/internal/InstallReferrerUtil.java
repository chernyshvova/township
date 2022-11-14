package com.facebook.internal;

import com.android.installreferrer.api.InstallReferrerClient;
import com.facebook.FacebookSdk;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstallReferrerUtil.kt */
public final class InstallReferrerUtil {
    public static final InstallReferrerUtil INSTANCE = new InstallReferrerUtil();
    public static final String IS_REFERRER_UPDATED = "is_referrer_updated";

    /* compiled from: InstallReferrerUtil.kt */
    public interface Callback {
        void onReceiveReferrerUrl(String str);
    }

    private final boolean isUpdated() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean(IS_REFERRER_UPDATED, false);
    }

    private final void tryConnectReferrerInfo(Callback callback) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        InstallReferrerClient build = InstallReferrerClient.newBuilder(FacebookSdk.getApplicationContext()).build();
        try {
            build.startConnection(new C1559x4e593c98(build, callback));
        } catch (Exception unused) {
        }
    }

    public static final void tryUpdateReferrerInfo(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!INSTANCE.isUpdated()) {
            INSTANCE.tryConnectReferrerInfo(callback);
        }
    }

    /* access modifiers changed from: private */
    public final void updateReferrer() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
    }
}
