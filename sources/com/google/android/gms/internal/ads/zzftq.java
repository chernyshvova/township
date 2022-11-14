package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzftq extends zzfrt<zzfzw, zzfzt> {
    public final /* synthetic */ zzftr zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzftq(zzftr zzftr, Class cls) {
        super(cls);
        this.zza = zzftr;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzfzw zzfzw = (zzfzw) zzgfk;
        if (zzfzw.zza().isEmpty() || !zzfzw.zzc()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfzw.zze(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzfzs zze = zzfzt.zze();
        zze.zzb((zzfzw) zzgfk);
        zze.zza(0);
        return (zzfzt) zze.zzah();
    }
}
