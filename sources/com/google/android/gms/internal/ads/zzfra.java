package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfra extends zzfqm<zzfqn> {
    public final /* synthetic */ zzfrc zza;
    public final zzfpk zzb;

    public zzfra(zzfrc zzfrc, zzfpk zzfpk) {
        this.zza = zzfrc;
        if (zzfpk != null) {
            this.zzb = zzfpk;
            return;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzfqn zza2 = this.zzb.zza();
        zzfke.zzd(zza2, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzb);
        return zza2;
    }

    public final String zzc() {
        return this.zzb.toString();
    }

    public final boolean zzd() {
        return this.zza.isDone();
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        this.zza.zzj((zzfqn) obj);
    }

    public final void zzg(Throwable th) {
        this.zza.zzi(th);
    }
}
