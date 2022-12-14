package com.google.android.gms.internal.p041authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzj */
public final class zzj extends zzp<CredentialRequestResult> {
    public final /* synthetic */ CredentialRequest zzam;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzj(zzi zzi, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        super(googleApiClient);
        this.zzam = credentialRequest;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return zzh.zzd(status);
    }

    public final void zzc(Context context, zzw zzw) throws RemoteException {
        zzw.zzc((zzu) new zzk(this), this.zzam);
    }
}
