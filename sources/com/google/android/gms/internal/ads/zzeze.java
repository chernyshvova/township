package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeze implements zzfqa<String> {
    public final /* synthetic */ zzcmr zza;
    public final /* synthetic */ zzfdz zzb;
    public final /* synthetic */ zzedb zzc;

    public zzeze(zzcmr zzcmr, zzfdz zzfdz, zzedb zzedb) {
        this.zza = zzcmr;
        this.zzb = zzfdz;
        this.zzc = zzedb;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzF().zzae) {
            this.zzb.zzb(str);
            return;
        }
        long currentTimeMillis = zzs.zzj().currentTimeMillis();
        String str2 = this.zza.zzaB().zzb;
        zzs.zzc();
        int i = 1;
        if (true == zzr.zzI(this.zza.getContext())) {
            i = 2;
        }
        this.zzc.zze(new zzedd(currentTimeMillis, str2, str, i));
    }
}
