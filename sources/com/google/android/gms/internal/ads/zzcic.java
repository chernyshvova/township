package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcic implements Runnable {
    public final /* synthetic */ zzcie zza;

    public zzcic(zzcie zzcie) {
        this.zza = zzcie;
    }

    public final void run() {
        if (this.zza.zzs != null) {
            if (!this.zza.zzt) {
                this.zza.zzs.zzk();
                boolean unused = this.zza.zzt = true;
            }
            this.zza.zzs.zzc();
        }
    }
}
