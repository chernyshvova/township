package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.playrix.gplay.billing.Base64;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxd extends zzxn {
    @Nullable
    public zztn zza;
    @Nullable
    public zzxc zzb;

    public static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    public final void zza(boolean z) {
        super.zza(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    public final long zzb(zzakr zzakr) {
        if (!zzd(zzakr.zzi())) {
            return -1;
        }
        int i = (zzakr.zzi()[2] & Base64.EQUALS_SIGN_ENC) >> 4;
        if (i != 6) {
            if (i == 7) {
                i = 7;
            }
            int zzc = zzti.zzc(zzakr, i);
            zzakr.zzh(0);
            return (long) zzc;
        }
        zzakr.zzk(4);
        zzakr.zzH();
        int zzc2 = zzti.zzc(zzakr, i);
        zzakr.zzh(0);
        return (long) zzc2;
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzakr zzakr, long j, zzxl zzxl) {
        byte[] zzi = zzakr.zzi();
        zztn zztn = this.zza;
        if (zztn == null) {
            zztn zztn2 = new zztn(zzi, 17);
            this.zza = zztn2;
            zzxl.zza = zztn2.zzc(Arrays.copyOfRange(zzi, 9, zzakr.zze()), (zzabe) null);
            return true;
        } else if ((zzi[0] & Byte.MAX_VALUE) == 3) {
            zztm zzb2 = zztk.zzb(zzakr);
            zztn zze = zztn.zze(zzb2);
            this.zza = zze;
            this.zzb = new zzxc(zze, zzb2);
            return true;
        } else if (!zzd(zzi)) {
            return true;
        } else {
            zzxc zzxc = this.zzb;
            if (zzxc != null) {
                zzxc.zzd(j);
                zzxl.zzb = this.zzb;
            }
            if (zzxl.zza != null) {
                return false;
            }
            throw null;
        }
    }
}
