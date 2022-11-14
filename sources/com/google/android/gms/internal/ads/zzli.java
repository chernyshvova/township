package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzli extends Exception {
    public static final zzif<zzli> zzk = zzlh.zza;
    public final int zzi;
    public final long zzj;

    public zzli(@Nullable String str, @Nullable Throwable th, int i, long j) {
        super(str, th);
        this.zzi = i;
        this.zzj = j;
    }
}
