package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zacn<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    @Nullable
    public ResultTransform<? super R, ? extends Result> zaa = null;
    @Nullable
    public zacn<? extends Result> zab = null;
    @Nullable
    public volatile ResultCallbacks<? super R> zac = null;
    @Nullable
    public PendingResult<R> zad = null;
    public final Object zae = new Object();
    @Nullable
    public Status zaf = null;
    public final WeakReference<GoogleApiClient> zag;
    public final zacp zah;
    public boolean zai = false;

    public zacn(WeakReference<GoogleApiClient> weakReference) {
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zag = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        this.zah = new zacp(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    @GuardedBy("mSyncToken")
    private final void zab() {
        if (this.zaa != null || this.zac != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zag.get();
            if (!(this.zai || this.zaa == null || googleApiClient == null)) {
                googleApiClient.zaa(this);
                this.zai = true;
            }
            Status status = this.zaf;
            if (status != null) {
                zab(status);
                return;
            }
            PendingResult<R> pendingResult = this.zad;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean zac() {
        return (this.zac == null || ((GoogleApiClient) this.zag.get()) == null) ? false : true;
    }

    public final void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.zae) {
            boolean z = true;
            Preconditions.checkState(this.zac == null, "Cannot call andFinally() twice.");
            if (this.zaa != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zac = resultCallbacks;
            zab();
        }
    }

    public final void onResult(R r) {
        synchronized (this.zae) {
            if (!r.getStatus().isSuccess()) {
                zaa(r.getStatus());
                zaa((Result) r);
            } else if (this.zaa != null) {
                zacd.zaa().submit(new zacm(this, r));
            } else if (zac()) {
                ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onSuccess(r);
            }
        }
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zacn<? extends Result> zacn;
        synchronized (this.zae) {
            boolean z = true;
            Preconditions.checkState(this.zaa == null, "Cannot call then() twice.");
            if (this.zac != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zaa = resultTransform;
            zacn = new zacn<>(this.zag);
            this.zab = zacn;
            zab();
        }
        return zacn;
    }

    public final void zaa(PendingResult<?> pendingResult) {
        synchronized (this.zae) {
            this.zad = pendingResult;
            zab();
        }
    }

    /* access modifiers changed from: private */
    public final void zaa(Status status) {
        synchronized (this.zae) {
            this.zaf = status;
            zab(status);
        }
    }

    public final void zaa() {
        this.zac = null;
    }

    public static void zaa(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e);
            }
        }
    }

    private final void zab(Status status) {
        synchronized (this.zae) {
            if (this.zaa != null) {
                ((zacn) Preconditions.checkNotNull(this.zab)).zaa((Status) Preconditions.checkNotNull(this.zaa.onFailure(status), "onFailure must not return null"));
            } else if (zac()) {
                ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onFailure(status);
            }
        }
    }
}
