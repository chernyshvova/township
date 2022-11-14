package com.google.android.gms.internal.p041authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzh */
public final class zzh implements CredentialRequestResult {
    public final Status mStatus;
    public final Credential zzal;

    public zzh(Status status, Credential credential) {
        this.mStatus = status;
        this.zzal = credential;
    }

    public static zzh zzd(Status status) {
        return new zzh(status, (Credential) null);
    }

    public final Credential getCredential() {
        return this.zzal;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
