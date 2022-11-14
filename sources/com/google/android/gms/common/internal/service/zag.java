package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zag extends zaa {
    public final BaseImplementation.ResultHolder<Status> zaa;

    public zag(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zaa = resultHolder;
    }

    public final void zaa(int i) throws RemoteException {
        this.zaa.setResult(new Status(i));
    }
}
