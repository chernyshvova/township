package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbid extends zzbfj {
    public final /* synthetic */ zzbie zza;

    public /* synthetic */ zzbid(zzbie zzbie, zzbib zzbib) {
        this.zza = zzbie;
    }

    public final void zze(zzbdk zzbdk) throws RemoteException {
        zzi(zzbdk, 1);
    }

    @Nullable
    public final String zzf() throws RemoteException {
        return null;
    }

    public final boolean zzg() throws RemoteException {
        return false;
    }

    @Nullable
    public final String zzh() throws RemoteException {
        return null;
    }

    public final void zzi(zzbdk zzbdk, int i) throws RemoteException {
        zzcgs.zzf("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzcgl.zza.post(new zzbic(this));
    }
}
