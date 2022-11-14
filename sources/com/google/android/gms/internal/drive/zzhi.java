package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhi extends zzhh<DriveContents> {
    public zzhi(TaskCompletionSource<DriveContents> taskCompletionSource) {
        super(taskCompletionSource);
    }

    public final void zza(zzfh zzfh) throws RemoteException {
        zzay().setResult(new zzbi(zzfh.zzar()));
    }
}
