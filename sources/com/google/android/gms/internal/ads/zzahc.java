package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzahc {
    @Nullable
    public zzahb zza;
    @Nullable
    public zzahl zzb;

    public abstract void zzi(@Nullable Object obj);

    public abstract zzahd zzj(zzmb[] zzmbArr, zzaft zzaft, zzadv zzadv, zzmv zzmv) throws zzio;

    public final void zzk(zzahb zzahb, zzahl zzahl) {
        this.zza = zzahb;
        this.zzb = zzahl;
    }

    public final void zzl() {
        zzahb zzahb = this.zza;
        if (zzahb != null) {
            zzahb.zzk();
        }
    }

    public final zzahl zzm() {
        zzahl zzahl = this.zzb;
        if (zzahl != null) {
            return zzahl;
        }
        throw null;
    }
}
