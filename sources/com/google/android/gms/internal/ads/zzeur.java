package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeur implements zzelg<zzcvj> {
    public final Context zza;
    public final Executor zzb;
    public final zzcop zzc;
    public final zzekq zzd;
    public final zzeku zze;
    public final ViewGroup zzf;
    @Nullable
    public zzbki zzg;
    public final zzdds zzh;
    @GuardedBy("this")
    public final zzeyv zzi;
    @GuardedBy("this")
    public zzfqn<zzcvj> zzj;

    public zzeur(Context context, Executor executor, zzbdp zzbdp, zzcop zzcop, zzekq zzekq, zzeku zzeku, zzeyv zzeyv) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcop;
        this.zzd = zzekq;
        this.zze = zzeku;
        this.zzi = zzeyv;
        this.zzh = zzcop.zzh();
        this.zzf = new FrameLayout(context);
        zzeyv.zzc(zzbdp);
    }

    public final boolean zza(zzbdk zzbdk, String str, @Nullable zzele zzele, zzelf<? super zzcvj> zzelf) throws RemoteException {
        zzcwg zzcwg;
        if (str == null) {
            zzcgs.zzf("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new zzeun(this));
            return false;
        } else if (zzb()) {
            return false;
        } else {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue() && zzbdk.zzf) {
                this.zzc.zzz().zzc(true);
            }
            zzeyv zzeyv = this.zzi;
            zzeyv.zzf(str);
            zzeyv.zza(zzbdk);
            zzeyw zzu = zzeyv.zzu();
            if (!zzble.zzc.zze().booleanValue() || !this.zzi.zze().zzk) {
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfA)).booleanValue()) {
                    zzcwf zzk = this.zzc.zzk();
                    zzdao zzdao = new zzdao();
                    zzdao.zza(this.zza);
                    zzdao.zzb(zzu);
                    zzk.zzi(zzdao.zzd());
                    zzdgh zzdgh = new zzdgh();
                    zzdgh.zzl(this.zzd, this.zzb);
                    zzdgh.zze(this.zzd, this.zzb);
                    zzk.zzj(zzdgh.zzm());
                    zzk.zze(new zzejb(this.zzg));
                    zzk.zzb(new zzdkk(zzdml.zza, (zzbfe) null));
                    zzk.zzd(new zzcxc(this.zzh));
                    zzk.zzc(new zzcvg(this.zzf));
                    zzcwg = zzk.zza();
                } else {
                    zzcwf zzk2 = this.zzc.zzk();
                    zzdao zzdao2 = new zzdao();
                    zzdao2.zza(this.zza);
                    zzdao2.zzb(zzu);
                    zzk2.zzi(zzdao2.zzd());
                    zzdgh zzdgh2 = new zzdgh();
                    zzdgh2.zzl(this.zzd, this.zzb);
                    zzdgh2.zzf(this.zzd, this.zzb);
                    zzdgh2.zzf(this.zze, this.zzb);
                    zzdgh2.zzg(this.zzd, this.zzb);
                    zzdgh2.zza(this.zzd, this.zzb);
                    zzdgh2.zzb(this.zzd, this.zzb);
                    zzdgh2.zzc(this.zzd, this.zzb);
                    zzdgh2.zze(this.zzd, this.zzb);
                    zzdgh2.zzj(this.zzd, this.zzb);
                    zzk2.zzj(zzdgh2.zzm());
                    zzk2.zze(new zzejb(this.zzg));
                    zzk2.zzb(new zzdkk(zzdml.zza, (zzbfe) null));
                    zzk2.zzd(new zzcxc(this.zzh));
                    zzk2.zzc(new zzcvg(this.zzf));
                    zzcwg = zzk2.zza();
                }
                zzcyl<zzcvj> zzb2 = zzcwg.zzb();
                zzfqn<zzcvj> zzc2 = zzb2.zzc(zzb2.zzb());
                this.zzj = zzc2;
                zzfqe.zzp(zzc2, new zzeuq(this, zzelf, zzcwg), this.zzb);
                return true;
            }
            zzekq zzekq = this.zzd;
            if (zzekq != null) {
                zzekq.zzbT(zzezr.zzd(7, (String) null, (zzbdd) null));
            }
            return false;
        }
    }

    public final boolean zzb() {
        zzfqn<zzcvj> zzfqn = this.zzj;
        return zzfqn != null && !zzfqn.isDone();
    }

    public final ViewGroup zzc() {
        return this.zzf;
    }

    public final void zzd(zzbki zzbki) {
        this.zzg = zzbki;
    }

    public final void zze(zzbfb zzbfb) {
        this.zze.zza(zzbfb);
    }

    public final zzeyv zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        ViewParent parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        zzs.zzc();
        return zzr.zzZ(view, view.getContext());
    }

    public final void zzh(zzddt zzddt) {
        this.zzh.zzh(zzddt, this.zzb);
    }

    public final void zzi() {
        this.zzh.zzd(60);
    }

    public final /* synthetic */ void zzj() {
        this.zzd.zzbT(zzezr.zzd(6, (String) null, (zzbdd) null));
    }
}
