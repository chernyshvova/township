package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzbn extends zzag.zzb {
    public final /* synthetic */ Long zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ Bundle zzf;
    public final /* synthetic */ boolean zzg;
    public final /* synthetic */ boolean zzh;
    public final /* synthetic */ zzag zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbn(zzag zzag, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzag);
        this.zzi = zzag;
        this.zzc = l;
        this.zzd = str;
        this.zze = str2;
        this.zzf = bundle;
        this.zzg = z;
        this.zzh = z2;
    }

    public final void zza() throws RemoteException {
        Long l = this.zzc;
        this.zzi.zzm.logEvent(this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l == null ? this.zza : l.longValue());
    }
}
