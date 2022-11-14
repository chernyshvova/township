package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.playrix.gplay.billing.Base64;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzadl implements zzaht {
    public final zzaht zza;
    public final int zzb;
    public final zzadk zzc;
    public final byte[] zzd;
    public int zze;

    public zzadl(zzaht zzaht, int i, zzadk zzadk) {
        zzajg.zza(i > 0);
        this.zza = zzaht;
        this.zzb = i;
        this.zzc = zzadk;
        this.zzd = new byte[1];
        this.zze = i;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zze;
        if (i3 == 0) {
            int i4 = 0;
            if (this.zza.zza(this.zzd, 0, 1) != -1) {
                int i5 = (this.zzd[0] & Base64.EQUALS_SIGN_ENC) << 4;
                if (i5 != 0) {
                    byte[] bArr2 = new byte[i5];
                    int i6 = i5;
                    while (i6 > 0) {
                        int zza2 = this.zza.zza(bArr2, i4, i6);
                        if (zza2 != -1) {
                            i4 += zza2;
                            i6 -= zza2;
                        }
                    }
                    while (i5 > 0) {
                        int i7 = i5 - 1;
                        if (bArr2[i7] != 0) {
                            break;
                        }
                        i5 = i7;
                    }
                    if (i5 > 0) {
                        this.zzc.zza(new zzakr(bArr2, i5));
                    }
                }
                i3 = this.zzb;
                this.zze = i3;
            }
            return -1;
        }
        int zza3 = this.zza.zza(bArr, i, Math.min(i3, i2));
        if (zza3 != -1) {
            this.zze -= zza3;
        }
        return zza3;
    }

    public final void zzb(zzajd zzajd) {
        if (zzajd != null) {
            this.zza.zzb(zzajd);
            return;
        }
        throw null;
    }

    public final long zzc(zzahx zzahx) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public final Uri zzd() {
        return this.zza.zzd();
    }

    public final Map<String, List<String>> zze() {
        return this.zza.zze();
    }

    public final void zzf() {
        throw new UnsupportedOperationException();
    }
}
