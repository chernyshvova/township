package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbtn extends zzchq<zzbtu> {
    public final Object zza = new Object();
    public final zzbts zzb;
    public boolean zzc;

    public zzbtn(zzbts zzbts) {
        this.zzb = zzbts;
    }

    public final void zza() {
        synchronized (this.zza) {
            if (!this.zzc) {
                this.zzc = true;
                zze(new zzbtk(this), new zzchm());
                zze(new zzbtl(this), new zzbtm(this));
            }
        }
    }
}
