package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcds implements zzfqa<Void> {
    public final /* synthetic */ zzfqn zza;

    public zzcds(zzcdt zzcdt, zzfqn zzfqn) {
        this.zza = zzfqn;
    }

    public final void zza(Throwable th) {
        zzcdt.zzc.remove(this.zza);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        zzcdt.zzc.remove(this.zza);
    }
}
