package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzehs implements Runnable {
    public final zzdsj zza;

    public zzehs(zzdsj zzdsj) {
        this.zza = zzdsj;
    }

    public static Runnable zza(zzdsj zzdsj) {
        return new zzehs(zzdsj);
    }

    public final void run() {
        this.zza.zzb();
    }
}
