package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzkd {
    public static final Class<?> zza = zzd();
    public static final zzkt<?, ?> zzb = zza(false);
    public static final zzkt<?, ?> zzc = zza(true);
    public static final zzkt<?, ?> zzd = new zzkv();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzhy.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzb(int i, List<Float> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzi(i, list, z);
        }
    }

    public static void zzb(int i, List<zzgp> list, zzlm zzlm) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzb(i, list);
        }
    }

    public static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzf(zzix.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzf(list.get(i2).longValue());
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
        if (list instanceof zzib) {
            zzib zzib = (zzib) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzk(zzib.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzk(list.get(i2).intValue());
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
        if (list instanceof zzib) {
            zzib zzib = (zzib) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzf(zzib.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzf(list.get(i2).intValue());
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
        if (list instanceof zzib) {
            zzib zzib = (zzib) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzg(zzib.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            zzib zzib = (zzib) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzh(zzib.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzh(list.get(i2).intValue());
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

    public static void zza(int i, List<Double> list, zzlm zzlm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzg(i, list, z);
        }
    }

    public static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzhi.zzi(i, 0) * size;
    }

    public static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzhi.zzg(i, 0) * size;
    }

    public static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzhi.zzb(i, true) * size;
    }

    public static void zzb(int i, List<?> list, zzlm zzlm, zzkb zzkb) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zzb(i, list, zzkb);
        }
    }

    public static void zza(int i, List<String> list, zzlm zzlm) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zza(i, list);
        }
    }

    public static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zze(zzix.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void zza(int i, List<?> list, zzlm zzlm, zzkb zzkb) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzlm.zza(i, list, zzkb);
        }
    }

    public static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zzc(list);
    }

    public static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zzd(list);
    }

    public static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zze(list);
    }

    public static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zzf(list);
    }

    public static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zzg(list);
    }

    public static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzd(zzix.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzkt<?, ?> zzc() {
        return zzd;
    }

    public static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zzb(list);
    }

    public static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzhi.zze(i) * list.size()) + zza(list);
    }

    public static int zzb(int i, List<zzgp> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzhi.zze(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzhi.zzb(list.get(i2));
        }
        return zze;
    }

    public static int zza(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzhi.zze(i) * size;
        if (list instanceof zziq) {
            zziq zziq = (zziq) list;
            while (i4 < size) {
                Object zzb2 = zziq.zzb(i4);
                if (zzb2 instanceof zzgp) {
                    i3 = zzhi.zzb((zzgp) zzb2);
                } else {
                    i3 = zzhi.zzb((String) zzb2);
                }
                zze = i3 + zze;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzgp) {
                    i2 = zzhi.zzb((zzgp) obj);
                } else {
                    i2 = zzhi.zzb((String) obj);
                }
                zze = i2 + zze;
                i4++;
            }
        }
        return zze;
    }

    public static int zzb(int i, List<zzjj> list, zzkb zzkb) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzhi.zzc(i, list.get(i3), zzkb);
        }
        return i2;
    }

    public static zzkt<?, ?> zzb() {
        return zzc;
    }

    public static int zza(int i, Object obj, zzkb zzkb) {
        if (obj instanceof zzio) {
            return zzhi.zza(i, (zzio) obj);
        }
        return zzhi.zzb(i, (zzjj) obj, zzkb);
    }

    public static int zza(int i, List<?> list, zzkb zzkb) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzhi.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzio) {
                i2 = zzhi.zza((zzio) obj);
            } else {
                i2 = zzhi.zza((zzjj) obj, zzkb);
            }
            zze = i2 + zze;
        }
        return zze;
    }

    public static zzkt<?, ?> zza() {
        return zzb;
    }

    public static zzkt<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzkt) zze.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T> void zza(zzjc zzjc, T t, T t2, long j) {
        zzkz.zza((Object) t, j, zzjc.zza(zzkz.zzf(t, j), zzkz.zzf(t2, j)));
    }

    public static <T, FT extends zzht<FT>> void zza(zzhn<FT> zzhn, T t, T t2) {
        zzhr<FT> zza2 = zzhn.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzhn.zzb(t).zza(zza2);
        }
    }

    public static <T, UT, UB> void zza(zzkt<UT, UB> zzkt, T t, T t2) {
        zzkt.zza((Object) t, zzkt.zzc(zzkt.zzb(t), zzkt.zzb(t2)));
    }

    public static <UT, UB> UB zza(int i, List<Integer> list, zzif zzif, UB ub, zzkt<UT, UB> zzkt) {
        if (zzif == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzif.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzkt);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzif.zza(intValue2)) {
                    ub = zza(i, intValue2, ub, zzkt);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static <UT, UB> UB zza(int i, int i2, UB ub, zzkt<UT, UB> zzkt) {
        if (ub == null) {
            ub = zzkt.zza();
        }
        zzkt.zza(ub, i, (long) i2);
        return ub;
    }
}
