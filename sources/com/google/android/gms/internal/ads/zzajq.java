package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzajq {
    public final SparseBooleanArray zza = new SparseBooleanArray();
    public boolean zzb;

    public final zzajq zza(int i) {
        zzajg.zzd(!this.zzb);
        this.zza.append(i, true);
        return this;
    }

    public final zzajr zzb() {
        zzajg.zzd(!this.zzb);
        this.zzb = true;
        return new zzajr(this.zza, (zzajp) null);
    }
}
