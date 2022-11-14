package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzaz extends zzav {
    public final /* synthetic */ zzj zzek;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaz(zzaw zzaw, GoogleApiClient googleApiClient, zzj zzj) {
        super(googleApiClient);
        this.zzek = zzj;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(this.zzek, (zzes) null, (String) null, (zzeq) new zzgy(this));
    }
}
