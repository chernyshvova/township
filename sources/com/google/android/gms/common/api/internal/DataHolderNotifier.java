package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class DataHolderNotifier<L> implements ListenerHolder.Notifier<L> {
    public final DataHolder zaa;

    @KeepForSdk
    public DataHolderNotifier(@RecentlyNonNull DataHolder dataHolder) {
        this.zaa = dataHolder;
    }

    @KeepForSdk
    public final void notifyListener(@RecentlyNonNull L l) {
        notifyListener(l, this.zaa);
    }

    @KeepForSdk
    public abstract void notifyListener(@RecentlyNonNull L l, @RecentlyNonNull DataHolder dataHolder);

    @KeepForSdk
    public void onNotifyListenerFailed() {
        DataHolder dataHolder = this.zaa;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
