package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcp extends RegisterListenerMethod<zzaw, zzdi> {
    public final /* synthetic */ DriveResource zzfq;
    public final /* synthetic */ zzdi zzfr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcp(zzch zzch, ListenerHolder listenerHolder, DriveResource driveResource, zzdi zzdi) {
        super(listenerHolder);
        this.zzfq = driveResource;
        this.zzfr = zzdi;
    }

    public final /* synthetic */ void registerListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzj(1, this.zzfq.getDriveId()), (zzes) this.zzfr.zzgh, (String) null, (zzeq) new zzhr(taskCompletionSource));
    }
}
