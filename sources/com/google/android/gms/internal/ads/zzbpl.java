package com.google.android.gms.internal.ads;

import com.facebook.LegacyTokenHelper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbpl implements zzbps<Object> {
    public final void zza(Object obj, Map<String, String> map) {
        String valueOf = String.valueOf(map.get(LegacyTokenHelper.TYPE_STRING));
        zzcgs.zzh(valueOf.length() != 0 ? "Received log message: ".concat(valueOf) : new String("Received log message: "));
    }
}
