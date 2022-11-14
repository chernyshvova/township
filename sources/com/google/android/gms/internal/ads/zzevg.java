package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzevg implements zzfqa<Void> {
    public zzevg(zzevi zzevi) {
    }

    public final void zza(Throwable th) {
        zze.zza("Notification of cache hit failed.");
    }

    public final /* bridge */ /* synthetic */ void zzb(@NullableDecl Object obj) {
        Void voidR = (Void) obj;
        zze.zza("Notification of cache hit successful.");
    }
}
