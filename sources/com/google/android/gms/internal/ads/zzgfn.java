package com.google.android.gms.internal.ads;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.drive.DriveFile;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfn<T> implements zzgga<T> {
    public static final int[] zza = new int[0];
    public static final Unsafe zzb = zzggy.zzt();
    public final int[] zzc;
    public final Object[] zzd;
    public final int zze;
    public final int zzf;
    public final zzgfk zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final boolean zzj;
    public final int[] zzk;
    public final int zzl;
    public final int zzm;
    public final zzgey zzn;
    public final zzggo<?, ?> zzo;
    public final zzgdp<?> zzp;
    public final zzgfp zzq;
    public final zzgff zzr;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.gms.internal.ads.zzgfk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.google.android.gms.internal.ads.zzgfp} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.ads.zzgff} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzgdp, com.google.android.gms.internal.ads.zzgdp<?>] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v9, types: [int] */
    /* JADX WARNING: type inference failed for: r3v12, types: [com.google.android.gms.internal.ads.zzgey] */
    /* JADX WARNING: type inference failed for: r3v13, types: [com.google.android.gms.internal.ads.zzggo<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzgfn(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.gms.internal.ads.zzgfk r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.gms.internal.ads.zzgfp r17, com.google.android.gms.internal.ads.zzgey r18, com.google.android.gms.internal.ads.zzggo<?, ?> r19, com.google.android.gms.internal.ads.zzgdp<?> r20, com.google.android.gms.internal.ads.zzgff r21) {
        /*
            r5 = this;
            r0 = r5
            r1 = r10
            r2 = r19
            r5.<init>()
            r3 = r6
            r0.zzc = r3
            r3 = r7
            r0.zzd = r3
            r3 = r8
            r0.zze = r3
            r3 = r9
            r0.zzf = r3
            boolean r3 = r1 instanceof com.google.android.gms.internal.ads.zzgec
            r0.zzi = r3
            r3 = r11
            r0.zzj = r3
            r3 = 0
            if (r2 == 0) goto L_0x0024
            boolean r4 = r2.zza(r10)
            if (r4 == 0) goto L_0x0024
            r3 = 1
        L_0x0024:
            r0.zzh = r3
            r3 = r13
            r0.zzk = r3
            r3 = r14
            r0.zzl = r3
            r3 = r15
            r0.zzm = r3
            r3 = r16
            r0.zzq = r3
            r3 = r17
            r0.zzn = r3
            r3 = r18
            r0.zzo = r3
            r0.zzp = r2
            r0.zzg = r1
            r1 = r20
            r0.zzr = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgfn.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.ads.zzgfk, boolean, boolean, int[], int, int, com.google.android.gms.internal.ads.zzgfp, com.google.android.gms.internal.ads.zzgey, com.google.android.gms.internal.ads.zzggo, com.google.android.gms.internal.ads.zzgdp, com.google.android.gms.internal.ads.zzgff, byte[]):void");
    }

    private final <UT, UB> UB zzA(Object obj, int i, UB ub, zzggo<UT, UB> zzggo) {
        int i2 = this.zzc[i];
        Object zzn2 = zzggy.zzn(obj, (long) (zzD(i) & 1048575));
        if (zzn2 == null || zzy(i) == null) {
            return ub;
        }
        zzgfe zzgfe = (zzgfe) zzn2;
        zzgfd zzgfd = (zzgfd) zzx(i);
        throw null;
    }

    public static boolean zzB(Object obj, int i, zzgga zzgga) {
        return zzgga.zzk(zzggy.zzn(obj, (long) (i & 1048575)));
    }

    private final void zzC(Object obj, int i, zzgfv zzgfv) throws IOException {
        if (zzG(i)) {
            zzggy.zzo(obj, (long) (i & 1048575), zzgfv.zzn());
        } else if (this.zzi) {
            zzggy.zzo(obj, (long) (i & 1048575), zzgfv.zzm());
        } else {
            zzggy.zzo(obj, (long) (i & 1048575), zzgfv.zzq());
        }
    }

    private final int zzD(int i) {
        return this.zzc[i + 1];
    }

    private final int zzE(int i) {
        return this.zzc[i + 2];
    }

    public static int zzF(int i) {
        return (i >>> 20) & 255;
    }

    public static boolean zzG(int i) {
        return (i & DriveFile.MODE_WRITE_ONLY) != 0;
    }

    public static <T> double zzH(T t, long j) {
        return ((Double) zzggy.zzn(t, j)).doubleValue();
    }

    public static <T> float zzI(T t, long j) {
        return ((Float) zzggy.zzn(t, j)).floatValue();
    }

    public static <T> int zzJ(T t, long j) {
        return ((Integer) zzggy.zzn(t, j)).intValue();
    }

    public static <T> long zzK(T t, long j) {
        return ((Long) zzggy.zzn(t, j)).longValue();
    }

    public static <T> boolean zzL(T t, long j) {
        return ((Boolean) zzggy.zzn(t, j)).booleanValue();
    }

    private final boolean zzM(T t, T t2, int i) {
        return zzO(t, i) == zzO(t2, i);
    }

    private final boolean zzN(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzO(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzO(T t, int i) {
        int zzE = zzE(i);
        long j = (long) (zzE & 1048575);
        if (j != 1048575) {
            return (zzggy.zzd(t, j) & (1 << (zzE >>> 20))) != 0;
        }
        int zzD = zzD(i);
        long j2 = (long) (zzD & 1048575);
        switch (zzF(zzD)) {
            case 0:
                return zzggy.zzl(t, j2) != RoundRectDrawableWithShadow.COS_45;
            case 1:
                return zzggy.zzj(t, j2) != 0.0f;
            case 2:
                return zzggy.zzf(t, j2) != 0;
            case 3:
                return zzggy.zzf(t, j2) != 0;
            case 4:
                return zzggy.zzd(t, j2) != 0;
            case 5:
                return zzggy.zzf(t, j2) != 0;
            case 6:
                return zzggy.zzd(t, j2) != 0;
            case 7:
                return zzggy.zzh(t, j2);
            case 8:
                Object zzn2 = zzggy.zzn(t, j2);
                if (zzn2 instanceof String) {
                    return !((String) zzn2).isEmpty();
                }
                if (zzn2 instanceof zzgcz) {
                    return !zzgcz.zzb.equals(zzn2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzggy.zzn(t, j2) != null;
            case 10:
                return !zzgcz.zzb.equals(zzggy.zzn(t, j2));
            case 11:
                return zzggy.zzd(t, j2) != 0;
            case 12:
                return zzggy.zzd(t, j2) != 0;
            case 13:
                return zzggy.zzd(t, j2) != 0;
            case 14:
                return zzggy.zzf(t, j2) != 0;
            case 15:
                return zzggy.zzd(t, j2) != 0;
            case 16:
                return zzggy.zzf(t, j2) != 0;
            case 17:
                return zzggy.zzn(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzP(T t, int i) {
        int zzE = zzE(i);
        long j = (long) (1048575 & zzE);
        if (j != 1048575) {
            zzggy.zze(t, j, (1 << (zzE >>> 20)) | zzggy.zzd(t, j));
        }
    }

    private final boolean zzQ(T t, int i, int i2) {
        return zzggy.zzd(t, (long) (zzE(i2) & 1048575)) == i;
    }

    private final void zzR(T t, int i, int i2) {
        zzggy.zze(t, (long) (zzE(i2) & 1048575), i);
    }

    private final int zzS(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzU(i, 0);
    }

    private final int zzT(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzU(i, i2);
    }

    private final int zzU(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final void zzV(T t, zzgdk zzgdk) throws IOException {
        int i;
        T t2 = t;
        zzgdk zzgdk2 = zzgdk;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i2 = 1048575;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1048575;
            while (i3 < length) {
                int zzD = zzD(i3);
                int i6 = this.zzc[i3];
                int zzF = zzF(zzD);
                if (zzF <= 17) {
                    int i7 = this.zzc[i3 + 2];
                    int i8 = i7 & i2;
                    if (i8 != i5) {
                        i4 = unsafe.getInt(t2, (long) i8);
                        i5 = i8;
                    }
                    i = 1 << (i7 >>> 20);
                } else {
                    i = 0;
                }
                long j = (long) (zzD & i2);
                switch (zzF) {
                    case 0:
                        if ((i4 & i) == 0) {
                            break;
                        } else {
                            zzgdk2.zzf(i6, zzggy.zzl(t2, j));
                            continue;
                        }
                    case 1:
                        if ((i4 & i) != 0) {
                            zzgdk2.zze(i6, zzggy.zzj(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzc(i6, unsafe.getLong(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzh(i6, unsafe.getLong(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzi(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzj(i6, unsafe.getLong(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzk(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzl(i6, zzggy.zzh(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if ((i4 & i) != 0) {
                            zzX(i6, unsafe.getObject(t2, j), zzgdk2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzr(i6, unsafe.getObject(t2, j), zzw(i3));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzn(i6, (zzgcz) unsafe.getObject(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzo(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzg(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzb(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzd(i6, unsafe.getLong(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzp(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzq(i6, unsafe.getLong(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if ((i4 & i) != 0) {
                            zzgdk2.zzs(i6, unsafe.getObject(t2, j), zzw(i3));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        zzggc.zzJ(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        continue;
                    case 19:
                        zzggc.zzK(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        continue;
                    case 20:
                        zzggc.zzL(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        continue;
                    case 21:
                        zzggc.zzM(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        continue;
                    case 22:
                        zzggc.zzQ(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        continue;
                    case 23:
                        zzggc.zzO(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        continue;
                    case 24:
                        zzggc.zzT(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        continue;
                    case 25:
                        zzggc.zzW(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        continue;
                    case 26:
                        zzggc.zzX(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2);
                        break;
                    case 27:
                        zzggc.zzZ(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, zzw(i3));
                        break;
                    case 28:
                        zzggc.zzY(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2);
                        break;
                    case 29:
                        zzggc.zzR(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        break;
                    case 30:
                        zzggc.zzV(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        break;
                    case 31:
                        zzggc.zzU(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        break;
                    case 32:
                        zzggc.zzP(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        break;
                    case 33:
                        zzggc.zzS(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        break;
                    case 34:
                        zzggc.zzN(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, false);
                        break;
                    case 35:
                        zzggc.zzJ(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 36:
                        zzggc.zzK(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 37:
                        zzggc.zzL(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 38:
                        zzggc.zzM(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 39:
                        zzggc.zzQ(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 40:
                        zzggc.zzO(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 41:
                        zzggc.zzT(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 42:
                        zzggc.zzW(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 43:
                        zzggc.zzR(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 44:
                        zzggc.zzV(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 45:
                        zzggc.zzU(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 46:
                        zzggc.zzP(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 47:
                        zzggc.zzS(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 48:
                        zzggc.zzN(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, true);
                        break;
                    case 49:
                        zzggc.zzaa(this.zzc[i3], (List) unsafe.getObject(t2, j), zzgdk2, zzw(i3));
                        break;
                    case 50:
                        zzW(zzgdk2, i6, unsafe.getObject(t2, j), i3);
                        break;
                    case 51:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzf(i6, zzH(t2, j));
                            break;
                        }
                        break;
                    case 52:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zze(i6, zzI(t2, j));
                            break;
                        }
                        break;
                    case 53:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzc(i6, zzK(t2, j));
                            break;
                        }
                        break;
                    case 54:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzh(i6, zzK(t2, j));
                            break;
                        }
                        break;
                    case 55:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzi(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 56:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzj(i6, zzK(t2, j));
                            break;
                        }
                        break;
                    case 57:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzk(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 58:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzl(i6, zzL(t2, j));
                            break;
                        }
                        break;
                    case 59:
                        if (zzQ(t2, i6, i3)) {
                            zzX(i6, unsafe.getObject(t2, j), zzgdk2);
                            break;
                        }
                        break;
                    case 60:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzr(i6, unsafe.getObject(t2, j), zzw(i3));
                            break;
                        }
                        break;
                    case 61:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzn(i6, (zzgcz) unsafe.getObject(t2, j));
                            break;
                        }
                        break;
                    case 62:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzo(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 63:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzg(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 64:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzb(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 65:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzd(i6, zzK(t2, j));
                            break;
                        }
                        break;
                    case 66:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzp(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 67:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzq(i6, zzK(t2, j));
                            break;
                        }
                        break;
                    case 68:
                        if (zzQ(t2, i6, i3)) {
                            zzgdk2.zzs(i6, unsafe.getObject(t2, j), zzw(i3));
                            break;
                        }
                        break;
                }
                i3 += 3;
                i2 = 1048575;
            }
            zzggo<?, ?> zzggo = this.zzo;
            zzggo.zzr(zzggo.zzj(t2), zzgdk2);
            return;
        }
        this.zzp.zzb(t2);
        throw null;
    }

    private final <K, V> void zzW(zzgdk zzgdk, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzgfd zzgfd = (zzgfd) zzx(i2);
            throw null;
        }
    }

    public static final void zzX(int i, Object obj, zzgdk zzgdk) throws IOException {
        if (obj instanceof String) {
            zzgdk.zzm(i, (String) obj);
        } else {
            zzgdk.zzn(i, (zzgcz) obj);
        }
    }

    public static zzggp zzg(Object obj) {
        zzgec zzgec = (zzgec) obj;
        zzggp zzggp = zzgec.zzc;
        if (zzggp != zzggp.zza()) {
            return zzggp;
        }
        zzggp zzb2 = zzggp.zzb();
        zzgec.zzc = zzb2;
        return zzb2;
    }

    public static <T> zzgfn<T> zzl(Class<T> cls, zzgfh zzgfh, zzgfp zzgfp, zzgey zzgey, zzggo<?, ?> zzggo, zzgdp<?> zzgdp, zzgff zzgff) {
        if (zzgfh instanceof zzgfu) {
            return zzm((zzgfu) zzgfh, zzgfp, zzgey, zzggo, zzgdp, zzgff);
        }
        zzggl zzggl = (zzggl) zzgfh;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0378  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.google.android.gms.internal.ads.zzgfn<T> zzm(com.google.android.gms.internal.ads.zzgfu r33, com.google.android.gms.internal.ads.zzgfp r34, com.google.android.gms.internal.ads.zzgey r35, com.google.android.gms.internal.ads.zzggo<?, ?> r36, com.google.android.gms.internal.ads.zzgdp<?> r37, com.google.android.gms.internal.ads.zzgff r38) {
        /*
            int r0 = r33.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = 0
        L_0x000b:
            java.lang.String r0 = r33.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0056
            int[] r6 = zza
            r13 = r6
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            goto L_0x0165
        L_0x0056:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0062:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0072
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0062
        L_0x0072:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0075:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0094
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0081:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0091
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0081
        L_0x0091:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0094:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b0
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a0
        L_0x00b0:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b3:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r32 = r12
            r12 = r9
            r9 = r32
        L_0x0165:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r33.zze()
            com.google.android.gms.internal.ads.zzgfk r18 = r33.zzb()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0183:
            if (r4 >= r3) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ab
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x0193:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01a5
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x0193
        L_0x01a5:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01ad
        L_0x01ab:
            r2 = r24
        L_0x01ad:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01da
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bb:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01d4
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01bb
        L_0x01d4:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01de
        L_0x01da:
            r28 = r3
            r3 = r24
        L_0x01de:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ec
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ec:
            r14 = 51
            if (r5 < r14) goto L_0x0295
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0222
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0203:
            int r30 = r14 + 1
            char r14 = r0.charAt(r14)
            r31 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021c
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r30
            r12 = r31
            goto L_0x0203
        L_0x021c:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r30
            goto L_0x0226
        L_0x0222:
            r31 = r12
            r14 = r27
        L_0x0226:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0247
            r14 = 17
            if (r12 != r14) goto L_0x0233
            goto L_0x0247
        L_0x0233:
            r14 = 12
            if (r12 != r14) goto L_0x0256
            if (r10 != 0) goto L_0x0256
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0254
        L_0x0247:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0254:
            r16 = r14
        L_0x0256:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0260
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0268
        L_0x0260:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzo(r1, r12)
            r17[r3] = r12
        L_0x0268:
            r30 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r8 = (int) r7
            int r3 = r3 + 1
            r7 = r17[r3]
            boolean r12 = r7 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027b
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0283
        L_0x027b:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzo(r1, r7)
            r17[r3] = r7
        L_0x0283:
            r3 = r8
            long r7 = r15.objectFieldOffset(r7)
            int r8 = (int) r7
            r26 = r1
            r1 = r8
            r29 = r11
            r25 = 1
            r11 = r0
            r8 = r3
            r3 = 0
            goto L_0x0391
        L_0x0295:
            r30 = r7
            r14 = r8
            r31 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzo(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030d
            r12 = 17
            if (r5 != r12) goto L_0x02ad
            goto L_0x030d
        L_0x02ad:
            r12 = 27
            if (r5 == r12) goto L_0x02fd
            r12 = 49
            if (r5 != r12) goto L_0x02b6
            goto L_0x02fd
        L_0x02b6:
            r12 = 12
            if (r5 == r12) goto L_0x02ed
            r12 = 30
            if (r5 == r12) goto L_0x02ed
            r12 = 44
            if (r5 != r12) goto L_0x02c3
            goto L_0x02ed
        L_0x02c3:
            r12 = 50
            if (r5 != r12) goto L_0x02e3
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e6
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e3:
            r25 = 1
            goto L_0x031a
        L_0x02e6:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031b
        L_0x02ed:
            if (r10 != 0) goto L_0x02e3
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030a
        L_0x02fd:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030a:
            r12 = r27
            goto L_0x031b
        L_0x030d:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031a:
            r12 = r7
        L_0x031b:
            long r7 = r15.objectFieldOffset(r8)
            int r8 = (int) r7
            r7 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r7 != r11) goto L_0x0378
            r7 = 17
            if (r5 > r7) goto L_0x0378
            int r7 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0354
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033e:
            int r27 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r11) goto L_0x0350
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r26
            r3 = r3 | r7
            int r26 = r26 + 13
            r7 = r27
            goto L_0x033e
        L_0x0350:
            int r7 = r7 << r26
            r3 = r3 | r7
            goto L_0x0356
        L_0x0354:
            r27 = r7
        L_0x0356:
            int r7 = r6 + r6
            int r26 = r3 / 32
            int r26 = r26 + r7
            r7 = r17[r26]
            boolean r11 = r7 instanceof java.lang.reflect.Field
            if (r11 == 0) goto L_0x0365
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x036d
        L_0x0365:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzo(r1, r7)
            r17[r26] = r7
        L_0x036d:
            r11 = r0
            r26 = r1
            long r0 = r15.objectFieldOffset(r7)
            int r1 = (int) r0
            int r3 = r3 % 32
            goto L_0x0381
        L_0x0378:
            r11 = r0
            r26 = r1
            r27 = r3
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r3 = 0
        L_0x0381:
            r0 = 18
            if (r5 < r0) goto L_0x038f
            r0 = 49
            if (r5 > r0) goto L_0x038f
            int r0 = r23 + 1
            r13[r23] = r8
            r23 = r0
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r0 = r9 + 1
            r30[r9] = r4
            int r4 = r0 + 1
            r7 = r2 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x039e
            r7 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r7 = 0
        L_0x039f:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03a6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r2 = 0
        L_0x03a7:
            r2 = r2 | r7
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r8
            r30[r0] = r2
            int r9 = r4 + 1
            int r0 = r3 << 20
            r0 = r0 | r1
            r30[r4] = r0
            r0 = r11
            r8 = r14
            r14 = r24
            r1 = r26
            r4 = r27
            r3 = r28
            r11 = r29
            r7 = r30
            r12 = r31
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0183
        L_0x03ca:
            r30 = r7
            r29 = r11
            r31 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.ads.zzgfn r0 = new com.google.android.gms.internal.ads.zzgfn
            r4 = r0
            com.google.android.gms.internal.ads.zzgfk r9 = r33.zzb()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r30
            r6 = r1
            r7 = r14
            r8 = r31
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r34
            r16 = r35
            r17 = r36
            r18 = r37
            r19 = r38
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgfn.zzm(com.google.android.gms.internal.ads.zzgfu, com.google.android.gms.internal.ads.zzgfp, com.google.android.gms.internal.ads.zzgey, com.google.android.gms.internal.ads.zzggo, com.google.android.gms.internal.ads.zzgdp, com.google.android.gms.internal.ads.zzgff):com.google.android.gms.internal.ads.zzgfn");
    }

    public static Field zzo(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(str).length(), 40, name.length(), String.valueOf(arrays).length()));
            GeneratedOutlineSupport.outline34(sb, "Field ", str, " for ", name);
            throw new RuntimeException(GeneratedOutlineSupport.outline18(sb, " not found. Known fields are ", arrays));
        }
    }

    private final void zzp(T t, T t2, int i) {
        long zzD = (long) (zzD(i) & 1048575);
        if (zzO(t2, i)) {
            Object zzn2 = zzggy.zzn(t, zzD);
            Object zzn3 = zzggy.zzn(t2, zzD);
            if (zzn2 != null && zzn3 != null) {
                zzggy.zzo(t, zzD, zzgem.zzi(zzn2, zzn3));
                zzP(t, i);
            } else if (zzn3 != null) {
                zzggy.zzo(t, zzD, zzn3);
                zzP(t, i);
            }
        }
    }

    private final void zzq(T t, T t2, int i) {
        int zzD = zzD(i);
        int i2 = this.zzc[i];
        long j = (long) (zzD & 1048575);
        if (zzQ(t2, i2, i)) {
            Object zzn2 = zzQ(t, i2, i) ? zzggy.zzn(t, j) : null;
            Object zzn3 = zzggy.zzn(t2, j);
            if (zzn2 != null && zzn3 != null) {
                zzggy.zzo(t, j, zzgem.zzi(zzn2, zzn3));
                zzR(t, i2, i);
            } else if (zzn3 != null) {
                zzggy.zzo(t, j, zzn3);
                zzR(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0304, code lost:
        r9 = (r9 + r8) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x04a4, code lost:
        r9 = (r9 + r7) + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x04a6, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04c0, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04eb, code lost:
        r7 = r7 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0512, code lost:
        r4 = (r8 + r7) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0520, code lost:
        r7 = r7 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x052d, code lost:
        r7 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0530, code lost:
        r3 = r3 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzr(T r15) {
        /*
            r14 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x000c:
            int[] r7 = r14.zzc
            int r7 = r7.length
            if (r3 >= r7) goto L_0x0534
            int r7 = r14.zzD(r3)
            int[] r8 = r14.zzc
            r8 = r8[r3]
            int r9 = zzF(r7)
            r10 = 17
            r11 = 1
            if (r9 > r10) goto L_0x0037
            int[] r10 = r14.zzc
            int r12 = r3 + 2
            r10 = r10[r12]
            r12 = r10 & r1
            int r10 = r10 >>> 20
            int r10 = r11 << r10
            if (r12 == r6) goto L_0x0038
            long r5 = (long) r12
            int r5 = r0.getInt(r15, r5)
            r6 = r12
            goto L_0x0038
        L_0x0037:
            r10 = 0
        L_0x0038:
            r7 = r7 & r1
            long r12 = (long) r7
            r7 = 63
            switch(r9) {
                case 0: goto L_0x0523;
                case 1: goto L_0x0516;
                case 2: goto L_0x0500;
                case 3: goto L_0x04ed;
                case 4: goto L_0x04d9;
                case 5: goto L_0x04ce;
                case 6: goto L_0x04c3;
                case 7: goto L_0x04b6;
                case 8: goto L_0x0488;
                case 9: goto L_0x0476;
                case 10: goto L_0x045d;
                case 11: goto L_0x0449;
                case 12: goto L_0x0435;
                case 13: goto L_0x0429;
                case 14: goto L_0x041d;
                case 15: goto L_0x0404;
                case 16: goto L_0x03ec;
                case 17: goto L_0x03d8;
                case 18: goto L_0x03cc;
                case 19: goto L_0x03c0;
                case 20: goto L_0x03b4;
                case 21: goto L_0x03a8;
                case 22: goto L_0x039c;
                case 23: goto L_0x0390;
                case 24: goto L_0x0384;
                case 25: goto L_0x0378;
                case 26: goto L_0x036c;
                case 27: goto L_0x035c;
                case 28: goto L_0x0350;
                case 29: goto L_0x0344;
                case 30: goto L_0x0338;
                case 31: goto L_0x032c;
                case 32: goto L_0x0320;
                case 33: goto L_0x0314;
                case 34: goto L_0x0308;
                case 35: goto L_0x02f0;
                case 36: goto L_0x02db;
                case 37: goto L_0x02c6;
                case 38: goto L_0x02b1;
                case 39: goto L_0x029c;
                case 40: goto L_0x0287;
                case 41: goto L_0x0271;
                case 42: goto L_0x025b;
                case 43: goto L_0x0245;
                case 44: goto L_0x022f;
                case 45: goto L_0x0219;
                case 46: goto L_0x0203;
                case 47: goto L_0x01ed;
                case 48: goto L_0x01d7;
                case 49: goto L_0x01c7;
                case 50: goto L_0x01ba;
                case 51: goto L_0x01ac;
                case 52: goto L_0x019e;
                case 53: goto L_0x0188;
                case 54: goto L_0x0172;
                case 55: goto L_0x015c;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0132;
                case 59: goto L_0x0104;
                case 60: goto L_0x00f0;
                case 61: goto L_0x00d4;
                case 62: goto L_0x00be;
                case 63: goto L_0x00a8;
                case 64: goto L_0x009a;
                case 65: goto L_0x008c;
                case 66: goto L_0x0071;
                case 67: goto L_0x0057;
                case 68: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0530
        L_0x0041:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzgfk r7 = (com.google.android.gms.internal.ads.zzgfk) r7
            com.google.android.gms.internal.ads.zzgga r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzE(r8, r7, r9)
            goto L_0x052f
        L_0x0057:
            boolean r9 = r14.zzQ(r15, r8, r3)
            if (r9 == 0) goto L_0x0530
            long r9 = zzK(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzx(r9)
            goto L_0x04eb
        L_0x0071:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = zzJ(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x04eb
        L_0x008c:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x052d
        L_0x009a:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0520
        L_0x00a8:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = zzJ(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzv(r7)
            goto L_0x04eb
        L_0x00be:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = zzJ(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x04eb
        L_0x00d4:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzgcz r7 = (com.google.android.gms.internal.ads.zzgcz) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x04a4
        L_0x00f0:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzgga r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzggc.zzw(r8, r7, r9)
            goto L_0x052f
        L_0x0104:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.ads.zzgcz
            if (r9 == 0) goto L_0x0124
            com.google.android.gms.internal.ads.zzgcz r7 = (com.google.android.gms.internal.ads.zzgcz) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x04a4
        L_0x0124:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzy(r7)
            goto L_0x04eb
        L_0x0132:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x04c0
        L_0x0140:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0520
        L_0x014e:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x052d
        L_0x015c:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = zzJ(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzv(r7)
            goto L_0x04eb
        L_0x0172:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            long r9 = zzK(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzx(r9)
            goto L_0x0512
        L_0x0188:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            long r9 = zzK(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzx(r9)
            goto L_0x0512
        L_0x019e:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0520
        L_0x01ac:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x052d
        L_0x01ba:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.zzx(r3)
            com.google.android.gms.internal.ads.zzgff.zza(r8, r7, r9)
            goto L_0x0530
        L_0x01c7:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzgga r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzggc.zzz(r8, r7, r9)
            goto L_0x052f
        L_0x01d7:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzf(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x01ed:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzn(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x0203:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzr(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x0219:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzp(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x022f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzh(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x0245:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzl(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x025b:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzt(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x0271:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzp(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x0287:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzr(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x029c:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzj(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x02b1:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzd(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x02c6:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzb(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x02db:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzp(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0304
        L_0x02f0:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzr(r7)
            if (r7 <= 0) goto L_0x0530
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
        L_0x0304:
            int r9 = r9 + r8
            int r9 = r9 + r7
            goto L_0x04a6
        L_0x0308:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzg(r8, r7, r2)
            goto L_0x052f
        L_0x0314:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzo(r8, r7, r2)
            goto L_0x052f
        L_0x0320:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzs(r8, r7, r2)
            goto L_0x052f
        L_0x032c:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzq(r8, r7, r2)
            goto L_0x052f
        L_0x0338:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzi(r8, r7, r2)
            goto L_0x052f
        L_0x0344:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzm(r8, r7, r2)
            goto L_0x052f
        L_0x0350:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzy(r8, r7)
            goto L_0x052f
        L_0x035c:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzgga r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzggc.zzx(r8, r7, r9)
            goto L_0x052f
        L_0x036c:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzv(r8, r7)
            goto L_0x052f
        L_0x0378:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzu(r8, r7, r2)
            goto L_0x052f
        L_0x0384:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzq(r8, r7, r2)
            goto L_0x052f
        L_0x0390:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzs(r8, r7, r2)
            goto L_0x052f
        L_0x039c:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzk(r8, r7, r2)
            goto L_0x052f
        L_0x03a8:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zze(r8, r7, r2)
            goto L_0x052f
        L_0x03b4:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzc(r8, r7, r2)
            goto L_0x052f
        L_0x03c0:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzq(r8, r7, r2)
            goto L_0x052f
        L_0x03cc:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzggc.zzs(r8, r7, r2)
            goto L_0x052f
        L_0x03d8:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzgfk r7 = (com.google.android.gms.internal.ads.zzgfk) r7
            com.google.android.gms.internal.ads.zzgga r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzE(r8, r7, r9)
            goto L_0x052f
        L_0x03ec:
            r9 = r5 & r10
            if (r9 == 0) goto L_0x0530
            long r9 = r0.getLong(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzx(r9)
            goto L_0x04eb
        L_0x0404:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x04eb
        L_0x041d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x052d
        L_0x0429:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0520
        L_0x0435:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzv(r7)
            goto L_0x04eb
        L_0x0449:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x04eb
        L_0x045d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzgcz r7 = (com.google.android.gms.internal.ads.zzgcz) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x04a4
        L_0x0476:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzgga r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzggc.zzw(r8, r7, r9)
            goto L_0x052f
        L_0x0488:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.ads.zzgcz
            if (r9 == 0) goto L_0x04a9
            com.google.android.gms.internal.ads.zzgcz r7 = (com.google.android.gms.internal.ads.zzgcz) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
        L_0x04a4:
            int r9 = r9 + r7
            int r9 = r9 + r8
        L_0x04a6:
            int r4 = r4 + r9
            goto L_0x0530
        L_0x04a9:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzy(r7)
            goto L_0x04eb
        L_0x04b6:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
        L_0x04c0:
            int r7 = r7 + r11
            goto L_0x052f
        L_0x04c3:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x0520
        L_0x04ce:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            goto L_0x052d
        L_0x04d9:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzv(r7)
        L_0x04eb:
            int r7 = r7 + r8
            goto L_0x052f
        L_0x04ed:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzx(r9)
            goto L_0x0512
        L_0x0500:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
            int r8 = com.google.android.gms.internal.ads.zzgdj.zzx(r9)
        L_0x0512:
            int r8 = r8 + r7
            int r8 = r8 + r4
            r4 = r8
            goto L_0x0530
        L_0x0516:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
        L_0x0520:
            int r7 = r7 + 4
            goto L_0x052f
        L_0x0523:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0530
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgdj.zzw(r7)
        L_0x052d:
            int r7 = r7 + 8
        L_0x052f:
            int r4 = r4 + r7
        L_0x0530:
            int r3 = r3 + 3
            goto L_0x000c
        L_0x0534:
            com.google.android.gms.internal.ads.zzggo<?, ?> r0 = r14.zzo
            java.lang.Object r1 = r0.zzj(r15)
            int r0 = r0.zzq(r1)
            int r0 = r0 + r4
            boolean r1 = r14.zzh
            if (r1 != 0) goto L_0x0544
            return r0
        L_0x0544:
            com.google.android.gms.internal.ads.zzgdp<?> r0 = r14.zzp
            r0.zzb(r15)
            r15 = 0
            goto L_0x054c
        L_0x054b:
            throw r15
        L_0x054c:
            goto L_0x054b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgfn.zzr(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r6 = (r6 + r5) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x04b1, code lost:
        r6 = (r6 + r4) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x04b3, code lost:
        r3 = r3 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04cf, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0501, code lost:
        r4 = r4 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x052c, code lost:
        r4 = r4 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x053a, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0549, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x054c, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzs(T r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0550
            int r4 = r11.zzD(r2)
            int r5 = zzF(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.ads.zzgdu r4 = com.google.android.gms.internal.ads.zzgdu.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.ads.zzgdu r4 = com.google.android.gms.internal.ads.zzgdu.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x053d;
                case 1: goto L_0x052e;
                case 2: goto L_0x0518;
                case 3: goto L_0x0503;
                case 4: goto L_0x04ed;
                case 5: goto L_0x04e0;
                case 6: goto L_0x04d3;
                case 7: goto L_0x04c3;
                case 8: goto L_0x0493;
                case 9: goto L_0x047f;
                case 10: goto L_0x0464;
                case 11: goto L_0x044e;
                case 12: goto L_0x0438;
                case 13: goto L_0x042a;
                case 14: goto L_0x041c;
                case 15: goto L_0x0401;
                case 16: goto L_0x03e6;
                case 17: goto L_0x03d0;
                case 18: goto L_0x03c4;
                case 19: goto L_0x03b8;
                case 20: goto L_0x03ac;
                case 21: goto L_0x03a0;
                case 22: goto L_0x0394;
                case 23: goto L_0x0388;
                case 24: goto L_0x037c;
                case 25: goto L_0x0370;
                case 26: goto L_0x0364;
                case 27: goto L_0x0354;
                case 28: goto L_0x0348;
                case 29: goto L_0x033c;
                case 30: goto L_0x0330;
                case 31: goto L_0x0324;
                case 32: goto L_0x0318;
                case 33: goto L_0x030c;
                case 34: goto L_0x0300;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x054c
        L_0x0038:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzgfk r4 = (com.google.android.gms.internal.ads.zzgfk) r4
            com.google.android.gms.internal.ads.zzgga r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzE(r6, r4, r5)
            goto L_0x054b
        L_0x004e:
            boolean r5 = r11.zzQ(r12, r6, r2)
            if (r5 == 0) goto L_0x054c
            long r7 = zzK(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzx(r6)
            goto L_0x0501
        L_0x0069:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = zzJ(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x0501
        L_0x0084:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x0549
        L_0x0092:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x053a
        L_0x00a0:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = zzJ(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzv(r4)
            goto L_0x0501
        L_0x00b6:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = zzJ(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x0501
        L_0x00cc:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzgcz r4 = (com.google.android.gms.internal.ads.zzgcz) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x04b1
        L_0x00e8:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzgga r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzggc.zzw(r6, r4, r5)
            goto L_0x054b
        L_0x00fc:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzgcz
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.ads.zzgcz r4 = (com.google.android.gms.internal.ads.zzgcz) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x04b1
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzy(r4)
            goto L_0x0501
        L_0x012a:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x04cf
        L_0x0138:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x053a
        L_0x0146:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x0549
        L_0x0154:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = zzJ(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzv(r4)
            goto L_0x0501
        L_0x016a:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            long r4 = zzK(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r6)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzx(r4)
            goto L_0x052c
        L_0x0180:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            long r4 = zzK(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r6)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzx(r4)
            goto L_0x052c
        L_0x0196:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x053a
        L_0x01a4:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x0549
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.lang.Object r5 = r11.zzx(r2)
            com.google.android.gms.internal.ads.zzgff.zza(r6, r4, r5)
            goto L_0x054c
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzgga r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzggc.zzz(r6, r4, r5)
            goto L_0x054b
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzf(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzn(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzr(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzp(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzh(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzl(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzt(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzp(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzr(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzj(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzd(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzb(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzp(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzr(r4)
            if (r4 <= 0) goto L_0x054c
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
        L_0x02fc:
            int r6 = r6 + r5
            int r6 = r6 + r4
            goto L_0x04b3
        L_0x0300:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzg(r6, r4, r1)
            goto L_0x054b
        L_0x030c:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzo(r6, r4, r1)
            goto L_0x054b
        L_0x0318:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzs(r6, r4, r1)
            goto L_0x054b
        L_0x0324:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzq(r6, r4, r1)
            goto L_0x054b
        L_0x0330:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzi(r6, r4, r1)
            goto L_0x054b
        L_0x033c:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzm(r6, r4, r1)
            goto L_0x054b
        L_0x0348:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzy(r6, r4)
            goto L_0x054b
        L_0x0354:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzgga r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzggc.zzx(r6, r4, r5)
            goto L_0x054b
        L_0x0364:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzv(r6, r4)
            goto L_0x054b
        L_0x0370:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzu(r6, r4, r1)
            goto L_0x054b
        L_0x037c:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzq(r6, r4, r1)
            goto L_0x054b
        L_0x0388:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzs(r6, r4, r1)
            goto L_0x054b
        L_0x0394:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzk(r6, r4, r1)
            goto L_0x054b
        L_0x03a0:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zze(r6, r4, r1)
            goto L_0x054b
        L_0x03ac:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzc(r6, r4, r1)
            goto L_0x054b
        L_0x03b8:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzq(r6, r4, r1)
            goto L_0x054b
        L_0x03c4:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzggc.zzs(r6, r4, r1)
            goto L_0x054b
        L_0x03d0:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzgfk r4 = (com.google.android.gms.internal.ads.zzgfk) r4
            com.google.android.gms.internal.ads.zzgga r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzE(r6, r4, r5)
            goto L_0x054b
        L_0x03e6:
            boolean r5 = r11.zzO(r12, r2)
            if (r5 == 0) goto L_0x054c
            long r7 = com.google.android.gms.internal.ads.zzggy.zzf(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzx(r6)
            goto L_0x0501
        L_0x0401:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = com.google.android.gms.internal.ads.zzggy.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x0501
        L_0x041c:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x0549
        L_0x042a:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x053a
        L_0x0438:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = com.google.android.gms.internal.ads.zzggy.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzv(r4)
            goto L_0x0501
        L_0x044e:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = com.google.android.gms.internal.ads.zzggy.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x0501
        L_0x0464:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzgcz r4 = (com.google.android.gms.internal.ads.zzgcz) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x04b1
        L_0x047f:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzgga r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzggc.zzw(r6, r4, r5)
            goto L_0x054b
        L_0x0493:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzggy.zzn(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzgcz
            if (r5 == 0) goto L_0x04b6
            com.google.android.gms.internal.ads.zzgcz r4 = (com.google.android.gms.internal.ads.zzgcz) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
        L_0x04b1:
            int r6 = r6 + r4
            int r6 = r6 + r5
        L_0x04b3:
            int r3 = r3 + r6
            goto L_0x054c
        L_0x04b6:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzy(r4)
            goto L_0x0501
        L_0x04c3:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
        L_0x04cf:
            int r4 = r4 + 1
            goto L_0x054b
        L_0x04d3:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x053a
        L_0x04e0:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
            goto L_0x0549
        L_0x04ed:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = com.google.android.gms.internal.ads.zzggy.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgdj.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzv(r4)
        L_0x0501:
            int r4 = r4 + r5
            goto L_0x054b
        L_0x0503:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            long r4 = com.google.android.gms.internal.ads.zzggy.zzf(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r6)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzx(r4)
            goto L_0x052c
        L_0x0518:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            long r4 = com.google.android.gms.internal.ads.zzggy.zzf(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgdj.zzw(r6)
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzx(r4)
        L_0x052c:
            int r4 = r4 + r6
            goto L_0x054b
        L_0x052e:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
        L_0x053a:
            int r4 = r4 + 4
            goto L_0x054b
        L_0x053d:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x054c
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgdj.zzw(r4)
        L_0x0549:
            int r4 = r4 + 8
        L_0x054b:
            int r3 = r3 + r4
        L_0x054c:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0550:
            com.google.android.gms.internal.ads.zzggo<?, ?> r0 = r11.zzo
            java.lang.Object r12 = r0.zzj(r12)
            int r12 = r0.zzq(r12)
            int r12 = r12 + r3
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgfn.zzs(java.lang.Object):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0451 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0451 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d1  */
    private final int zzt(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.ads.zzgcm r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzgel r11 = (com.google.android.gms.internal.ads.zzgel) r11
            boolean r12 = r11.zza()
            if (r12 != 0) goto L_0x0034
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002a
            r12 = 10
            goto L_0x002b
        L_0x002a:
            int r12 = r12 + r12
        L_0x002b:
            com.google.android.gms.internal.ads.zzgel r11 = r11.zze(r12)
            sun.misc.Unsafe r12 = zzb
            r12.putObject(r1, r9, r11)
        L_0x0034:
            r9 = 5
            r12 = 0
            r10 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e3;
                case 19: goto L_0x0396;
                case 20: goto L_0x0353;
                case 21: goto L_0x0353;
                case 22: goto L_0x0338;
                case 23: goto L_0x02f7;
                case 24: goto L_0x02b6;
                case 25: goto L_0x025c;
                case 26: goto L_0x01a9;
                case 27: goto L_0x018e;
                case 28: goto L_0x0134;
                case 29: goto L_0x0338;
                case 30: goto L_0x00fc;
                case 31: goto L_0x02b6;
                case 32: goto L_0x02f7;
                case 33: goto L_0x00ad;
                case 34: goto L_0x005e;
                case 35: goto L_0x03e3;
                case 36: goto L_0x0396;
                case 37: goto L_0x0353;
                case 38: goto L_0x0353;
                case 39: goto L_0x0338;
                case 40: goto L_0x02f7;
                case 41: goto L_0x02b6;
                case 42: goto L_0x025c;
                case 43: goto L_0x0338;
                case 44: goto L_0x00fc;
                case 45: goto L_0x02b6;
                case 46: goto L_0x02f7;
                case 47: goto L_0x00ad;
                case 48: goto L_0x005e;
                default: goto L_0x003c;
            }
        L_0x003c:
            r1 = 3
            if (r6 != r1) goto L_0x0451
            com.google.android.gms.internal.ads.zzgga r1 = r15.zzw(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.ads.zzgcn.zzj(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x042f
        L_0x005e:
            if (r6 != r14) goto L_0x0082
            com.google.android.gms.internal.ads.zzgez r11 = (com.google.android.gms.internal.ads.zzgez) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0069:
            if (r1 >= r2) goto L_0x0079
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzc(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.ads.zzgde.zzH(r4)
            r11.zzg(r4)
            goto L_0x0069
        L_0x0079:
            if (r1 != r2) goto L_0x007d
            goto L_0x0452
        L_0x007d:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r1
        L_0x0082:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.ads.zzgez r11 = (com.google.android.gms.internal.ads.zzgez) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzc(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.ads.zzgde.zzH(r8)
            r11.zzg(r8)
        L_0x0093:
            if (r1 >= r5) goto L_0x00ac
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009e
            goto L_0x00ac
        L_0x009e:
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzc(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.ads.zzgde.zzH(r8)
            r11.zzg(r8)
            goto L_0x0093
        L_0x00ac:
            return r1
        L_0x00ad:
            if (r6 != r14) goto L_0x00d1
            com.google.android.gms.internal.ads.zzged r11 = (com.google.android.gms.internal.ads.zzged) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b8:
            if (r1 >= r2) goto L_0x00c8
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgde.zzG(r4)
            r11.zzh(r4)
            goto L_0x00b8
        L_0x00c8:
            if (r1 != r2) goto L_0x00cc
            goto L_0x0452
        L_0x00cc:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r1
        L_0x00d1:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.ads.zzged r11 = (com.google.android.gms.internal.ads.zzged) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgde.zzG(r4)
            r11.zzh(r4)
        L_0x00e2:
            if (r1 >= r5) goto L_0x00fb
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00ed
            goto L_0x00fb
        L_0x00ed:
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgde.zzG(r4)
            r11.zzh(r4)
            goto L_0x00e2
        L_0x00fb:
            return r1
        L_0x00fc:
            if (r6 != r14) goto L_0x0103
            int r2 = com.google.android.gms.internal.ads.zzgcn.zzl(r3, r4, r11, r7)
            goto L_0x0114
        L_0x0103:
            if (r6 != 0) goto L_0x0451
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r11
            r7 = r29
            int r2 = com.google.android.gms.internal.ads.zzgcn.zzk(r2, r3, r4, r5, r6, r7)
        L_0x0114:
            com.google.android.gms.internal.ads.zzgec r1 = (com.google.android.gms.internal.ads.zzgec) r1
            com.google.android.gms.internal.ads.zzggp r3 = r1.zzc
            com.google.android.gms.internal.ads.zzggp r4 = com.google.android.gms.internal.ads.zzggp.zza()
            if (r3 != r4) goto L_0x011f
            r3 = 0
        L_0x011f:
            com.google.android.gms.internal.ads.zzgeg r4 = r15.zzy(r8)
            com.google.android.gms.internal.ads.zzggo<?, ?> r5 = r0.zzo
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggc.zzG(r6, r11, r4, r3, r5)
            if (r3 != 0) goto L_0x012f
            goto L_0x027d
        L_0x012f:
            com.google.android.gms.internal.ads.zzggp r3 = (com.google.android.gms.internal.ads.zzggp) r3
            r1.zzc = r3
            return r2
        L_0x0134:
            if (r6 != r14) goto L_0x0451
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0189
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0184
            if (r4 != 0) goto L_0x014a
            com.google.android.gms.internal.ads.zzgcz r4 = com.google.android.gms.internal.ads.zzgcz.zzb
            r11.add(r4)
            goto L_0x0152
        L_0x014a:
            com.google.android.gms.internal.ads.zzgcz r6 = com.google.android.gms.internal.ads.zzgcz.zzs(r3, r1, r4)
            r11.add(r6)
        L_0x0151:
            int r1 = r1 + r4
        L_0x0152:
            if (r1 >= r5) goto L_0x0183
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015d
            goto L_0x0183
        L_0x015d:
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017e
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0179
            if (r4 != 0) goto L_0x0171
            com.google.android.gms.internal.ads.zzgcz r4 = com.google.android.gms.internal.ads.zzgcz.zzb
            r11.add(r4)
            goto L_0x0152
        L_0x0171:
            com.google.android.gms.internal.ads.zzgcz r6 = com.google.android.gms.internal.ads.zzgcz.zzs(r3, r1, r4)
            r11.add(r6)
            goto L_0x0151
        L_0x0179:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r1
        L_0x017e:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zze()
            throw r1
        L_0x0183:
            return r1
        L_0x0184:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r1
        L_0x0189:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zze()
            throw r1
        L_0x018e:
            if (r6 == r14) goto L_0x0192
            goto L_0x0451
        L_0x0192:
            com.google.android.gms.internal.ads.zzgga r1 = r15.zzw(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r11
            r27 = r29
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzm(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a9:
            if (r6 != r14) goto L_0x0451
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 != 0) goto L_0x01fc
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f7
            if (r6 != 0) goto L_0x01c4
            r11.add(r1)
            goto L_0x01cf
        L_0x01c4:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzgem.zza
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01ce:
            int r4 = r4 + r6
        L_0x01cf:
            if (r4 >= r5) goto L_0x0451
            int r6 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0451
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f2
            if (r6 != 0) goto L_0x01e7
            r11.add(r1)
            goto L_0x01cf
        L_0x01e7:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzgem.zza
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01ce
        L_0x01f2:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zze()
            throw r1
        L_0x01f7:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zze()
            throw r1
        L_0x01fc:
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0257
            if (r6 != 0) goto L_0x020a
            r11.add(r1)
            goto L_0x021d
        L_0x020a:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzghd.zzb(r3, r4, r8)
            if (r9 == 0) goto L_0x0252
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzgem.zza
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x021c:
            r4 = r8
        L_0x021d:
            if (r4 >= r5) goto L_0x0451
            int r6 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0451
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x024d
            if (r6 != 0) goto L_0x0235
            r11.add(r1)
            goto L_0x021d
        L_0x0235:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzghd.zzb(r3, r4, r8)
            if (r9 == 0) goto L_0x0248
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzgem.zza
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x021c
        L_0x0248:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzl()
            throw r1
        L_0x024d:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zze()
            throw r1
        L_0x0252:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzl()
            throw r1
        L_0x0257:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zze()
            throw r1
        L_0x025c:
            r1 = 0
            if (r6 != r14) goto L_0x0285
            com.google.android.gms.internal.ads.zzgco r11 = (com.google.android.gms.internal.ads.zzgco) r11
            int r2 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0268:
            if (r2 >= r4) goto L_0x027b
            int r2 = com.google.android.gms.internal.ads.zzgcn.zzc(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r8 == 0) goto L_0x0276
            r5 = 1
            goto L_0x0277
        L_0x0276:
            r5 = 0
        L_0x0277:
            r11.zzd(r5)
            goto L_0x0268
        L_0x027b:
            if (r2 != r4) goto L_0x0280
        L_0x027d:
            r1 = r2
            goto L_0x0452
        L_0x0280:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r1
        L_0x0285:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.ads.zzgco r11 = (com.google.android.gms.internal.ads.zzgco) r11
            int r4 = com.google.android.gms.internal.ads.zzgcn.zzc(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x0295
            r6 = 1
            goto L_0x0296
        L_0x0295:
            r6 = 0
        L_0x0296:
            r11.zzd(r6)
        L_0x0299:
            if (r4 >= r5) goto L_0x02b5
            int r6 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a4
            goto L_0x02b5
        L_0x02a4:
            int r4 = com.google.android.gms.internal.ads.zzgcn.zzc(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x02b0
            r6 = 1
            goto L_0x02b1
        L_0x02b0:
            r6 = 0
        L_0x02b1:
            r11.zzd(r6)
            goto L_0x0299
        L_0x02b5:
            return r4
        L_0x02b6:
            if (r6 != r14) goto L_0x02d6
            com.google.android.gms.internal.ads.zzged r11 = (com.google.android.gms.internal.ads.zzged) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02c1:
            if (r1 >= r2) goto L_0x02cd
            int r4 = com.google.android.gms.internal.ads.zzgcn.zzd(r3, r1)
            r11.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02c1
        L_0x02cd:
            if (r1 != r2) goto L_0x02d1
            goto L_0x0452
        L_0x02d1:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r1
        L_0x02d6:
            if (r6 != r9) goto L_0x0451
            com.google.android.gms.internal.ads.zzged r11 = (com.google.android.gms.internal.ads.zzged) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzd(r17, r18)
            r11.zzh(r1)
        L_0x02e1:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f6
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ee
            goto L_0x02f6
        L_0x02ee:
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzd(r3, r4)
            r11.zzh(r1)
            goto L_0x02e1
        L_0x02f6:
            return r1
        L_0x02f7:
            if (r6 != r14) goto L_0x0317
            com.google.android.gms.internal.ads.zzgez r11 = (com.google.android.gms.internal.ads.zzgez) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0302:
            if (r1 >= r2) goto L_0x030e
            long r4 = com.google.android.gms.internal.ads.zzgcn.zze(r3, r1)
            r11.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0302
        L_0x030e:
            if (r1 != r2) goto L_0x0312
            goto L_0x0452
        L_0x0312:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r1
        L_0x0317:
            if (r6 != r10) goto L_0x0451
            com.google.android.gms.internal.ads.zzgez r11 = (com.google.android.gms.internal.ads.zzgez) r11
            long r8 = com.google.android.gms.internal.ads.zzgcn.zze(r17, r18)
            r11.zzg(r8)
        L_0x0322:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0337
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032f
            goto L_0x0337
        L_0x032f:
            long r8 = com.google.android.gms.internal.ads.zzgcn.zze(r3, r4)
            r11.zzg(r8)
            goto L_0x0322
        L_0x0337:
            return r1
        L_0x0338:
            if (r6 != r14) goto L_0x0340
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzl(r3, r4, r11, r7)
            goto L_0x0452
        L_0x0340:
            if (r6 == 0) goto L_0x0344
            goto L_0x0451
        L_0x0344:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r11
            r25 = r29
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzk(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0353:
            if (r6 != r14) goto L_0x0373
            com.google.android.gms.internal.ads.zzgez r11 = (com.google.android.gms.internal.ads.zzgez) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035e:
            if (r1 >= r2) goto L_0x036a
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzc(r3, r1, r7)
            long r4 = r7.zzb
            r11.zzg(r4)
            goto L_0x035e
        L_0x036a:
            if (r1 != r2) goto L_0x036e
            goto L_0x0452
        L_0x036e:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r1
        L_0x0373:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.ads.zzgez r11 = (com.google.android.gms.internal.ads.zzgez) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzc(r3, r4, r7)
            long r8 = r7.zzb
            r11.zzg(r8)
        L_0x0380:
            if (r1 >= r5) goto L_0x0395
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x038b
            goto L_0x0395
        L_0x038b:
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzc(r3, r4, r7)
            long r8 = r7.zzb
            r11.zzg(r8)
            goto L_0x0380
        L_0x0395:
            return r1
        L_0x0396:
            if (r6 != r14) goto L_0x03ba
            com.google.android.gms.internal.ads.zzgdv r11 = (com.google.android.gms.internal.ads.zzgdv) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03a1:
            if (r1 >= r2) goto L_0x03b1
            int r4 = com.google.android.gms.internal.ads.zzgcn.zzd(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r11.zzd(r4)
            int r1 = r1 + 4
            goto L_0x03a1
        L_0x03b1:
            if (r1 != r2) goto L_0x03b5
            goto L_0x0452
        L_0x03b5:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r1
        L_0x03ba:
            if (r6 != r9) goto L_0x0451
            com.google.android.gms.internal.ads.zzgdv r11 = (com.google.android.gms.internal.ads.zzgdv) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzd(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r11.zzd(r1)
        L_0x03c9:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e2
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d6
            goto L_0x03e2
        L_0x03d6:
            int r1 = com.google.android.gms.internal.ads.zzgcn.zzd(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r11.zzd(r1)
            goto L_0x03c9
        L_0x03e2:
            return r1
        L_0x03e3:
            if (r6 != r14) goto L_0x0406
            com.google.android.gms.internal.ads.zzgdl r11 = (com.google.android.gms.internal.ads.zzgdl) r11
            int r1 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ee:
            if (r1 >= r2) goto L_0x03fe
            long r4 = com.google.android.gms.internal.ads.zzgcn.zze(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r11.zzd(r4)
            int r1 = r1 + 8
            goto L_0x03ee
        L_0x03fe:
            if (r1 != r2) goto L_0x0401
            goto L_0x0452
        L_0x0401:
            com.google.android.gms.internal.ads.zzgeo r1 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r1
        L_0x0406:
            if (r6 != r10) goto L_0x0451
            com.google.android.gms.internal.ads.zzgdl r11 = (com.google.android.gms.internal.ads.zzgdl) r11
            long r8 = com.google.android.gms.internal.ads.zzgcn.zze(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r11.zzd(r8)
        L_0x0415:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042e
            int r4 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0422
            goto L_0x042e
        L_0x0422:
            long r8 = com.google.android.gms.internal.ads.zzgcn.zze(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r11.zzd(r8)
            goto L_0x0415
        L_0x042e:
            return r1
        L_0x042f:
            if (r4 >= r5) goto L_0x0450
            int r8 = com.google.android.gms.internal.ads.zzgcn.zza(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x043a
            goto L_0x0450
        L_0x043a:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.ads.zzgcn.zzj(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x042f
        L_0x0450:
            return r4
        L_0x0451:
            r1 = r4
        L_0x0452:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgfn.zzt(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzgcm):int");
    }

    private final <K, V> int zzu(T t, byte[] bArr, int i, int i2, int i3, long j, zzgcm zzgcm) throws IOException {
        Unsafe unsafe = zzb;
        Object zzx = zzx(i3);
        Object object = unsafe.getObject(t, j);
        if (zzgff.zzb(object)) {
            zzgfe zzc2 = zzgfe.zza().zzc();
            zzgff.zzc(zzc2, object);
            unsafe.putObject(t, j, zzc2);
        }
        zzgfd zzgfd = (zzgfd) zzx;
        throw null;
    }

    private final int zzv(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzgcm zzgcm) throws IOException {
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzgcm zzgcm2 = zzgcm;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(Double.longBitsToDouble(zzgcn.zze(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(Float.intBitsToFloat(zzgcn.zzd(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzc2 = zzgcn.zzc(bArr2, i9, zzgcm2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzgcm2.zzb));
                    unsafe.putInt(t2, j3, i11);
                    return zzc2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zza2 = zzgcn.zza(bArr2, i9, zzgcm2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzgcm2.zza));
                    unsafe.putInt(t2, j3, i11);
                    return zza2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(zzgcn.zze(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(zzgcn.zzd(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzc3 = zzgcn.zzc(bArr2, i9, zzgcm2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(zzgcm2.zzb != 0));
                    unsafe.putInt(t2, j3, i11);
                    return zzc3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zza3 = zzgcn.zza(bArr2, i9, zzgcm2);
                    int i14 = zzgcm2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & DriveFile.MODE_WRITE_ONLY) == 0 || zzghd.zzb(bArr2, zza3, zza3 + i14)) {
                        unsafe.putObject(t2, j2, new String(bArr2, zza3, i14, zzgem.zza));
                        zza3 += i14;
                    } else {
                        throw zzgeo.zzl();
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zza3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzi2 = zzgcn.zzi(zzw(i13), bArr2, i9, i2, zzgcm2);
                    Object object = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, zzgcm2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzgem.zzi(object, zzgcm2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzi2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zzh2 = zzgcn.zzh(bArr2, i9, zzgcm2);
                    unsafe.putObject(t2, j2, zzgcm2.zzc);
                    unsafe.putInt(t2, j3, i11);
                    return zzh2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zza4 = zzgcn.zza(bArr2, i9, zzgcm2);
                    int i15 = zzgcm2.zza;
                    zzgeg zzy = zzy(i13);
                    if (zzy == null || zzy.zza(i15)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i15));
                        unsafe.putInt(t2, j3, i11);
                    } else {
                        zzg(t).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zza4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zza5 = zzgcn.zza(bArr2, i9, zzgcm2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzgde.zzG(zzgcm2.zza)));
                    unsafe.putInt(t2, j3, i11);
                    return zza5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzc4 = zzgcn.zzc(bArr2, i9, zzgcm2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzgde.zzH(zzgcm2.zzb)));
                    unsafe.putInt(t2, j3, i11);
                    return zzc4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzj2 = zzgcn.zzj(zzw(i13), bArr, i, i2, (i10 & -8) | 4, zzgcm);
                    Object object2 = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j2, zzgcm2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzgem.zzi(object2, zzgcm2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzj2;
                }
                break;
        }
        return i9;
    }

    private final zzgga zzw(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgga zzgga = (zzgga) this.zzd[i3];
        if (zzgga != null) {
            return zzgga;
        }
        zzgga zzb2 = zzgfs.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzx(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzgeg zzy(int i) {
        int i2 = i / 3;
        return (zzgeg) this.zzd[i2 + i2 + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02a8, code lost:
        if (r0 != r15) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02be, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02f1, code lost:
        if (r0 != r15) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0314, code lost:
        if (r0 != r15) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x017d, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r1 = r20;
        r8 = 1048575;
        r10 = -1;
        r29 = r13;
        r13 = r2;
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d2, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r2 = r13;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0207, code lost:
        r6 = r6 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x020a, code lost:
        r2 = r4;
        r28 = r10;
        r19 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzz(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.ads.zzgcm r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x033d
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzb(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002f
        L_0x002c:
            r17 = r0
            r4 = r3
        L_0x002f:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.zzT(r5, r2)
            goto L_0x0040
        L_0x003c:
            int r0 = r15.zzS(r5)
        L_0x0040:
            r2 = r0
            if (r2 != r10) goto L_0x004e
            r2 = r4
            r20 = r5
            r28 = r9
            r18 = -1
            r19 = 0
            goto L_0x0317
        L_0x004e:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = zzF(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x0213
            int[] r10 = r15.zzc
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            if (r10 == r7) goto L_0x0090
            r23 = r1
            r20 = r2
            if (r7 == r13) goto L_0x0081
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0083
        L_0x0081:
            r7 = r19
        L_0x0083:
            if (r10 == r13) goto L_0x008a
            long r1 = (long) r10
            int r6 = r7.getInt(r14, r1)
        L_0x008a:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x0096
        L_0x0090:
            r23 = r1
            r20 = r2
            r10 = r19
        L_0x0096:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x01f1;
                case 1: goto L_0x01da;
                case 2: goto L_0x01bc;
                case 3: goto L_0x01bc;
                case 4: goto L_0x01a9;
                case 5: goto L_0x018d;
                case 6: goto L_0x0169;
                case 7: goto L_0x014c;
                case 8: goto L_0x012b;
                case 9: goto L_0x00f9;
                case 10: goto L_0x00e7;
                case 11: goto L_0x01a9;
                case 12: goto L_0x00d6;
                case 13: goto L_0x0169;
                case 14: goto L_0x018d;
                case 15: goto L_0x00c1;
                case 16: goto L_0x00a3;
                default: goto L_0x009a;
            }
        L_0x009a:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            goto L_0x020a
        L_0x00a3:
            if (r3 != 0) goto L_0x00bc
            int r17 = com.google.android.gms.internal.ads.zzgcn.zzc(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.ads.zzgde.zzH(r0)
            r0 = r10
            r1 = r31
            r13 = r20
            r2 = r8
            r20 = r33
            r0.putLong(r1, r2, r4)
            goto L_0x01d2
        L_0x00bc:
            r13 = r20
            r20 = r33
            goto L_0x0126
        L_0x00c1:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0126
            int r0 = com.google.android.gms.internal.ads.zzgcn.zza(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.ads.zzgde.zzG(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x0207
        L_0x00d6:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0126
            int r0 = com.google.android.gms.internal.ads.zzgcn.zza(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x0207
        L_0x00e7:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x0126
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzh(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0207
        L_0x00f9:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x0124
            com.google.android.gms.internal.ads.zzgga r0 = r15.zzw(r13)
            r2 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzi(r0, r12, r4, r2, r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x011a
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x017d
        L_0x011a:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgem.zzi(r1, r3)
            r10.putObject(r14, r8, r1)
            goto L_0x017d
        L_0x0124:
            r2 = r34
        L_0x0126:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x020a
        L_0x012b:
            r2 = r34
            r13 = r20
            r0 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r0) goto L_0x020a
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x0142
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzf(r12, r4, r11)
            goto L_0x0146
        L_0x0142:
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzg(r12, r4, r11)
        L_0x0146:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x017d
        L_0x014c:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x020a
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzc(r12, r4, r11)
            long r3 = r11.zzb
            r22 = 0
            int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r5 = 0
        L_0x0165:
            com.google.android.gms.internal.ads.zzggy.zzi(r14, r8, r5)
            goto L_0x017d
        L_0x0169:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r1) goto L_0x020a
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzd(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
        L_0x017d:
            r6 = r6 | r21
            r9 = r10
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x001a
        L_0x018d:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r5) goto L_0x020a
            long r22 = com.google.android.gms.internal.ads.zzgcn.zze(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0207
        L_0x01a9:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x020a
            int r0 = com.google.android.gms.internal.ads.zzgcn.zza(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x0207
        L_0x01bc:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x020a
            int r17 = com.google.android.gms.internal.ads.zzgcn.zzc(r12, r4, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
        L_0x01d2:
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x0257
        L_0x01da:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r1) goto L_0x020a
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzd(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.ads.zzggy.zzk(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0207
        L_0x01f1:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r5) goto L_0x020a
            long r0 = com.google.android.gms.internal.ads.zzgcn.zze(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.ads.zzggy.zzm(r14, r8, r0)
            int r0 = r4 + 8
        L_0x0207:
            r6 = r6 | r21
            goto L_0x0255
        L_0x020a:
            r2 = r4
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x0317
        L_0x0213:
            r20 = r33
            r23 = r1
            r13 = r2
            r10 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 27
            if (r0 != r1) goto L_0x026e
            r1 = 2
            if (r3 != r1) goto L_0x0261
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.android.gms.internal.ads.zzgel r0 = (com.google.android.gms.internal.ads.zzgel) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x0241
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0239
            r1 = 10
            goto L_0x023a
        L_0x0239:
            int r1 = r1 + r1
        L_0x023a:
            com.google.android.gms.internal.ads.zzgel r0 = r0.zze(r1)
            r10.putObject(r14, r8, r0)
        L_0x0241:
            r5 = r0
            com.google.android.gms.internal.ads.zzgga r0 = r15.zzw(r13)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzm(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x0255:
            r9 = r10
            r2 = r13
        L_0x0257:
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r13 = r34
            goto L_0x001a
        L_0x0261:
            r15 = r4
            r24 = r6
            r25 = r7
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x02f4
        L_0x026e:
            r1 = 49
            if (r0 > r1) goto L_0x02c0
            r1 = r23
            long r1 = (long) r1
            r5 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r4
            r15 = r4
            r4 = r34
            r23 = r5
            r5 = r17
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r19 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02be
        L_0x02aa:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r19
            r1 = r20
            r6 = r24
            r7 = r25
            goto L_0x0335
        L_0x02be:
            r2 = r0
            goto L_0x02f5
        L_0x02c0:
            r33 = r3
            r15 = r4
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r19 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            if (r9 != r0) goto L_0x02fa
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x02f4
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r26
            r8 = r35
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02be
            goto L_0x02aa
        L_0x02f4:
            r2 = r15
        L_0x02f5:
            r6 = r24
            r7 = r25
            goto L_0x0317
        L_0x02fa:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r20
            r10 = r26
            r12 = r19
            r13 = r35
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02be
            goto L_0x02aa
        L_0x0317:
            com.google.android.gms.internal.ads.zzggp r4 = zzg(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzn(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r19
            r1 = r20
        L_0x0335:
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001a
        L_0x033d:
            r24 = r6
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x0350
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0350:
            r1 = r34
            if (r0 != r1) goto L_0x0355
            return r0
        L_0x0355:
            com.google.android.gms.internal.ads.zzgeo r0 = com.google.android.gms.internal.ads.zzgeo.zzk()
            goto L_0x035b
        L_0x035a:
            throw r0
        L_0x035b:
            goto L_0x035a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgfn.zzz(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzgcm):int");
    }

    public final T zza() {
        return ((zzgec) this.zzg).zzb(4, (Object) null, (Object) null);
    }

    public final boolean zzb(T t, T t2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzD = zzD(i);
            long j = (long) (zzD & 1048575);
            switch (zzF(zzD)) {
                case 0:
                    if (zzM(t, t2, i) && Double.doubleToLongBits(zzggy.zzl(t, j)) == Double.doubleToLongBits(zzggy.zzl(t2, j))) {
                        continue;
                    }
                case 1:
                    if (zzM(t, t2, i) && Float.floatToIntBits(zzggy.zzj(t, j)) == Float.floatToIntBits(zzggy.zzj(t2, j))) {
                        continue;
                    }
                case 2:
                    if (zzM(t, t2, i) && zzggy.zzf(t, j) == zzggy.zzf(t2, j)) {
                        continue;
                    }
                case 3:
                    if (zzM(t, t2, i) && zzggy.zzf(t, j) == zzggy.zzf(t2, j)) {
                        continue;
                    }
                case 4:
                    if (zzM(t, t2, i) && zzggy.zzd(t, j) == zzggy.zzd(t2, j)) {
                        continue;
                    }
                case 5:
                    if (zzM(t, t2, i) && zzggy.zzf(t, j) == zzggy.zzf(t2, j)) {
                        continue;
                    }
                case 6:
                    if (zzM(t, t2, i) && zzggy.zzd(t, j) == zzggy.zzd(t2, j)) {
                        continue;
                    }
                case 7:
                    if (zzM(t, t2, i) && zzggy.zzh(t, j) == zzggy.zzh(t2, j)) {
                        continue;
                    }
                case 8:
                    if (zzM(t, t2, i) && zzggc.zzD(zzggy.zzn(t, j), zzggy.zzn(t2, j))) {
                        continue;
                    }
                case 9:
                    if (zzM(t, t2, i) && zzggc.zzD(zzggy.zzn(t, j), zzggy.zzn(t2, j))) {
                        continue;
                    }
                case 10:
                    if (zzM(t, t2, i) && zzggc.zzD(zzggy.zzn(t, j), zzggy.zzn(t2, j))) {
                        continue;
                    }
                case 11:
                    if (zzM(t, t2, i) && zzggy.zzd(t, j) == zzggy.zzd(t2, j)) {
                        continue;
                    }
                case 12:
                    if (zzM(t, t2, i) && zzggy.zzd(t, j) == zzggy.zzd(t2, j)) {
                        continue;
                    }
                case 13:
                    if (zzM(t, t2, i) && zzggy.zzd(t, j) == zzggy.zzd(t2, j)) {
                        continue;
                    }
                case 14:
                    if (zzM(t, t2, i) && zzggy.zzf(t, j) == zzggy.zzf(t2, j)) {
                        continue;
                    }
                case 15:
                    if (zzM(t, t2, i) && zzggy.zzd(t, j) == zzggy.zzd(t2, j)) {
                        continue;
                    }
                case 16:
                    if (zzM(t, t2, i) && zzggy.zzf(t, j) == zzggy.zzf(t2, j)) {
                        continue;
                    }
                case 17:
                    if (zzM(t, t2, i) && zzggc.zzD(zzggy.zzn(t, j), zzggy.zzn(t2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzggc.zzD(zzggy.zzn(t, j), zzggy.zzn(t2, j));
                    break;
                case 50:
                    z = zzggc.zzD(zzggy.zzn(t, j), zzggy.zzn(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzE = (long) (zzE(i) & 1048575);
                    if (zzggy.zzd(t, zzE) == zzggy.zzd(t2, zzE) && zzggc.zzD(zzggy.zzn(t, j), zzggy.zzn(t2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzo.zzj(t).equals(this.zzo.zzj(t2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zzb(t);
        this.zzp.zzb(t2);
        throw null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzD(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzF(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0228
        L_0x001f:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggy.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzK(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzK(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggy.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggy.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggy.zzn(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzL(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zzf(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzK(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzK(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzK(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzI(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zzH(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggy.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggy.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggy.zzn(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzggy.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzggy.zzd(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzggy.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzggy.zzd(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzggy.zzd(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzggy.zzd(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggy.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggy.zzn(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzggy.zzn(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.ads.zzggy.zzh(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zzf(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzggy.zzd(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzggy.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzggy.zzd(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzggy.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzggy.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.ads.zzggy.zzj(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.ads.zzggy.zzl(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.ads.zzgem.zze(r3)
        L_0x0226:
            int r3 = r3 + r2
            r2 = r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.ads.zzggo<?, ?> r0 = r8.zzo
            java.lang.Object r0 = r0.zzj(r9)
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            boolean r1 = r8.zzh
            if (r1 != 0) goto L_0x023e
            return r0
        L_0x023e:
            com.google.android.gms.internal.ads.zzgdp<?> r0 = r8.zzp
            r0.zzb(r9)
            r9 = 0
            goto L_0x0246
        L_0x0245:
            throw r9
        L_0x0246:
            goto L_0x0245
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgfn.zzc(java.lang.Object):int");
    }

    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzD = zzD(i);
                long j = (long) (1048575 & zzD);
                int i2 = this.zzc[i];
                switch (zzF(zzD)) {
                    case 0:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zzm(t, j, zzggy.zzl(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 1:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zzk(t, j, zzggy.zzj(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 2:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zzg(t, j, zzggy.zzf(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 3:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zzg(t, j, zzggy.zzf(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 4:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zze(t, j, zzggy.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 5:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zzg(t, j, zzggy.zzf(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 6:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zze(t, j, zzggy.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 7:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zzi(t, j, zzggy.zzh(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 8:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zzo(t, j, zzggy.zzn(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 9:
                        zzp(t, t2, i);
                        break;
                    case 10:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zzo(t, j, zzggy.zzn(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 11:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zze(t, j, zzggy.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 12:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zze(t, j, zzggy.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 13:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zze(t, j, zzggy.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 14:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zzg(t, j, zzggy.zzf(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 15:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zze(t, j, zzggy.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 16:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzggy.zzg(t, j, zzggy.zzf(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 17:
                        zzp(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzn.zzc(t, t2, j);
                        break;
                    case 50:
                        zzggc.zzI(this.zzr, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zzQ(t2, i2, i)) {
                            break;
                        } else {
                            zzggy.zzo(t, j, zzggy.zzn(t2, j));
                            zzR(t, i2, i);
                            break;
                        }
                    case 60:
                        zzq(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zzQ(t2, i2, i)) {
                            break;
                        } else {
                            zzggy.zzo(t, j, zzggy.zzn(t2, j));
                            zzR(t, i2, i);
                            break;
                        }
                    case 68:
                        zzq(t, t2, i);
                        break;
                }
            }
            zzggc.zzF(this.zzo, t, t2);
            if (this.zzh) {
                zzggc.zzE(this.zzp, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    public final int zze(T t) {
        return this.zzj ? zzs(t) : zzr(t);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zzf(T r13, com.google.android.gms.internal.ads.zzgfv r14, com.google.android.gms.internal.ads.zzgdo r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x05db
            com.google.android.gms.internal.ads.zzggo<?, ?> r8 = r12.zzo
            com.google.android.gms.internal.ads.zzgdp<?> r9 = r12.zzp
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zzb()     // Catch:{ all -> 0x0078 }
            int r3 = r12.zzS(r2)     // Catch:{ all -> 0x0078 }
            if (r3 >= 0) goto L_0x007b
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzl
        L_0x001a:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzA(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x05c3
            r8.zzl(r13, r10)
            return
        L_0x002f:
            boolean r3 = r12.zzh     // Catch:{ all -> 0x0078 }
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.ads.zzgfk r3 = r12.zzg     // Catch:{ all -> 0x0078 }
            java.lang.Object r2 = r9.zzf(r15, r3, r2)     // Catch:{ all -> 0x0078 }
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0051
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzgdt r1 = r9.zzc(r13)     // Catch:{ all -> 0x0078 }
        L_0x0044:
            r11 = r1
            r1 = r9
            r2 = r14
            r4 = r15
            r5 = r11
            r6 = r10
            r7 = r8
            java.lang.Object r10 = r1.zze(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0078 }
            r1 = r11
            goto L_0x0009
        L_0x0051:
            r8.zza(r14)     // Catch:{ all -> 0x0078 }
            if (r10 != 0) goto L_0x005b
            java.lang.Object r2 = r8.zzk(r13)     // Catch:{ all -> 0x0078 }
            r10 = r2
        L_0x005b:
            boolean r2 = r8.zzn(r10, r14)     // Catch:{ all -> 0x0078 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzl
        L_0x0063:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0072
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzA(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0063
        L_0x0072:
            if (r10 == 0) goto L_0x05c3
            r8.zzl(r13, r10)
            return
        L_0x0078:
            r14 = move-exception
            goto L_0x05c4
        L_0x007b:
            int r4 = r12.zzD(r3)     // Catch:{ all -> 0x0078 }
            int r5 = zzF(r4)     // Catch:{ zzgen -> 0x059d }
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x0570;
                case 1: goto L_0x0561;
                case 2: goto L_0x0552;
                case 3: goto L_0x0543;
                case 4: goto L_0x0534;
                case 5: goto L_0x0525;
                case 6: goto L_0x0516;
                case 7: goto L_0x0507;
                case 8: goto L_0x04ff;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04bf;
                case 11: goto L_0x04b0;
                case 12: goto L_0x048e;
                case 13: goto L_0x047f;
                case 14: goto L_0x0470;
                case 15: goto L_0x0461;
                case 16: goto L_0x0452;
                case 17: goto L_0x0421;
                case 18: goto L_0x0413;
                case 19: goto L_0x0405;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e9;
                case 22: goto L_0x03db;
                case 23: goto L_0x03cd;
                case 24: goto L_0x03bf;
                case 25: goto L_0x03b1;
                case 26: goto L_0x0387;
                case 27: goto L_0x0375;
                case 28: goto L_0x0367;
                case 29: goto L_0x0359;
                case 30: goto L_0x0344;
                case 31: goto L_0x0336;
                case 32: goto L_0x0328;
                case 33: goto L_0x031a;
                case 34: goto L_0x030c;
                case 35: goto L_0x02fe;
                case 36: goto L_0x02f0;
                case 37: goto L_0x02e2;
                case 38: goto L_0x02d4;
                case 39: goto L_0x02c6;
                case 40: goto L_0x02b8;
                case 41: goto L_0x02aa;
                case 42: goto L_0x029c;
                case 43: goto L_0x028e;
                case 44: goto L_0x0279;
                case 45: goto L_0x026b;
                case 46: goto L_0x025d;
                case 47: goto L_0x024f;
                case 48: goto L_0x0241;
                case 49: goto L_0x022f;
                case 50: goto L_0x01f9;
                case 51: goto L_0x01e7;
                case 52: goto L_0x01d5;
                case 53: goto L_0x01c3;
                case 54: goto L_0x01b1;
                case 55: goto L_0x019f;
                case 56: goto L_0x018d;
                case 57: goto L_0x017b;
                case 58: goto L_0x0169;
                case 59: goto L_0x0161;
                case 60: goto L_0x0130;
                case 61: goto L_0x0122;
                case 62: goto L_0x0110;
                case 63: goto L_0x00eb;
                case 64: goto L_0x00d9;
                case 65: goto L_0x00c7;
                case 66: goto L_0x00b5;
                case 67: goto L_0x00a3;
                case 68: goto L_0x0091;
                default: goto L_0x0089;
            }     // Catch:{ zzgen -> 0x059d }
        L_0x0089:
            if (r10 != 0) goto L_0x0580
            java.lang.Object r2 = r8.zzg()     // Catch:{ zzgen -> 0x059d }
            goto L_0x057f
        L_0x0091:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgga r6 = r12.zzw(r3)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r6 = r14.zzp(r6, r15)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x00a3:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            long r6 = r14.zzw()     // Catch:{ zzgen -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x00b5:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            int r6 = r14.zzv()     // Catch:{ zzgen -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x00c7:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            long r6 = r14.zzu()     // Catch:{ zzgen -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x00d9:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            int r6 = r14.zzt()     // Catch:{ zzgen -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x00eb:
            int r5 = r14.zzs()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgeg r7 = r12.zzy(r3)     // Catch:{ zzgen -> 0x059d }
            if (r7 == 0) goto L_0x0102
            boolean r7 = r7.zza(r5)     // Catch:{ zzgen -> 0x059d }
            if (r7 == 0) goto L_0x00fc
            goto L_0x0102
        L_0x00fc:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzggc.zzH(r2, r5, r10, r8)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0102:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzgen -> 0x059d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r6, r4)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0110:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            int r6 = r14.zzr()     // Catch:{ zzgen -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0122:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgcz r6 = r14.zzq()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0130:
            boolean r5 = r12.zzQ(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            if (r5 == 0) goto L_0x014c
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.ads.zzggy.zzn(r13, r4)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgga r7 = r12.zzw(r3)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r7 = r14.zzo(r7, r15)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.ads.zzgem.zzi(r6, r7)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            goto L_0x015c
        L_0x014c:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgga r6 = r12.zzw(r3)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r6 = r14.zzo(r6, r15)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
        L_0x015c:
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0161:
            r12.zzC(r13, r4, r14)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0169:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            boolean r6 = r14.zzl()     // Catch:{ zzgen -> 0x059d }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x017b:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            int r6 = r14.zzk()     // Catch:{ zzgen -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x018d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            long r6 = r14.zzj()     // Catch:{ zzgen -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x019f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            int r6 = r14.zzi()     // Catch:{ zzgen -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x01b1:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            long r6 = r14.zzg()     // Catch:{ zzgen -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x01c3:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            long r6 = r14.zzh()     // Catch:{ zzgen -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x01d5:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            float r6 = r14.zzf()     // Catch:{ zzgen -> 0x059d }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x01e7:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgen -> 0x059d }
            double r6 = r14.zze()     // Catch:{ zzgen -> 0x059d }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzR(r13, r2, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x01f9:
            java.lang.Object r2 = r12.zzx(r3)     // Catch:{ zzgen -> 0x059d }
            int r3 = r12.zzD(r3)     // Catch:{ zzgen -> 0x059d }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzggy.zzn(r13, r3)     // Catch:{ zzgen -> 0x059d }
            if (r5 == 0) goto L_0x021f
            boolean r6 = com.google.android.gms.internal.ads.zzgff.zzb(r5)     // Catch:{ zzgen -> 0x059d }
            if (r6 == 0) goto L_0x022a
            com.google.android.gms.internal.ads.zzgfe r6 = com.google.android.gms.internal.ads.zzgfe.zza()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgfe r6 = r6.zzc()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgff.zzc(r6, r5)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r3, r6)     // Catch:{ zzgen -> 0x059d }
            r5 = r6
            goto L_0x022a
        L_0x021f:
            com.google.android.gms.internal.ads.zzgfe r5 = com.google.android.gms.internal.ads.zzgfe.zza()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgfe r5 = r5.zzc()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r3, r5)     // Catch:{ zzgen -> 0x059d }
        L_0x022a:
            com.google.android.gms.internal.ads.zzgfe r5 = (com.google.android.gms.internal.ads.zzgfe) r5     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgfd r2 = (com.google.android.gms.internal.ads.zzgfd) r2     // Catch:{ zzgen -> 0x059d }
            throw r0     // Catch:{ zzgen -> 0x059d }
        L_0x022f:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgga r2 = r12.zzw(r3)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgey r3 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzgen -> 0x059d }
            r14.zzH(r3, r2, r15)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0241:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzO(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x024f:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzN(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x025d:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzM(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x026b:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzL(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0279:
            com.google.android.gms.internal.ads.zzgey r5 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzgen -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzgen -> 0x059d }
            r14.zzK(r4)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgeg r3 = r12.zzy(r3)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzggc.zzG(r2, r4, r3, r10, r8)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x028e:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzJ(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x029c:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzE(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x02aa:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzD(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x02b8:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzC(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x02c6:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzB(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x02d4:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzz(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x02e2:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzA(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x02f0:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzy(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x02fe:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzx(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x030c:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzO(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x031a:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzN(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0328:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzM(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0336:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzL(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0344:
            com.google.android.gms.internal.ads.zzgey r5 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzgen -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzgen -> 0x059d }
            r14.zzK(r4)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgeg r3 = r12.zzy(r3)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzggc.zzG(r2, r4, r3, r10, r8)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0359:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzJ(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0367:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzI(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0375:
            com.google.android.gms.internal.ads.zzgga r2 = r12.zzw(r3)     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgey r5 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzG(r3, r2, r15)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0387:
            boolean r2 = zzG(r4)     // Catch:{ zzgen -> 0x059d }
            if (r2 == 0) goto L_0x039f
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r3 = r14
            com.google.android.gms.internal.ads.zzgdf r3 = (com.google.android.gms.internal.ads.zzgdf) r3     // Catch:{ zzgen -> 0x059d }
            r4 = 1
            r3.zzF(r2, r4)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x039f:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r3 = r14
            com.google.android.gms.internal.ads.zzgdf r3 = (com.google.android.gms.internal.ads.zzgdf) r3     // Catch:{ zzgen -> 0x059d }
            r4 = 0
            r3.zzF(r2, r4)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x03b1:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzE(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x03bf:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzD(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x03cd:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzC(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x03db:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzB(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x03e9:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzz(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x03f7:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzA(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0405:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzy(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0413:
            com.google.android.gms.internal.ads.zzgey r2 = r12.zzn     // Catch:{ zzgen -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgen -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgen -> 0x059d }
            r14.zzx(r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0421:
            boolean r2 = r12.zzO(r13, r3)     // Catch:{ zzgen -> 0x059d }
            if (r2 == 0) goto L_0x043f
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzggy.zzn(r13, r4)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgga r3 = r12.zzw(r3)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r3 = r14.zzp(r3, r15)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzgem.zzi(r2, r3)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x043f:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgga r2 = r12.zzw(r3)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r2 = r14.zzp(r2, r15)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0452:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            long r6 = r14.zzw()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzg(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0461:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            int r2 = r14.zzv()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zze(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0470:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            long r6 = r14.zzu()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzg(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x047f:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            int r2 = r14.zzt()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zze(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x048e:
            int r5 = r14.zzs()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgeg r7 = r12.zzy(r3)     // Catch:{ zzgen -> 0x059d }
            if (r7 == 0) goto L_0x04a5
            boolean r7 = r7.zza(r5)     // Catch:{ zzgen -> 0x059d }
            if (r7 == 0) goto L_0x049f
            goto L_0x04a5
        L_0x049f:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzggc.zzH(r2, r5, r10, r8)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x04a5:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zze(r13, r6, r5)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x04b0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            int r2 = r14.zzr()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zze(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x04bf:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgcz r2 = r14.zzq()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x04ce:
            boolean r2 = r12.zzO(r13, r3)     // Catch:{ zzgen -> 0x059d }
            if (r2 == 0) goto L_0x04ec
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzggy.zzn(r13, r4)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgga r3 = r12.zzw(r3)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r3 = r14.zzo(r3, r15)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzgem.zzi(r2, r3)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x04ec:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzgga r2 = r12.zzw(r3)     // Catch:{ zzgen -> 0x059d }
            java.lang.Object r2 = r14.zzo(r2, r15)     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzo(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x04ff:
            r12.zzC(r13, r4, r14)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0507:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            boolean r2 = r14.zzl()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzi(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0516:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            int r2 = r14.zzk()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zze(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0525:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            long r6 = r14.zzj()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzg(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0534:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            int r2 = r14.zzi()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zze(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0543:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            long r6 = r14.zzg()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzg(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0552:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            long r6 = r14.zzh()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzg(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0561:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            float r2 = r14.zzf()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzk(r13, r4, r2)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x0570:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgen -> 0x059d }
            double r6 = r14.zze()     // Catch:{ zzgen -> 0x059d }
            com.google.android.gms.internal.ads.zzggy.zzm(r13, r4, r6)     // Catch:{ zzgen -> 0x059d }
            r12.zzP(r13, r3)     // Catch:{ zzgen -> 0x059d }
            goto L_0x0009
        L_0x057f:
            r10 = r2
        L_0x0580:
            boolean r2 = r8.zzn(r10, r14)     // Catch:{ zzgen -> 0x059d }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzl
        L_0x0588:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0597
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzA(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0588
        L_0x0597:
            if (r10 == 0) goto L_0x05c3
            r8.zzl(r13, r10)
            return
        L_0x059d:
            r8.zza(r14)     // Catch:{ all -> 0x0078 }
            if (r10 != 0) goto L_0x05a7
            java.lang.Object r2 = r8.zzk(r13)     // Catch:{ all -> 0x0078 }
            r10 = r2
        L_0x05a7:
            boolean r2 = r8.zzn(r10, r14)     // Catch:{ all -> 0x0078 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzl
        L_0x05af:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x05be
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzA(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05af
        L_0x05be:
            if (r10 == 0) goto L_0x05c3
            r8.zzl(r13, r10)
        L_0x05c3:
            return
        L_0x05c4:
            int r15 = r12.zzl
        L_0x05c6:
            int r0 = r12.zzm
            if (r15 >= r0) goto L_0x05d5
            int[] r0 = r12.zzk
            r0 = r0[r15]
            java.lang.Object r10 = r12.zzA(r13, r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x05c6
        L_0x05d5:
            if (r10 == 0) goto L_0x05da
            r8.zzl(r13, r10)
        L_0x05da:
            throw r14
        L_0x05db:
            goto L_0x05dd
        L_0x05dc:
            throw r0
        L_0x05dd:
            goto L_0x05dc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgfn.zzf(java.lang.Object, com.google.android.gms.internal.ads.zzgfv, com.google.android.gms.internal.ads.zzgdo):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0340, code lost:
        if (r0 != r15) goto L_0x0342;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x035c, code lost:
        r7 = r33;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0386, code lost:
        if (r0 != r15) goto L_0x0342;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03aa, code lost:
        if (r0 != r15) goto L_0x0342;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x020b, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0246, code lost:
        r5 = r6 | r24;
        r3 = r7;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0283, code lost:
        r5 = r6 | r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0285, code lost:
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0286, code lost:
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x029d, code lost:
        r18 = r6;
        r19 = r7;
        r26 = r10;
        r8 = r11;
        r23 = r20;
        r6 = r25;
        r7 = r33;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzh(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.ads.zzgcm r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r31
            r1 = 0
            r2 = -1
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x041e
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzb(r0, r12, r1, r9)
            int r1 = r9.zza
            goto L_0x002d
        L_0x0028:
            r27 = r1
            r1 = r0
            r0 = r27
        L_0x002d:
            int r7 = r1 >>> 3
            r8 = r1 & 7
            r4 = 3
            if (r7 <= r2) goto L_0x003a
            int r3 = r3 / r4
            int r2 = r15.zzT(r7, r3)
            goto L_0x003e
        L_0x003a:
            int r2 = r15.zzS(r7)
        L_0x003e:
            r3 = -1
            if (r2 != r3) goto L_0x0050
            r2 = r0
            r8 = r1
            r18 = r5
            r23 = r7
            r26 = r10
            r7 = r11
            r17 = -1
            r19 = 0
            goto L_0x03ad
        L_0x0050:
            int[] r3 = r15.zzc
            int r19 = r2 + 1
            r3 = r3[r19]
            int r4 = zzF(r3)
            r20 = r1
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r3 & r17
            r21 = r0
            long r0 = (long) r1
            r22 = r0
            r0 = 17
            if (r4 > r0) goto L_0x02ac
            int[] r0 = r15.zzc
            int r24 = r2 + 2
            r0 = r0[r24]
            int r24 = r0 >>> 20
            r1 = 1
            int r24 = r1 << r24
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r11
            if (r0 == r6) goto L_0x008b
            r17 = r2
            if (r6 == r11) goto L_0x0083
            long r1 = (long) r6
            r10.putInt(r14, r1, r5)
        L_0x0083:
            long r1 = (long) r0
            int r5 = r10.getInt(r14, r1)
            r25 = r0
            goto L_0x008f
        L_0x008b:
            r17 = r2
            r25 = r6
        L_0x008f:
            r6 = r5
            r0 = 5
            switch(r4) {
                case 0: goto L_0x0267;
                case 1: goto L_0x024b;
                case 2: goto L_0x0227;
                case 3: goto L_0x0227;
                case 4: goto L_0x020e;
                case 5: goto L_0x01ea;
                case 6: goto L_0x01d1;
                case 7: goto L_0x01af;
                case 8: goto L_0x018b;
                case 9: goto L_0x015a;
                case 10: goto L_0x0140;
                case 11: goto L_0x020e;
                case 12: goto L_0x010b;
                case 13: goto L_0x01d1;
                case 14: goto L_0x01ea;
                case 15: goto L_0x00ee;
                case 16: goto L_0x00c2;
                default: goto L_0x0094;
            }
        L_0x0094:
            r11 = r20
            r2 = r21
            r4 = r22
            r0 = 3
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x029d
            com.google.android.gms.internal.ads.zzgga r0 = r15.zzw(r7)
            int r1 = r20 << 3
            r8 = r1 | 4
            r1 = r30
            r3 = r32
            r12 = r4
            r4 = r8
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzj(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x0289
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x0296
        L_0x00c2:
            if (r8 != 0) goto L_0x00e2
            r1 = r21
            int r8 = com.google.android.gms.internal.ads.zzgcn.zzc(r12, r1, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.ads.zzgde.zzH(r0)
            r2 = r22
            r0 = r10
            r11 = r20
            r1 = r29
            r20 = r7
            r7 = r17
            r17 = -1
            r0.putLong(r1, r2, r4)
            goto L_0x0246
        L_0x00e2:
            r11 = r20
            r20 = r7
            r7 = r17
            r17 = -1
            r2 = r21
            goto L_0x029d
        L_0x00ee:
            r11 = r20
            r1 = r21
            r2 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x020b
            int r0 = com.google.android.gms.internal.ads.zzgcn.zza(r12, r1, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.ads.zzgde.zzG(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0283
        L_0x010b:
            r11 = r20
            r1 = r21
            r2 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x020b
            int r0 = com.google.android.gms.internal.ads.zzgcn.zza(r12, r1, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.ads.zzgeg r4 = r15.zzy(r7)
            if (r4 == 0) goto L_0x013b
            boolean r4 = r4.zza(r1)
            if (r4 == 0) goto L_0x012c
            goto L_0x013b
        L_0x012c:
            com.google.android.gms.internal.ads.zzggp r2 = zzg(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r5 = r6
            goto L_0x0285
        L_0x013b:
            r10.putInt(r14, r2, r1)
            goto L_0x0283
        L_0x0140:
            r11 = r20
            r1 = r21
            r2 = r22
            r0 = 2
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020b
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzh(r12, r1, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0283
        L_0x015a:
            r11 = r20
            r1 = r21
            r2 = r22
            r0 = 2
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020b
            com.google.android.gms.internal.ads.zzgga r0 = r15.zzw(r7)
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzi(r0, r12, r1, r13, r9)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x017c
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0283
        L_0x017c:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgem.zzi(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0283
        L_0x018b:
            r11 = r20
            r1 = r21
            r4 = r22
            r0 = 2
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020b
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r3
            if (r0 != 0) goto L_0x01a4
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzf(r12, r1, r9)
            goto L_0x01a8
        L_0x01a4:
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzg(r12, r1, r9)
        L_0x01a8:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x0283
        L_0x01af:
            r11 = r20
            r1 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x020b
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzc(r12, r1, r9)
            long r1 = r9.zzb
            r21 = 0
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 == 0) goto L_0x01cb
            r1 = 1
            goto L_0x01cc
        L_0x01cb:
            r1 = 0
        L_0x01cc:
            com.google.android.gms.internal.ads.zzggy.zzi(r14, r4, r1)
            goto L_0x0283
        L_0x01d1:
            r11 = r20
            r1 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020b
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzd(r12, r1)
            r10.putInt(r14, r4, r0)
            int r0 = r1 + 4
            goto L_0x0283
        L_0x01ea:
            r11 = r20
            r1 = r21
            r4 = r22
            r0 = 1
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020b
            long r21 = com.google.android.gms.internal.ads.zzgcn.zze(r12, r1)
            r8 = r1
            r0 = r10
            r1 = r29
            r2 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0283
        L_0x020b:
            r2 = r1
            goto L_0x029d
        L_0x020e:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x029d
            int r0 = com.google.android.gms.internal.ads.zzgcn.zza(r12, r2, r9)
            int r1 = r9.zza
            r10.putInt(r14, r4, r1)
            goto L_0x0283
        L_0x0227:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x029d
            int r8 = com.google.android.gms.internal.ads.zzgcn.zzc(r12, r2, r9)
            long r2 = r9.zzb
            r0 = r10
            r1 = r29
            r21 = r2
            r2 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
        L_0x0246:
            r5 = r6 | r24
            r3 = r7
            r0 = r8
            goto L_0x0286
        L_0x024b:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x029d
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzd(r12, r2)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.ads.zzggy.zzk(r14, r4, r0)
            int r0 = r2 + 4
            goto L_0x0283
        L_0x0267:
            r11 = r20
            r2 = r21
            r4 = r22
            r0 = 1
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x029d
            long r0 = com.google.android.gms.internal.ads.zzgcn.zze(r12, r2)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.ads.zzggy.zzm(r14, r4, r0)
            int r0 = r2 + 8
        L_0x0283:
            r5 = r6 | r24
        L_0x0285:
            r3 = r7
        L_0x0286:
            r1 = r11
            goto L_0x02f8
        L_0x0289:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgem.zzi(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x0296:
            r5 = r6 | r24
            r12 = r30
            r13 = r32
            goto L_0x0285
        L_0x029d:
            r18 = r6
            r19 = r7
            r26 = r10
            r8 = r11
            r23 = r20
            r6 = r25
            r7 = r33
            goto L_0x03ad
        L_0x02ac:
            r11 = r20
            r12 = r22
            r17 = -1
            r20 = r7
            r7 = r2
            r2 = r21
            r0 = 27
            if (r4 != r0) goto L_0x030f
            r0 = 2
            if (r8 != r0) goto L_0x0300
            java.lang.Object r0 = r10.getObject(r14, r12)
            com.google.android.gms.internal.ads.zzgel r0 = (com.google.android.gms.internal.ads.zzgel) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x02db
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02d3
            r1 = 10
            goto L_0x02d4
        L_0x02d3:
            int r1 = r1 + r1
        L_0x02d4:
            com.google.android.gms.internal.ads.zzgel r0 = r0.zze(r1)
            r10.putObject(r14, r12, r0)
        L_0x02db:
            r8 = r0
            com.google.android.gms.internal.ads.zzgga r0 = r15.zzw(r7)
            r1 = r11
            r3 = r2
            r2 = r30
            r4 = r32
            r18 = r5
            r5 = r8
            r25 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzm(r0, r1, r2, r3, r4, r5, r6)
            r12 = r30
            r13 = r32
            r3 = r7
            r5 = r18
        L_0x02f8:
            r2 = r20
            r6 = r25
            r11 = r33
            goto L_0x0019
        L_0x0300:
            r18 = r5
            r25 = r6
            r15 = r2
            r19 = r7
            r26 = r10
            r23 = r20
            r20 = r11
            goto L_0x0389
        L_0x030f:
            r18 = r5
            r25 = r6
            r6 = r2
            r0 = 49
            if (r4 > r0) goto L_0x0360
            long r2 = (long) r3
            r0 = r28
            r1 = r29
            r21 = r2
            r2 = r30
            r3 = r6
            r5 = r4
            r4 = r32
            r31 = r5
            r5 = r11
            r15 = r6
            r6 = r20
            r19 = r7
            r23 = r20
            r7 = r8
            r8 = r19
            r26 = r10
            r9 = r21
            r20 = r11
            r11 = r31
            r14 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x035c
        L_0x0342:
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            r5 = r18
            r3 = r19
            r1 = r20
            r2 = r23
            r6 = r25
            r10 = r26
            goto L_0x0019
        L_0x035c:
            r7 = r33
            r2 = r0
            goto L_0x038c
        L_0x0360:
            r31 = r4
            r15 = r6
            r19 = r7
            r26 = r10
            r23 = r20
            r20 = r11
            r0 = 50
            r9 = r31
            if (r9 != r0) goto L_0x0391
            r0 = 2
            if (r8 != r0) goto L_0x0389
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r19
            r6 = r12
            r8 = r34
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x035c
            goto L_0x0342
        L_0x0389:
            r7 = r33
            r2 = r15
        L_0x038c:
            r8 = r20
            r6 = r25
            goto L_0x03ad
        L_0x0391:
            r0 = r28
            r1 = r29
            r2 = r30
            r10 = r3
            r3 = r15
            r4 = r32
            r5 = r20
            r6 = r23
            r7 = r8
            r8 = r10
            r10 = r12
            r12 = r19
            r13 = r34
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x035c
            goto L_0x0342
        L_0x03ad:
            if (r8 != r7) goto L_0x03bf
            if (r7 == 0) goto L_0x03bf
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r28
            r12 = r29
            r0 = r2
            r1 = r8
            r5 = r18
            r2 = 0
            goto L_0x042b
        L_0x03bf:
            r9 = r28
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x03f7
            r10 = r34
            com.google.android.gms.internal.ads.zzgdo r0 = r10.zzd
            com.google.android.gms.internal.ads.zzgdo r1 = com.google.android.gms.internal.ads.zzgdo.zza()
            if (r0 == r1) goto L_0x03f4
            com.google.android.gms.internal.ads.zzgfk r0 = r9.zzg
            com.google.android.gms.internal.ads.zzgdo r1 = r10.zzd
            r11 = r23
            com.google.android.gms.internal.ads.zzgea r0 = r1.zzc(r0, r11)
            if (r0 != 0) goto L_0x03ed
            com.google.android.gms.internal.ads.zzggp r4 = zzg(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzn(r0, r1, r2, r3, r4, r5)
            r12 = r29
            goto L_0x040c
        L_0x03ed:
            r12 = r29
            r0 = r12
            com.google.android.gms.internal.ads.zzgdz r0 = (com.google.android.gms.internal.ads.zzgdz) r0
            r2 = 0
            throw r2
        L_0x03f4:
            r12 = r29
            goto L_0x03fb
        L_0x03f7:
            r12 = r29
            r10 = r34
        L_0x03fb:
            r11 = r23
            com.google.android.gms.internal.ads.zzggp r4 = zzg(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzgcn.zzn(r0, r1, r2, r3, r4, r5)
        L_0x040c:
            r13 = r32
            r1 = r8
            r15 = r9
            r9 = r10
            r2 = r11
            r14 = r12
            r5 = r18
            r3 = r19
            r10 = r26
            r12 = r30
            r11 = r7
            goto L_0x0019
        L_0x041e:
            r18 = r5
            r25 = r6
            r26 = r10
            r7 = r11
            r12 = r14
            r9 = r15
            r2 = 0
            r3 = 1048575(0xfffff, float:1.469367E-39)
        L_0x042b:
            if (r6 == r3) goto L_0x0433
            long r3 = (long) r6
            r6 = r26
            r6.putInt(r12, r3, r5)
        L_0x0433:
            int r3 = r9.zzl
        L_0x0435:
            int r4 = r9.zzm
            if (r3 >= r4) goto L_0x0445
            int[] r4 = r9.zzk
            r4 = r4[r3]
            com.google.android.gms.internal.ads.zzggo<?, ?> r5 = r9.zzo
            r9.zzA(r12, r4, r2, r5)
            int r3 = r3 + 1
            goto L_0x0435
        L_0x0445:
            if (r7 != 0) goto L_0x0451
            r2 = r32
            if (r0 != r2) goto L_0x044c
            goto L_0x0457
        L_0x044c:
            com.google.android.gms.internal.ads.zzgeo r0 = com.google.android.gms.internal.ads.zzgeo.zzk()
            throw r0
        L_0x0451:
            r2 = r32
            if (r0 > r2) goto L_0x0458
            if (r1 != r7) goto L_0x0458
        L_0x0457:
            return r0
        L_0x0458:
            com.google.android.gms.internal.ads.zzgeo r0 = com.google.android.gms.internal.ads.zzgeo.zzk()
            goto L_0x045e
        L_0x045d:
            throw r0
        L_0x045e:
            goto L_0x045d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgfn.zzh(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgcm):int");
    }

    public final void zzi(T t, byte[] bArr, int i, int i2, zzgcm zzgcm) throws IOException {
        if (this.zzj) {
            zzz(t, bArr, i, i2, zzgcm);
        } else {
            zzh(t, bArr, i, i2, 0, zzgcm);
        }
    }

    public final void zzj(T t) {
        int i;
        int i2 = this.zzl;
        while (true) {
            i = this.zzm;
            if (i2 >= i) {
                break;
            }
            long zzD = (long) (zzD(this.zzk[i2]) & 1048575);
            Object zzn2 = zzggy.zzn(t, zzD);
            if (zzn2 != null) {
                ((zzgfe) zzn2).zzd();
                zzggy.zzo(t, zzD, zzn2);
            }
            i2++;
        }
        int length = this.zzk.length;
        while (i < length) {
            this.zzn.zzb(t, (long) this.zzk[i]);
            i++;
        }
        this.zzo.zzm(t);
        if (this.zzh) {
            this.zzp.zzd(t);
        }
    }

    public final boolean zzk(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzl) {
            int i6 = this.zzk[i5];
            int i7 = this.zzc[i6];
            int zzD = zzD(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzD) != 0 && !zzN(t, i6, i2, i, i10)) {
                return false;
            }
            int zzF = zzF(zzD);
            if (zzF != 9 && zzF != 17) {
                if (zzF != 27) {
                    if (zzF == 60 || zzF == 68) {
                        if (zzQ(t2, i7, i6) && !zzB(t2, zzD, zzw(i6))) {
                            return false;
                        }
                    } else if (zzF != 49) {
                        if (zzF == 50 && !((zzgfe) zzggy.zzn(t2, (long) (zzD & 1048575))).isEmpty()) {
                            zzgfd zzgfd = (zzgfd) zzx(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzggy.zzn(t2, (long) (zzD & 1048575));
                if (!list.isEmpty()) {
                    zzgga zzw = zzw(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzw.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzN(t, i6, i2, i, i10) && !zzB(t2, zzD, zzw(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zzb(t2);
        throw null;
    }

    public final void zzn(T t, zzgdk zzgdk) throws IOException {
        if (!this.zzj) {
            zzV(t, zzgdk);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzD = zzD(i);
                int i2 = this.zzc[i];
                switch (zzF(zzD)) {
                    case 0:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzf(i2, zzggy.zzl(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zze(i2, zzggy.zzj(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzc(i2, zzggy.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzh(i2, zzggy.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzi(i2, zzggy.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzj(i2, zzggy.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzk(i2, zzggy.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzl(i2, zzggy.zzh(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzX(i2, zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk);
                            break;
                        }
                    case 9:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzr(i2, zzggy.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                    case 10:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzn(i2, (zzgcz) zzggy.zzn(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzo(i2, zzggy.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzg(i2, zzggy.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzb(i2, zzggy.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzd(i2, zzggy.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzp(i2, zzggy.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzq(i2, zzggy.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzgdk.zzs(i2, zzggy.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                    case 18:
                        zzggc.zzJ(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 19:
                        zzggc.zzK(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 20:
                        zzggc.zzL(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 21:
                        zzggc.zzM(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 22:
                        zzggc.zzQ(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 23:
                        zzggc.zzO(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 24:
                        zzggc.zzT(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 25:
                        zzggc.zzW(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 26:
                        zzggc.zzX(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk);
                        break;
                    case 27:
                        zzggc.zzZ(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, zzw(i));
                        break;
                    case 28:
                        zzggc.zzY(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk);
                        break;
                    case 29:
                        zzggc.zzR(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 30:
                        zzggc.zzV(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 31:
                        zzggc.zzU(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 32:
                        zzggc.zzP(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 33:
                        zzggc.zzS(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 34:
                        zzggc.zzN(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, false);
                        break;
                    case 35:
                        zzggc.zzJ(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 36:
                        zzggc.zzK(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 37:
                        zzggc.zzL(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 38:
                        zzggc.zzM(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 39:
                        zzggc.zzQ(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 40:
                        zzggc.zzO(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 41:
                        zzggc.zzT(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 42:
                        zzggc.zzW(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 43:
                        zzggc.zzR(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 44:
                        zzggc.zzV(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 45:
                        zzggc.zzU(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 46:
                        zzggc.zzP(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 47:
                        zzggc.zzS(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 48:
                        zzggc.zzN(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, true);
                        break;
                    case 49:
                        zzggc.zzaa(this.zzc[i], (List) zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk, zzw(i));
                        break;
                    case 50:
                        zzW(zzgdk, i2, zzggy.zzn(t, (long) (zzD & 1048575)), i);
                        break;
                    case 51:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzf(i2, zzH(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zze(i2, zzI(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzc(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzh(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzi(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzj(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzk(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzl(i2, zzL(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzX(i2, zzggy.zzn(t, (long) (zzD & 1048575)), zzgdk);
                            break;
                        }
                    case 60:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzr(i2, zzggy.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                    case 61:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzn(i2, (zzgcz) zzggy.zzn(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzo(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzg(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzb(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzd(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzp(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzq(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzgdk.zzs(i2, zzggy.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                }
            }
            zzggo<?, ?> zzggo = this.zzo;
            zzggo.zzr(zzggo.zzj(t), zzgdk);
        } else {
            this.zzp.zzb(t);
            throw null;
        }
    }
}
