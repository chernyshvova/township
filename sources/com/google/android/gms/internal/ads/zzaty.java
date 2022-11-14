package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaty {
    public final zzats[] zza = new zzats[1];
    public int zzb;
    public int zzc;
    public int zzd = 0;
    public zzats[] zze = new zzats[100];

    public zzaty(boolean z, int i) {
    }

    public final synchronized void zza() {
        zzb(0);
    }

    public final synchronized void zzb(int i) {
        int i2 = this.zzb;
        this.zzb = i;
        if (i < i2) {
            zzf();
        }
    }

    public final synchronized zzats zzc() {
        zzats zzats;
        this.zzc++;
        int i = this.zzd;
        if (i > 0) {
            zzats[] zzatsArr = this.zze;
            int i2 = i - 1;
            this.zzd = i2;
            zzats = zzatsArr[i2];
            zzatsArr[i2] = null;
        } else {
            zzats = new zzats(new byte[65536], 0);
        }
        return zzats;
    }

    public final synchronized void zzd(zzats zzats) {
        zzats[] zzatsArr = this.zza;
        zzatsArr[0] = zzats;
        zze(zzatsArr);
    }

    public final synchronized void zze(zzats[] zzatsArr) {
        int i = this.zzd + r0;
        zzats[] zzatsArr2 = this.zze;
        int length = zzatsArr2.length;
        if (i >= length) {
            this.zze = (zzats[]) Arrays.copyOf(zzatsArr2, Math.max(length + length, i));
        }
        for (zzats zzats : zzatsArr) {
            zzaul.zza(zzats.zza.length == 65536);
            zzats[] zzatsArr3 = this.zze;
            int i2 = this.zzd;
            this.zzd = i2 + 1;
            zzatsArr3[i2] = zzats;
        }
        this.zzc -= zzatsArr.length;
        notifyAll();
    }

    public final synchronized void zzf() {
        int max = Math.max(0, zzava.zze(this.zzb, 65536) - this.zzc);
        int i = this.zzd;
        if (max < i) {
            Arrays.fill(this.zze, max, i, (Object) null);
            this.zzd = max;
        }
    }

    public final synchronized int zzg() {
        return this.zzc * 65536;
    }
}
