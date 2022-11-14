package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzezg {
    public final zzeye zza;
    public final zzeyh zzb;
    public final zzedb zzc;
    public final zzfdz zzd;

    @VisibleForTesting
    public zzezg(zzedb zzedb, zzfdz zzfdz, zzeye zzeye, zzeyh zzeyh) {
        this.zza = zzeye;
        this.zzb = zzeyh;
        this.zzc = zzedb;
        this.zzd = zzfdz;
    }

    public final void zza(List<String> list) {
        for (String zzc2 : list) {
            zzc(zzc2, 2);
        }
    }

    public final void zzb(List<String> list, int i) {
        for (String zzc2 : list) {
            zzc(zzc2, i);
        }
    }

    public final void zzc(String str, int i) {
        if (!this.zza.zzae) {
            this.zzd.zzb(str);
            return;
        }
        this.zzc.zze(new zzedd(zzs.zzj().currentTimeMillis(), this.zzb.zzb, str, i));
    }
}
