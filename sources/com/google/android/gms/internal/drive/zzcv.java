package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.drive.events.OpenFileCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcv extends UnregisterListenerMethod<zzaw, OpenFileCallback> {
    public final /* synthetic */ zzg zzfu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcv(zzch zzch, ListenerHolder.ListenerKey listenerKey, zzg zzg) {
        super(listenerKey);
        this.zzfu = zzg;
    }

    public final /* synthetic */ void unregisterListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(Boolean.valueOf(this.zzfu.cancel()));
    }
}
