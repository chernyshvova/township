package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzals {
    @Nullable
    public final List<byte[]> zza;
    public final int zzb;
    @Nullable
    public final String zzc;

    public zzals(@Nullable List<byte[]> list, int i, @Nullable String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = str;
    }

    public static zzals zza(zzakr zzakr) throws zzlg {
        List list;
        zzakr zzakr2 = zzakr;
        try {
            zzakr2.zzk(21);
            int zzn = zzakr.zzn() & 3;
            int zzn2 = zzakr.zzn();
            int zzg = zzakr.zzg();
            int i = 0;
            for (int i2 = 0; i2 < zzn2; i2++) {
                zzakr2.zzk(1);
                int zzo = zzakr.zzo();
                for (int i3 = 0; i3 < zzo; i3++) {
                    int zzo2 = zzakr.zzo();
                    i += zzo2 + 4;
                    zzakr2.zzk(zzo2);
                }
            }
            zzakr2.zzh(zzg);
            byte[] bArr = new byte[i];
            String str = null;
            int i4 = 0;
            for (int i5 = 0; i5 < zzn2; i5++) {
                int zzn3 = zzakr.zzn() & 127;
                int zzo3 = zzakr.zzo();
                int i6 = 0;
                while (i6 < zzo3) {
                    int zzo4 = zzakr.zzo();
                    System.arraycopy(zzakj.zza, 0, bArr, i4, 4);
                    int i7 = i4 + 4;
                    System.arraycopy(zzakr.zzi(), zzakr.zzg(), bArr, i7, zzo4);
                    if (zzn3 == 33 && i6 == 0) {
                        str = zzaji.zzb(new zzaks(bArr, i7, i7 + zzo4));
                        i6 = 0;
                    }
                    i4 = i7 + zzo4;
                    zzakr2.zzk(zzo4);
                    i6++;
                }
            }
            if (i == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zzals(list, zzn + 1, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlg("Error parsing HEVC config", e);
        }
    }
}
