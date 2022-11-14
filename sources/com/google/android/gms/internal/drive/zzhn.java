package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhn extends zzhh<MetadataBuffer> {
    public zzhn(TaskCompletionSource<MetadataBuffer> taskCompletionSource) {
        super(taskCompletionSource);
    }

    public final void zza(zzft zzft) throws RemoteException {
        zzay().setResult(new MetadataBuffer(zzft.zzau()));
    }
}
