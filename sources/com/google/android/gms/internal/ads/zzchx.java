package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzchx implements Runnable {
    public final /* synthetic */ zzcie zza;

    public zzchx(zzcie zzcie) {
        this.zza = zzcie;
    }

    public final void run() {
        if (this.zza.zzs != null) {
            this.zza.zzs.zze();
        }
    }
}
