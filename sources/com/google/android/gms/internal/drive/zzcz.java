package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcz extends TaskApiCall<zzaw, MetadataBuffer> {
    public final /* synthetic */ Query zzdu;

    public zzcz(zzch zzch, Query query) {
        this.zzdu = query;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgq(this.zzdu), (zzeq) new zzhn(taskCompletionSource));
    }
}
