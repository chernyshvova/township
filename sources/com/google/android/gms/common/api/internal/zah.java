package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zah<ResultT> extends zad {
    public final TaskApiCall<Api.AnyClient, ResultT> zab;
    public final TaskCompletionSource<ResultT> zac;
    public final StatusExceptionMapper zad;

    public zah(int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i);
        this.zac = taskCompletionSource;
        this.zab = taskApiCall;
        this.zad = statusExceptionMapper;
        if (i == 2 && taskApiCall.shouldAutoResolveMissingFeatures()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    public final void zaa(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            this.zab.doExecute(zaa.zab(), this.zac);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zaa(zab.zab(e2));
        } catch (RuntimeException e3) {
            zaa((Exception) e3);
        }
    }

    @Nullable
    public final Feature[] zac(GoogleApiManager.zaa<?> zaa) {
        return this.zab.zaa();
    }

    public final boolean zad(GoogleApiManager.zaa<?> zaa) {
        return this.zab.shouldAutoResolveMissingFeatures();
    }

    public final void zaa(@NonNull Status status) {
        this.zac.trySetException(this.zad.getException(status));
    }

    public final void zaa(@NonNull Exception exc) {
        this.zac.trySetException(exc);
    }

    public final void zaa(@NonNull zav zav, boolean z) {
        zav.zaa(this.zac, z);
    }
}
