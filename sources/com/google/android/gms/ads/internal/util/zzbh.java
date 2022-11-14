package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbh {
    public final String[] zza;
    public final double[] zzb;
    public final double[] zzc;
    public final int[] zzd;
    public int zze = 0;

    public /* synthetic */ zzbh(zzbg zzbg, zzbe zzbe) {
        int size = zzbg.zzb.size();
        this.zza = (String[]) zzbg.zza.toArray(new String[size]);
        this.zzb = zzc(zzbg.zzb);
        this.zzc = zzc(zzbg.zzc);
        this.zzd = new int[size];
    }

    public static final double[] zzc(List<Double> list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d) {
        this.zze++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzc;
            if (i < dArr.length) {
                double d2 = dArr[i];
                if (d2 <= d && d < this.zzb[i]) {
                    int[] iArr = this.zzd;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= d2) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final List<zzbf> zzb() {
        ArrayList arrayList = new ArrayList(this.zza.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zza;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.zzc[i];
            double d2 = this.zzb[i];
            int i2 = this.zzd[i];
            double d3 = (double) i2;
            double d4 = (double) this.zze;
            Double.isNaN(d3);
            Double.isNaN(d4);
            arrayList.add(new zzbf(str, d, d2, d3 / d4, i2));
            i++;
        }
    }
}
