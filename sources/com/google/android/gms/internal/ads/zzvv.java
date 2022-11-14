package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import com.swrve.sdk.rest.RESTClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzvv implements zzvu {
    public final long[] zza;
    public final long[] zzb;
    public final long zzc;
    public final long zzd;

    public zzvv(long[] jArr, long[] jArr2, long j, long j2) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j2;
    }

    @Nullable
    public static zzvv zzd(long j, long j2, zzrc zzrc, zzakr zzakr) {
        int i;
        long j3 = j;
        zzrc zzrc2 = zzrc;
        zzakr zzakr2 = zzakr;
        zzakr2.zzk(10);
        int zzv = zzakr.zzv();
        if (zzv <= 0) {
            return null;
        }
        int i2 = zzrc2.zzd;
        long zzF = zzalh.zzF((long) zzv, ((long) (i2 >= 32000 ? 1152 : 576)) * 1000000, (long) i2);
        int zzo = zzakr.zzo();
        int zzo2 = zzakr.zzo();
        int zzo3 = zzakr.zzo();
        zzakr2.zzk(2);
        long j4 = j2 + ((long) zzrc2.zzc);
        long[] jArr = new long[zzo];
        long[] jArr2 = new long[zzo];
        int i3 = 0;
        long j5 = j2;
        while (i3 < zzo) {
            int i4 = zzo2;
            jArr[i3] = (((long) i3) * zzF) / ((long) zzo);
            long j6 = j4;
            jArr2[i3] = Math.max(j5, j6);
            if (zzo3 == 1) {
                i = zzakr.zzn();
            } else if (zzo3 == 2) {
                i = zzakr.zzo();
            } else if (zzo3 == 3) {
                i = zzakr.zzr();
            } else if (zzo3 != 4) {
                return null;
            } else {
                i = zzakr.zzB();
            }
            j5 += (long) (i * i4);
            i3++;
            j4 = j6;
            zzo2 = i4;
        }
        if (!(j3 == -1 || j3 == j5)) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("VBRI data size mismatch: ");
            sb.append(j3);
            sb.append(RESTClient.COMMA_SEPARATOR);
            sb.append(j5);
            Log.w("VbriSeeker", sb.toString());
        }
        return new zzvv(jArr, jArr2, zzF, j5);
    }

    public final boolean zza() {
        return true;
    }

    public final zztt zzb(long j) {
        int zzD = zzalh.zzD(this.zza, j, true, true);
        zztw zztw = new zztw(this.zza[zzD], this.zzb[zzD]);
        if (zztw.zzb < j) {
            long[] jArr = this.zza;
            if (zzD != jArr.length - 1) {
                int i = zzD + 1;
                return new zztt(zztw, new zztw(jArr[i], this.zzb[i]));
            }
        }
        return new zztt(zztw, zztw);
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zze(long j) {
        return this.zza[zzalh.zzD(this.zzb, j, true, true)];
    }

    public final long zzf() {
        return this.zzd;
    }
}
