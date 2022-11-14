package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfrr {
    public static zzfrq zza(String str) throws GeneralSecurityException {
        String str2;
        if (zzfsn.zzm().containsKey(str)) {
            return zzfsn.zzm().get(str);
        }
        if (str.length() != 0) {
            str2 = "cannot find key template: ".concat(str);
        } else {
            str2 = new String("cannot find key template: ");
        }
        throw new GeneralSecurityException(str2);
    }
}
