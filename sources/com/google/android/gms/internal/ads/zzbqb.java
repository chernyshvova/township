package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzt;
import com.vungle.warren.log.LogEntry;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbqb implements zzt {
    public boolean zza = false;
    public final /* synthetic */ Map zzb;
    public final /* synthetic */ Map zzc;
    public final /* synthetic */ zzbcz zzd;

    public zzbqb(zzbqd zzbqd, Map map, Map map2, zzbcz zzbcz) {
        this.zzb = map;
        this.zzc = map2;
        this.zzd = zzbcz;
    }

    public final void zza(boolean z) {
        if (!this.zza) {
            this.zza = true;
            this.zzb.put((String) this.zzc.get(LogEntry.LOG_ITEM_EVENT_ID), Boolean.valueOf(z));
            ((zzbsj) this.zzd).zze("openIntentAsync", this.zzb);
        }
    }

    public final void zzb(int i) {
    }
}
