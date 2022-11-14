package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveFolder;

public final class zzbw extends zzl {
    public final BaseImplementation.ResultHolder<DriveFolder.DriveFolderResult> zzdx;

    public zzbw(BaseImplementation.ResultHolder<DriveFolder.DriveFolderResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    public final void zza(zzfn zzfn) throws RemoteException {
        this.zzdx.setResult(new zzbz(Status.RESULT_SUCCESS, new zzbs(zzfn.zzdd)));
    }

    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzbz(status, (DriveFolder) null));
    }
}
