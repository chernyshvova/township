package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzte {
    @Pure
    public static void zza(boolean z, @Nullable String str) throws zzlg {
        if (!z) {
            throw zzlg.zza(str, (Throwable) null);
        }
    }

    public static int zzb(zztb zztb, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int zzg = zztb.zzg(bArr, i + i3, i2 - i3);
            if (zzg == -1) {
                break;
            }
            i3 += zzg;
        }
        return i3;
    }
}
