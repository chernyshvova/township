package com.google.android.gms.internal.drive;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

@SuppressLint({"MissingRemoteException"})
public final class zzat extends zzav {
    public zzat(GoogleApiClient googleApiClient, Status status) {
        super(googleApiClient);
        setResult(status);
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
    }
}
