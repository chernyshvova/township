package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzasc implements Runnable {
    public final /* synthetic */ zzasf zza;
    public final /* synthetic */ zzash zzb;

    public zzasc(zzash zzash, zzasf zzasf) {
        this.zzb = zzash;
        this.zza = zzasf;
    }

    public final void run() {
        this.zza.zza();
        int size = this.zzb.zzn.size();
        for (int i = 0; i < size; i++) {
            ((zzasw) this.zzb.zzn.valueAt(i)).zzg();
        }
    }
}
