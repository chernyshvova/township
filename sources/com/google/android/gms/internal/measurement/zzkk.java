package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzkk implements Iterator<Map.Entry<K, V>> {
    public int zza;
    public boolean zzb;
    public Iterator<Map.Entry<K, V>> zzc;
    public final /* synthetic */ zzkc zzd;

    public zzkk(zzkc zzkc) {
        this.zzd = zzkc;
        this.zza = -1;
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        if (this.zzc == null) {
            this.zzc = this.zzd.zzc.entrySet().iterator();
        }
        return this.zzc;
    }

    public final boolean hasNext() {
        if (this.zza + 1 < this.zzd.zzb.size() || (!this.zzd.zzc.isEmpty() && zza().hasNext())) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        this.zzb = true;
        int i = this.zza + 1;
        this.zza = i;
        if (i < this.zzd.zzb.size()) {
            return (Map.Entry) this.zzd.zzb.get(this.zza);
        }
        return (Map.Entry) zza().next();
    }

    public final void remove() {
        if (this.zzb) {
            this.zzb = false;
            this.zzd.zzf();
            if (this.zza < this.zzd.zzb.size()) {
                zzkc zzkc = this.zzd;
                int i = this.zza;
                this.zza = i - 1;
                Object unused = zzkc.zzc(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    public /* synthetic */ zzkk(zzkc zzkc, zzkf zzkf) {
        this(zzkc);
    }
}
