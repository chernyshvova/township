package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzclm implements zzaht {
    public final zzaht zza;
    public final long zzb;
    public final zzaht zzc;
    public long zzd;
    public Uri zze;

    public zzclm(zzaht zzaht, int i, zzaht zzaht2) {
        this.zza = zzaht;
        this.zzb = (long) i;
        this.zzc = zzaht2;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int zza2 = this.zza.zza(bArr, i, (int) Math.min((long) i2, j2 - j));
            long j3 = this.zzd + ((long) zza2);
            this.zzd = j3;
            i3 = zza2;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < this.zzb) {
            return i3;
        }
        int zza3 = this.zzc.zza(bArr, i + i3, i2 - i3);
        this.zzd += (long) zza3;
        return i3 + zza3;
    }

    public final void zzb(zzajd zzajd) {
    }

    public final long zzc(zzahx zzahx) throws IOException {
        zzahx zzahx2;
        zzahx zzahx3 = zzahx;
        this.zze = zzahx3.zza;
        long j = zzahx3.zzf;
        long j2 = this.zzb;
        zzahx zzahx4 = null;
        if (j >= j2) {
            zzahx2 = null;
        } else {
            long j3 = zzahx3.zzg;
            zzahx2 = new zzahx(zzahx3.zza, (byte[]) null, j, j, j3 != -1 ? Math.min(j3, j2 - j) : j2 - j, (String) null, 0);
        }
        long j4 = zzahx3.zzg;
        if (j4 == -1 || zzahx3.zzf + j4 > this.zzb) {
            long max = Math.max(this.zzb, zzahx3.zzf);
            long j5 = zzahx3.zzg;
            zzahx4 = new zzahx(zzahx3.zza, (byte[]) null, max, max, j5 != -1 ? Math.min(j5, (zzahx3.zzf + j5) - this.zzb) : -1, (String) null, 0);
        }
        long j6 = 0;
        long zzc2 = zzahx2 != null ? this.zza.zzc(zzahx2) : 0;
        if (zzahx4 != null) {
            j6 = this.zzc.zzc(zzahx4);
        }
        this.zzd = zzahx3.zzf;
        if (zzc2 == -1 || j6 == -1) {
            return -1;
        }
        return zzc2 + j6;
    }

    public final Uri zzd() {
        return this.zze;
    }

    public final Map<String, List<String>> zze() {
        return zzfmp.zza();
    }

    public final void zzf() throws IOException {
        this.zza.zzf();
        this.zzc.zzf();
    }
}
