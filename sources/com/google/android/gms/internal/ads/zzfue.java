package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfue extends zzfrt<zzfxo, zzfxu> {
    public final /* synthetic */ zzfuf zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfue(zzfuf zzfuf, Class cls) {
        super(cls);
        this.zza = zzfuf;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzfuo.zza(((zzfxo) zzgfk).zza());
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfxo.zzc(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzfxo zzfxo = (zzfxo) zzgfk;
        KeyPair zzc = zzgbc.zzc(zzgbc.zzd(zzfuo.zzc(zzfxo.zza().zza().zza())));
        ECPoint w = ((ECPublicKey) zzc.getPublic()).getW();
        zzfxw zzg = zzfxx.zzg();
        zzg.zza(0);
        zzg.zzb(zzfxo.zza());
        zzg.zzc(zzgcz.zzt(w.getAffineX().toByteArray()));
        zzg.zzd(zzgcz.zzt(w.getAffineY().toByteArray()));
        zzfxt zzf = zzfxu.zzf();
        zzf.zza(0);
        zzf.zzb((zzfxx) zzg.zzah());
        zzf.zzc(zzgcz.zzt(((ECPrivateKey) zzc.getPrivate()).getS().toByteArray()));
        return (zzfxu) zzf.zzah();
    }

    public final Map<String, zzfrs<zzfxo>> zze() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzfuf.zzk(zzfyc.NIST_P256, zzfye.SHA256, zzfxi.UNCOMPRESSED, zzfrr.zza("AES128_GCM"), zzfuf.zza, 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzfuf.zzk(zzfyc.NIST_P256, zzfye.SHA256, zzfxi.UNCOMPRESSED, zzfrr.zza("AES128_GCM"), zzfuf.zza, 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzfuf.zzk(zzfyc.NIST_P256, zzfye.SHA256, zzfxi.COMPRESSED, zzfrr.zza("AES128_GCM"), zzfuf.zza, 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzfuf.zzk(zzfyc.NIST_P256, zzfye.SHA256, zzfxi.COMPRESSED, zzfrr.zza("AES128_GCM"), zzfuf.zza, 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzfuf.zzk(zzfyc.NIST_P256, zzfye.SHA256, zzfxi.COMPRESSED, zzfrr.zza("AES128_GCM"), zzfuf.zza, 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzfuf.zzk(zzfyc.NIST_P256, zzfye.SHA256, zzfxi.UNCOMPRESSED, zzfrr.zza("AES128_CTR_HMAC_SHA256"), zzfuf.zza, 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzfuf.zzk(zzfyc.NIST_P256, zzfye.SHA256, zzfxi.UNCOMPRESSED, zzfrr.zza("AES128_CTR_HMAC_SHA256"), zzfuf.zza, 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzfuf.zzk(zzfyc.NIST_P256, zzfye.SHA256, zzfxi.COMPRESSED, zzfrr.zza("AES128_CTR_HMAC_SHA256"), zzfuf.zza, 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzfuf.zzk(zzfyc.NIST_P256, zzfye.SHA256, zzfxi.COMPRESSED, zzfrr.zza("AES128_CTR_HMAC_SHA256"), zzfuf.zza, 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
