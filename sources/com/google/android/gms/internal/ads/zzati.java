package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzati extends zzatm {
    public final AtomicReference<zzath> zza;

    public zzati() {
        this((zzatn) null);
    }

    public static boolean zza(int i, boolean z) {
        int i2 = i & 3;
        return i2 == 3 || (z && i2 == 2);
    }

    public static int zzh(int i, int i2) {
        if (i == -1) {
            return i2 != -1 ? -1 : 0;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    public final zzatg[] zzb(zzanq[] zzanqArr, zzatc[] zzatcArr, int[][][] iArr) throws zzamw {
        zzatj zzatj;
        zzatj zzatj2;
        int[] iArr2;
        ArrayList arrayList;
        zzatb zzatb;
        boolean z;
        int i;
        int i2;
        int i3 = 2;
        zzatg[] zzatgArr = new zzatg[2];
        zzath zzath = this.zza.get();
        int i4 = 0;
        boolean z2 = false;
        while (i4 < i3) {
            if (zzanqArr[i4].zza() == i3) {
                if (!z2) {
                    zzanq zzanq = zzanqArr[i4];
                    zzatc zzatc = zzatcArr[i4];
                    int[][] iArr3 = iArr[i4];
                    int i5 = zzath.zzd;
                    int i6 = 0;
                    zzatb zzatb2 = null;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = -1;
                    int i10 = -1;
                    while (i6 < zzatc.zzb) {
                        zzatb zza2 = zzatc.zza(i6);
                        ArrayList arrayList2 = new ArrayList(zza2.zza);
                        for (int i11 = 0; i11 < zza2.zza; i11++) {
                            arrayList2.add(Integer.valueOf(i11));
                        }
                        int[] iArr4 = iArr3[i6];
                        int i12 = i10;
                        int i13 = 0;
                        while (i13 < zza2.zza) {
                            zzatc zzatc2 = zzatc;
                            if (zza(iArr4[i13], true)) {
                                zzank zza3 = zza2.zza(i13);
                                if (arrayList2.contains(Integer.valueOf(i13))) {
                                    int i14 = zza3.zzj;
                                    int i15 = zza3.zzb;
                                    zzatb = zza2;
                                    z = true;
                                } else {
                                    zzatb = zza2;
                                    z = false;
                                }
                                if (true != z) {
                                    arrayList = arrayList2;
                                    i = 1;
                                } else {
                                    arrayList = arrayList2;
                                    i = 2;
                                }
                                iArr2 = iArr4;
                                boolean zza4 = zza(iArr4[i13], false);
                                if (zza4) {
                                    i += 1000;
                                }
                                boolean z3 = i > i8;
                                if (i == i8) {
                                    if (zza3.zzk() != i12) {
                                        i2 = zzh(zza3.zzk(), i12);
                                    } else {
                                        i2 = zzh(zza3.zzb, i9);
                                    }
                                    z3 = !zza4 || !z ? i2 < 0 : i2 > 0;
                                }
                                if (z3) {
                                    i9 = zza3.zzb;
                                    i12 = zza3.zzk();
                                    i8 = i;
                                    i7 = i13;
                                    zzatb2 = zzatb;
                                }
                            } else {
                                zzatb = zza2;
                                iArr2 = iArr4;
                                arrayList = arrayList2;
                            }
                            i13++;
                            zzatc = zzatc2;
                            zza2 = zzatb;
                            arrayList2 = arrayList;
                            iArr4 = iArr2;
                        }
                        zzatc zzatc3 = zzatc;
                        i6++;
                        i10 = i12;
                    }
                    if (zzatb2 == null) {
                        zzatj2 = null;
                    } else {
                        zzatj2 = new zzatj(zzatb2, i7, 0, (Object) null);
                    }
                    zzatgArr[i4] = zzatj2;
                    z2 = zzatj2 != null;
                }
                int i16 = zzatcArr[i4].zzb;
            }
            i4++;
            i3 = 2;
        }
        int i17 = 0;
        boolean z4 = false;
        while (i17 < i3) {
            if (zzanqArr[i17].zza() == 1 && !z4) {
                zzatc zzatc4 = zzatcArr[i17];
                int[][] iArr5 = iArr[i17];
                String str = zzath.zza;
                int i18 = -1;
                int i19 = -1;
                int i20 = 0;
                int i21 = 0;
                while (i20 < zzatc4.zzb) {
                    zzatb zza5 = zzatc4.zza(i20);
                    int[] iArr6 = iArr5[i20];
                    int i22 = i21;
                    int i23 = i19;
                    int i24 = i18;
                    for (int i25 = 0; i25 < zza5.zza; i25++) {
                        if (zza(iArr6[i25], true)) {
                            zzank zza6 = zza5.zza(i25);
                            int i26 = iArr6[i25];
                            int i27 = 1 != (zza6.zzx & 1) ? 1 : 2;
                            if (zza(i26, false)) {
                                i27 += 1000;
                            }
                            if (i27 > i22) {
                                i23 = i25;
                                i24 = i20;
                                i22 = i27;
                            }
                        }
                    }
                    i20++;
                    i18 = i24;
                    i19 = i23;
                    i21 = i22;
                }
                if (i18 == -1) {
                    zzatj = null;
                } else {
                    zzatj = new zzatj(zzatc4.zza(i18), i19, 0, (Object) null);
                }
                zzatgArr[i17] = zzatj;
                z4 = zzatj != null;
            }
            i17++;
            i3 = 2;
        }
        return zzatgArr;
    }

    public zzati(zzatn zzatn) {
        this.zza = new AtomicReference<>(new zzath());
    }
}
