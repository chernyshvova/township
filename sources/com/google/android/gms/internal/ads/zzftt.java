package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzftt extends zzfrt<zzgah, zzgae> {
    public final /* synthetic */ zzftu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzftt(zzftu zzftu, Class cls) {
        super(cls);
        this.zza = zzftu;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzgah zzgah = (zzgah) zzgfk;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzgah.zza(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzgah zzgah = (zzgah) zzgfk;
        zzgad zze = zzgae.zze();
        zze.zza(0);
        zze.zzb(zzgcz.zzt(zzgbv.zza(32)));
        return (zzgae) zze.zzah();
    }

    public final Map<String, zzfrs<zzgah>> zze() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", new zzfrs(zzgah.zzc(), 1));
        hashMap.put("XCHACHA20_POLY1305_RAW", new zzfrs(zzgah.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
