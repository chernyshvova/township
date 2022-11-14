package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zacm implements Runnable {
    public final /* synthetic */ Result zaa;
    public final /* synthetic */ zacn zab;

    public zacm(zacn zacn, Result result) {
        this.zab = zacn;
        this.zaa = result;
    }

    @WorkerThread
    public final void run() {
        try {
            BasePendingResult.zaa.set(Boolean.TRUE);
            this.zab.zah.sendMessage(this.zab.zah.obtainMessage(0, ((ResultTransform) Preconditions.checkNotNull(this.zab.zaa)).onSuccess(this.zaa)));
            BasePendingResult.zaa.set(Boolean.FALSE);
            zacn.zaa(this.zaa);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient != null) {
                googleApiClient.zab(this.zab);
            }
        } catch (RuntimeException e) {
            this.zab.zah.sendMessage(this.zab.zah.obtainMessage(1, e));
            BasePendingResult.zaa.set(Boolean.FALSE);
            zacn.zaa(this.zaa);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zab(this.zab);
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zacn.zaa(this.zaa);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zab(this.zab);
            }
            throw th;
        }
    }
}
