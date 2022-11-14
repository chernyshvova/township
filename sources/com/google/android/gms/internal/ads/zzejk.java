package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzejk {
    public final ConcurrentHashMap<String, zzbxo> zza = new ConcurrentHashMap<>();
    public final zzdss zzb;

    public zzejk(zzdss zzdss) {
        this.zzb = zzdss;
    }

    public final void zza(String str) {
        try {
            this.zza.put(str, this.zzb.zzc(str));
        } catch (RemoteException e) {
            zzcgs.zzg("Couldn't create RTB adapter : ", e);
        }
    }

    @CheckForNull
    public final zzbxo zzb(String str) {
        if (this.zza.containsKey(str)) {
            return this.zza.get(str);
        }
        return null;
    }
}
