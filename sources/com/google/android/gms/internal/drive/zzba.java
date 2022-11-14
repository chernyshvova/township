package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

public final class zzba extends zzav {
    public final /* synthetic */ DriveId zzen;
    public final /* synthetic */ int zzeo = 1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzba(zzaw zzaw, GoogleApiClient googleApiClient, DriveId driveId, int i) {
        super(googleApiClient);
        this.zzen = driveId;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgs(this.zzen, this.zzeo), (zzes) null, (String) null, (zzeq) new zzgy(this));
    }
}
