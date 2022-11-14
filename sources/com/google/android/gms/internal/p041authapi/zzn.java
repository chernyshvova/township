package com.google.android.gms.internal.p041authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzn */
public final class zzn extends zzp<Status> {
    public zzn(zzi zzi, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final void zzc(Context context, zzw zzw) throws RemoteException {
        zzw.zzc(new zzo(this));
    }
}
