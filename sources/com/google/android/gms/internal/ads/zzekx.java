package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzekx implements zzelf<zzdiw> {
    public final /* synthetic */ zzeky zza;

    public zzekx(zzeky zzeky) {
        this.zza = zzeky;
    }

    public final void zza() {
        synchronized (this.zza) {
            zzdiw unused = this.zza.zzg = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdiw zzdiw = (zzdiw) obj;
        synchronized (this.zza) {
            zzdiw unused = this.zza.zzg = zzdiw;
            this.zza.zzg.zzS();
        }
    }
}
