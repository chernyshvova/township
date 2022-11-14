package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzftj extends zzfrt<zzfxg, zzfxd> {
    public final /* synthetic */ zzftk zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzftj(zzftk zzftk, Class cls) {
        super(cls);
        this.zza = zzftk;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzfxg zzfxg = (zzfxg) zzgfk;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfxg.zza(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzfxg zzfxg = (zzfxg) zzgfk;
        zzfxc zze = zzfxd.zze();
        zze.zza(0);
        zze.zzb(zzgcz.zzt(zzgbv.zza(32)));
        return (zzfxd) zze.zzah();
    }

    public final Map<String, zzfrs<zzfxg>> zze() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", new zzfrs(zzfxg.zzc(), 1));
        hashMap.put("CHACHA20_POLY1305_RAW", new zzfrs(zzfxg.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
