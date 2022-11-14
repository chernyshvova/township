package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzavh {
    public final List<byte[]> zza;
    public final int zzb;

    public zzavh(List<byte[]> list, int i) {
        this.zza = list;
        this.zzb = i;
    }

    public static zzavh zza(zzaut zzaut) throws zzann {
        List list;
        try {
            zzaut.zzj(21);
            int zzl = zzaut.zzl() & 3;
            int zzl2 = zzaut.zzl();
            int zzg = zzaut.zzg();
            int i = 0;
            for (int i2 = 0; i2 < zzl2; i2++) {
                zzaut.zzj(1);
                int zzm = zzaut.zzm();
                for (int i3 = 0; i3 < zzm; i3++) {
                    int zzm2 = zzaut.zzm();
                    i += zzm2 + 4;
                    zzaut.zzj(zzm2);
                }
            }
            zzaut.zzi(zzg);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < zzl2; i5++) {
                zzaut.zzj(1);
                int zzm3 = zzaut.zzm();
                for (int i6 = 0; i6 < zzm3; i6++) {
                    int zzm4 = zzaut.zzm();
                    System.arraycopy(zzaur.zza, 0, bArr, i4, 4);
                    int i7 = i4 + 4;
                    System.arraycopy(zzaut.zza, zzaut.zzg(), bArr, i7, zzm4);
                    i4 = i7 + zzm4;
                    zzaut.zzj(zzm4);
                }
            }
            if (i == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zzavh(list, zzl + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzann("Error parsing HEVC config", e);
        }
    }
}
