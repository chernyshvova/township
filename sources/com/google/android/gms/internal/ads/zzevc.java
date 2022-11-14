package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxi;
import com.google.android.gms.internal.ads.zzdam;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzevc<R extends zzdam<AdT>, AdT extends zzcxi> implements zzevv<R, AdT> {
    public final zzevv<R, AdT> zza;
    public final zzevv<R, zzevh<R, AdT>> zzb;
    public final zzfbd<R, AdT> zzc;
    public final String zzd;
    @GuardedBy("this")
    public R zze;
    public final Executor zzf;

    public zzevc(zzevv<R, AdT> zzevv, zzevv<R, zzevh<R, AdT>> zzevv2, zzfbd<R, AdT> zzfbd, String str, Executor executor) {
        this.zza = zzevv;
        this.zzb = zzevv2;
        this.zzc = zzfbd;
        this.zzd = str;
        this.zzf = executor;
    }

    private final zzfqn<AdT> zzg(zzfaq<R, AdT> zzfaq, zzevw zzevw) {
        R r = zzfaq.zza;
        this.zze = r;
        if (zzfaq.zzc != null) {
            if (r.zzd() != null) {
                zzfaq.zzc.zzn().zzp(zzfaq.zza.zzd());
            }
            return zzfqe.zza(zzfaq.zzc);
        }
        r.zzc().zzh(zzfaq.zzb);
        return ((zzevm) this.zza).zzb(zzevw, (zzevu) null, zzfaq.zza);
    }

    /* renamed from: zza */
    public final synchronized R zzd() {
        return this.zze;
    }

    public final synchronized zzfqn<AdT> zzb(zzevw zzevw, zzevu<R> zzevu, R r) {
        zzfqn<AdT> zzi;
        zzevw zzevw2 = zzevw;
        zzevu<R> zzevu2 = zzevu;
        synchronized (this) {
            zzdal<R> zza2 = zzevu2.zza(zzevw2.zzb);
            zza2.zzg(new zzevd(this.zzd));
            zzdam zzdam = (zzdam) zza2.zzf();
            zzeyw zza3 = zzdam.zza();
            zzevu<R> zzevu3 = zzevu;
            zzevw zzevw3 = zzevw;
            zzi = zzfqe.zzi(zzfpv.zzw(((zzevi) this.zzb).zza(zzevw2, zzevu2, zzdam)), new zzeuy(this, zzevw, new zzevb(zzevu3, zzevw3, zza3.zzd, zza3.zzf, this.zzf, zza3.zzj, (zzfar) null), zzevu, zzdam), this.zzf);
        }
        return zzi;
    }

    public final /* bridge */ /* synthetic */ zzfqn zzc(zzevw zzevw, zzevu zzevu, Object obj) {
        return zzb(zzevw, zzevu, (zzdam) null);
    }

    public final /* synthetic */ zzfqn zze(zzfba zzfba) throws Exception {
        zzfbc<U, A> zzfbc;
        if (zzfba == null || zzfba.zza == null || (zzfbc = zzfba.zzb) == null) {
            throw new zzdxy(1, "Empty prefetch");
        }
        zzazm zza2 = zzazu.zza();
        zzazk zza3 = zzazl.zza();
        zza3.zza(zzazp.IN_MEMORY);
        zza3.zzb(zzazr.zza());
        zza2.zza(zza3);
        zzfba.zza.zza.zzc().zzd().zzm((zzazu) zza2.zzah());
        return zzg(zzfba.zza, ((zzevb) zzfbc).zzb);
    }

    public final /* synthetic */ zzfqn zzf(zzevw zzevw, zzevb zzevb, zzevu zzevu, zzdam zzdam, zzevh zzevh) throws Exception {
        if (zzevh != null) {
            zzevb zzevb2 = new zzevb(zzevb.zza, zzevb.zzb, zzevb.zzc, zzevb.zzd, zzevb.zze, zzevb.zzf, zzevh.zza);
            if (zzevh.zzc != null) {
                this.zze = null;
                this.zzc.zza(zzevb2);
                return zzg(zzevh.zzc, zzevw);
            }
            zzfqn<zzfba<R, AdT>> zzb2 = this.zzc.zzb(zzevb2);
            if (zzb2 != null) {
                this.zze = null;
                return zzfqe.zzi(zzb2, new zzeuz(this), this.zzf);
            }
            this.zzc.zza(zzevb2);
            zzevw = new zzevw(zzevw.zzb, zzevh.zzb);
        }
        zzfqn zzb3 = ((zzevm) this.zza).zzb(zzevw, zzevu, zzdam);
        this.zze = zzdam;
        return zzb3;
    }
}
