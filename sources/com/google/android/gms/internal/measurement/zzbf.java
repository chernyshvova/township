package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzbf extends zzag.zzb {
    public final /* synthetic */ zzag.zza zzc;
    public final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbf(zzag zzag, zzag.zza zza) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zza;
    }

    public final void zza() throws RemoteException {
        this.zzd.zzm.setEventInterceptor(this.zzc);
    }
}
