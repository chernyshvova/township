package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbyu extends NativeAd.Image {
    public final zzbmi zza;
    @Nullable
    public final Drawable zzb;
    @Nullable
    public final Uri zzc;
    public final double zzd;

    public zzbyu(zzbmi zzbmi) {
        Drawable drawable;
        double d;
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
                this.zza.zze();
                this.zza.zzf();
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
        try {
            this.zza.zze();
        } catch (RemoteException e4) {
            zzcgs.zzg("", e4);
        }
        try {
            this.zza.zzf();
        } catch (RemoteException e5) {
            zzcgs.zzg("", e5);
        }
    }

    @Nullable
    public final Drawable getDrawable() {
        return this.zzb;
    }

    public final double getScale() {
        return this.zzd;
    }

    @Nullable
    public final Uri getUri() {
        return this.zzc;
    }
}
