package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfus extends zzfrt<zzfvh, zzfve> {
    public zzfus(zzfut zzfut, Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ void zzb(zzgfk zzgfk) throws GeneralSecurityException {
        zzfvh zzfvh = (zzfvh) zzgfk;
        zzfut.zzl(zzfvh.zzc());
        zzfut.zzm(zzfvh.zza());
    }

    public final /* bridge */ /* synthetic */ zzgfk zzc(zzgcz zzgcz) throws zzgeo {
        return zzfvh.zzd(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzgfk zzgfk) throws GeneralSecurityException {
        zzfvh zzfvh = (zzfvh) zzgfk;
        zzfvd zzf = zzfve.zzf();
        zzf.zza(0);
        zzf.zzb(zzgcz.zzt(zzgbv.zza(zzfvh.zza())));
        zzf.zzc(zzfvh.zzc());
        return (zzfve) zzf.zzah();
    }

    public final Map<String, zzfrs<zzfvh>> zze() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzfvg zze = zzfvh.zze();
        zze.zza(32);
        zzfvj zzc = zzfvk.zzc();
        zzc.zza(16);
        zze.zzb((zzfvk) zzc.zzah());
        hashMap.put("AES_CMAC", new zzfrs((zzfvh) zze.zzah(), 1));
        zzfvg zze2 = zzfvh.zze();
        zze2.zza(32);
        zzfvj zzc2 = zzfvk.zzc();
        zzc2.zza(16);
        zze2.zzb((zzfvk) zzc2.zzah());
        hashMap.put("AES256_CMAC", new zzfrs((zzfvh) zze2.zzah(), 1));
        zzfvg zze3 = zzfvh.zze();
        zze3.zza(32);
        zzfvj zzc3 = zzfvk.zzc();
        zzc3.zza(16);
        zze3.zzb((zzfvk) zzc3.zzah());
        hashMap.put("AES256_CMAC_RAW", new zzfrs((zzfvh) zze3.zzah(), 3));
        return Collections.unmodifiableMap(hashMap);
    }
}
