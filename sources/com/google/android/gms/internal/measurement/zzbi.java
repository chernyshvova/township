package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzbi extends zzag.zzb {
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbi(zzag zzag, Bundle bundle) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = bundle;
    }

    public final void zza() throws RemoteException {
        this.zzd.zzm.setDefaultEventParameters(this.zzc);
    }
}
