package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzahy {
    public final zzahe[] zza = new zzahe[1];
    public int zzb;
    public int zzc;
    public int zzd = 0;
    public zzahe[] zze = new zzahe[100];

    public zzahy(boolean z, int i) {
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

    public final synchronized zzahe zzc() {
        zzahe zzahe;
        this.zzc++;
        int i = this.zzd;
        if (i > 0) {
            zzahe[] zzaheArr = this.zze;
            int i2 = i - 1;
            this.zzd = i2;
            zzahe = zzaheArr[i2];
            if (zzahe != null) {
                zzaheArr[i2] = null;
            } else {
                throw null;
            }
        } else {
            zzahe = new zzahe(new byte[65536], 0);
        }
        return zzahe;
    }

    public final synchronized void zzd(zzahe zzahe) {
        zzahe[] zzaheArr = this.zza;
        zzaheArr[0] = zzahe;
        zze(zzaheArr);
    }

    public final synchronized void zze(zzahe[] zzaheArr) {
        int i = this.zzd + r0;
        zzahe[] zzaheArr2 = this.zze;
        int length = zzaheArr2.length;
        if (i >= length) {
            this.zze = (zzahe[]) Arrays.copyOf(zzaheArr2, Math.max(length + length, i));
        }
        for (zzahe zzahe : zzaheArr) {
            zzahe[] zzaheArr3 = this.zze;
            int i2 = this.zzd;
            this.zzd = i2 + 1;
            zzaheArr3[i2] = zzahe;
        }
        this.zzc -= zzaheArr.length;
        notifyAll();
    }

    public final synchronized void zzf() {
        int max = Math.max(0, zzalh.zzw(this.zzb, 65536) - this.zzc);
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
