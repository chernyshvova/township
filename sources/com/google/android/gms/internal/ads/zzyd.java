package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyd {
    public static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    public boolean zze;

    public zzyd(int i) {
    }

    public final void zza() {
        this.zze = false;
        this.zza = 0;
        this.zzb = 0;
    }

    public final boolean zzb(int i, int i2) {
        if (this.zze) {
            int i3 = this.zza - i2;
            this.zza = i3;
            if (this.zzb == 0 && i == 181) {
                this.zzb = i3;
            } else {
                this.zze = false;
                return true;
            }
        } else if (i == 179) {
            this.zze = true;
        }
        zzc(zzd, 0, 3);
        return false;
    }

    public final void zzc(byte[] bArr, int i, int i2) {
        if (this.zze) {
            int i3 = i2 - i;
            byte[] bArr2 = this.zzc;
            int length = bArr2.length;
            int i4 = this.zza + i3;
            if (length < i4) {
                this.zzc = Arrays.copyOf(bArr2, i4 + i4);
            }
            System.arraycopy(bArr, i, this.zzc, this.zza, i3);
            this.zza += i3;
        }
    }
}
