package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzflr<T> implements Iterator<T> {
    public int zzb = this.zze.zzf;
    public int zzc = this.zze.zzf();
    public int zzd = -1;
    public final /* synthetic */ zzflv zze;

    public /* synthetic */ zzflr(zzflv zzflv, zzfln zzfln) {
        this.zze = zzflv;
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    public final T next() {
        zzb();
        if (hasNext()) {
            int i = this.zzc;
            this.zzd = i;
            T zza = zza(i);
            this.zzc = this.zze.zzg(this.zzc);
            return zza;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        zzb();
        zzfke.zzb(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzflv zzflv = this.zze;
        zzflv.remove(zzflv.zzb[this.zzd]);
        this.zzc--;
        this.zzd = -1;
    }

    public abstract T zza(int i);
}
