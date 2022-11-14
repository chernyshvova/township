package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgax implements zzfrl {
    public final ECPrivateKey zza;
    public final zzgaz zzb;
    public final String zzc;
    public final byte[] zzd;
    public final zzgaw zze;

    public zzgax(ECPrivateKey eCPrivateKey, byte[] bArr, String str, int i, zzgaw zzgaw) throws GeneralSecurityException {
        this.zza = eCPrivateKey;
        this.zzb = new zzgaz(eCPrivateKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zze = zzgaw;
    }
}
