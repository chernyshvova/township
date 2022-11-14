package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzme {
    public static final zzme zza = new zzme(0, 0);
    public static final zzme zzb = new zzme(RecyclerView.FOREVER_NS, RecyclerView.FOREVER_NS);
    public static final zzme zzc = new zzme(RecyclerView.FOREVER_NS, 0);
    public static final zzme zzd = new zzme(0, RecyclerView.FOREVER_NS);
    public static final zzme zze = zza;
    public final long zzf;
    public final long zzg;

    public zzme(long j, long j2) {
        boolean z = true;
        zzajg.zza(j >= 0);
        zzajg.zza(j2 < 0 ? false : z);
        this.zzf = j;
        this.zzg = j2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzme.class == obj.getClass()) {
            zzme zzme = (zzme) obj;
            return this.zzf == zzme.zzf && this.zzg == zzme.zzg;
        }
    }

    public final int hashCode() {
        return (((int) this.zzf) * 31) + ((int) this.zzg);
    }
}
