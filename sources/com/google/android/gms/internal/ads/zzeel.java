package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeel implements Runnable {
    public final zzcmr zza;

    public zzeel(zzcmr zzcmr) {
        this.zza = zzcmr;
    }

    public static Runnable zza(zzcmr zzcmr) {
        return new zzeel(zzcmr);
    }

    public final void run() {
        this.zza.zzau();
    }
}
