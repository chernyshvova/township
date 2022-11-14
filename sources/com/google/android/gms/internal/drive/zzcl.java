package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcl extends TaskApiCall<zzaw, Void> {
    public final /* synthetic */ DriveResource zzfq;

    public zzcl(zzch zzch, DriveResource driveResource) {
        this.zzfq = driveResource;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzab(this.zzfq.getDriveId()), (zzeq) new zzhr(taskCompletionSource));
    }
}
