package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzak extends zzag.zzb {
    public final /* synthetic */ String zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ zzt zze;
    public final /* synthetic */ zzag zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzak(zzag zzag, String str, String str2, zzt zzt) {
        super(zzag);
        this.zzf = zzag;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzt;
    }

    public final void zza() throws RemoteException {
        this.zzf.zzm.getConditionalUserProperties(this.zzc, this.zzd, this.zze);
    }

    public final void zzb() {
        this.zze.zza((Bundle) null);
    }
}
