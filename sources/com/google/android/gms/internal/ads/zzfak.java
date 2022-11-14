package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfak {
    public final zzfaj zza = new zzfaj();
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;

    public final void zza() {
        this.zzd++;
    }

    public final void zzb() {
        this.zze++;
    }

    public final void zzc() {
        this.zzb++;
        this.zza.zza = true;
    }

    public final void zzd() {
        this.zzc++;
        this.zza.zzb = true;
    }

    public final void zze() {
        this.zzf++;
    }

    public final zzfaj zzf() {
        zzfaj zza2 = this.zza.clone();
        zzfaj zzfaj = this.zza;
        zzfaj.zza = false;
        zzfaj.zzb = false;
        return zza2;
    }

    public final String zzg() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("\n\tPool does not exist: ");
        outline24.append(this.zzd);
        outline24.append("\n\tNew pools created: ");
        outline24.append(this.zzb);
        outline24.append("\n\tPools removed: ");
        outline24.append(this.zzc);
        outline24.append("\n\tEntries added: ");
        outline24.append(this.zzf);
        outline24.append("\n\tNo entries retrieved: ");
        outline24.append(this.zze);
        outline24.append("\n");
        return outline24.toString();
    }
}
