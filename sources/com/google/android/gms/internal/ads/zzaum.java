package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaum {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    public static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> zza(byte[] bArr) {
        zzaus zzaus = new zzaus(bArr, bArr.length);
        int zzc2 = zzc(zzaus);
        int zzd = zzd(zzaus);
        int zza2 = zzaus.zza(4);
        if (zzc2 == 5 || zzc2 == 29) {
            zzd = zzd(zzaus);
            if (zzc(zzaus) == 22) {
                zza2 = zzaus.zza(4);
            }
        }
        int i = zzc[zza2];
        zzaul.zza(i != -1);
        return Pair.create(Integer.valueOf(zzd), Integer.valueOf(i));
    }

    public static byte[] zzb(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i2 + 4)];
        System.arraycopy(zza, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }

    public static int zzc(zzaus zzaus) {
        int zza2 = zzaus.zza(5);
        return zza2 == 31 ? zzaus.zza(6) + 32 : zza2;
    }

    public static int zzd(zzaus zzaus) {
        int zza2 = zzaus.zza(4);
        if (zza2 == 15) {
            return zzaus.zza(24);
        }
        zzaul.zza(zza2 < 13);
        return zzb[zza2];
    }
}
