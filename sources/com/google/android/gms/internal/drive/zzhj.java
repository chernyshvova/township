package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhj extends zzhh<DriveFile> {
    public zzhj(TaskCompletionSource<DriveFile> taskCompletionSource) {
        super(taskCompletionSource);
    }

    public final void zza(zzfn zzfn) throws RemoteException {
        zzay().setResult(zzfn.getDriveId().asDriveFile());
    }
}
