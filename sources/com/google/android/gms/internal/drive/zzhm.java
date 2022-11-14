package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.drive.TransferPreferencesBuilder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhm extends zzhh<TransferPreferences> {
    public zzhm(TaskCompletionSource<TransferPreferences> taskCompletionSource) {
        super(taskCompletionSource);
    }

    public final void zza(zzfj zzfj) throws RemoteException {
        zzay().setResult(new TransferPreferencesBuilder((FileUploadPreferences) zzfj.zzas()).build());
    }

    public final void zza(zzga zzga) throws RemoteException {
        zzay().setResult(zzga.zzax());
    }
}
