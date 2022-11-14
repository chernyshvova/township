package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgfk;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfro<KeyFormatProtoT extends zzgfk, KeyProtoT extends zzgfk> {
    public final zzfrt<KeyFormatProtoT, KeyProtoT> zza;

    public zzfro(zzfrt<KeyFormatProtoT, KeyProtoT> zzfrt) {
        this.zza = zzfrt;
    }

    public final KeyProtoT zza(zzgcz zzgcz) throws GeneralSecurityException, zzgeo {
        KeyFormatProtoT zzc = this.zza.zzc(zzgcz);
        this.zza.zzb(zzc);
        return this.zza.zzd(zzc);
    }
}
