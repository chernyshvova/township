package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzkx implements Runnable {
    public final zzky zza;
    public final zzfmi zzb;
    public final zzadv zzc;

    public zzkx(zzky zzky, zzfmi zzfmi, zzadv zzadv) {
        this.zza = zzky;
        this.zzb = zzfmi;
        this.zzc = zzadv;
    }

    public final void run() {
        this.zza.zzq(this.zzb, this.zzc);
    }
}
