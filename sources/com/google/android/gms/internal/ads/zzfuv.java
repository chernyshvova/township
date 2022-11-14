package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfuv extends zzfrt<zzfyk, zzfyh> {
    public final /* synthetic */ zzfuw zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfuv(zzfuw zzfuw, Class cls) {
        super(cls);
        this.zza = zzfuw;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzfyk zzfyk = (zzfyk) zzgfk;
        if (zzfyk.zzc() >= 16) {
            zzfuw.zzm(zzfyk.zza());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfyk.zzd(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzfyk zzfyk = (zzfyk) zzgfk;
        zzfyg zzf = zzfyh.zzf();
        zzf.zza(0);
        zzf.zzb(zzfyk.zza());
        zzf.zzc(zzgcz.zzt(zzgbv.zza(zzfyk.zzc())));
        return (zzfyh) zzf.zzah();
    }

    public final Map<String, zzfrs<zzfyk>> zze() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zzfuw.zzk(32, 16, zzfye.SHA256, 1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzfuw.zzk(32, 16, zzfye.SHA256, 3));
        hashMap.put("HMAC_SHA256_256BITTAG", zzfuw.zzk(32, 32, zzfye.SHA256, 1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzfuw.zzk(32, 32, zzfye.SHA256, 3));
        hashMap.put("HMAC_SHA512_128BITTAG", zzfuw.zzk(64, 16, zzfye.SHA512, 1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzfuw.zzk(64, 16, zzfye.SHA512, 3));
        hashMap.put("HMAC_SHA512_256BITTAG", zzfuw.zzk(64, 32, zzfye.SHA512, 1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzfuw.zzk(64, 32, zzfye.SHA512, 3));
        hashMap.put("HMAC_SHA512_512BITTAG", zzfuw.zzk(64, 64, zzfye.SHA512, 1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzfuw.zzk(64, 64, zzfye.SHA512, 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
