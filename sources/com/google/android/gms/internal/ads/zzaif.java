package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaif implements zzahs {
    public final zzaio zza = new zzaio();
    @Nullable
    public zzajd zzb;
    @Nullable
    public String zzc;
    public int zzd = 8000;
    public int zze = 8000;
    public boolean zzf;

    public final zzaif zzb(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    public final zzaif zzc(int i) {
        this.zzd = i;
        return this;
    }

    public final zzaif zzd(int i) {
        this.zze = i;
        return this;
    }

    public final zzaif zze(boolean z) {
        this.zzf = true;
        return this;
    }

    public final zzaif zzf(@Nullable zzajd zzajd) {
        this.zzb = zzajd;
        return this;
    }

    /* renamed from: zzg */
    public final zzaig zza() {
        zzaig zzaig = new zzaig(this.zzc, this.zzd, this.zze, this.zzf, this.zza, (zzfkf) null, (zzaie) null);
        zzajd zzajd = this.zzb;
        if (zzajd != null) {
            zzaig.zzb(zzajd);
        }
        return zzaig;
    }
}
