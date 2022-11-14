package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdgd implements Runnable {
    public final zzdge zza;
    public final Object zzb;

    public zzdgd(zzdge zzdge, Object obj) {
        this.zza = zzdge;
        this.zzb = obj;
    }

    public final void run() {
        try {
            this.zza.zza(this.zzb);
        } catch (Throwable th) {
            zzs.zzg().zzh(th, "EventEmitter.notify");
            zze.zzb("Event emitter exception.", th);
        }
    }
}
