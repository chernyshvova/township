package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzagw extends zzahc {
    @Nullable
    public zzagv zza;

    public abstract Pair<zzmc[], zzagf[]> zzc(zzagv zzagv, int[][][] iArr, int[] iArr2, zzadv zzadv, zzmv zzmv) throws zzio;

    public final void zzi(@Nullable Object obj) {
        this.zza = (zzagv) obj;
    }

    public final zzahd zzj(zzmb[] zzmbArr, zzaft zzaft, zzadv zzadv, zzmv zzmv) throws zzio {
        int[] iArr;
        zzaft zzaft2 = zzaft;
        int[] iArr2 = new int[3];
        zzafr[][] zzafrArr = new zzafr[3][];
        int[][][] iArr3 = new int[3][][];
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = zzaft2.zzb;
            zzafrArr[i2] = new zzafr[i3];
            iArr3[i2] = new int[i3][];
        }
        int i4 = 2;
        int[] iArr4 = new int[2];
        for (int i5 = 0; i5 < 2; i5++) {
            iArr4[i5] = zzmbArr[i5].zzs();
        }
        int i6 = 0;
        while (i6 < zzaft2.zzb) {
            zzafr zza2 = zzaft2.zza(i6);
            int zzf = zzakg.zzf(zza2.zza(i).zzl);
            int i7 = 0;
            int i8 = 2;
            int i9 = 0;
            boolean z = true;
            while (i7 < i4) {
                zzmb zzmb = zzmbArr[i7];
                int i10 = 0;
                while (i < zza2.zza) {
                    i10 = Math.max(i10, zzmb.zzN(zza2.zza(i)) & 7);
                    i++;
                }
                boolean z2 = iArr2[i7] == 0;
                if (i10 > i9) {
                    z = z2;
                    i9 = i10;
                    i8 = i7;
                } else if (i10 == i9 && zzf == 5 && !z && z2) {
                    i9 = i10;
                    i8 = i7;
                    z = true;
                }
                i7++;
                i4 = 2;
                i = 0;
            }
            if (i8 == i4) {
                iArr = new int[zza2.zza];
            } else {
                zzmb zzmb2 = zzmbArr[i8];
                int[] iArr5 = new int[zza2.zza];
                for (int i11 = 0; i11 < zza2.zza; i11++) {
                    iArr5[i11] = zzmb2.zzN(zza2.zza(i11));
                }
                iArr = iArr5;
            }
            int i12 = iArr2[i8];
            zzafrArr[i8][i12] = zza2;
            iArr3[i8][i12] = iArr;
            iArr2[i8] = i12 + 1;
            i6++;
            i4 = 2;
            i = 0;
        }
        zzaft[] zzaftArr = new zzaft[i4];
        String[] strArr = new String[i4];
        int[] iArr6 = new int[i4];
        int i13 = 0;
        while (i13 < i4) {
            int i14 = iArr2[i13];
            zzaftArr[i13] = new zzaft((zzafr[]) zzalh.zzf(zzafrArr[i13], i14));
            iArr3[i13] = (int[][]) zzalh.zzf(iArr3[i13], i14);
            strArr[i13] = zzmbArr[i13].zzJ();
            iArr6[i13] = zzmbArr[i13].zza();
            i13++;
            i4 = 2;
        }
        zzagv zzagv = new zzagv(strArr, iArr6, zzaftArr, iArr4, iArr3, new zzaft((zzafr[]) zzalh.zzf(zzafrArr[2], iArr2[2])));
        Pair<zzmc[], zzagf[]> zzc = zzc(zzagv, iArr3, iArr4, zzadv, zzmv);
        return new zzahd((zzmc[]) zzc.first, (zzagf[]) zzc.second, zzagv, (byte[]) null);
    }
}
