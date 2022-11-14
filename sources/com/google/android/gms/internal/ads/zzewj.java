package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzewj implements zzelg<zzdiw> {
    public final Context zza;
    public final Executor zzb;
    public final zzcop zzc;
    public final zzekq zzd;
    public final zzexi zze;
    @Nullable
    public zzbki zzf;
    @GuardedBy("this")
    public final zzeyv zzg;
    @GuardedBy("this")
    public zzfqn<zzdiw> zzh;

    public zzewj(Context context, Executor executor, zzcop zzcop, zzekq zzekq, zzexi zzexi, zzeyv zzeyv) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcop;
        this.zzd = zzekq;
        this.zzg = zzeyv;
        this.zze = zzexi;
    }

    public final boolean zza(zzbdk zzbdk, String str, zzele zzele, zzelf<? super zzdiw> zzelf) {
        zzdjt zzdjt;
        if (str == null) {
            zzcgs.zzf("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new zzewd(this));
            return false;
        } else if (zzb()) {
            return false;
        } else {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue() && zzbdk.zzf) {
                this.zzc.zzz().zzc(true);
            }
            zzbdp zzbdp = ((zzewc) zzele).zza;
            zzeyv zzeyv = this.zzg;
            zzeyv.zzf(str);
            zzeyv.zzc(zzbdp);
            zzeyv.zza(zzbdk);
            zzeyw zzu = zzeyv.zzu();
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfC)).booleanValue()) {
                zzdjs zzp = this.zzc.zzp();
                zzdao zzdao = new zzdao();
                zzdao.zza(this.zza);
                zzdao.zzb(zzu);
                zzp.zzc(zzdao.zzd());
                zzdgh zzdgh = new zzdgh();
                zzdgh.zzl(this.zzd, this.zzb);
                zzdgh.zze(this.zzd, this.zzb);
                zzp.zzd(zzdgh.zzm());
                zzp.zzb(new zzejb(this.zzf));
                zzdjt = zzp.zza();
            } else {
                zzdgh zzdgh2 = new zzdgh();
                zzexi zzexi = this.zze;
                if (zzexi != null) {
                    zzdgh2.zza(zzexi, this.zzb);
                    zzdgh2.zzb(this.zze, this.zzb);
                    zzdgh2.zzc(this.zze, this.zzb);
                }
                zzdjs zzp2 = this.zzc.zzp();
                zzdao zzdao2 = new zzdao();
                zzdao2.zza(this.zza);
                zzdao2.zzb(zzu);
                zzp2.zzc(zzdao2.zzd());
                zzdgh2.zzl(this.zzd, this.zzb);
                zzdgh2.zza(this.zzd, this.zzb);
                zzdgh2.zzb(this.zzd, this.zzb);
                zzdgh2.zzc(this.zzd, this.zzb);
                zzdgh2.zzf(this.zzd, this.zzb);
                zzdgh2.zze(this.zzd, this.zzb);
                zzdgh2.zzj(this.zzd, this.zzb);
                zzdgh2.zzd(this.zzd, this.zzb);
                zzp2.zzd(zzdgh2.zzm());
                zzp2.zzb(new zzejb(this.zzf));
                zzdjt = zzp2.zza();
            }
            zzcyl<zzdiw> zzb2 = zzdjt.zzb();
            zzfqn<zzdiw> zzc2 = zzb2.zzc(zzb2.zzb());
            this.zzh = zzc2;
            zzfqe.zzp(zzc2, new zzewi(this, zzelf, zzdjt), this.zzb);
            return true;
        }
    }

    public final boolean zzb() {
        zzfqn<zzdiw> zzfqn = this.zzh;
        return zzfqn != null && !zzfqn.isDone();
    }

    public final void zzc(zzbki zzbki) {
        this.zzf = zzbki;
    }

    public final /* synthetic */ void zzd() {
        this.zzd.zzbT(zzezr.zzd(6, (String) null, (zzbdd) null));
    }
}
