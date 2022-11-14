package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfud extends zzfru<zzfrl, zzfxu> {
    public zzfud(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zzb(Object obj) throws GeneralSecurityException {
        zzfxu zzfxu = (zzfxu) obj;
        zzfxr zzc = zzfxu.zzc().zzc();
        zzfya zza = zzc.zza();
        int zzc2 = zzfuo.zzc(zza.zza());
        byte[] zzz = zzfxu.zzd().zzz();
        ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(new BigInteger(1, zzz), zzgbc.zzd(zzc2));
        return new zzgax((ECPrivateKey) zzgbe.zzg.zza("EC").generatePrivate(eCPrivateKeySpec), zza.zzd().zzz(), zzfuo.zzb(zza.zzc()), zzfuo.zzd(zzc.zzd()), new zzfup(zzc.zzc().zza()));
    }
}
