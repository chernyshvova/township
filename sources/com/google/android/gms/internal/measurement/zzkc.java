package com.google.android.gms.internal.measurement;

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

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class zzkc<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public final int zza;
    public List<zzkl> zzb;
    public Map<K, V> zzc;
    public boolean zzd;
    public volatile zzkn zze;
    public Map<K, V> zzf;
    public volatile zzkh zzg;

    public zzkc(int i) {
        this.zza = i;
        this.zzb = Collections.emptyList();
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends zzht<FieldDescriptorType>> zzkc<FieldDescriptorType, Object> zza(int i) {
        return new zzkf(i);
    }

    /* access modifiers changed from: private */
    public final void zzf() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzg() {
        zzf();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    public void clear() {
        zzf();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzkn(this, (zzkf) null);
        }
        return this.zze;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkc)) {
            return super.equals(obj);
        }
        zzkc zzkc = (zzkc) obj;
        int size = size();
        if (size != zzkc.size()) {
            return false;
        }
        int zzc2 = zzc();
        if (zzc2 != zzkc.zzc()) {
            return entrySet().equals(zzkc.entrySet());
        }
        for (int i = 0; i < zzc2; i++) {
            if (!zzb(i).equals(zzkc.zzb(i))) {
                return false;
            }
        }
        if (zzc2 != size) {
            return this.zzc.equals(zzkc.zzc);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza2 = zza(comparable);
        if (zza2 >= 0) {
            return this.zzb.get(zza2).getValue();
        }
        return this.zzc.get(comparable);
    }

    public int hashCode() {
        int zzc2 = zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc2; i2++) {
            i += this.zzb.get(i2).hashCode();
        }
        return this.zzc.size() > 0 ? i + this.zzc.hashCode() : i;
    }

    public V remove(Object obj) {
        zzf();
        Comparable comparable = (Comparable) obj;
        int zza2 = zza(comparable);
        if (zza2 >= 0) {
            return zzc(zza2);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    public int size() {
        return this.zzc.size() + this.zzb.size();
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzb.size();
    }

    public final Iterable<Map.Entry<K, V>> zzd() {
        if (this.zzc.isEmpty()) {
            return zzkg.zza();
        }
        return this.zzc.entrySet();
    }

    public final Set<Map.Entry<K, V>> zze() {
        if (this.zzg == null) {
            this.zzg = new zzkh(this, (zzkf) null);
        }
        return this.zzg;
    }

    /* access modifiers changed from: private */
    public final V zzc(int i) {
        zzf();
        V value = this.zzb.remove(i).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it = zzg().entrySet().iterator();
            this.zzb.add(new zzkl(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void zza() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzd) {
            if (this.zzc.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzc);
            }
            this.zzc = map;
            if (this.zzf.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzf);
            }
            this.zzf = map2;
            this.zzd = true;
        }
    }

    public final Map.Entry<K, V> zzb(int i) {
        return this.zzb.get(i);
    }

    public /* synthetic */ zzkc(int i, zzkf zzkf) {
        this(i);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzf();
        int zza2 = zza(k);
        if (zza2 >= 0) {
            return this.zzb.get(zza2).setValue(v);
        }
        zzf();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i = -(zza2 + 1);
        if (i >= this.zza) {
            return zzg().put(k, v);
        }
        int size = this.zzb.size();
        int i2 = this.zza;
        if (size == i2) {
            zzkl remove = this.zzb.remove(i2 - 1);
            zzg().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzb.add(i, new zzkl(this, k, v));
        return null;
    }

    private final int zza(K k) {
        int size = this.zzb.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzb.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.zzb.get(i2).getKey());
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
