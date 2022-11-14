package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbc extends TaskApiCall<zzaw, DriveId> {
    public final /* synthetic */ String zzdw;

    public zzbc(zzbb zzbb, String str) {
        this.zzdw = str;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzek(DriveId.zza(this.zzdw), false), (zzeq) new zzhl(taskCompletionSource));
    }
}
