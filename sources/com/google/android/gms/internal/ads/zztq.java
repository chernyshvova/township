package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zztq {
    public final zzakr zza = new zzakr(10);

    @Nullable
    public final zzabe zza(zztb zztb, @Nullable zzacd zzacd) throws IOException {
        zzabe zzabe = null;
        int i = 0;
        while (true) {
            try {
                ((zzsx) zztb).zzh(this.zza.zzi(), 0, 10, false);
                this.zza.zzh(0);
                if (this.zza.zzr() != 4801587) {
                    break;
                }
                this.zza.zzk(3);
                int zzA = this.zza.zzA();
                int i2 = zzA + 10;
                if (zzabe == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.zza.zzi(), 0, bArr, 0, 10);
                    ((zzsx) zztb).zzh(bArr, 10, zzA, false);
                    zzabe = zzacf.zza(bArr, i2, zzacd, new zzabg());
                } else {
                    ((zzsx) zztb).zzj(zzA, false);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        zztb.zzl();
        ((zzsx) zztb).zzj(i, false);
        return zzabe;
    }
}
