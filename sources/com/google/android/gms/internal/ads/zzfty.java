package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfty extends zzfrt<zzfxa, zzfwx> {
    public final /* synthetic */ zzftz zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfty(zzftz zzftz, Class cls) {
        super(cls);
        this.zza = zzftz;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzfxa zzfxa = (zzfxa) zzgfk;
        if (zzfxa.zza() != 64) {
            throw new InvalidAlgorithmParameterException(GeneratedOutlineSupport.outline10(61, "invalid key size: ", zzfxa.zza(), ". Valid keys must have 64 bytes."));
        }
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfxa.zzc(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzfww zze = zzfwx.zze();
        zze.zzb(zzgcz.zzt(zzgbv.zza(((zzfxa) zzgfk).zza())));
        zze.zza(0);
        return (zzfwx) zze.zzah();
    }

    public final Map<String, zzfrs<zzfxa>> zze() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzfwz zzd = zzfxa.zzd();
        zzd.zza(64);
        hashMap.put("AES256_SIV", new zzfrs((zzfxa) zzd.zzah(), 1));
        zzfwz zzd2 = zzfxa.zzd();
        zzd2.zza(64);
        hashMap.put("AES256_SIV_RAW", new zzfrs((zzfxa) zzd2.zzah(), 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
