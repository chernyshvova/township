package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeqq implements Runnable {
    public final zzeqp zza;
    public final long zzb;

    public zzeqq(zzeqp zzeqp, long j) {
        this.zza = zzeqp;
        this.zzb = j;
    }

    public final void run() {
        zzeqp zzeqp = this.zza;
        long j = this.zzb;
        String canonicalName = zzeqp.getClass().getCanonicalName();
        long elapsedRealtime = zzs.zzj().elapsedRealtime();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb.append("Signal runtime : ");
        sb.append(canonicalName);
        sb.append(" = ");
        sb.append(elapsedRealtime - j);
        zze.zza(sb.toString());
    }
}
