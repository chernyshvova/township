package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.AccessToken;
import com.facebook.internal.InstallReferrerUtil;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* renamed from: com.facebook.internal.InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1 */
/* compiled from: InstallReferrerUtil.kt */
public final class C1559x4e593c98 implements InstallReferrerStateListener {
    public final /* synthetic */ InstallReferrerUtil.Callback $callback;
    public final /* synthetic */ InstallReferrerClient $referrerClient;

    public C1559x4e593c98(InstallReferrerClient installReferrerClient, InstallReferrerUtil.Callback callback) {
        this.$referrerClient = installReferrerClient;
        this.$callback = callback;
    }

    public void onInstallReferrerServiceDisconnected() {
    }

    public void onInstallReferrerSetupFinished(int i) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (i == 0) {
                try {
                    ReferrerDetails installReferrer = this.$referrerClient.getInstallReferrer();
                    Intrinsics.checkNotNullExpressionValue(installReferrer, "{\n                      referrerClient.installReferrer\n                    }");
                    String installReferrer2 = installReferrer.getInstallReferrer();
                    if (installReferrer2 != null && (CharsKt__CharKt.contains$default(installReferrer2, "fb", false, 2) || CharsKt__CharKt.contains$default(installReferrer2, AccessToken.DEFAULT_GRAPH_DOMAIN, false, 2))) {
                        this.$callback.onReceiveReferrerUrl(installReferrer2);
                    }
                    InstallReferrerUtil.INSTANCE.updateReferrer();
                } catch (RemoteException unused) {
                }
            } else if (i == 2) {
                try {
                    InstallReferrerUtil.INSTANCE.updateReferrer();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }
}
