package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzcd extends zzav {
    public final /* synthetic */ zzei zzfl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcd(zzcb zzcb, GoogleApiClient googleApiClient, zzei zzei) {
        super(googleApiClient);
        this.zzfl = zzei;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgu(this.zzfl), (zzeq) new zzgy(this));
    }
}
