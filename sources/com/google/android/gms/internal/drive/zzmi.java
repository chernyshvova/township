package com.google.android.gms.internal.drive;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class zzmi<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public boolean zzot;
    public final int zzvd;
    public List<zzmp> zzve;
    public Map<K, V> zzvf;
    public volatile zzmr zzvg;
    public Map<K, V> zzvh;
    public volatile zzml zzvi;

    public zzmi(int i) {
        this.zzvd = i;
        this.zzve = Collections.emptyList();
        this.zzvf = Collections.emptyMap();
        this.zzvh = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends zzkd<FieldDescriptorType>> zzmi<FieldDescriptorType, Object> zzav(int i) {
        return new zzmj(i);
    }

    /* access modifiers changed from: private */
    public final V zzax(int i) {
        zzeu();
        V value = this.zzve.remove(i).getValue();
        if (!this.zzvf.isEmpty()) {
            Iterator it = zzev().entrySet().iterator();
            this.zzve.add(new zzmp(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void zzeu() {
        if (this.zzot) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzev() {
        zzeu();
        if (this.zzvf.isEmpty() && !(this.zzvf instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzvf = treeMap;
            this.zzvh = treeMap.descendingMap();
        }
        return (SortedMap) this.zzvf;
    }

    public void clear() {
        zzeu();
        if (!this.zzve.isEmpty()) {
            this.zzve.clear();
        }
        if (!this.zzvf.isEmpty()) {
            this.zzvf.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzvf.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzvg == null) {
            this.zzvg = new zzmr(this, (zzmj) null);
        }
        return this.zzvg;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmi)) {
            return super.equals(obj);
        }
        zzmi zzmi = (zzmi) obj;
        int size = size();
        if (size != zzmi.size()) {
            return false;
        }
        int zzer = zzer();
        if (zzer != zzmi.zzer()) {
            return entrySet().equals(zzmi.entrySet());
        }
        for (int i = 0; i < zzer; i++) {
            if (!zzaw(i).equals(zzmi.zzaw(i))) {
                return false;
            }
        }
        if (zzer != size) {
            return this.zzvf.equals(zzmi.zzvf);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzve.get(zza).getValue();
        }
        return this.zzvf.get(comparable);
    }

    public int hashCode() {
        int zzer = zzer();
        int i = 0;
        for (int i2 = 0; i2 < zzer; i2++) {
            i += this.zzve.get(i2).hashCode();
        }
        return this.zzvf.size() > 0 ? i + this.zzvf.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zzot;
    }

    public V remove(Object obj) {
        zzeu();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzax(zza);
        }
        if (this.zzvf.isEmpty()) {
            return null;
        }
        return this.zzvf.remove(comparable);
    }

    public int size() {
        return this.zzvf.size() + this.zzve.size();
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzeu();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzve.get(zza).setValue(v);
        }
        zzeu();
        if (this.zzve.isEmpty() && !(this.zzve instanceof ArrayList)) {
            this.zzve = new ArrayList(this.zzvd);
        }
        int i = -(zza + 1);
        if (i >= this.zzvd) {
            return zzev().put(k, v);
        }
        int size = this.zzve.size();
        int i2 = this.zzvd;
        if (size == i2) {
            zzmp remove = this.zzve.remove(i2 - 1);
            zzev().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzve.add(i, new zzmp(this, k, v));
        return null;
    }

    public final Map.Entry<K, V> zzaw(int i) {
        return this.zzve.get(i);
    }

    public void zzbp() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzot) {
            if (this.zzvf.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzvf);
            }
            this.zzvf = map;
            if (this.zzvh.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzvh);
            }
            this.zzvh = map2;
            this.zzot = true;
        }
    }

    public final int zzer() {
        return this.zzve.size();
    }

    public final Iterable<Map.Entry<K, V>> zzes() {
        if (this.zzvf.isEmpty()) {
            return zzmm.zzex();
        }
        return this.zzvf.entrySet();
    }

    public final Set<Map.Entry<K, V>> zzet() {
        if (this.zzvi == null) {
            this.zzvi = new zzml(this, (zzmj) null);
        }
        return this.zzvi;
    }

    public /* synthetic */ zzmi(int i, zzmj zzmj) {
        this(i);
    }

    private final int zza(K k) {
        int size = this.zzve.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzve.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzve.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }
}
