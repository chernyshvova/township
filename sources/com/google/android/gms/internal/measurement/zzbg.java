package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzbg extends zzag.zzb {
    public final /* synthetic */ zzt zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ zzag zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbg(zzag zzag, zzt zzt, int i) {
        super(zzag);
        this.zze = zzag;
        this.zzc = zzt;
        this.zzd = i;
    }

    public final void zza() throws RemoteException {
        this.zze.zzm.getTestFlag(this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
