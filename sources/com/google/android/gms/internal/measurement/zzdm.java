package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzdm {
    public final Uri zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    @Nullable
    public final zzdw<Context, Boolean> zzi;

    public zzdm(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (zzdw<Context, Boolean>) null);
    }

    public final zzdh<Long> zza(String str, long j) {
        return zzdh.zzb(this, str, j, true);
    }

    public zzdm(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzdw<Context, Boolean> zzdw) {
        this.zzd = null;
        this.zza = uri;
        this.zzb = str2;
        this.zzc = str3;
        this.zze = false;
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzdh<Boolean> zza(String str, boolean z) {
        return zzdh.zzb(this, str, z, true);
    }

    public final zzdh<Double> zza(String str, double d) {
        return zzdh.zzb(this, str, -3.0d, true);
    }

    public final zzdh<String> zza(String str, String str2) {
        return zzdh.zzb(this, str, str2, true);
    }
}
