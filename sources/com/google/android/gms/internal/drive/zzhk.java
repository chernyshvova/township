package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhk extends zzhh<DriveFolder> {
    public zzhk(TaskCompletionSource<DriveFolder> taskCompletionSource) {
        super(taskCompletionSource);
    }

    public final void zza(zzfn zzfn) throws RemoteException {
        zzay().setResult(zzfn.getDriveId().asDriveFolder());
    }
}
