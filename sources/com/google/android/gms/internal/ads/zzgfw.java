package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfw extends zzgcs {
    public final zzgfy zza = new zzgfy(this.zzc, (zzgfw) null);
    public zzgcu zzb = zzb();
    public final /* synthetic */ zzgfz zzc;

    public zzgfw(zzgfz zzgfz) {
        this.zzc = zzgfz;
    }

    private final zzgcu zzb() {
        if (this.zza.hasNext()) {
            return this.zza.next().iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final byte zza() {
        zzgcu zzgcu = this.zzb;
        if (zzgcu != null) {
            byte zza2 = zzgcu.zza();
            if (!this.zzb.hasNext()) {
                this.zzb = zzb();
            }
            return zza2;
        }
        throw new NoSuchElementException();
    }
}
