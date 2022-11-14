package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzexi extends zzfgi implements zzdcr, zzdbg, zzdbd, zzdbt, zzddo, zzevs {
    public final zzfad zza;
    public final AtomicReference<zzfgi> zzb = new AtomicReference<>();
    public final AtomicReference<zzcda> zzc = new AtomicReference<>();
    public final AtomicReference<zzccw> zzd = new AtomicReference<>();
    public final AtomicReference<zzccg> zze = new AtomicReference<>();
    public final AtomicReference<zzcdb> zzf = new AtomicReference<>();
    public final AtomicReference<zzccb> zzg = new AtomicReference<>();
    public final AtomicReference<zzbha> zzh = new AtomicReference<>();

    public zzexi(zzfad zzfad) {
        this.zza = zzfad;
    }

    public final void zzb(zzcda zzcda) {
        this.zzc.set(zzcda);
    }

    public final void zzbT(zzbdd zzbdd) {
        int i = zzbdd.zza;
        zzevk.zza(this.zzc, new zzexa(zzbdd));
        zzevk.zza(this.zzc, new zzexb(i));
        zzevk.zza(this.zze, new zzexc(i));
    }

    public final void zzbU() {
        zzevk.zza(this.zzc, zzewn.zza);
        zzevk.zza(this.zze, zzewy.zza);
    }

    public final void zzc() {
        zzevk.zza(this.zzd, zzexd.zza);
        zzevk.zza(this.zze, zzexe.zza);
        zzevk.zza(this.zzd, zzexf.zza);
    }

    public final void zzd() {
        this.zza.zzb();
        zzevk.zza(this.zzd, zzexg.zza);
        zzevk.zza(this.zze, zzexh.zza);
    }

    public final void zze() {
        zzevk.zza(this.zze, zzewo.zza);
    }

    public final void zzf(zzcca zzcca, String str, String str2) {
        zzevk.zza(this.zzd, new zzewq(zzcca));
        zzevk.zza(this.zzf, new zzewr(zzcca, str, str2));
        zzevk.zza(this.zze, new zzews(zzcca));
        zzevk.zza(this.zzg, new zzewt(zzcca, str, str2));
    }

    public final void zzg() {
        zzevk.zza(this.zze, zzewp.zza);
    }

    public final void zzh() {
        zzevk.zza(this.zze, zzewu.zza);
    }

    public final void zzi(zzbdd zzbdd) {
        zzevk.zza(this.zzd, new zzewv(zzbdd));
        zzevk.zza(this.zzd, new zzeww(zzbdd));
    }

    public final void zzj(zzccw zzccw) {
        this.zzd.set(zzccw);
    }

    public final void zzk(@NonNull zzbdr zzbdr) {
        zzevk.zza(this.zzh, new zzewz(zzbdr));
    }

    public final void zzl() {
        zzevk.zza(this.zzb, zzewx.zza);
    }

    public final void zzm(zzfgi zzfgi) {
        this.zzb.set(zzfgi);
    }

    public final void zzn(zzbha zzbha) {
        this.zzh.set(zzbha);
    }

    @Deprecated
    public final void zzo(zzccg zzccg) {
        this.zze.set(zzccg);
    }

    public final void zzp(zzevs zzevs) {
        throw null;
    }

    public final void zzq(zzcdb zzcdb) {
        this.zzf.set(zzcdb);
    }

    @Deprecated
    public final void zzr(zzccb zzccb) {
        this.zzg.set(zzccb);
    }
}
