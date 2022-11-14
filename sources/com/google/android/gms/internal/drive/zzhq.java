package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhq extends zzhh<Boolean> {
    public zzhq(TaskCompletionSource<Boolean> taskCompletionSource) {
        super(taskCompletionSource);
    }

    public final void onSuccess() throws RemoteException {
        zzay().setResult(Boolean.TRUE);
    }
}
