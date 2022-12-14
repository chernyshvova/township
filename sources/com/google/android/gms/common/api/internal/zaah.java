package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaah implements BaseGmsClient.ConnectionProgressReportCallbacks {
    public final WeakReference<zaaf> zaa;
    public final Api<?> zab;
    public final boolean zac;

    public zaah(zaaf zaaf, Api<?> api, boolean z) {
        this.zaa = new WeakReference<>(zaaf);
        this.zab = api;
        this.zac = z;
    }

    public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        zaaf zaaf = (zaaf) this.zaa.get();
        if (zaaf != null) {
            Preconditions.checkState(Looper.myLooper() == zaaf.zaa.zad.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zaaf.zab.lock();
            try {
                if (zaaf.zab(0)) {
                    if (!connectionResult.isSuccess()) {
                        zaaf.zab(connectionResult, this.zab, this.zac);
                    }
                    if (zaaf.zad()) {
                        zaaf.zae();
                    }
                    zaaf.zab.unlock();
                }
            } finally {
                zaaf.zab.unlock();
            }
        }
    }
}
