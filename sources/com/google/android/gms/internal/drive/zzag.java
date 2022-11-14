package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.query.Query;

public final class zzag extends zzar {
    public final /* synthetic */ Query zzdu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzag(zzaf zzaf, GoogleApiClient googleApiClient, Query query) {
        super(googleApiClient);
        this.zzdu = query;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgq(this.zzdu), (zzeq) new zzas(this));
    }
}
