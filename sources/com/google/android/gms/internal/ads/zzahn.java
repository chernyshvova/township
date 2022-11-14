package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzahn extends zzahm {
    public final byte[] zza;
    @Nullable
    public Uri zzb;
    public int zzc;
    public int zzd;
    public boolean zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzahn(byte[] bArr) {
        super(false);
        boolean z = false;
        zzajg.zza(bArr.length > 0 ? true : z);
        this.zza = bArr;
    }

    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.zza, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzi(min);
        return min;
    }

    public final long zzc(zzahx zzahx) throws IOException {
        this.zzb = zzahx.zza;
        zzg(zzahx);
        long j = zzahx.zzf;
        int length = this.zza.length;
        if (j <= ((long) length)) {
            int i = (int) j;
            this.zzc = i;
            int i2 = length - i;
            this.zzd = i2;
            long j2 = zzahx.zzg;
            if (j2 != -1) {
                this.zzd = (int) Math.min((long) i2, j2);
            }
            this.zze = true;
            zzh(zzahx);
            long j3 = zzahx.zzg;
            return j3 != -1 ? j3 : (long) this.zzd;
        }
        throw new zzahu(0);
    }

    @Nullable
    public final Uri zzd() {
        return this.zzb;
    }

    public final void zzf() {
        if (this.zze) {
            this.zze = false;
            zzj();
        }
        this.zzb = null;
    }
}
