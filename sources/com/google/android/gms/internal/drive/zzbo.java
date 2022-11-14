package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.DriveFile;

public final class zzbo extends zzam {
    public final /* synthetic */ int zzdv;
    public final /* synthetic */ DriveFile.DownloadProgressListener zzey;
    public final /* synthetic */ zzbn zzez;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbo(zzbn zzbn, GoogleApiClient googleApiClient, int i, DriveFile.DownloadProgressListener downloadProgressListener) {
        super(googleApiClient);
        this.zzez = zzbn;
        this.zzdv = i;
        this.zzey = downloadProgressListener;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        setCancelToken(ICancelToken.Stub.asInterface(((zzeo) ((zzaw) anyClient).getService()).zza(new zzgj(this.zzez.getDriveId(), this.zzdv, 0), (zzeq) new zzgl(this, this.zzey)).zzgs));
    }
}
