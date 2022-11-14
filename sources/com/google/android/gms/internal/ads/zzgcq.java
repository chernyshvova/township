package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgcq extends zzgcs {
    public final /* synthetic */ zzgcz zza;
    public int zzb = 0;
    public final int zzc = this.zza.zzc();

    public zzgcq(zzgcz zzgcz) {
        this.zza = zzgcz;
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
