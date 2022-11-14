package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzdq extends zzea {
    public final /* synthetic */ boolean zzga = false;
    public final /* synthetic */ zzdp zzgq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdq(zzdp zzdp, GoogleApiClient googleApiClient, boolean z) {
        super(zzdp, googleApiClient, (zzdq) null);
        this.zzgq = zzdp;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzek(this.zzgq.zzk, this.zzga), (zzeq) new zzdy(this));
    }
}
