package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzamw extends Exception {
    public zzamw(int i, String str, Throwable th, int i2) {
        super((String) null, th);
    }

    public static zzamw zza(Exception exc, int i) {
        return new zzamw(1, (String) null, exc, i);
    }

    public static zzamw zzb(IOException iOException) {
        return new zzamw(0, (String) null, iOException, -1);
    }

    public static zzamw zzc(RuntimeException runtimeException) {
        return new zzamw(2, (String) null, runtimeException, -1);
    }
}
