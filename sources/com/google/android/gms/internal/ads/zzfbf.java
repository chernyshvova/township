package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfbf {
    public final long zza;
    public final zzfbe zzb = new zzfbe();
    public long zzc;
    public int zzd = 0;
    public int zze = 0;
    public int zzf = 0;

    public zzfbf() {
        long currentTimeMillis = zzs.zzj().currentTimeMillis();
        this.zza = currentTimeMillis;
        this.zzc = currentTimeMillis;
    }

    public final void zza() {
        this.zzc = zzs.zzj().currentTimeMillis();
        this.zzd++;
    }

    public final void zzb() {
        this.zze++;
        this.zzb.zza = true;
    }

    public final void zzc() {
        this.zzf++;
        this.zzb.zzb++;
    }

    public final long zzd() {
        return this.zza;
    }

    public final long zze() {
        return this.zzc;
    }

    public final int zzf() {
        return this.zzd;
    }

    public final zzfbe zzg() {
        zzfbe zza2 = this.zzb.clone();
        zzfbe zzfbe = this.zzb;
        zzfbe.zza = false;
        zzfbe.zzb = 0;
        return zza2;
    }

    public final String zzh() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Created: ");
        outline24.append(this.zza);
        outline24.append(" Last accessed: ");
        outline24.append(this.zzc);
        outline24.append(" Accesses: ");
        outline24.append(this.zzd);
        outline24.append("\nEntries retrieved: Valid: ");
        outline24.append(this.zze);
        outline24.append(" Stale: ");
        outline24.append(this.zzf);
        return outline24.toString();
    }
}
