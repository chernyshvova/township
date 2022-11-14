package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzkl implements Comparable<zzkl>, Map.Entry<K, V> {
    public final K zza;
    public V zzb;
    public final /* synthetic */ zzkc zzc;

    public zzkl(zzkc zzkc, Map.Entry<K, V> entry) {
        this(zzkc, (Comparable) entry.getKey(), entry.getValue());
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzkl) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zza(this.zza, entry.getKey()) && zza(this.zzb, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    public final V getValue() {
        return this.zzb;
    }

    public final int hashCode() {
        K k = this.zza;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.zzb;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.zzc.zzf();
        V v2 = this.zzb;
        this.zzb = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        return GeneratedOutlineSupport.outline12(valueOf2.length() + valueOf.length() + 1, valueOf, "=", valueOf2);
    }

    public zzkl(zzkc zzkc, K k, V v) {
        this.zzc = zzkc;
        this.zza = k;
        this.zzb = v;
    }
}
