package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdnb implements zzbps {
    public final zzdnc zza;
    public final zzboc zzb;

    public zzdnb(zzdnc zzdnc, zzboc zzboc) {
        this.zza = zzdnc;
        this.zzb = zzboc;
    }

    public final void zza(Object obj, Map map) {
        zzdnc zzdnc = this.zza;
        zzboc zzboc = this.zzb;
        try {
            zzdnc.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzcgs.zzf("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzdnc.zza = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzboc == null) {
            zzcgs.zzd("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzboc.zze(str);
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
