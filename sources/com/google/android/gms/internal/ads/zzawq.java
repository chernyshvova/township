package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzawq implements Runnable {
    public final /* synthetic */ zzawr zza;

    public zzawq(zzawr zzawr) {
        this.zza = zzawr;
    }

    public final void run() {
        synchronized (this.zza.zzc) {
            if (!this.zza.zzd || !this.zza.zze) {
                zzcgs.zzd("App is still foreground");
            } else {
                boolean unused = this.zza.zzd = false;
                zzcgs.zzd("App went background");
                for (zzaws zza2 : this.zza.zzf) {
                    try {
                        zza2.zza(false);
                    } catch (Exception e) {
                        zzcgs.zzg("", e);
                    }
                }
            }
        }
    }
}
