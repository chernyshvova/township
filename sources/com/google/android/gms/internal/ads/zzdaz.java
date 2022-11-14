package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdaz implements zzgjg<zzcdz> {
    public final zzday zza;
    public final zzgju<Context> zzb;
    public final zzgju<zzcgy> zzc;
    public final zzgju<zzeye> zzd;
    public final zzgju<zzcdv> zze;

    public zzdaz(zzday zzday, zzgju<Context> zzgju, zzgju<zzcgy> zzgju2, zzgju<zzeye> zzgju3, zzgju<zzcdv> zzgju4) {
        this.zza = zzday;
        this.zzb = zzgju;
        this.zzc = zzgju2;
        this.zzd = zzgju3;
        this.zze = zzgju4;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zzb2 = this.zzb.zzb();
        zzcgy zza2 = ((zzcpd) this.zzc).zza();
        zzeye zza3 = ((zzcxy) this.zzd).zza();
        zzcdv zzcdv = new zzcdv();
        zzcdw zzcdw = zza3.zzA;
        if (zzcdw != null) {
            return new zzcdt(zzb2, zza2, zzcdw, zza3.zzs.zzb, zzcdv, (byte[]) null);
        }
        return null;
    }
}
