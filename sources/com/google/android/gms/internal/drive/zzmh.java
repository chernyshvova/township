package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class zzmh {
    public static final Class<?> zzuz = zzep();
    public static final zzmx<?, ?> zzva = zzf(false);
    public static final zzmx<?, ?> zzvb = zzf(true);
    public static final zzmx<?, ?> zzvc = new zzmz();

    public static void zza(int i, List<Double> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzn(i, list, z);
        }
    }

    public static zzmx<?, ?> zzem() {
        return zzva;
    }

    public static zzmx<?, ?> zzen() {
        return zzvb;
    }

    public static zzmx<?, ?> zzeo() {
        return zzvc;
    }

    public static Class<?> zzep() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> zzeq() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzf(int i, List<Long> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zze(i, list, z);
        }
    }

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzkk.class.isAssignableFrom(cls) && (cls2 = zzuz) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzh(int i, List<Integer> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzi(i, list, z);
        }
    }

    public static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzjr.zzab(i) * list.size()) + zza(list);
    }

    public static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjr.zzab(i) * size) + zzb(list);
    }

    public static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjr.zzab(i) * size) + zzc(list);
    }

    public static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjr.zzab(i) * size) + zzd(list);
    }

    public static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjr.zzab(i) * size) + zze(list);
    }

    public static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjr.zzab(i) * size) + zzf(list);
    }

    public static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzjr.zzab(i) * size) + zzg(list);
    }

    public static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzjr.zzj(i, 0) * size;
    }

    public static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzjr.zzg(i, 0) * size;
    }

    public static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzjr.zzc(i, true) * size;
    }

    public static void zza(int i, List<String> list, zzns zzns) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzjc> list, zzns zzns) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzb(i, list);
        }
    }

    public static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzle) {
            zzle zzle = (zzle) list;
            i = 0;
            while (i2 < size) {
                i += zzjr.zzq(zzle.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjr.zzq(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkl) {
            zzkl zzkl = (zzkl) list;
            i = 0;
            while (i2 < size) {
                i += zzjr.zzah(zzkl.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjr.zzah(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkl) {
            zzkl zzkl = (zzkl) list;
            i = 0;
            while (i2 < size) {
                i += zzjr.zzac(zzkl.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjr.zzac(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkl) {
            zzkl zzkl = (zzkl) list;
            i = 0;
            while (i2 < size) {
                i += zzjr.zzad(zzkl.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjr.zzad(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzh(List<?> list) {
        return list.size() << 2;
    }

    public static int zzi(List<?> list) {
        return list.size() << 3;
    }

    public static int zzj(List<?> list) {
        return list.size();
    }

    public static void zzg(int i, List<Long> list, zzns zzns, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzl(i, list, z);
        }
    }

    public static void zza(int i, List<?> list, zzns zzns, zzmf zzmf) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zza(i, list, zzmf);
        }
    }

    public static void zzb(int i, List<?> list, zzns zzns, zzmf zzmf) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzns.zzb(i, list, zzmf);
        }
    }

    public static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkl) {
            zzkl zzkl = (zzkl) list;
            i = 0;
            while (i2 < size) {
                i += zzjr.zzae(zzkl.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjr.zzae(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzle) {
            zzle zzle = (zzle) list;
            i = 0;
            while (i2 < size) {
                i += zzjr.zzo(zzle.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjr.zzo(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzle) {
            zzle zzle = (zzle) list;
            i = 0;
            while (i2 < size) {
                i += zzjr.zzp(zzle.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjr.zzp(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzab = zzjr.zzab(i) * size;
        if (list instanceof zzkz) {
            zzkz zzkz = (zzkz) list;
            while (i4 < size) {
                Object zzao = zzkz.zzao(i4);
                if (zzao instanceof zzjc) {
                    i3 = zzjr.zzb((zzjc) zzao);
                } else {
                    i3 = zzjr.zzm((String) zzao);
                }
                zzab = i3 + zzab;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzjc) {
                    i2 = zzjr.zzb((zzjc) obj);
                } else {
                    i2 = zzjr.zzm((String) obj);
                }
                zzab = i2 + zzab;
                i4++;
            }
        }
        return zzab;
    }

    public static int zzd(int i, List<zzjc> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzab = zzjr.zzab(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzab += zzjr.zzb(list.get(i2));
        }
        return zzab;
    }

    public static zzmx<?, ?> zzf(boolean z) {
        try {
            Class<?> zzeq = zzeq();
            if (zzeq == null) {
                return null;
            }
            return (zzmx) zzeq.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> void zza(zzll zzll, T t, T t2, long j) {
        zznd.zza((Object) t, j, zzll.zzb(zznd.zzo(t, j), zznd.zzo(t2, j)));
    }

    public static int zzd(int i, List<zzlq> list, zzmf zzmf) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzjr.zzc(i, list.get(i3), zzmf);
        }
        return i2;
    }

    public static boolean zzd(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T, FT extends zzkd<FT>> void zza(zzjy<FT> zzjy, T t, T t2) {
        zzkb<FT> zzb = zzjy.zzb(t2);
        if (!zzb.zzos.isEmpty()) {
            zzjy.zzc(t).zza(zzb);
        }
    }

    public static <T, UT, UB> void zza(zzmx<UT, UB> zzmx, T t, T t2) {
        zzmx.zze(t, zzmx.zzg(zzmx.zzr(t), zzmx.zzr(t2)));
    }

    public static int zzc(int i, Object obj, zzmf zzmf) {
        if (obj instanceof zzkx) {
            return zzjr.zza(i, (zzkx) obj);
        }
        return zzjr.zzb(i, (zzlq) obj, zzmf);
    }

    public static <UT, UB> UB zza(int i, List<Integer> list, zzko zzko, UB ub, zzmx<UT, UB> zzmx) {
        if (zzko == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzko.zzan(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzmx);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzko.zzan(intValue2)) {
                    ub = zza(i, intValue2, ub, zzmx);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static int zzc(int i, List<?> list, zzmf zzmf) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzab = zzjr.zzab(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzkx) {
                i2 = zzjr.zza((zzkx) obj);
            } else {
                i2 = zzjr.zza((zzlq) obj, zzmf);
            }
            zzab = i2 + zzab;
        }
        return zzab;
    }

    public static <UT, UB> UB zza(int i, int i2, UB ub, zzmx<UT, UB> zzmx) {
        if (ub == null) {
            ub = zzmx.zzez();
        }
        zzmx.zza(ub, i, (long) i2);
        return ub;
    }
}
