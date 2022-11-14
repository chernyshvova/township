package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzbc extends zzag.zzb {
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ zzt zzd;
    public final /* synthetic */ zzag zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbc(zzag zzag, Bundle bundle, zzt zzt) {
        super(zzag);
        this.zze = zzag;
        this.zzc = bundle;
        this.zzd = zzt;
    }

    public final void zza() throws RemoteException {
        this.zze.zzm.performAction(this.zzc, this.zzd, this.zza);
    }

    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
