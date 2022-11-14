package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfuz implements zzfrz {
    public final zzfse<zzfrz> zza;
    public final byte[] zzb = {0};

    public /* synthetic */ zzfuz(zzfse zzfse, zzfuy zzfuy) {
        this.zza = zzfse;
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        if (this.zza.zza().zzc().equals(zzfzy.LEGACY)) {
            return zzgar.zza(this.zza.zza().zzd(), this.zza.zza().zza().zza(zzgar.zza(bArr, this.zzb)));
        }
        return zzgar.zza(this.zza.zza().zzd(), this.zza.zza().zza().zza(bArr));
    }
}
