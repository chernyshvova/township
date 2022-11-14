package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdrg implements zzbqh {
    public final zzdck zza;
    @Nullable
    public final zzccm zzb;
    public final String zzc;
    public final String zzd;

    public zzdrg(zzdck zzdck, zzeye zzeye) {
        this.zza = zzdck;
        this.zzb = zzeye.zzm;
        this.zzc = zzeye.zzk;
        this.zzd = zzeye.zzl;
    }

    public final void zza() {
        this.zza.zzd();
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzccm zzccm) {
        int i;
        String str;
        zzccm zzccm2 = this.zzb;
        if (zzccm2 != null) {
            zzccm = zzccm2;
        }
        if (zzccm != null) {
            str = zzccm.zza;
            i = zzccm.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zze(new zzcbx(str, i), this.zzc, this.zzd);
    }

    public final void zzc() {
        this.zza.zzf();
    }
}
