package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzexz implements zzelf<zzdrj> {
    public final /* synthetic */ zzeyb zza;

    public zzexz(zzeyb zzeyb) {
        this.zza = zzeyb;
    }

    public final void zza() {
        synchronized (this.zza) {
            zzdrj unused = this.zza.zzd = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdrj zzdrj = (zzdrj) obj;
        synchronized (this.zza) {
            zzdrj unused = this.zza.zzd = zzdrj;
            this.zza.zzd.zzS();
        }
    }
}
