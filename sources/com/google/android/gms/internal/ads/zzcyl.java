package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcyl<T> {
    public final zzdzg zza;
    public final zzeyw zzb;
    public final zzfcx zzc;
    public final zzcse zzd;
    public final zzehf<T> zze;
    public final zzdga zzf;
    @Nullable
    public zzeyq zzg;
    public final zzeak zzh;
    public final zzdaj zzi;
    public final Executor zzj;
    public final zzdzx zzk;
    public final zzeds zzl;

    public zzcyl(zzdzg zzdzg, zzeyw zzeyw, zzfcx zzfcx, zzcse zzcse, zzehf<T> zzehf, zzdga zzdga, @Nullable zzeyq zzeyq, zzeak zzeak, zzdaj zzdaj, Executor executor, zzdzx zzdzx, zzeds zzeds) {
        this.zza = zzdzg;
        this.zzb = zzeyw;
        this.zzc = zzfcx;
        this.zzd = zzcse;
        this.zze = zzehf;
        this.zzf = zzdga;
        this.zzg = zzeyq;
        this.zzh = zzeak;
        this.zzi = zzdaj;
        this.zzj = executor;
        this.zzk = zzdzx;
        this.zzl = zzeds;
    }

    public final zzfqn<zzeyq> zza(zzfqn<zzcbk> zzfqn) {
        zzeyq zzeyq = this.zzg;
        if (zzeyq != null) {
            zzfcx zzfcx = this.zzc;
            return zzfci.zza(zzfqe.zza(zzeyq), zzfcr.SERVER_TRANSACTION, zzfcx).zzi();
        }
        zzs.zzi().zzb();
        return this.zzc.zza(zzfcr.SERVER_TRANSACTION, zzfqn).zzc(zzcyg.zzb(this.zzk)).zzi();
    }

    public final zzfqn<zzeyq> zzb() {
        zzbdk zzbdk = this.zzb.zzd;
        if (zzbdk.zzx == null && zzbdk.zzs == null) {
            return zza(this.zzi.zzb());
        }
        zzfcx zzfcx = this.zzc;
        return zzfci.zza(this.zza.zza(), zzfcr.SERVER_TRANSACTION, zzfcx).zzi();
    }

    public final zzfqn<T> zzc(zzfqn<zzeyq> zzfqn) {
        zzfco<O2> zzc2 = this.zzc.zza(zzfcr.RENDERER, zzfqn).zzb(new zzcyh(this)).zzc(this.zze);
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdN)).booleanValue()) {
            zzc2 = zzc2.zzh((long) ((Integer) zzbex.zzc().zzb(zzbjn.zzdO)).intValue(), TimeUnit.SECONDS);
        }
        return zzc2.zzi();
    }

    public final zzdga zzd() {
        return this.zzf;
    }

    public final zzfqn<zzcbk> zze(zzfao zzfao) {
        zzfcd zzi2 = this.zzc.zza(zzfcr.GET_CACHE_KEY, this.zzi.zzb()).zzc(new zzcyi(this, zzfao)).zzi();
        zzfqe.zzp(zzi2, new zzcyj(this), this.zzj);
        return zzi2;
    }

    public final zzfqn<Void> zzf(zzcbk zzcbk) {
        zzfcd zzi2 = this.zzc.zza(zzfcr.NOTIFY_CACHE_HIT, this.zzh.zzb(zzcbk)).zzi();
        zzfqe.zzp(zzi2, new zzcyk(this), this.zzj);
        return zzi2;
    }

    public final zzbdd zzg(Throwable th) {
        return zzezr.zzb(th, this.zzl);
    }

    public final void zzh(zzeyq zzeyq) {
        this.zzg = zzeyq;
    }

    public final /* synthetic */ zzfqn zzi(zzfao zzfao, zzcbk zzcbk) throws Exception {
        zzcbk.zzi = zzfao;
        return this.zzh.zza(zzcbk);
    }

    public final /* synthetic */ zzeyq zzj(zzeyq zzeyq) throws Exception {
        this.zzd.zza(zzeyq);
        return zzeyq;
    }
}
