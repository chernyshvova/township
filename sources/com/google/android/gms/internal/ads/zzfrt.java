package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgfk;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfrt<KeyFormatProtoT extends zzgfk, KeyT> {
    public final Class<KeyFormatProtoT> zza;

    public zzfrt(Class<KeyFormatProtoT> cls) {
        this.zza = cls;
    }

    public final Class<KeyFormatProtoT> zza() {
        return this.zza;
    }

    public abstract void zzb(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyFormatProtoT zzc(zzgcz zzgcz) throws zzgeo;

    public abstract KeyT zzd(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public Map<String, zzfrs<KeyFormatProtoT>> zze() throws GeneralSecurityException {
        return Collections.emptyMap();
    }
}
