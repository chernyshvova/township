package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfy implements Iterator<zzgcv> {
    public final ArrayDeque<zzgfz> zza;
    public zzgcv zzb;

    public /* synthetic */ zzgfy(zzgcz zzgcz, zzgfw zzgfw) {
        if (zzgcz instanceof zzgfz) {
            zzgfz zzgfz = (zzgfz) zzgcz;
            ArrayDeque<zzgfz> arrayDeque = new ArrayDeque<>(zzgfz.zzf());
            this.zza = arrayDeque;
            arrayDeque.push(zzgfz);
            this.zzb = zzb(zzgfz.zzd);
            return;
        }
        this.zza = null;
        this.zzb = (zzgcv) zzgcz;
    }

    private final zzgcv zzb(zzgcz zzgcz) {
        while (zzgcz instanceof zzgfz) {
            zzgfz zzgfz = (zzgfz) zzgcz;
            this.zza.push(zzgfz);
            zzgcz = zzgfz.zzd;
        }
        return (zzgcv) zzgcz;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: zza */
    public final zzgcv next() {
        zzgcv zzgcv;
        zzgcv zzgcv2 = this.zzb;
        if (zzgcv2 != null) {
            do {
                ArrayDeque<zzgfz> arrayDeque = this.zza;
                zzgcv = null;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    this.zzb = zzgcv;
                } else {
                    zzgcv = zzb(this.zza.pop().zze);
                }
            } while (zzgcv.zzr());
            this.zzb = zzgcv;
            return zzgcv2;
        }
        throw new NoSuchElementException();
    }
}
