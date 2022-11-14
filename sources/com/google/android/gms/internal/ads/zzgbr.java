package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgbr extends ThreadLocal<Mac> {
    public final /* synthetic */ zzgbs zza;

    public zzgbr(zzgbs zzgbs) {
        this.zza = zzgbs;
    }

    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac zza2 = zzgbe.zzb.zza(this.zza.zzb);
            zza2.init(this.zza.zzc);
            return zza2;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
