package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbls extends zzbmh {
    public final Drawable zza;
    public final Uri zzb;
    public final double zzc;
    public final int zzd;
    public final int zze;

    public zzbls(Drawable drawable, Uri uri, double d, int i, int i2) {
        this.zza = drawable;
        this.zzb = uri;
        this.zzc = d;
        this.zzd = i;
        this.zze = i2;
    }

    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.wrap(this.zza);
    }

    public final Uri zzc() throws RemoteException {
        return this.zzb;
    }

    public final double zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zze;
    }
}
