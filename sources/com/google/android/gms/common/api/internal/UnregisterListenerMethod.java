package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {
    public final ListenerHolder.ListenerKey<L> zaa;

    @KeepForSdk
    public UnregisterListenerMethod(@RecentlyNonNull ListenerHolder.ListenerKey<L> listenerKey) {
        this.zaa = listenerKey;
    }

    @RecentlyNonNull
    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa;
    }

    @KeepForSdk
    public abstract void unregisterListener(@RecentlyNonNull A a, @RecentlyNonNull TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;
}
