package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzejx implements zzelf<zzcvj> {
    public final /* synthetic */ zzejy zza;

    public zzejx(zzejy zzejy) {
        this.zza = zzejy;
    }

    public final void zza() {
        synchronized (this.zza) {
            zzcvj unused = this.zza.zzg = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcvj zzcvj = (zzcvj) obj;
        synchronized (this.zza) {
            if (this.zza.zzg != null) {
                this.zza.zzg.zzT();
            }
            zzcvj unused = this.zza.zzg = zzcvj;
            this.zza.zzg.zzS();
        }
    }
}
