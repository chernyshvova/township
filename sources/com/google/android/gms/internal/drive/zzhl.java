package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhl extends zzhh<DriveId> {
    public zzhl(TaskCompletionSource<DriveId> taskCompletionSource) {
        super(taskCompletionSource);
    }

    public final void zza(zzfn zzfn) throws RemoteException {
        zzay().setResult(zzfn.getDriveId());
    }

    public final void zza(zzfy zzfy) throws RemoteException {
        zzay().setResult(new zzaa(zzfy.zzaw()).getDriveId());
    }
}
