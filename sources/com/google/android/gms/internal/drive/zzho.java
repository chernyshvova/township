package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzho extends zzhh<MetadataBuffer> {
    public zzho(TaskCompletionSource<MetadataBuffer> taskCompletionSource) {
        super(taskCompletionSource);
    }

    public final void zza(zzfv zzfv) throws RemoteException {
        zzay().setResult(new MetadataBuffer(zzfv.zzav()));
    }
}
