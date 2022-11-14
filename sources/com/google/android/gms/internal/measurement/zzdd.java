package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzdd {
    public final Map<String, Map<String, String>> zza;

    public zzdd(Map<String, Map<String, String>> map) {
        this.zza = map;
    }

    @Nullable
    public final String zza(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        Map map;
        if (uri == null || (map = this.zza.get(uri.toString())) == null) {
            return null;
        }
        if (str2 != null) {
            String valueOf = String.valueOf(str3);
            str3 = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
        }
        return (String) map.get(str3);
    }
}
