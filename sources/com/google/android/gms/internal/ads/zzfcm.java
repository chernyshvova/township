package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzfcm implements Runnable {
    public final zzfco zza;
    public final zzfcd zzb;

    public zzfcm(zzfco zzfco, zzfcd zzfcd) {
        this.zza = zzfco;
        this.zzb = zzfcd;
    }

    public final void run() {
        zzfco zzfco = this.zza;
        zzfco.zza.zzd.zzb(this.zzb);
    }
}
