package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzexu implements zzelf<zzdrj> {
    public final /* synthetic */ zzexv zza;

    public zzexu(zzexv zzexv) {
        this.zza = zzexv;
    }

    public final void zza() {
        synchronized (this.zza) {
            zzdrj unused = this.zza.zzf = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdrj zzdrj = (zzdrj) obj;
        synchronized (this.zza) {
            zzdrj unused = this.zza.zzf = zzdrj;
            this.zza.zzf.zzS();
        }
    }
}
