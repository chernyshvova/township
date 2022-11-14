package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzvl {
    public final zzakr zza = new zzakr(8);
    public int zzb;

    private final long zzb(zztb zztb) throws IOException {
        zzsx zzsx = (zzsx) zztb;
        int i = 0;
        zzsx.zzh(this.zza.zzi(), 0, 1, false);
        byte b = this.zza.zzi()[0] & Base64.EQUALS_SIGN_ENC;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (i2 ^ -1);
        zzsx.zzh(this.zza.zzi(), 1, i3, false);
        while (i < i3) {
            i++;
            i4 = (this.zza.zzi()[i] & Base64.EQUALS_SIGN_ENC) + (i4 << 8);
        }
        this.zzb = i3 + 1 + this.zzb;
        return (long) i4;
    }

    public final boolean zza(zztb zztb) throws IOException {
        long zzo = zztb.zzo();
        long j = 1024;
        if (zzo != -1 && zzo <= 1024) {
            j = zzo;
        }
        int i = (int) j;
        zzsx zzsx = (zzsx) zztb;
        zzsx.zzh(this.zza.zzi(), 0, 4, false);
        long zzt = this.zza.zzt();
        this.zzb = 4;
        while (zzt != 440786851) {
            int i2 = this.zzb + 1;
            this.zzb = i2;
            if (i2 == i) {
                return false;
            }
            zzsx.zzh(this.zza.zzi(), 0, 1, false);
            zzt = ((zzt << 8) & -256) | ((long) (this.zza.zzi()[0] & Base64.EQUALS_SIGN_ENC));
        }
        long zzb2 = zzb(zztb);
        long j2 = (long) this.zzb;
        if (zzb2 != Long.MIN_VALUE && (zzo == -1 || j2 + zzb2 < zzo)) {
            while (true) {
                long j3 = (long) this.zzb;
                long j4 = j2 + zzb2;
                if (j3 < j4) {
                    if (zzb(zztb) == Long.MIN_VALUE) {
                        return false;
                    }
                    long zzb3 = zzb(zztb);
                    if (zzb3 < 0) {
                        return false;
                    }
                    if (zzb3 != 0) {
                        int i3 = (int) zzb3;
                        zzsx.zzj(i3, false);
                        this.zzb += i3;
                    }
                } else if (j3 == j4) {
                    return true;
                }
            }
        }
        return false;
    }
}
