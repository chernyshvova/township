package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzget extends zzgck<String> implements RandomAccess, zzgeu {
    public static final zzgeu zza = zzb;
    public static final zzget zzb;
    public final List<Object> zzc;

    static {
        zzget zzget = new zzget(10);
        zzb = zzget;
        zzget.zzb();
    }

    public zzget() {
        this(10);
    }

    public static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgcz) {
            return ((zzgcz) obj).zzA(zzgem.zza);
        }
        return zzgem.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzcb();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzcb();
        if (collection instanceof zzgeu) {
            collection = ((zzgeu) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzcb();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzcb();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzcb();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    /* renamed from: zzd */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgcz) {
            zzgcz zzgcz = (zzgcz) obj;
            String zzA = zzgcz.zzA(zzgem.zza);
            if (zzgcz.zzm()) {
                this.zzc.set(i, zzA);
            }
            return zzA;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzgem.zzd(bArr);
        if (zzgem.zzc(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    public final /* bridge */ /* synthetic */ zzgel zze(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzget((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(zzgcz zzgcz) {
        zzcb();
        this.zzc.add(zzgcz);
        this.modCount++;
    }

    public final Object zzg(int i) {
        return this.zzc.get(i);
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final zzgeu zzi() {
        return zza() ? new zzggt(this) : this;
    }

    public zzget(int i) {
        this.zzc = new ArrayList(i);
    }

    public zzget(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
