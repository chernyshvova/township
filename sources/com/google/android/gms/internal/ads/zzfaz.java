package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfaz implements zzfqa<Void> {
    public final /* synthetic */ zzfbc zza;
    public final /* synthetic */ zzfbd zzb;

    public zzfaz(zzfbd zzfbd, zzfbc zzfbc) {
        this.zzb = zzfbd;
        this.zza = zzfbc;
    }

    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            zzfbj unused = this.zzb.zze = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        synchronized (this.zzb) {
            zzfbj unused = this.zzb.zze = null;
            this.zzb.zzd.addFirst(this.zza);
            if (this.zzb.zzf == 1) {
                this.zzb.zzh();
            }
        }
    }
}
