package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.MetadataBuffer;

public final class zzdx extends zzl {
    public final BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> zzdx;

    public zzdx(BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    public final void zza(zzfv zzfv) throws RemoteException {
        this.zzdx.setResult(new zzaq(Status.RESULT_SUCCESS, new MetadataBuffer(zzfv.zzij), false));
    }

    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzaq(status, (MetadataBuffer) null, false));
    }
}
