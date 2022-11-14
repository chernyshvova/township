package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcus extends zzcxi {
    public final View zzc;
    @Nullable
    public final zzcmr zzd;
    public final zzeyf zze;
    public final int zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final zzcuk zzi;
    @Nullable
    public zzaxw zzj;

    public zzcus(zzcxh zzcxh, View view, @Nullable zzcmr zzcmr, zzeyf zzeyf, int i, boolean z, boolean z2, zzcuk zzcuk) {
        super(zzcxh);
        this.zzc = view;
        this.zzd = zzcmr;
        this.zze = zzeyf;
        this.zzf = i;
        this.zzg = z;
        this.zzh = z2;
        this.zzi = zzcuk;
    }

    public final zzeyf zza() {
        return zzeza.zza(this.zzb.zzr, this.zze);
    }

    public final View zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return this.zzg;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzd.zzR() != null && this.zzd.zzR().zzc();
    }

    public final boolean zzg() {
        return this.zzd.zzT();
    }

    public final void zzh(zzaxm zzaxm) {
        this.zzd.zzax(zzaxm);
    }

    public final void zzi(long j, int i) {
        this.zzi.zza(j, i);
    }

    public final void zzj(zzaxw zzaxw) {
        this.zzj = zzaxw;
    }

    @Nullable
    public final zzaxw zzk() {
        return this.zzj;
    }
}
