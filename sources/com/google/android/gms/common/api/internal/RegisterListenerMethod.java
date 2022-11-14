package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    public final ListenerHolder<L> zaa;
    @Nullable
    public final Feature[] zab;
    public final boolean zac;
    public final int zad;

    @KeepForSdk
    public RegisterListenerMethod(@RecentlyNonNull ListenerHolder<L> listenerHolder) {
        this(listenerHolder, (Feature[]) null, false, 0);
    }

    @KeepForSdk
    public void clearListener() {
        this.zaa.clear();
    }

    @KeepForSdk
    @RecentlyNullable
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa.getListenerKey();
    }

    @KeepForSdk
    @RecentlyNullable
    public Feature[] getRequiredFeatures() {
        return this.zab;
    }

    @KeepForSdk
    public abstract void registerListener(@RecentlyNonNull A a, @RecentlyNonNull TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    public final boolean zaa() {
        return this.zac;
    }

    public final int zab() {
        return this.zad;
    }

    @KeepForSdk
    public RegisterListenerMethod(@RecentlyNonNull ListenerHolder<L> listenerHolder, @RecentlyNonNull Feature[] featureArr, boolean z) {
        this(listenerHolder, featureArr, z, 0);
    }

    @KeepForSdk
    public RegisterListenerMethod(@RecentlyNonNull ListenerHolder<L> listenerHolder, @Nullable Feature[] featureArr, boolean z, int i) {
        this.zaa = listenerHolder;
        this.zab = featureArr;
        this.zac = z;
        this.zad = i;
    }
}
