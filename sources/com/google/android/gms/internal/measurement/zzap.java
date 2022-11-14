package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzap extends zzag.zzb {
    public final /* synthetic */ Boolean zzc;
    public final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzap(zzag zzag, Boolean bool) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = bool;
    }

    public final void zza() throws RemoteException {
        if (this.zzc != null) {
            this.zzd.zzm.setMeasurementEnabled(this.zzc.booleanValue(), this.zza);
        } else {
            this.zzd.zzm.clearMeasurementEnabled(this.zza);
        }
    }
}
