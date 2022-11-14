package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzn implements Runnable {
    public final /* synthetic */ zzac zza;
    public final /* synthetic */ zzo zzb;

    public zzn(zzo zzo, zzac zzac) {
        this.zzb = zzo;
        this.zza = zzac;
    }

    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
