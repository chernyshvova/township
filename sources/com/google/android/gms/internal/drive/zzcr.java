package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcr extends TaskApiCall<zzaw, Void> {
    public final /* synthetic */ DriveResource zzfq;

    public zzcr(zzch zzch, DriveResource driveResource) {
        this.zzfq = driveResource;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        if (zzaw.zzec) {
            ((zzeo) zzaw.getService()).zza(new zzj(1, this.zzfq.getDriveId()), (zzes) null, (String) null, (zzeq) new zzhr(taskCompletionSource));
            return;
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }
}
