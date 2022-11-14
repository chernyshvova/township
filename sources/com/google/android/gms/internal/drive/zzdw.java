package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzdw extends zzav {
    public final /* synthetic */ zzdp zzgq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdw(zzdp zzdp, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzgq = zzdp;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzhd(this.zzgq.zzk), (zzeq) new zzgy(this));
    }
}
