package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgbv {
    public static final ThreadLocal<SecureRandom> zza = new zzgbu();

    public static byte[] zza(int i) {
        byte[] bArr = new byte[i];
        zza.get().nextBytes(bArr);
        return bArr;
    }
}
