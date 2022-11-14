package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzgs extends zzgu {
    public int zza = 0;
    public final int zzb = this.zzc.zza();
    public final /* synthetic */ zzgp zzc;

    public zzgs(zzgp zzgp) {
        this.zzc = zzgp;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
