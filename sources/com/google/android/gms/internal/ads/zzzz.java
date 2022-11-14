package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzz {
    @Nullable
    public static zzzx zza(zztb zztb) throws IOException {
        byte[] bArr;
        zzakr zzakr = new zzakr(16);
        if (zzzy.zza(zztb, zzakr).zza != 1380533830) {
            return null;
        }
        zzsx zzsx = (zzsx) zztb;
        zzsx.zzh(zzakr.zzi(), 0, 4, false);
        zzakr.zzh(0);
        int zzv = zzakr.zzv();
        if (zzv != 1463899717) {
            StringBuilder sb = new StringBuilder(36);
            sb.append("Unsupported RIFF format: ");
            sb.append(zzv);
            Log.e("WavHeaderReader", sb.toString());
            return null;
        }
        zzzy zza = zzzy.zza(zztb, zzakr);
        while (zza.zza != 1718449184) {
            zzsx.zzj((int) zza.zzb, false);
            zza = zzzy.zza(zztb, zzakr);
        }
        zzajg.zzd(zza.zzb >= 16);
        zzsx.zzh(zzakr.zzi(), 0, 16, false);
        zzakr.zzh(0);
        int zzp = zzakr.zzp();
        int zzp2 = zzakr.zzp();
        int zzC = zzakr.zzC();
        int zzC2 = zzakr.zzC();
        int zzp3 = zzakr.zzp();
        int zzp4 = zzakr.zzp();
        int i = ((int) zza.zzb) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            zzsx.zzh(bArr2, 0, i, false);
            bArr = bArr2;
        } else {
            bArr = zzalh.zzf;
        }
        return new zzzx(zzp, zzp2, zzC, zzC2, zzp3, zzp4, bArr);
    }
}
