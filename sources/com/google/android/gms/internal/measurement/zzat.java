package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzat extends zzag.zzb {
    public final /* synthetic */ long zzc;
    public final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzat(zzag zzag, long j) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = j;
    }

    public final void zza() throws RemoteException {
        this.zzd.zzm.setSessionTimeoutDuration(this.zzc);
    }
}
