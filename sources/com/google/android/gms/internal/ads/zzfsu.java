package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsu extends zzfrt<zzfvq, zzfvn> {
    public final /* synthetic */ zzfsv zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfsu(zzfsv zzfsv, Class cls) {
        super(cls);
        this.zza = zzfsv;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzfvq zzfvq = (zzfvq) zzgfk;
        ((zzfsx) new zzfsy().zzi()).zzb(zzfvq.zza());
        new zzfuw().zzi().zzb(zzfvq.zzc());
        zzgbx.zza(zzfvq.zza().zzc());
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfvq.zzd(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzfvq zzfvq = (zzfvq) zzgfk;
        new zzfsy();
        zzfvt zzg = zzfsx.zzg(zzfvq.zza());
        zzfyh zzd = new zzfuw().zzi().zzd(zzfvq.zzc());
        zzfvm zzf = zzfvn.zzf();
        zzf.zzb(zzg);
        zzf.zzc(zzd);
        zzf.zza(0);
        return (zzfvn) zzf.zzah();
    }

    public final Map<String, zzfrs<zzfvq>> zze() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzfsv.zzj(16, 16, 32, 16, zzfye.SHA256, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzfsv.zzj(16, 16, 32, 16, zzfye.SHA256, 3));
        hashMap.put("AES256_CTR_HMAC_SHA256", zzfsv.zzj(32, 16, 32, 32, zzfye.SHA256, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzfsv.zzj(32, 16, 32, 32, zzfye.SHA256, 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
