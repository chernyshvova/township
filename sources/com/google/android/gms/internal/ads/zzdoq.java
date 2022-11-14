package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdoq implements zzfju {
    public final String zza;
    public final double zzb;
    public final int zzc;
    public final int zzd;

    public zzdoq(String str, double d, int i, int i2) {
        this.zza = str;
        this.zzb = d;
        this.zzc = i;
        this.zzd = i2;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        return new zzbls(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzb, this.zzc, this.zzd);
    }
}
