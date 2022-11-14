package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdov implements zzfpl {
    public final zzfqn zza;

    public zzdov(zzfqn zzfqn) {
        this.zza = zzfqn;
    }

    public final zzfqn zza(Object obj) {
        zzfqn zzfqn = this.zza;
        zzcmr zzcmr = (zzcmr) obj;
        if (zzcmr != null && zzcmr.zzh() != null) {
            return zzfqn;
        }
        throw new zzehd(1, "Retrieve video view in html5 ad response failed.");
    }
}
