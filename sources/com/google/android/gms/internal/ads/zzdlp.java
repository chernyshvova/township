package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdlp implements Runnable {
    public final zzdmi zza;

    public zzdlp(zzdmi zzdmi) {
        this.zza = zzdmi;
    }

    public static Runnable zza(zzdmi zzdmi) {
        return new zzdlp(zzdmi);
    }

    public final void run() {
        this.zza.zzv();
    }
}
