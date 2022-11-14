package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeax implements zzfqa<ParcelFileDescriptor> {
    public final /* synthetic */ zzcbg zza;

    public zzeax(zzebb zzebb, zzcbg zzcbg) {
        this.zza = zzcbg;
    }

    public final void zza(Throwable th) {
        try {
            this.zza.zzf(zzbb.zza(th));
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zze((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }
}
