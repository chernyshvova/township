package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public interface RemoteCall<T, U> {
    @KeepForSdk
    void accept(@RecentlyNonNull T t, @RecentlyNonNull U u) throws RemoteException;
}
