package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzfkd {
    public static final Logger zza = Logger.getLogger(zzfkd.class.getName());
    public static final zzfkc zzb = new zzfkc((zzfkb) null);

    public static boolean zza(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }

    public static String zzb(@CheckForNull String str) {
        return str == null ? "" : str;
    }
}
