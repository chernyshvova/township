package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckh implements zzatv {
    public final zzatv zza;
    public final long zzb;
    public final zzatv zzc;
    public long zzd;
    public Uri zze;

    public zzckh(zzatv zzatv, int i, zzatv zzatv2) {
        this.zza = zzatv;
        this.zzb = (long) i;
        this.zzc = zzatv2;
    }

    public final long zza(zzatx zzatx) throws IOException {
        zzatx zzatx2;
        zzatx zzatx3 = zzatx;
        this.zze = zzatx3.zza;
        long j = zzatx3.zzc;
        long j2 = this.zzb;
        zzatx zzatx4 = null;
        if (j >= j2) {
            zzatx2 = null;
        } else {
            long j3 = zzatx3.zzd;
            zzatx2 = new zzatx(zzatx3.zza, (byte[]) null, j, j, j3 != -1 ? Math.min(j3, j2 - j) : j2 - j, (String) null, 0);
        }
        long j4 = zzatx3.zzd;
        if (j4 == -1 || zzatx3.zzc + j4 > this.zzb) {
            long max = Math.max(this.zzb, zzatx3.zzc);
            long j5 = zzatx3.zzd;
            zzatx4 = new zzatx(zzatx3.zza, (byte[]) null, max, max, j5 != -1 ? Math.min(j5, (zzatx3.zzc + j5) - this.zzb) : -1, (String) null, 0);
        }
        long j6 = 0;
        long zza2 = zzatx2 != null ? this.zza.zza(zzatx2) : 0;
        if (zzatx4 != null) {
            j6 = this.zzc.zza(zzatx4);
        }
        this.zzd = zzatx3.zzc;
        if (j6 == -1) {
            return -1;
        }
        return zza2 + j6;
    }

    public final int zzb(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int zzb2 = this.zza.zzb(bArr, i, (int) Math.min((long) i2, j2 - j));
            long j3 = this.zzd + ((long) zzb2);
            this.zzd = j3;
            i3 = zzb2;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < this.zzb) {
            return i3;
        }
        int zzb3 = this.zzc.zzb(bArr, i + i3, i2 - i3);
        this.zzd += (long) zzb3;
        return i3 + zzb3;
    }

    public final Uri zzc() {
        return this.zze;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }
}
