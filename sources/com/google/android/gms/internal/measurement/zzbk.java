package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzbk extends zzag.zzb {
    public final /* synthetic */ zzag.zzd zzc;
    public final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbk(zzag zzag, zzag.zzd zzd2) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zzd2;
    }

    public final void zza() throws RemoteException {
        this.zzd.zzm.unregisterOnMeasurementEventListener(this.zzc);
    }
}
