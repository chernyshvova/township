package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfhu;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzh implements zzfhu {
    public final /* synthetic */ zzi zza;

    public zzh(zzi zzi) {
        this.zza = zzi;
    }

    public final void zza(int i, long j) {
        this.zza.zzi.zzc(i, System.currentTimeMillis() - j);
    }

    public final void zzb(int i, long j, String str) {
        this.zza.zzi.zzg(i, System.currentTimeMillis() - j, str);
    }
}
