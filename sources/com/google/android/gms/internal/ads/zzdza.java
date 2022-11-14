package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdza implements zzfqa<zzeyq> {
    public final /* synthetic */ zzdzb zza;

    public zzdza(zzdzb zzdzb) {
        this.zza = zzdzb;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzew)).booleanValue()) {
            Matcher matcher = zzdzb.zzf.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zze.zza(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeyq zzeyq = (zzeyq) obj;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzew)).booleanValue()) {
            this.zza.zze.zza(zzeyq.zzb.zzb.zze);
            this.zza.zze.zzc(zzeyq.zzb.zzb.zzf);
        }
    }
}
