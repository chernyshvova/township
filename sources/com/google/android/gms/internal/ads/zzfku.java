package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzfku extends zzfnj {
    public final transient Map zza;
    public final /* synthetic */ zzflh zzb;

    public zzfku(zzflh zzflh, Map map) {
        this.zzb = zzflh;
        this.zza = map;
    }

    public final void clear() {
        if (this.zza == this.zzb.zza) {
            this.zzb.zzf();
        } else {
            zzfmz.zzb(new zzfkt(this));
        }
    }

    public final boolean containsKey(Object obj) {
        Map map = this.zza;
        if (map != null) {
            try {
                return map.containsKey(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        } else {
            throw null;
        }
    }

    public final boolean equals(@NullableDecl Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) zzfnk.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzb(obj, collection);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public Set keySet() {
        return this.zzb.zzu();
    }

    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection zzc = this.zzb.zzc();
        zzc.addAll(collection);
        zzflh.zzr(this.zzb, collection.size());
        collection.clear();
        return zzc;
    }

    public final int size() {
        return this.zza.size();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final Set<Map.Entry> zza() {
        return new zzfks(this);
    }

    public final Map.Entry zzb(Map.Entry entry) {
        Object key = entry.getKey();
        return new zzfmh(key, this.zzb.zzb(key, (Collection) entry.getValue()));
    }
}
