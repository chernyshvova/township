package com.google.android.gms.internal.ads;

import android.util.Log;
import com.playrix.gplay.billing.Base64;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaac {
    public long zza;
    public long zzb;
    public boolean zzc;

    public final void zza() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = false;
    }

    public final long zzb(zzkc zzkc, zzrr zzrr) {
        if (this.zzc) {
            return zzrr.zzd;
        }
        ByteBuffer byteBuffer = zzrr.zzb;
        if (byteBuffer != null) {
            byte b = 0;
            for (int i = 0; i < 4; i++) {
                b = (b << 8) | (byteBuffer.get(i) & Base64.EQUALS_SIGN_ENC);
            }
            int zzb2 = zzrd.zzb(b);
            if (zzb2 == -1) {
                this.zzc = true;
                Log.w("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
                return zzrr.zzd;
            }
            long j = this.zza;
            if (j == 0) {
                long j2 = zzrr.zzd;
                this.zzb = j2;
                this.zza = ((long) zzb2) - 529;
                return j2;
            }
            long j3 = (1000000 * j) / ((long) zzkc.zzz);
            this.zza = j + ((long) zzb2);
            return this.zzb + j3;
        }
        throw null;
    }
}
