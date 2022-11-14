package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;

public final class zzbv extends zzl {
    public final BaseImplementation.ResultHolder<DriveFolder.DriveFileResult> zzdx;

    public zzbv(BaseImplementation.ResultHolder<DriveFolder.DriveFileResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    public final void zza(zzfn zzfn) throws RemoteException {
        this.zzdx.setResult(new zzbx(Status.RESULT_SUCCESS, new zzbn(zzfn.zzdd)));
    }

    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzbx(status, (DriveFile) null));
    }
}
