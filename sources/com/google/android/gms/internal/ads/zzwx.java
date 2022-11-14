package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwx {
    public zzwh zza;
    public long zzb;
    public long zzc;
    public int zzd;
    public int zze;
    public long[] zzf = new long[0];
    public int[] zzg = new int[0];
    public int[] zzh = new int[0];
    public int[] zzi = new int[0];
    public long[] zzj = new long[0];
    public boolean[] zzk = new boolean[0];
    public boolean zzl;
    public boolean[] zzm = new boolean[0];
    @Nullable
    public zzww zzn;
    public final zzakr zzo = new zzakr();
    public boolean zzp;
    public long zzq;
    public boolean zzr;

    public final void zza(int i) {
        this.zzo.zza(i);
        this.zzl = true;
        this.zzp = true;
    }

    public final long zzb(int i) {
        return this.zzj[i] + ((long) this.zzi[i]);
    }

    public final boolean zzc(int i) {
        return this.zzl && this.zzm[i];
    }
}
