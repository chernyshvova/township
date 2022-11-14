package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfpc implements Runnable {
    public final /* synthetic */ zzfqn zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzfpe zzc;

    public zzfpc(zzfpe zzfpe, zzfqn zzfqn, int i) {
        this.zzc = zzfpe;
        this.zza = zzfqn;
        this.zzb = i;
    }

    public final void run() {
        try {
            if (this.zza.isCancelled()) {
                zzfmg unused = this.zzc.zzb = null;
                this.zzc.cancel(false);
            } else {
                this.zzc.zzK(this.zzb, this.zza);
            }
        } finally {
            zzfpe.zzA(this.zzc, (zzfmg) null);
        }
    }
}
