package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzflv<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Object zzd = new Object();
    @NullableDecl
    public transient int[] zza;
    @NullableDecl
    public transient Object[] zzb;
    @NullableDecl
    public transient Object[] zzc;
    @NullableDecl
    public transient Object zze;
    public transient int zzf;
    public transient int zzg;
    @NullableDecl
    public transient Set<K> zzh;
    @NullableDecl
    public transient Set<Map.Entry<K, V>> zzi;
    @NullableDecl
    public transient Collection<V> zzj;

    public zzflv() {
        zza(3);
    }

    public static /* synthetic */ int zzn(zzflv zzflv) {
        int i = zzflv.zzg;
        zzflv.zzg = i - 1;
        return i;
    }

    private final void zzo(int i) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.zzf & -32);
    }

    /* access modifiers changed from: private */
    public final int zzp() {
        return (1 << (this.zzf & 31)) - 1;
    }

    private final int zzq(int i, int i2, int i3, int i4) {
        Object zza2 = zzflw.zza(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            zzflw.zzc(zza2, i3 & i5, i4 + 1);
        }
        Object obj = this.zze;
        int[] iArr = this.zza;
        for (int i6 = 0; i6 <= i; i6++) {
            int zzb2 = zzflw.zzb(obj, i6);
            while (zzb2 != 0) {
                int i7 = zzb2 - 1;
                int i8 = iArr[i7];
                int i9 = ((i ^ -1) & i8) | i6;
                int i10 = i9 & i5;
                int zzb3 = zzflw.zzb(zza2, i10);
                zzflw.zzc(zza2, i10, zzb2);
                iArr[i7] = ((i5 ^ -1) & i9) | (zzb3 & i5);
                zzb2 = i8 & i;
            }
        }
        this.zze = zza2;
        zzo(i5);
        return i5;
    }

    /* access modifiers changed from: private */
    public final int zzr(@NullableDecl Object obj) {
        if (zzb()) {
            return -1;
        }
        int zzb2 = zzfmd.zzb(obj);
        int zzp = zzp();
        int zzb3 = zzflw.zzb(this.zze, zzb2 & zzp);
        if (zzb3 != 0) {
            int i = zzp ^ -1;
            int i2 = zzb2 & i;
            do {
                int i3 = zzb3 - 1;
                int i4 = this.zza[i3];
                if ((i4 & i) == i2 && zzfka.zza(obj, this.zzb[i3])) {
                    return i3;
                }
                zzb3 = i4 & zzp;
            } while (zzb3 != 0);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    @NullableDecl
    public final Object zzs(@NullableDecl Object obj) {
        if (zzb()) {
            return zzd;
        }
        int zzp = zzp();
        int zze2 = zzflw.zze(obj, (Object) null, zzp, this.zze, this.zza, this.zzb, (Object[]) null);
        if (zze2 == -1) {
            return zzd;
        }
        Object obj2 = this.zzc[zze2];
        zze(zze2, zzp);
        this.zzg--;
        zzd();
        return obj2;
    }

    public final void clear() {
        if (!zzb()) {
            zzd();
            Map zzc2 = zzc();
            if (zzc2 != null) {
                this.zzf = zzfos.zza(size(), 3, 1073741823);
                zzc2.clear();
                this.zze = null;
                this.zzg = 0;
                return;
            }
            Arrays.fill(this.zzb, 0, this.zzg, (Object) null);
            Arrays.fill(this.zzc, 0, this.zzg, (Object) null);
            Object obj = this.zze;
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(this.zza, 0, this.zzg, 0);
            this.zzg = 0;
        }
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        Map zzc2 = zzc();
        if (zzc2 != null) {
            return zzc2.containsKey(obj);
        }
        return zzr(obj) != -1;
    }

    public final boolean containsValue(@NullableDecl Object obj) {
        Map zzc2 = zzc();
        if (zzc2 != null) {
            return zzc2.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (zzfka.zza(obj, this.zzc[i])) {
                return true;
            }
        }
        return false;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zzi;
        if (set != null) {
            return set;
        }
        zzflq zzflq = new zzflq(this);
        this.zzi = zzflq;
        return zzflq;
    }

    public final V get(@NullableDecl Object obj) {
        Map zzc2 = zzc();
        if (zzc2 != null) {
            return zzc2.get(obj);
        }
        int zzr = zzr(obj);
        if (zzr == -1) {
            return null;
        }
        return this.zzc[zzr];
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Set<K> keySet() {
        Set<K> set = this.zzh;
        if (set != null) {
            return set;
        }
        zzfls zzfls = new zzfls(this);
        this.zzh = zzfls;
        return zzfls;
    }

    @NullableDecl
    public final V put(@NullableDecl K k, @NullableDecl V v) {
        int min;
        K k2 = k;
        V v2 = v;
        if (zzb()) {
            zzfke.zzb(zzb(), "Arrays already allocated");
            int i = this.zzf;
            int max = Math.max(i + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > ((int) ((double) highestOneBit)) && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzflw.zza(max2);
            zzo(max2 - 1);
            this.zza = new int[i];
            this.zzb = new Object[i];
            this.zzc = new Object[i];
        }
        Map zzc2 = zzc();
        if (zzc2 != null) {
            return zzc2.put(k2, v2);
        }
        int[] iArr = this.zza;
        Object[] objArr = this.zzb;
        V[] vArr = this.zzc;
        int i2 = this.zzg;
        int i3 = i2 + 1;
        int zzb2 = zzfmd.zzb(k);
        int zzp = zzp();
        int i4 = zzb2 & zzp;
        int zzb3 = zzflw.zzb(this.zze, i4);
        if (zzb3 != 0) {
            int i5 = zzp ^ -1;
            int i6 = zzb2 & i5;
            int i7 = 0;
            while (true) {
                int i8 = zzb3 - 1;
                int i9 = iArr[i8];
                int i10 = i9 & i5;
                if (i10 != i6 || !zzfka.zza(k2, objArr[i8])) {
                    int i11 = i9 & zzp;
                    i7++;
                    if (i11 != 0) {
                        zzb3 = i11;
                    } else if (i7 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzp() + 1, 1.0f);
                        for (int zzf2 = zzf(); zzf2 >= 0; zzf2 = zzg(zzf2)) {
                            linkedHashMap.put(this.zzb[zzf2], this.zzc[zzf2]);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzd();
                        return linkedHashMap.put(k2, v2);
                    } else if (i3 > zzp) {
                        zzp = zzq(zzp, zzflw.zzd(zzp), zzb2, i2);
                    } else {
                        iArr[i8] = (i3 & zzp) | i10;
                    }
                } else {
                    V v3 = vArr[i8];
                    vArr[i8] = v2;
                    return v3;
                }
            }
        } else if (i3 > zzp) {
            zzp = zzq(zzp, zzflw.zzd(zzp), zzb2, i2);
        } else {
            zzflw.zzc(this.zze, i4, i3);
        }
        int length = this.zza.length;
        if (i3 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(this.zza, min);
            this.zzb = Arrays.copyOf(this.zzb, min);
            this.zzc = Arrays.copyOf(this.zzc, min);
        }
        this.zza[i2] = (zzp ^ -1) & zzb2;
        this.zzb[i2] = k2;
        this.zzc[i2] = v2;
        this.zzg = i3;
        zzd();
        return null;
    }

    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map zzc2 = zzc();
        if (zzc2 != null) {
            return zzc2.remove(obj);
        }
        V zzs = zzs(obj);
        if (zzs == zzd) {
            return null;
        }
        return zzs;
    }

    public final int size() {
        Map zzc2 = zzc();
        return zzc2 != null ? zzc2.size() : this.zzg;
    }

    public final Collection<V> values() {
        Collection<V> collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzflu zzflu = new zzflu(this);
        this.zzj = zzflu;
        return zzflu;
    }

    public final void zza(int i) {
        this.zzf = zzfos.zza(i, 1, 1073741823);
    }

    public final boolean zzb() {
        return this.zze == null;
    }

    @NullableDecl
    public final Map<K, V> zzc() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzd() {
        this.zzf += 32;
    }

    public final void zze(int i, int i2) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.zzb;
            Object obj = objArr[size];
            objArr[i] = obj;
            Object[] objArr2 = this.zzc;
            objArr2[i] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            int[] iArr = this.zza;
            iArr[i] = iArr[size];
            iArr[size] = 0;
            int zzb2 = zzfmd.zzb(obj) & i2;
            int zzb3 = zzflw.zzb(this.zze, zzb2);
            int i3 = size + 1;
            if (zzb3 != i3) {
                while (true) {
                    int i4 = zzb3 - 1;
                    int[] iArr2 = this.zza;
                    int i5 = iArr2[i4];
                    int i6 = i5 & i2;
                    if (i6 != i3) {
                        zzb3 = i6;
                    } else {
                        iArr2[i4] = ((i + 1) & i2) | ((i2 ^ -1) & i5);
                        return;
                    }
                }
            } else {
                zzflw.zzc(this.zze, zzb2, i + 1);
            }
        } else {
            this.zzb[i] = null;
            this.zzc[i] = null;
            this.zza[i] = 0;
        }
    }

    public final int zzf() {
        return isEmpty() ? -1 : 0;
    }

    public final int zzg(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    public zzflv(int i) {
        zza(8);
    }
}
