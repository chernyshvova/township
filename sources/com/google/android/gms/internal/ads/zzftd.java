package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzftd extends zzfrt<zzfwo, zzfwl> {
    public final /* synthetic */ zzfte zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzftd(zzfte zzfte, Class cls) {
        super(cls);
        this.zza = zzfte;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzgbx.zza(((zzfwo) zzgfk).zza());
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfwo.zzc(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzfwk zze = zzfwl.zze();
        zze.zzb(zzgcz.zzt(zzgbv.zza(((zzfwo) zzgfk).zza())));
        zze.zza(0);
        return (zzfwl) zze.zzah();
    }

    public final Map<String, zzfrs<zzfwo>> zze() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzfte.zzj(16, 1));
        hashMap.put("AES128_GCM_RAW", zzfte.zzj(16, 3));
        hashMap.put("AES256_GCM", zzfte.zzj(32, 1));
        hashMap.put("AES256_GCM_RAW", zzfte.zzj(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
