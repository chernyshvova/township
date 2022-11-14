package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;

public final class zzak extends zzl {
    public final BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> zzdx;

    public zzak(BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    public final void zza(zzfh zzfh) throws RemoteException {
        this.zzdx.setResult(new zzal(Status.RESULT_SUCCESS, new zzbi(zzfh.zzes)));
    }

    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzal(status, (DriveContents) null));
    }
}
