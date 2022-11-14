package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzba extends zzag.zzb {
    public final /* synthetic */ String zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzt zzf;
    public final /* synthetic */ zzag zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzba(zzag zzag, String str, String str2, boolean z, zzt zzt) {
        super(zzag);
        this.zzg = zzag;
        this.zzc = str;
        this.zzd = str2;
        this.zze = z;
        this.zzf = zzt;
    }

    public final void zza() throws RemoteException {
        this.zzg.zzm.getUserProperties(this.zzc, this.zzd, this.zze, this.zzf);
    }

    public final void zzb() {
        this.zzf.zza((Bundle) null);
    }
}
