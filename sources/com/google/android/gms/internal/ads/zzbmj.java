package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbmj extends NativeAd.Image {
    public final zzbmi zza;
    public final Drawable zzb;
    public final Uri zzc;
    public final double zzd;
    public final int zze;
    public final int zzf;

    public zzbmj(zzbmi zzbmi) {
        Drawable drawable;
        double d;
        int i;
        this.zza = zzbmi;
        Uri uri = null;
        try {
            IObjectWrapper zzb2 = zzbmi.zzb();
            if (zzb2 != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzb2);
                this.zzb = drawable;
                uri = this.zza.zzc();
                this.zzc = uri;
                d = this.zza.zzd();
                this.zzd = d;
                int i2 = -1;
                i = this.zza.zze();
                this.zze = i;
                i2 = this.zza.zzf();
                this.zzf = i2;
            }
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
        drawable = null;
        this.zzb = drawable;
        try {
            uri = this.zza.zzc();
        } catch (RemoteException e2) {
            zzcgs.zzg("", e2);
        }
        this.zzc = uri;
        try {
            d = this.zza.zzd();
        } catch (RemoteException e3) {
            zzcgs.zzg("", e3);
            d = 1.0d;
        }
        this.zzd = d;
        int i22 = -1;
        try {
            i = this.zza.zze();
        } catch (RemoteException e4) {
            zzcgs.zzg("", e4);
            i = -1;
        }
        this.zze = i;
        try {
            i22 = this.zza.zzf();
        } catch (RemoteException e5) {
            zzcgs.zzg("", e5);
        }
        this.zzf = i22;
    }

    public final Drawable getDrawable() {
        return this.zzb;
    }

    public final double getScale() {
        return this.zzd;
    }

    public final Uri getUri() {
        return this.zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }
}
