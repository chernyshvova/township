package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzv extends zzw {
    public final Callable<String> zzd;

    public /* synthetic */ zzv(Callable callable, zzu zzu) {
        super(false, (String) null, (Throwable) null);
        this.zzd = callable;
    }

    public final String zza() {
        try {
            return this.zzd.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
