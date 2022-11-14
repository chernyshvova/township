package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxj extends zzxn {
    public static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean zzb;

    public static boolean zzd(zzakr zzakr) {
        if (zzakr.zzd() < 8) {
            return false;
        }
        byte[] bArr = new byte[8];
        zzakr.zzm(bArr, 0, 8);
        return Arrays.equals(bArr, zza);
    }

    public final void zza(boolean z) {
        super.zza(z);
        if (z) {
            this.zzb = false;
        }
    }

    public final long zzb(zzakr zzakr) {
        byte[] zzi = zzakr.zzi();
        byte b = zzi[0] & Base64.EQUALS_SIGN_ENC;
        byte b2 = b & 3;
        byte b3 = 2;
        if (b2 == 0) {
            b3 = 1;
        } else if (!(b2 == 1 || b2 == 2)) {
            b3 = zzi[1] & 63;
        }
        int i = b >> 3;
        int i2 = i & 3;
        return zzi(((long) b3) * ((long) (i >= 16 ? 2500 << i2 : i >= 12 ? 10000 << (i2 & 1) : i2 == 3 ? 60000 : 10000 << i2)));
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzakr zzakr, long j, zzxl zzxl) {
        boolean z = true;
        if (!this.zzb) {
            byte[] copyOf = Arrays.copyOf(zzakr.zzi(), zzakr.zze());
            byte b = copyOf[9];
            List<byte[]> zza2 = zzre.zza(copyOf);
            zzkb zzkb = new zzkb();
            zzkb.zzj("audio/opus");
            zzkb.zzw(b & Base64.EQUALS_SIGN_ENC);
            zzkb.zzx(48000);
            zzkb.zzl(zza2);
            zzxl.zza = zzkb.zzD();
            this.zzb = true;
            return true;
        } else if (zzxl.zza != null) {
            if (zzakr.zzv() != 1332770163) {
                z = false;
            }
            zzakr.zzh(0);
            return z;
        } else {
            throw null;
        }
    }
}
