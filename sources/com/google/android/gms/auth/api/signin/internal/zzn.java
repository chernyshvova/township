package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public final class zzn extends zzc {
    public final /* synthetic */ zzm zzbm;

    public zzn(zzm zzm) {
        this.zzbm = zzm;
    }

    public final void zzf(Status status) throws RemoteException {
        this.zzbm.setResult(status);
    }
}
