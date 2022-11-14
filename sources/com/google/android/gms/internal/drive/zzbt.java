package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;

public final class zzbt extends zzby {
    public final /* synthetic */ MetadataChangeSet zzfd;
    public final /* synthetic */ int zzfe;
    public final /* synthetic */ int zzff;
    public final /* synthetic */ ExecutionOptions zzfg;
    public final /* synthetic */ zzbs zzfh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbt(zzbs zzbs, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        super(googleApiClient);
        this.zzfh = zzbs;
        this.zzfd = metadataChangeSet;
        this.zzfe = i;
        this.zzff = i2;
        this.zzfg = executionOptions;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzfd.zzq().zza(zzaw.getContext());
        ((zzeo) zzaw.getService()).zza(new zzw(this.zzfh.getDriveId(), this.zzfd.zzq(), this.zzfe, this.zzff, this.zzfg), (zzeq) new zzbv(this));
    }
}
