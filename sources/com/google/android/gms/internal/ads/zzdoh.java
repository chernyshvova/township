package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdoh implements zzfju<zzy, Bitmap> {
    public final /* synthetic */ double zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzdoi zzc;

    public zzdoh(zzdoi zzdoi, double d, boolean z) {
        this.zzc = zzdoi;
        this.zza = d;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        return zzdoi.zzb(this.zzc, ((zzy) obj).zzb, this.zza, this.zzb);
    }
}
