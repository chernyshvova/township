package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzuj implements zzss {
    public final zztn zza;
    public final int zzb;
    public final zzth zzc = new zzth();

    public /* synthetic */ zzuj(zztn zztn, int i, zzui zzui) {
        this.zza = zztn;
        this.zzb = i;
    }

    private final long zzc(zztb zztb) throws IOException {
        zztb zztb2 = zztb;
        while (zztb.zzm() < zztb.zzo() - 6) {
            zztn zztn = this.zza;
            int i = this.zzb;
            zzth zzth = this.zzc;
            long zzm = zztb.zzm();
            byte[] bArr = new byte[2];
            zzsx zzsx = (zzsx) zztb2;
            zzsx.zzh(bArr, 0, 2, false);
            if ((((bArr[0] & Base64.EQUALS_SIGN_ENC) << 8) | (bArr[1] & Base64.EQUALS_SIGN_ENC)) != i) {
                zztb.zzl();
                zzsx.zzj((int) (zzm - zztb.zzn()), false);
            } else {
                zzakr zzakr = new zzakr(16);
                System.arraycopy(bArr, 0, zzakr.zzi(), 0, 2);
                zzakr.zzf(zzte.zzb(zztb2, zzakr.zzi(), 2, 14));
                zztb.zzl();
                zzsx.zzj((int) (zzm - zztb.zzn()), false);
                if (zzti.zza(zzakr, zztn, i, zzth)) {
                    break;
                }
            }
            zzsx.zzj(1, false);
        }
        if (zztb.zzm() < zztb.zzo() - 6) {
            return this.zzc.zza;
        }
        ((zzsx) zztb2).zzj((int) (zztb.zzo() - zztb.zzm()), false);
        return this.zza.zzj;
    }

    public final zzsr zza(zztb zztb, long j) throws IOException {
        long zzn = zztb.zzn();
        long zzc2 = zzc(zztb);
        long zzm = zztb.zzm();
        ((zzsx) zztb).zzj(Math.max(6, this.zza.zzc), false);
        long zzc3 = zzc(zztb);
        long zzm2 = zztb.zzm();
        if (zzc2 > j || zzc3 <= j) {
            return zzc3 <= j ? zzsr.zzb(zzc3, zzm2) : zzsr.zza(zzc2, zzn);
        }
        return zzsr.zzc(zzm);
    }

    public final void zzb() {
    }
}
