package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzda extends TaskApiCall<zzaw, Void> {
    public final /* synthetic */ DriveContents zzfx;

    public zzda(zzch zzch, DriveContents driveContents) {
        this.zzfx = driveContents;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzo(this.zzfx.zzi().getRequestId(), false), (zzeq) new zzhr(taskCompletionSource));
    }
}
