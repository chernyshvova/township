package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.zzn;

public final class zzbk extends zzav {
    public final /* synthetic */ zzbi zzev;
    public final /* synthetic */ MetadataChangeSet zzew;
    public final /* synthetic */ zzn zzex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbk(zzbi zzbi, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, zzn zzn) {
        super(googleApiClient);
        this.zzev = zzbi;
        this.zzew = metadataChangeSet;
        this.zzex = zzn;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzew.zzq().zza(zzaw.getContext());
        ((zzeo) zzaw.getService()).zza(new zzm(this.zzev.zzes.getDriveId(), this.zzew.zzq(), this.zzev.zzes.getRequestId(), this.zzev.zzes.zzb(), this.zzex), (zzeq) new zzgy(this));
    }
}
