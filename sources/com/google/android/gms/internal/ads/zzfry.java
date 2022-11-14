package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfry {
    public static final CopyOnWriteArrayList<zzfrx> zza = new CopyOnWriteArrayList<>();

    public static zzfrx zza(String str) throws GeneralSecurityException {
        Iterator<zzfrx> it = zza.iterator();
        while (it.hasNext()) {
            zzfrx next = it.next();
            if (next.zza()) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
