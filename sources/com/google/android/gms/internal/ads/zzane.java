package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzane {
    public final zzasl zza;
    public final Object zzb;
    public final int zzc;
    public final zzasx[] zzd;
    public final boolean[] zze;
    public final long zzf;
    public int zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public zzane zzl;
    public zzatr zzm;
    public final zzanp[] zzn;
    public final zzanq[] zzo;
    public final zzatq zzp;
    public final zzasn zzq;
    public zzatr zzr;
    public final zzcjw zzs;

    public zzane(zzanp[] zzanpArr, zzanq[] zzanqArr, long j, zzatq zzatq, zzcjw zzcjw, zzasn zzasn, Object obj, int i, int i2, boolean z, long j2, byte[] bArr) {
        this.zzn = zzanpArr;
        this.zzo = zzanqArr;
        this.zzf = j;
        this.zzp = zzatq;
        this.zzs = zzcjw;
        this.zzq = zzasn;
        if (obj != null) {
            this.zzb = obj;
            this.zzc = i;
            this.zzg = i2;
            this.zzi = z;
            this.zzh = j2;
            this.zzd = new zzasx[2];
            this.zze = new boolean[2];
            this.zza = zzasn.zze(i2, zzcjw.zzl());
            return;
        }
        throw null;
    }

    public final boolean zza() {
        return this.zzj && (!this.zzk || this.zza.zzj() == Long.MIN_VALUE);
    }

    public final boolean zzb() throws zzamw {
        zzatr zzd2 = this.zzp.zzd(this.zzo, this.zza.zzg());
        zzatr zzatr = this.zzr;
        if (zzatr != null) {
            int i = 0;
            while (i < 2) {
                if (zzd2.zza(zzatr, i)) {
                    i++;
                }
            }
            return false;
        }
        this.zzm = zzd2;
        return true;
    }

    public final long zzc(long j, boolean z) {
        return zzd(j, false, new boolean[2]);
    }

    public final long zzd(long j, boolean z, boolean[] zArr) {
        zzato zzato = this.zzm.zzb;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= 2) {
                break;
            }
            boolean[] zArr2 = this.zze;
            if (z || !this.zzm.zza(this.zzr, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zzB = this.zza.zzB(zzato.zzb(), this.zze, this.zzd, zArr, j);
        this.zzr = this.zzm;
        this.zzk = false;
        int i2 = 0;
        while (true) {
            zzasx[] zzasxArr = this.zzd;
            if (i2 < 2) {
                if (zzasxArr[i2] != null) {
                    zzaul.zzd(zzato.zza(i2) != null);
                    this.zzk = true;
                } else {
                    zzaul.zzd(zzato.zza(i2) == null);
                }
                i2++;
            } else {
                this.zzs.zzb(this.zzn, this.zzm.zza, zzato);
                return zzB;
            }
        }
    }

    public final void zze() {
        try {
            this.zzq.zzc(this.zza);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }
}
