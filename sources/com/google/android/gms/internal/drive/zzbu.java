package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;

public final class zzbu extends zzca {
    public final /* synthetic */ MetadataChangeSet zzfd;
    public final /* synthetic */ zzbs zzfh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbu(zzbs zzbs, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        super(googleApiClient);
        this.zzfh = zzbs;
        this.zzfd = metadataChangeSet;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzfd.zzq().zza(zzaw.getContext());
        ((zzeo) zzaw.getService()).zza(new zzy(this.zzfh.getDriveId(), this.zzfd.zzq()), (zzeq) new zzbw(this));
    }
}
