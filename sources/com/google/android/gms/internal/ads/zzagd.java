package com.google.android.gms.internal.ads;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzagd extends zzagf {
    public final zzahl zzd;
    public final zzfml<zzagb> zze;
    public final zzajh zzf;

    public zzagd(zzafr zzafr, int[] iArr, int i, zzahl zzahl, long j, long j2, long j3, float f, float f2, List<zzagb> list, zzajh zzajh) {
        super(zzafr, iArr, i);
        this.zzd = zzahl;
        this.zze = zzfml.zzp(list);
        this.zzf = zzajh;
    }

    public static /* synthetic */ zzfml zza(zzagt[] zzagtArr) {
        int length;
        int i;
        int[] iArr;
        double d;
        zzagt[] zzagtArr2 = zzagtArr;
        ArrayList arrayList = new ArrayList();
        char c = 0;
        int i2 = 0;
        while (true) {
            length = zzagtArr2.length;
            i = 1;
            if (i2 >= length) {
                break;
            }
            zzagt zzagt = zzagtArr2[i2];
            if (zzagt == null || zzagt.zzb.length <= 1) {
                arrayList.add((Object) null);
            } else {
                zzfmi zzu = zzfml.zzu();
                zzu.zze(new zzagb(0, 0));
                arrayList.add(zzu);
            }
            i2++;
        }
        long[][] jArr = new long[length][];
        for (int i3 = 0; i3 < zzagtArr2.length; i3++) {
            zzagt zzagt2 = zzagtArr2[i3];
            if (zzagt2 == null) {
                jArr[i3] = new long[0];
            } else {
                jArr[i3] = new long[zzagt2.zzb.length];
                int i4 = 0;
                while (true) {
                    int[] iArr2 = zzagt2.zzb;
                    if (i4 >= iArr2.length) {
                        break;
                    }
                    jArr[i3][i4] = (long) zzagt2.zza.zza(iArr2[i4]).zzh;
                    i4++;
                }
                Arrays.sort(jArr[i3]);
            }
        }
        int[] iArr3 = new int[length];
        long[] jArr2 = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            long[] jArr3 = jArr[i5];
            jArr2[i5] = jArr3.length == 0 ? 0 : jArr3[0];
        }
        zzf(arrayList, jArr2);
        zzfna zza = zzfns.zzc(zzfnx.zzb()).zzb(2).zza();
        int i6 = 0;
        while (i6 < length) {
            int length2 = jArr[i6].length;
            if (length2 <= i) {
                iArr = iArr3;
            } else {
                double[] dArr = new double[length2];
                int i7 = 0;
                while (true) {
                    long[] jArr4 = jArr[i6];
                    int length3 = jArr4.length;
                    double d2 = RoundRectDrawableWithShadow.COS_45;
                    if (i7 >= length3) {
                        break;
                    }
                    int[] iArr4 = iArr3;
                    long j = jArr4[i7];
                    if (j != -1) {
                        d2 = Math.log((double) j);
                    }
                    dArr[i7] = d2;
                    i7++;
                    iArr3 = iArr4;
                }
                iArr = iArr3;
                int i8 = length2 - 1;
                double d3 = dArr[i8] - dArr[c];
                int i9 = 0;
                while (i9 < i8) {
                    int i10 = i9 + 1;
                    double d4 = (dArr[i9] + dArr[i10]) * 0.5d;
                    if (d3 == RoundRectDrawableWithShadow.COS_45) {
                        d = 1.0d;
                    } else {
                        d = (d4 - dArr[c]) / d3;
                    }
                    zza.zze(Double.valueOf(d), Integer.valueOf(i6));
                    i9 = i10;
                    c = 0;
                }
            }
            i6++;
            iArr3 = iArr;
            c = 0;
            i = 1;
        }
        int[] iArr5 = iArr3;
        zzfml zzp = zzfml.zzp(zza.zzv());
        for (int i11 = 0; i11 < zzp.size(); i11++) {
            int intValue = ((Integer) zzp.get(i11)).intValue();
            int i12 = iArr5[intValue] + 1;
            iArr5[intValue] = i12;
            jArr2[intValue] = jArr[intValue][i12];
            zzf(arrayList, jArr2);
        }
        for (int i13 = 0; i13 < zzagtArr2.length; i13++) {
            if (arrayList.get(i13) != null) {
                long j2 = jArr2[i13];
                jArr2[i13] = j2 + j2;
            }
        }
        zzf(arrayList, jArr2);
        zzfmi zzu2 = zzfml.zzu();
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            zzfmi zzfmi = (zzfmi) arrayList.get(i14);
            zzu2.zze(zzfmi == null ? zzfml.zzi() : zzfmi.zzf());
        }
        return zzu2.zzf();
    }

    public static void zzf(List<zzfmi<zzagb>> list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            zzfmi zzfmi = list.get(i);
            if (zzfmi != null) {
                zzfmi.zze(new zzagb(j, jArr[i]));
            }
        }
    }
}
