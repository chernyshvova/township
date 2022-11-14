package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzatm extends zzatq {
    public final SparseArray<Map<zzatc, zzatl>> zza = new SparseArray<>();
    public final SparseBooleanArray zzb = new SparseBooleanArray();
    public zzatk zzc;

    public abstract zzatg[] zzb(zzanq[] zzanqArr, zzatc[] zzatcArr, int[][][] iArr) throws zzamw;

    public final void zzc(int i, boolean z) {
        if (this.zzb.get(i) != z) {
            this.zzb.put(i, z);
            zzg();
        }
    }

    public final zzatr zzd(zzanq[] zzanqArr, zzatc zzatc) throws zzamw {
        zzatl zzatl;
        int[] iArr;
        zzanq[] zzanqArr2 = zzanqArr;
        zzatc zzatc2 = zzatc;
        int[] iArr2 = new int[3];
        zzatb[][] zzatbArr = new zzatb[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzatc2.zzb;
            zzatbArr[i] = new zzatb[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            zzanqArr2[i4].zzq();
            iArr4[i4] = 4;
        }
        int i5 = 0;
        while (i5 < zzatc2.zzb) {
            zzatb zza2 = zzatc2.zza(i5);
            int i6 = 0;
            int i7 = 0;
            int i8 = 2;
            while (true) {
                if (i6 >= i3) {
                    i6 = i8;
                    break;
                }
                zzanq zzanq = zzanqArr2[i6];
                for (int i9 = 0; i9 < zza2.zza; i9++) {
                    int zzG = zzanq.zzG(zza2.zza(i9)) & 3;
                    if (zzG > i7) {
                        if (zzG == 3) {
                            break;
                        }
                        i8 = i6;
                        i7 = zzG;
                    }
                }
                i6++;
                i3 = 2;
            }
            if (i6 == 2) {
                iArr = new int[zza2.zza];
            } else {
                zzanq zzanq2 = zzanqArr2[i6];
                int[] iArr5 = new int[zza2.zza];
                for (int i10 = 0; i10 < zza2.zza; i10++) {
                    iArr5[i10] = zzanq2.zzG(zza2.zza(i10));
                }
                iArr = iArr5;
            }
            int i11 = iArr2[i6];
            zzatbArr[i6][i11] = zza2;
            iArr3[i6][i11] = iArr;
            iArr2[i6] = i11 + 1;
            i5++;
            i3 = 2;
        }
        zzatc[] zzatcArr = new zzatc[2];
        int[] iArr6 = new int[2];
        int i12 = 0;
        for (int i13 = 2; i12 < i13; i13 = 2) {
            int i14 = iArr2[i12];
            zzatcArr[i12] = new zzatc((zzatb[]) Arrays.copyOf(zzatbArr[i12], i14));
            iArr3[i12] = (int[][]) Arrays.copyOf(iArr3[i12], i14);
            iArr6[i12] = zzanqArr2[i12].zza();
            i12++;
        }
        zzatc zzatc3 = new zzatc((zzatb[]) Arrays.copyOf(zzatbArr[2], iArr2[2]));
        zzatg[] zzb2 = zzb(zzanqArr2, zzatcArr, iArr3);
        int i15 = 0;
        for (int i16 = 2; i15 < i16; i16 = 2) {
            if (this.zzb.get(i15)) {
                zzb2[i15] = null;
            } else {
                zzatc zzatc4 = zzatcArr[i15];
                Map map = this.zza.get(i15);
                if (map == null) {
                    zzatl = null;
                } else {
                    zzatl = (zzatl) map.get(zzatc4);
                }
                if (zzatl != null) {
                    throw null;
                }
            }
            i15++;
        }
        zzatk zzatk = new zzatk(iArr6, zzatcArr, iArr4, iArr3, zzatc3);
        zzanr[] zzanrArr = new zzanr[2];
        for (int i17 = 0; i17 < 2; i17++) {
            zzanrArr[i17] = zzb2[i17] != null ? zzanr.zza : null;
        }
        return new zzatr(zzatc2, new zzato(zzb2, (byte[]) null), zzatk, zzanrArr);
    }

    public final void zze(Object obj) {
        this.zzc = (zzatk) obj;
    }
}
