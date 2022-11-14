package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcnf implements Runnable {
    public final zzcmr zza;

    public zzcnf(zzcmr zzcmr) {
        this.zza = zzcmr;
    }

    public static Runnable zza(zzcmr zzcmr) {
        return new zzcnf(zzcmr);
    }

    public final void run() {
        this.zza.destroy();
    }
}
