package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbii extends zzbgh {
    public zzbrt zza;

    public final /* synthetic */ void zzb() {
        zzbrt zzbrt = this.zza;
        if (zzbrt != null) {
            try {
                zzbrt.zzb(Collections.emptyList());
            } catch (RemoteException e) {
                zzcgs.zzj("Could not notify onComplete event.", e);
            }
        }
    }

    public final void zze() throws RemoteException {
        zzcgs.zzf("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzcgl.zza.post(new zzbih(this));
    }

    public final void zzf(float f) throws RemoteException {
    }

    public final void zzg(String str) throws RemoteException {
    }

    public final void zzh(boolean z) throws RemoteException {
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final void zzj(@Nullable String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final float zzk() throws RemoteException {
        return 1.0f;
    }

    public final boolean zzl() throws RemoteException {
        return false;
    }

    public final String zzm() {
        return "";
    }

    public final void zzn(@Nullable String str) throws RemoteException {
    }

    public final void zzo(zzbvh zzbvh) throws RemoteException {
    }

    public final void zzp(zzbrt zzbrt) throws RemoteException {
        this.zza = zzbrt;
    }

    public final List<zzbrm> zzq() throws RemoteException {
        return Collections.emptyList();
    }

    public final void zzr(zzbip zzbip) throws RemoteException {
    }

    public final void zzs() {
    }

    public final void zzt(zzbgu zzbgu) {
    }
}
