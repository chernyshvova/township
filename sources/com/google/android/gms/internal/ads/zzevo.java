package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzevo implements zzfju<zzeaa, zzevq> {
    public final /* synthetic */ zzevr zza;

    public zzevo(zzevr zzevr) {
        this.zza = zzevr;
    }

    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzcgs.zzg("", (zzeaa) obj);
        zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzevr zzevr = this.zza;
        zzevq unused = zzevr.zzd = new zzevq((zzcbk) null, zzevr.zze(), (zzevo) null);
        return this.zza.zzd;
    }
}
