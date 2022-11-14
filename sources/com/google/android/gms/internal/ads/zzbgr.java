package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbgr implements MuteThisAdReason {
    public final String zza;
    public final zzbgq zzb;

    public zzbgr(zzbgq zzbgq) {
        String str;
        this.zzb = zzbgq;
        try {
            str = zzbgq.zze();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            str = null;
        }
        this.zza = str;
    }

    public final String getDescription() {
        return this.zza;
    }

    public final String toString() {
        return this.zza;
    }

    public final zzbgq zza() {
        return this.zzb;
    }
}
