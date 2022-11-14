package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbtd implements Runnable {
    public final zzbso zza;

    public zzbtd(zzbso zzbso) {
        this.zza = zzbso;
    }

    public static Runnable zza(zzbso zzbso) {
        return new zzbtd(zzbso);
    }

    public final void run() {
        this.zza.zzi();
    }
}
