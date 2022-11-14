package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzchy implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzcie zzc;

    public zzchy(zzcie zzcie, String str, String str2) {
        this.zzc = zzcie;
        this.zza = str;
        this.zzb = str2;
    }

    public final void run() {
        if (this.zzc.zzs != null) {
            this.zzc.zzs.zzf(this.zza, this.zzb);
        }
    }
}
