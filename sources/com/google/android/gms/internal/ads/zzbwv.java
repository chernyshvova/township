package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest$ErrorCode;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwv implements Runnable {
    public final /* synthetic */ AdRequest$ErrorCode zza;
    public final /* synthetic */ zzbwx zzb;

    public zzbwv(zzbwx zzbwx, AdRequest$ErrorCode adRequest$ErrorCode) {
        this.zzb = zzbwx;
        this.zza = adRequest$ErrorCode;
    }

    public final void run() {
        try {
            this.zzb.zza.zzg(zzbwy.zza(this.zza));
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
