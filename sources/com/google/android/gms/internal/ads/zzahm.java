package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzahm implements zzaht {
    public final boolean zza;
    public final ArrayList<zzajd> zzb = new ArrayList<>(1);
    public int zzc;
    @Nullable
    public zzahx zzd;

    public zzahm(boolean z) {
        this.zza = z;
    }

    public final void zzb(zzajd zzajd) {
        if (zzajd == null) {
            throw null;
        } else if (!this.zzb.contains(zzajd)) {
            this.zzb.add(zzajd);
            this.zzc++;
        }
    }

    public Map zze() {
        return Collections.emptyMap();
    }

    public final void zzg(zzahx zzahx) {
        for (int i = 0; i < this.zzc; i++) {
            this.zzb.get(i).zzd(this, zzahx, this.zza);
        }
    }

    public final void zzh(zzahx zzahx) {
        this.zzd = zzahx;
        for (int i = 0; i < this.zzc; i++) {
            this.zzb.get(i).zze(this, zzahx, this.zza);
        }
    }

    public final void zzi(int i) {
        zzahx zzahx = this.zzd;
        int i2 = zzalh.zza;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            this.zzb.get(i3).zzf(this, zzahx, this.zza, i);
        }
    }

    public final void zzj() {
        zzahx zzahx = this.zzd;
        int i = zzalh.zza;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            this.zzb.get(i2).zzg(this, zzahx, this.zza);
        }
        this.zzd = null;
    }
}
