package com.google.android.gms.internal.p041authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzm */
public final class zzm extends zzp<Status> {
    public final /* synthetic */ Credential zzao;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzm(zzi zzi, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.zzao = credential;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final void zzc(Context context, zzw zzw) throws RemoteException {
        zzw.zzc((zzu) new zzo(this), new zzs(this.zzao));
    }
}
