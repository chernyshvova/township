package com.google.android.gms.internal.drive;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Map;

public final class zzmp implements Comparable<zzmp>, Map.Entry<K, V> {
    public V value;
    public final /* synthetic */ zzmi zzvk;
    public final K zzvn;

    public zzmp(zzmi zzmi, Map.Entry<K, V> entry) {
        this(zzmi, (Comparable) entry.getKey(), entry.getValue());
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzmp) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzvn, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zzvn;
    }

    public final V getValue() {
        return this.value;
    }

    public final int hashCode() {
        K k = this.zzvn;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.zzvk.zzeu();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzvn);
        String valueOf2 = String.valueOf(this.value);
        return GeneratedOutlineSupport.outline12(valueOf2.length() + valueOf.length() + 1, valueOf, "=", valueOf2);
    }

    public zzmp(zzmi zzmi, K k, V v) {
        this.zzvk = zzmi;
        this.zzvn = k;
        this.value = v;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
