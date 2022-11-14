package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhp extends zzhh<Metadata> {
    public zzhp(TaskCompletionSource<Metadata> taskCompletionSource) {
        super(taskCompletionSource);
    }

    public final void zza(zzfy zzfy) throws RemoteException {
        zzay().setResult(new zzaa(zzfy.zzaw()));
    }
}
