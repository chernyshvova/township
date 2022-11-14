package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbpb implements zzfju {
    public final String zza;

    public zzbpb(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        Throwable th = (Throwable) obj;
        zzbps<zzcmr> zzbps = zzbpr.zza;
        if (zzbkz.zzj.zze().booleanValue()) {
            zzs.zzg().zzg(th, "prepareClickUrl.attestation2");
        }
        return str;
    }
}
