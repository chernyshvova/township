package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzeq extends AbstractSet<Map.Entry<K, V>> {
    public final /* synthetic */ zzem zza;

    public zzeq(zzem zzem) {
        this.zza = zzem;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzb2 = this.zza.zza(entry.getKey());
            if (zzb2 == -1 || !zzdz.zza(this.zza.zzc[zzb2], entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return this.zza.zzf();
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.zza.zza()) {
            return false;
        }
        int zzb2 = this.zza.zzi();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object zzc = this.zza.zze;
        zzem zzem = this.zza;
        int zza2 = zzex.zza(key, value, zzb2, zzc, zzem.zza, zzem.zzb, zzem.zzc);
        if (zza2 == -1) {
            return false;
        }
        this.zza.zza(zza2, zzb2);
        zzem.zzd(this.zza);
        this.zza.zzc();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
