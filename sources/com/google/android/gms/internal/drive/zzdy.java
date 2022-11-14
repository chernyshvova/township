package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;

public final class zzdy extends zzl {
    public final BaseImplementation.ResultHolder<DriveResource.MetadataResult> zzdx;

    public zzdy(BaseImplementation.ResultHolder<DriveResource.MetadataResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    public final void zza(zzfy zzfy) throws RemoteException {
        this.zzdx.setResult(new zzdz(Status.RESULT_SUCCESS, new zzaa(zzfy.zzdn)));
    }

    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzdz(status, (Metadata) null));
    }
}
