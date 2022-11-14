package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;

public final class zzan extends zzl {
    public final BaseImplementation.ResultHolder<DriveApi.DriveIdResult> zzdx;

    public zzan(BaseImplementation.ResultHolder<DriveApi.DriveIdResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    public final void zza(zzfy zzfy) throws RemoteException {
        this.zzdx.setResult(new zzao(Status.RESULT_SUCCESS, new zzaa(zzfy.zzdn).getDriveId()));
    }

    public final void zza(zzfn zzfn) throws RemoteException {
        this.zzdx.setResult(new zzao(Status.RESULT_SUCCESS, zzfn.zzdd));
    }

    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzao(status, (DriveId) null));
    }
}
