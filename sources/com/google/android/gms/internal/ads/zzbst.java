package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbst implements Predicate {
    public final zzbps zza;

    public zzbst(zzbps zzbps) {
        this.zza = zzbps;
    }

    public final boolean apply(Object obj) {
        zzbps zzbps = (zzbps) obj;
        return (zzbps instanceof zzbsv) && ((zzbsv) zzbps).zzb.equals(this.zza);
    }
}
