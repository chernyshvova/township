package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyk {
    public final zztz zza;
    public final SparseArray<zzaki> zzb = new SparseArray<>();
    public final SparseArray<zzakh> zzc = new SparseArray<>();
    public final zzaks zzd;
    public final byte[] zze;
    public int zzf;
    public long zzg;
    public long zzh;
    public final zzyj zzi = new zzyj((zzyi) null);
    public final zzyj zzj = new zzyj((zzyi) null);
    public boolean zzk;
    public long zzl;
    public long zzm;
    public boolean zzn;

    public zzyk(zztz zztz, boolean z, boolean z2) {
        this.zza = zztz;
        byte[] bArr = new byte[128];
        this.zze = bArr;
        this.zzd = new zzaks(bArr, 0, 0);
        this.zzk = false;
    }

    public final void zza(zzaki zzaki) {
        this.zzb.append(zzaki.zzd, zzaki);
    }

    public final void zzb(zzakh zzakh) {
        this.zzc.append(zzakh.zza, zzakh);
    }

    public final void zzc() {
        this.zzk = false;
    }

    public final void zzd(long j, int i, long j2) {
        this.zzf = i;
        this.zzh = j2;
        this.zzg = j;
    }

    public final boolean zze(long j, int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.zzf == 9) {
            if (z && this.zzk) {
                long j2 = this.zzg;
                boolean z4 = this.zzn;
                long j3 = this.zzl;
                int i2 = z4 ? 1 : 0;
                this.zza.zzd(this.zzm, i2, (int) (j2 - j3), i + ((int) (j - j2)), (zzty) null);
            }
            this.zzl = this.zzg;
            this.zzm = this.zzh;
            this.zzn = false;
            this.zzk = true;
        }
        boolean z5 = this.zzn;
        int i3 = this.zzf;
        if (i3 == 5 || (z2 && i3 == 1)) {
            z3 = true;
        }
        boolean z6 = z5 | z3;
        this.zzn = z6;
        return z6;
    }
}
