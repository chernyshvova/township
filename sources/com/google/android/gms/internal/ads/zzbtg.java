package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbtg implements Runnable {
    public final zzbso zza;

    public zzbtg(zzbso zzbso) {
        this.zza = zzbso;
    }

    public static Runnable zza(zzbso zzbso) {
        return new zzbtg(zzbso);
    }

    public final void run() {
        this.zza.zzi();
    }
}
