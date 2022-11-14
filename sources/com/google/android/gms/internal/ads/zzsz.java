package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzsz implements zztz {
    public final byte[] zza = new byte[4096];

    public final void zza(zzkc zzkc) {
    }

    public final int zzb(zzahq zzahq, int i, boolean z, int i2) throws IOException {
        int zza2 = zzahq.zza(this.zza, 0, Math.min(4096, i));
        if (zza2 != -1) {
            return zza2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void zzc(zzakr zzakr, int i, int i2) {
        zzakr.zzk(i);
    }

    public final void zzd(long j, int i, int i2, int i3, @Nullable zzty zzty) {
    }

    public final int zze(zzahq zzahq, int i, boolean z) throws IOException {
        return zztx.zza(this, zzahq, i, true);
    }

    public final void zzf(zzakr zzakr, int i) {
        zztx.zzb(this, zzakr, i);
    }
}
