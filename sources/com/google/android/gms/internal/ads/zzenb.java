package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzenb implements zzeqo<Bundle> {
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final float zzg;
    public final boolean zzh;

    public zzenb(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = f;
        this.zzh = z3;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.zza);
        bundle.putBoolean("ma", this.zzb);
        bundle.putBoolean("sp", this.zzc);
        bundle.putInt("muv", this.zzd);
        bundle.putInt("rm", this.zze);
        bundle.putInt("riv", this.zzf);
        bundle.putFloat("android_app_volume", this.zzg);
        bundle.putBoolean("android_app_muted", this.zzh);
    }
}
