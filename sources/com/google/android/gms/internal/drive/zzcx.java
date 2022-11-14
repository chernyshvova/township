package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcx extends TaskApiCall<zzaw, DriveContents> {
    public final /* synthetic */ DriveContents zzfx;

    public zzcx(zzch zzch, DriveContents driveContents) {
        this.zzfx = driveContents;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgj(this.zzfx.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzfx.zzi().getRequestId()), (zzeq) new zzhi(taskCompletionSource));
    }
}
