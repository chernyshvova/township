package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzcxi;
import com.google.android.gms.internal.ads.zzdam;
import java.util.ArrayDeque;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfbd<R extends zzdam<AdT>, AdT extends zzcxi> {
    public final zzfah zza;
    public final zzfbb<R, AdT> zzb;
    public final zzfad zzc;
    @GuardedBy("this")
    public final ArrayDeque<zzfbc<R, AdT>> zzd;
    @GuardedBy("this")
    public zzfbj<R, AdT> zze;
    @GuardedBy("this")
    public int zzf = 1;

    public zzfbd(zzfah zzfah, zzfad zzfad, zzfbb<R, AdT> zzfbb) {
        this.zza = zzfah;
        this.zzc = zzfad;
        this.zzb = zzfbb;
        this.zzd = new ArrayDeque<>();
        this.zzc.zza(new zzfay(this));
    }

    /* access modifiers changed from: private */
    public final synchronized void zzh() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeB)).booleanValue()) {
            if (!zzs.zzg().zzl().zzn().zzi()) {
                this.zzd.clear();
                return;
            }
        }
        if (zzi()) {
            while (!this.zzd.isEmpty()) {
                zzfbc pollFirst = this.zzd.pollFirst();
                if (pollFirst == null || (pollFirst.zzb() != null && this.zza.zzc(pollFirst.zzb()))) {
                    zzfbj<R, AdT> zzfbj = new zzfbj<>(this.zza, this.zzb, pollFirst);
                    this.zze = zzfbj;
                    zzfbj.zza(new zzfaz(this, pollFirst));
                    return;
                }
            }
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized void zza(zzfbc<R, AdT> zzfbc) {
        this.zzd.add(zzfbc);
    }

    public final synchronized zzfqn<zzfba<R, AdT>> zzb(zzfbc<R, AdT> zzfbc) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zzb(zzfbc);
    }

    public final /* synthetic */ void zzc() {
        synchronized (this) {
            this.zzf = 1;
            zzh();
        }
    }
}
