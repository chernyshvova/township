package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzct extends TaskApiCall<zzaw, DriveContents> {
    public final /* synthetic */ DriveFile zzfs;
    public final /* synthetic */ int zzft;

    public zzct(zzch zzch, DriveFile driveFile, int i) {
        this.zzfs = driveFile;
        this.zzft = i;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgj(this.zzfs.getDriveId(), this.zzft, 0), (zzeq) new zzhi(taskCompletionSource));
    }
}
