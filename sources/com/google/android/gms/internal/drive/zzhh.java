package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public class zzhh<T> extends zzl {
    public TaskCompletionSource<T> zziv;

    public zzhh(TaskCompletionSource<T> taskCompletionSource) {
        this.zziv = taskCompletionSource;
    }

    public final void zza(Status status) throws RemoteException {
        this.zziv.setException(new ApiException(status));
    }

    public final TaskCompletionSource<T> zzay() {
        return this.zziv;
    }
}
