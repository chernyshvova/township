package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeuo implements Runnable {
    public final zzekq zza;

    public zzeuo(zzekq zzekq) {
        this.zza = zzekq;
    }

    public static Runnable zza(zzekq zzekq) {
        return new zzeuo(zzekq);
    }

    public final void run() {
        this.zza.zzbU();
    }
}
