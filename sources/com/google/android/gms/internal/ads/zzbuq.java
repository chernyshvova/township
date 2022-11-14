package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbuq {
    public final zzbtt zza;
    public zzfqn<zzbtu> zzb;

    public zzbuq(zzbtt zzbtt) {
        this.zza = zzbtt;
    }

    private final void zzd() {
        if (this.zzb == null) {
            zzchj zzchj = new zzchj();
            this.zzb = zzchj;
            this.zza.zzb((zzfb) null).zze(new zzbum(zzchj), new zzbun(zzchj));
        }
    }

    public final <I, O> zzbut<I, O> zza(String str, zzbua<I> zzbua, zzbtz<O> zzbtz) {
        zzd();
        return new zzbut<>(this.zzb, "google.afma.activeView.handleUpdate", zzbua, zzbtz);
    }

    public final void zzb(String str, zzbps<? super zzbtu> zzbps) {
        zzd();
        this.zzb = zzfqe.zzi(this.zzb, new zzbuo(str, zzbps), zzche.zzf);
    }

    public final void zzc(String str, zzbps<? super zzbtu> zzbps) {
        this.zzb = zzfqe.zzj(this.zzb, new zzbup(str, zzbps), zzche.zzf);
    }
}
