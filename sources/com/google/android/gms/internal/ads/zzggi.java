package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzggi implements Iterator<Map.Entry> {
    public final /* synthetic */ zzggk zza;
    public int zzb = -1;
    public boolean zzc;
    public Iterator<Map.Entry> zzd;

    public /* synthetic */ zzggi(zzggk zzggk, zzggd zzggd) {
        this.zza = zzggk;
    }

    private final Iterator<Map.Entry> zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 >= this.zza.zzb.size()) {
            return !this.zza.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i < this.zza.zzb.size()) {
            return (Map.Entry) this.zza.zzb.get(this.zzb);
        }
        return zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzm();
            if (this.zzb < this.zza.zzb.size()) {
                zzggk zzggk = this.zza;
                int i = this.zzb;
                this.zzb = i - 1;
                Object unused = zzggk.zzk(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
