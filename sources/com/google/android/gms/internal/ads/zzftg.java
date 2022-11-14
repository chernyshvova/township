package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzftg extends zzfrt<zzfwu, zzfwr> {
    public final /* synthetic */ zzfth zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzftg(zzfth zzfth, Class cls) {
        super(cls);
        this.zza = zzfth;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzgbx.zza(((zzfwu) zzgfk).zza());
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfwu.zzc(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzfwq zze = zzfwr.zze();
        zze.zzb(zzgcz.zzt(zzgbv.zza(((zzfwu) zzgfk).zza())));
        zze.zza(0);
        return (zzfwr) zze.zzah();
    }

    public final Map<String, zzfrs<zzfwu>> zze() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM_SIV", zzfth.zzk(16, 1));
        hashMap.put("AES128_GCM_SIV_RAW", zzfth.zzk(16, 3));
        hashMap.put("AES256_GCM_SIV", zzfth.zzk(32, 1));
        hashMap.put("AES256_GCM_SIV_RAW", zzfth.zzk(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
