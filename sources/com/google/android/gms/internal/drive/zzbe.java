package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbe extends TaskApiCall<zzaw, Void> {
    public final /* synthetic */ TransferPreferences zzep;

    public zzbe(zzbb zzbb, TransferPreferences transferPreferences) {
        this.zzep = transferPreferences;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgu(new zzei(this.zzep)), (zzeq) new zzhr(taskCompletionSource));
    }
}
