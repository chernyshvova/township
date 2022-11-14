package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzexr implements zzelg<zzdrj> {
    public final Context zza;
    public final Executor zzb;
    public final zzcop zzc;
    public final zzexi zzd;
    public final zzevv<zzdro, zzdrj> zze;
    public final zzeyr zzf;
    @GuardedBy("this")
    public final zzeyv zzg;
    @GuardedBy("this")
    public zzfqn<zzdrj> zzh;

    public zzexr(Context context, Executor executor, zzcop zzcop, zzevv<zzdro, zzdrj> zzevv, zzexi zzexi, zzeyv zzeyv, zzeyr zzeyr) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcop;
        this.zze = zzevv;
        this.zzd = zzexi;
        this.zzg = zzeyv;
        this.zzf = zzeyr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzj */
    public final zzdrn zzh(zzevt zzevt) {
        zzdrn zzs = this.zzc.zzs();
        zzdao zzdao = new zzdao();
        zzdao.zza(this.zza);
        zzdao.zzb(((zzexq) zzevt).zza);
        zzdao.zze(this.zzf);
        zzs.zzb(zzdao.zzd());
        zzs.zzc(new zzdgh().zzm());
        return zzs;
    }

    public final boolean zza(zzbdk zzbdk, String str, zzele zzele, zzelf<? super zzdrj> zzelf) throws RemoteException {
        zzcch zzcch = new zzcch(zzbdk, str);
        if (zzcch.zzb == null) {
            zzcgs.zzf("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new zzexl(this));
        } else {
            zzfqn<zzdrj> zzfqn = this.zzh;
            if (zzfqn == null || zzfqn.isDone()) {
                zzezm.zzb(this.zza, zzcch.zza.zzf);
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue() && zzcch.zza.zzf) {
                    this.zzc.zzz().zzc(true);
                }
                zzeyv zzeyv = this.zzg;
                zzeyv.zzf(zzcch.zzb);
                zzeyv.zzc(zzbdp.zzc());
                zzeyv.zza(zzcch.zza);
                zzeyw zzu = zzeyv.zzu();
                zzexq zzexq = new zzexq((zzexp) null);
                zzexq.zza = zzu;
                zzexq.zzb = null;
                zzfqn<zzdrj> zzc2 = this.zze.zzc(new zzevw(zzexq, (zzcbk) null), new zzexm(this), null);
                this.zzh = zzc2;
                zzfqe.zzp(zzc2, new zzexp(this, zzelf, zzexq), this.zzb);
                return true;
            }
        }
        return false;
    }

    public final boolean zzb() {
        throw null;
    }

    public final /* synthetic */ void zzc() {
        this.zzd.zzbT(zzezr.zzd(6, (String) null, (zzbdd) null));
    }

    public final void zzi(int i) {
        this.zzg.zzi().zza(i);
    }
}
