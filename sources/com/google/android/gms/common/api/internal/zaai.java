package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaai extends zaay {
    public final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaai(zaag zaag, zaaw zaaw, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zaaw);
        this.zaa = connectionProgressReportCallbacks;
    }

    @GuardedBy("mLock")
    public final void zaa() {
        this.zaa.onReportServiceBinding(new ConnectionResult(16, (PendingIntent) null));
    }
}
