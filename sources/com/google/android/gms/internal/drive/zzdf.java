package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

public final class zzdf extends TaskApiCall<zzaw, Void> {
    public final /* synthetic */ DriveResource zzfq;
    public final /* synthetic */ List zzgb;

    public zzdf(zzch zzch, DriveResource driveResource, List list) {
        this.zzfq = driveResource;
        this.zzgb = list;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgw(this.zzfq.getDriveId(), this.zzgb), (zzeq) new zzhr(taskCompletionSource));
    }
}
