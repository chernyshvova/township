package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;

public final class zzdt extends zzea {
    public final /* synthetic */ MetadataChangeSet zzfd;
    public final /* synthetic */ zzdp zzgq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdt(zzdp zzdp, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        super(zzdp, googleApiClient, (zzdq) null);
        this.zzgq = zzdp;
        this.zzfd = metadataChangeSet;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzfd.zzq().zza(zzaw.getContext());
        ((zzeo) zzaw.getService()).zza(new zzhf(this.zzgq.zzk, this.zzfd.zzq()), (zzeq) new zzdy(this));
    }
}
