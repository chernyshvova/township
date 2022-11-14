package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzggc {
    public static final Class<?> zza;
    public static final zzggo<?, ?> zzb = zzab(false);
    public static final zzggo<?, ?> zzc = zzab(true);
    public static final zzggo<?, ?> zzd = new zzggq();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzggo<?, ?> zzA() {
        return zzb;
    }

    public static zzggo<?, ?> zzB() {
        return zzc;
    }

    public static zzggo<?, ?> zzC() {
        return zzd;
    }

    public static boolean zzD(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T, FT extends zzgds<FT>> void zzE(zzgdp<FT> zzgdp, T t, T t2) {
        zzgdp.zzb(t2);
        throw null;
    }

    public static <T, UT, UB> void zzF(zzggo<UT, UB> zzggo, T t, T t2) {
        zzggo.zzi(t, zzggo.zzo(zzggo.zzj(t), zzggo.zzj(t2)));
    }

    public static <UT, UB> UB zzG(int i, List<Integer> list, zzgeg zzgeg, UB ub, zzggo<UT, UB> zzggo) {
        if (zzgeg == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzgeg.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zzH(i, intValue, ub, zzggo);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzgeg.zza(intValue2)) {
                    ub = zzH(i, intValue2, ub, zzggo);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static <UT, UB> UB zzH(int i, int i2, UB ub, zzggo<UT, UB> zzggo) {
        if (ub == null) {
            ub = zzggo.zzg();
        }
        zzggo.zzb(ub, i, (long) i2);
        return ub;
    }

    public static <T> void zzI(zzgff zzgff, T t, T t2, long j) {
        zzggy.zzo(t, j, zzgff.zzc(zzggy.zzn(t, j), zzggy.zzn(t2, j)));
    }

    public static void zzJ(int i, List<Double> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzB(i, list, z);
        }
    }

    public static void zzK(int i, List<Float> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzA(i, list, z);
        }
    }

    public static void zzL(int i, List<Long> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzx(i, list, z);
        }
    }

    public static void zzM(int i, List<Long> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzy(i, list, z);
        }
    }

    public static void zzN(int i, List<Long> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzK(i, list, z);
        }
    }

    public static void zzO(int i, List<Long> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzz(i, list, z);
        }
    }

    public static void zzP(int i, List<Long> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzI(i, list, z);
        }
    }

    public static void zzQ(int i, List<Integer> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzv(i, list, z);
        }
    }

    public static void zzR(int i, List<Integer> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzG(i, list, z);
        }
    }

    public static void zzS(int i, List<Integer> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzJ(i, list, z);
        }
    }

    public static void zzT(int i, List<Integer> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzw(i, list, z);
        }
    }

    public static void zzU(int i, List<Integer> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzH(i, list, z);
        }
    }

    public static void zzV(int i, List<Integer> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzC(i, list, z);
        }
    }

    public static void zzW(int i, List<Boolean> list, zzgdk zzgdk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzD(i, list, z);
        }
    }

    public static void zzX(int i, List<String> list, zzgdk zzgdk) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzE(i, list);
        }
    }

    public static void zzY(int i, List<zzgcz> list, zzgdk zzgdk) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgdk.zzF(i, list);
        }
    }

    public static void zzZ(int i, List<?> list, zzgdk zzgdk, zzgga zzgga) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzgdk.zzr(i, list.get(i2), zzgga);
            }
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzgec.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzaa(int i, List<?> list, zzgdk zzgdk, zzgga zzgga) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzgdk.zzs(i, list.get(i2), zzgga);
            }
        }
    }

    public static zzggo<?, ?> zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzggo) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgez) {
            zzgez zzgez = (zzgez) list;
            i = 0;
            while (i2 < size) {
                i += zzgdj.zzx(zzgez.zzf(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgdj.zzx(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzc(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzgdj.zzu(i) * list.size()) + zzb(list);
    }

    public static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgez) {
            zzgez zzgez = (zzgez) list;
            i = 0;
            while (i2 < size) {
                i += zzgdj.zzx(zzgez.zzf(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgdj.zzx(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zze(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgdj.zzu(i) * size) + zzd(list);
    }

    public static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgez) {
            zzgez zzgez = (zzgez) list;
            i = 0;
            while (i2 < size) {
                long zzf = zzgez.zzf(i2);
                i += zzgdj.zzx((zzf >> 63) ^ (zzf + zzf));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = list.get(i2).longValue();
                i3 = i + zzgdj.zzx((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    public static int zzg(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgdj.zzu(i) * size) + zzf(list);
    }

    public static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzged) {
            zzged zzged = (zzged) list;
            i = 0;
            while (i2 < size) {
                i += zzgdj.zzv(zzged.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgdj.zzv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgdj.zzu(i) * size) + zzh(list);
    }

    public static int zzj(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzged) {
            zzged zzged = (zzged) list;
            i = 0;
            while (i2 < size) {
                i += zzgdj.zzv(zzged.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgdj.zzv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzk(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgdj.zzu(i) * size) + zzj(list);
    }

    public static int zzl(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzged) {
            zzged zzged = (zzged) list;
            i = 0;
            while (i2 < size) {
                i += zzgdj.zzw(zzged.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgdj.zzw(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzm(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgdj.zzu(i) * size) + zzl(list);
    }

    public static int zzn(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzged) {
            zzged zzged = (zzged) list;
            i = 0;
            while (i2 < size) {
                int zzg = zzged.zzg(i2);
                i += zzgdj.zzw((zzg >> 31) ^ (zzg + zzg));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = list.get(i2).intValue();
                i3 = i + zzgdj.zzw((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    public static int zzo(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgdj.zzu(i) * size) + zzn(list);
    }

    public static int zzp(List<?> list) {
        return list.size() * 4;
    }

    public static int zzq(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgdj.zzw(i << 3) + 4) * size;
    }

    public static int zzr(List<?> list) {
        return list.size() * 8;
    }

    public static int zzs(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgdj.zzw(i << 3) + 8) * size;
    }

    public static int zzt(List<?> list) {
        return list.size();
    }

    public static int zzu(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgdj.zzw(i << 3) + 1) * size;
    }

    public static int zzv(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzu = zzgdj.zzu(i) * size;
        if (list instanceof zzgeu) {
            zzgeu zzgeu = (zzgeu) list;
            while (i4 < size) {
                Object zzg = zzgeu.zzg(i4);
                if (zzg instanceof zzgcz) {
                    i3 = zzgdj.zzA((zzgcz) zzg);
                } else {
                    i3 = zzgdj.zzy((String) zzg);
                }
                zzu = i3 + zzu;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzgcz) {
                    i2 = zzgdj.zzA((zzgcz) obj);
                } else {
                    i2 = zzgdj.zzy((String) obj);
                }
                zzu = i2 + zzu;
                i4++;
            }
        }
        return zzu;
    }

    public static int zzw(int i, Object obj, zzgga zzgga) {
        if (obj instanceof zzges) {
            int zzw = zzgdj.zzw(i << 3);
            int zza2 = ((zzges) obj).zza();
            return zzgdj.zzw(zza2) + zza2 + zzw;
        }
        return zzgdj.zzB((zzgfk) obj, zzgga) + zzgdj.zzw(i << 3);
    }

    public static int zzx(int i, List<?> list, zzgga zzgga) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = zzgdj.zzu(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzges) {
                i2 = zzgdj.zzz((zzges) obj);
            } else {
                i2 = zzgdj.zzB((zzgfk) obj, zzgga);
            }
            zzu = i2 + zzu;
        }
        return zzu;
    }

    public static int zzy(int i, List<zzgcz> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = zzgdj.zzu(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzu += zzgdj.zzA(list.get(i2));
        }
        return zzu;
    }

    public static int zzz(int i, List<zzgfk> list, zzgga zzgga) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzgdj.zzE(i, list.get(i3), zzgga);
        }
        return i2;
    }
}
