package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdff extends zzfgi implements zzdbd, zzbcz, zzamt, zzddo, zzdbx, zzddc, zzo, zzdbt {
    public final zzdfd zza = new zzdfd(this, (zzdfc) null);
    @Nullable
    public zzekq zzb;
    @Nullable
    public zzeku zzc;
    @Nullable
    public zzeud zzd;
    @Nullable
    public zzexi zze;

    public static <T> void zzq(T t, zzdfe<T> zzdfe) {
        if (t != null) {
            zzdfe.zza(t);
        }
    }

    public final void onAdClicked() {
        zzq(this.zzb, zzdec.zza);
        zzq(this.zzc, zzded.zza);
    }

    public final void zzK() {
        zzq(this.zzd, zzdej.zza);
    }

    public final void zza(String str, String str2) {
        zzq(this.zzb, new zzdee(str, str2));
    }

    public final void zzbE() {
        zzq(this.zzd, zzdeo.zza);
    }

    public final void zzbF() {
        zzq(this.zzb, zzdei.zza);
    }

    public final void zzbH() {
        zzq(this.zzd, zzdeq.zza);
    }

    public final void zzbI() {
        zzq(this.zzd, zzder.zza);
    }

    public final void zzbJ() {
        zzq(this.zzd, zzdes.zza);
    }

    public final void zzbK(int i) {
        zzq(this.zzd, new zzdep(i));
    }

    public final void zzc() {
        zzq(this.zzb, zzddz.zza);
        zzq(this.zze, zzdek.zza);
    }

    public final void zzca() {
        zzq(this.zzd, zzdet.zza);
    }

    public final void zzd() {
        zzq(this.zzb, zzdeu.zza);
        zzq(this.zze, zzdev.zza);
    }

    public final void zze() {
        zzq(this.zzb, zzdew.zza);
        zzq(this.zze, zzdex.zza);
    }

    public final void zzf(zzcca zzcca, String str, String str2) {
        zzq(this.zzb, new zzdfa(zzcca, str, str2));
        zzq(this.zze, new zzdfb(zzcca, str, str2));
    }

    public final void zzg() {
        zzq(this.zzb, zzdey.zza);
        zzq(this.zze, zzdez.zza);
    }

    public final void zzh() {
        zzq(this.zzb, zzdea.zza);
        zzq(this.zze, zzdeb.zza);
    }

    public final void zzi(zzbdd zzbdd) {
        zzq(this.zze, new zzdem(zzbdd));
        zzq(this.zzb, new zzden(zzbdd));
    }

    public final zzdfd zzj() {
        return this.zza;
    }

    public final void zzk(zzbdr zzbdr) {
        zzq(this.zzb, new zzdef(zzbdr));
        zzq(this.zze, new zzdeg(zzbdr));
        zzq(this.zzd, new zzdeh(zzbdr));
    }

    public final void zzl() {
        zzq(this.zze, zzdel.zza);
    }
}
