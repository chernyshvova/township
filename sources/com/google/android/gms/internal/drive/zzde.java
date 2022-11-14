package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzde extends TaskApiCall<zzaw, MetadataBuffer> {
    public final /* synthetic */ DriveResource zzfq;

    public zzde(zzch zzch, DriveResource driveResource) {
        this.zzfq = driveResource;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzex(this.zzfq.getDriveId()), (zzeq) new zzho(taskCompletionSource));
    }
}
