package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.swrve.sdk.rest.RESTClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzvw implements zzvu {
    public final long zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    @Nullable
    public final long[] zzf;

    public zzvw(long j, int i, long j2, long j3, @Nullable long[] jArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = j3;
        this.zze = j3 != -1 ? j + j3 : -1;
    }

    @Nullable
    public static zzvw zzd(long j, long j2, zzrc zzrc, zzakr zzakr) {
        int zzB;
        long j3 = j;
        zzrc zzrc2 = zzrc;
        int i = zzrc2.zzg;
        int i2 = zzrc2.zzd;
        int zzv = zzakr.zzv();
        if ((zzv & 1) != 1 || (zzB = zzakr.zzB()) == 0) {
            return null;
        }
        long zzF = zzalh.zzF((long) zzB, ((long) i) * 1000000, (long) i2);
        if ((zzv & 6) != 6) {
            return new zzvw(j2, zzrc2.zzc, zzF, -1, (long[]) null);
        }
        long zzt = zzakr.zzt();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = (long) zzakr.zzn();
        }
        if (j3 != -1) {
            long j4 = j2 + zzt;
            if (j3 != j4) {
                StringBuilder sb = new StringBuilder(67);
                sb.append("XING data size mismatch: ");
                sb.append(j3);
                sb.append(RESTClient.COMMA_SEPARATOR);
                sb.append(j4);
                Log.w("XingSeeker", sb.toString());
            }
        }
        return new zzvw(j2, zzrc2.zzc, zzF, zzt, jArr);
    }

    private final long zzg(int i) {
        return (this.zzc * ((long) i)) / 100;
    }

    public final boolean zza() {
        return this.zzf != null;
    }

    public final zztt zzb(long j) {
        double d;
        if (!zza()) {
            zztw zztw = new zztw(0, this.zza + ((long) this.zzb));
            return new zztt(zztw, zztw);
        }
        long zzy = zzalh.zzy(j, 0, this.zzc);
        double d2 = (double) zzy;
        Double.isNaN(d2);
        double d3 = (double) this.zzc;
        Double.isNaN(d3);
        double d4 = (d2 * 100.0d) / d3;
        double d5 = RoundRectDrawableWithShadow.COS_45;
        if (d4 > RoundRectDrawableWithShadow.COS_45) {
            if (d4 >= 100.0d) {
                d5 = 256.0d;
            } else {
                int i = (int) d4;
                long[] jArr = (long[]) zzajg.zze(this.zzf);
                double d6 = (double) jArr[i];
                if (i == 99) {
                    d = 256.0d;
                } else {
                    d = (double) jArr[i + 1];
                }
                double d7 = (double) i;
                Double.isNaN(d7);
                Double.isNaN(d6);
                Double.isNaN(d6);
                d5 = d6 + ((d - d6) * (d4 - d7));
            }
        }
        double d8 = (double) this.zzd;
        Double.isNaN(d8);
        zztw zztw2 = new zztw(zzy, this.zza + zzalh.zzy(Math.round((d5 / 256.0d) * d8), (long) this.zzb, this.zzd - 1));
        return new zztt(zztw2, zztw2);
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zze(long j) {
        long j2;
        double d;
        long j3 = j - this.zza;
        if (!zza() || j3 <= ((long) this.zzb)) {
            return 0;
        }
        long[] jArr = (long[]) zzajg.zze(this.zzf);
        double d2 = (double) j3;
        Double.isNaN(d2);
        double d3 = (double) this.zzd;
        Double.isNaN(d3);
        double d4 = (d2 * 256.0d) / d3;
        int zzD = zzalh.zzD(jArr, (long) d4, true, true);
        long zzg = zzg(zzD);
        long j4 = jArr[zzD];
        int i = zzD + 1;
        long zzg2 = zzg(i);
        if (zzD == 99) {
            j2 = 256;
        } else {
            j2 = jArr[i];
        }
        if (j4 == j2) {
            d = RoundRectDrawableWithShadow.COS_45;
        } else {
            double d5 = (double) j4;
            Double.isNaN(d5);
            double d6 = (double) (j2 - j4);
            Double.isNaN(d6);
            d = (d4 - d5) / d6;
        }
        double d7 = (double) (zzg2 - zzg);
        Double.isNaN(d7);
        return Math.round(d * d7) + zzg;
    }

    public final long zzf() {
        return this.zze;
    }
}
