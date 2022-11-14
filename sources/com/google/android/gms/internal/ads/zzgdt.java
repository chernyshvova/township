package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgds;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgdt<T extends zzgds<T>> {
    public static final zzgdt zzd = new zzgdt(true);
    public final zzggk<T, Object> zza = new zzggd(16);
    public boolean zzb;
    public boolean zzc;

    public zzgdt() {
    }

    public static <T extends zzgds<T>> zzgdt<T> zza() {
        throw null;
    }

    public static final void zzd(T t, Object obj) {
        boolean z;
        zzghe zzb2 = t.zzb();
        zzgem.zza(obj);
        zzghe zzghe = zzghe.DOUBLE;
        zzghf zzghf = zzghf.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzgcz) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzgee)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzgfk) || (obj instanceof zzger)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t.zza()), t.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgdt zzgdt = new zzgdt();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzd2 = this.zza.zzd(i);
            zzgdt.zzc((zzgds) zzd2.getKey(), zzd2.getValue());
        }
        for (Map.Entry next : this.zza.zze()) {
            zzgdt.zzc((zzgds) next.getKey(), next.getValue());
        }
        zzgdt.zzc = this.zzc;
        return zzgdt;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgdt)) {
            return false;
        }
        return this.zza.equals(((zzgdt) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final void zzc(T t, Object obj) {
        if (!t.zzc()) {
            zzd(t, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(t, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzger) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    public zzgdt(boolean z) {
        zzb();
        zzb();
    }
}
