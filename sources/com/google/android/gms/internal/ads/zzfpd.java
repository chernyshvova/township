package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfpd implements Runnable {
    public final /* synthetic */ zzfmg zza;
    public final /* synthetic */ zzfpe zzb;

    public zzfpd(zzfpe zzfpe, zzfmg zzfmg) {
        this.zzb = zzfpe;
        this.zza = zzfmg;
    }

    public final void run() {
        zzfpe.zzA(this.zzb, this.zza);
    }
}
