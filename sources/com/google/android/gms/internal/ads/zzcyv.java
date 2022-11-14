package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcyv implements zzdcr, zzbcz, zzddy, zzdbx, zzdbd, zzdgc {
    public final Clock zza;
    public final zzcfy zzb;

    public zzcyv(Clock clock, zzcfy zzcfy) {
        this.zza = clock;
        this.zzb = zzcfy;
    }

    public final void onAdClicked() {
        this.zzb.zzf();
    }

    public final void zzbF() {
        this.zzb.zze();
    }

    public final void zzbU() {
        this.zzb.zzh(true);
    }

    public final void zzc() {
    }

    public final void zzd() {
        this.zzb.zzg();
    }

    public final void zze() {
    }

    public final void zzf(zzcca zzcca, String str, String str2) {
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzi(zzbdk zzbdk) {
        this.zzb.zza(zzbdk);
    }

    public final void zzj(zzcbk zzcbk) {
    }

    public final void zzk(zzazu zzazu) {
        this.zzb.zzb();
    }

    public final void zzl(zzazu zzazu) {
    }

    public final void zzm(zzazu zzazu) {
        this.zzb.zzc();
    }

    public final void zzn(boolean z) {
    }

    public final void zzo(boolean z) {
    }

    public final void zzp() {
    }

    public final void zzq(zzeyq zzeyq) {
        this.zzb.zzd(this.zza.elapsedRealtime());
    }

    public final String zzr() {
        return this.zzb.zzj();
    }
}
