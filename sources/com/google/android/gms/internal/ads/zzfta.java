package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfta extends zzfrt<zzfwf, zzfwc> {
    public final /* synthetic */ zzftb zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfta(zzftb zzftb, Class cls) {
        super(cls);
        this.zza = zzftb;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzfwf zzfwf = (zzfwf) zzgfk;
        zzgbx.zza(zzfwf.zzc());
        if (zzfwf.zza().zza() != 12 && zzfwf.zza().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfwf.zzd(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzfwf zzfwf = (zzfwf) zzgfk;
        zzfwb zzf = zzfwc.zzf();
        zzf.zzc(zzgcz.zzt(zzgbv.zza(zzfwf.zzc())));
        zzf.zzb(zzfwf.zza());
        zzf.zza(0);
        return (zzfwc) zzf.zzah();
    }

    public final Map<String, zzfrs<zzfwf>> zze() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzftb.zzj(16, 16, 1));
        hashMap.put("AES128_EAX_RAW", zzftb.zzj(16, 16, 3));
        hashMap.put("AES256_EAX", zzftb.zzj(32, 16, 1));
        hashMap.put("AES256_EAX_RAW", zzftb.zzj(32, 16, 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
