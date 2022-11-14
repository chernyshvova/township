package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzcur;
import com.google.android.gms.internal.ads.zzcxi;
import com.google.android.gms.internal.ads.zzdal;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzetp<AppOpenAd extends zzcxi, AppOpenRequestComponent extends zzcur<AppOpenAd>, AppOpenRequestComponentBuilder extends zzdal<AppOpenRequestComponent>> implements zzelg<AppOpenAd> {
    public final zzcop zza;
    public final Context zzb;
    public final Executor zzc;
    public final zzeud zzd;
    public final zzevv<AppOpenRequestComponent, AppOpenAd> zze;
    public final ViewGroup zzf;
    @GuardedBy("this")
    public final zzeyv zzg;
    @GuardedBy("this")
    @Nullable
    public zzfqn<AppOpenAd> zzh;

    public zzetp(Context context, Executor executor, zzcop zzcop, zzevv<AppOpenRequestComponent, AppOpenAd> zzevv, zzeud zzeud, zzeyv zzeyv) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcop;
        this.zze = zzevv;
        this.zzd = zzeud;
        this.zzg = zzeyv;
        this.zzf = new FrameLayout(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzl */
    public final synchronized AppOpenRequestComponentBuilder zzk(zzevt zzevt) {
        zzeto zzeto = (zzeto) zzevt;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfB)).booleanValue()) {
            zzcvg zzcvg = new zzcvg(this.zzf);
            zzdao zzdao = new zzdao();
            zzdao.zza(this.zzb);
            zzdao.zzb(zzeto.zza);
            return zzc(zzcvg, zzdao.zzd(), new zzdgh().zzm());
        }
        zzeud zzg2 = zzeud.zzg(this.zzd);
        zzdgh zzdgh = new zzdgh();
        zzdgh.zzc(zzg2, this.zzc);
        zzdgh.zzh(zzg2, this.zzc);
        zzdgh.zzi(zzg2, this.zzc);
        zzdgh.zzj(zzg2, this.zzc);
        zzdgh.zzk(zzg2);
        zzcvg zzcvg2 = new zzcvg(this.zzf);
        zzdao zzdao2 = new zzdao();
        zzdao2.zza(this.zzb);
        zzdao2.zzb(zzeto.zza);
        return zzc(zzcvg2, zzdao2.zzd(), zzdgh.zzm());
    }

    public final synchronized boolean zza(zzbdk zzbdk, String str, zzele zzele, zzelf<? super AppOpenAd> zzelf) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (str == null) {
            zzcgs.zzf("Ad unit ID should not be null for app open ad.");
            this.zzc.execute(new zzetk(this));
            return false;
        } else if (this.zzh != null) {
            return false;
        } else {
            zzezm.zzb(this.zzb, zzbdk.zzf);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue() && zzbdk.zzf) {
                this.zza.zzz().zzc(true);
            }
            zzeyv zzeyv = this.zzg;
            zzeyv.zzf(str);
            zzeyv.zzc(zzbdp.zzd());
            zzeyv.zza(zzbdk);
            zzeyw zzu = zzeyv.zzu();
            zzeto zzeto = new zzeto((zzetn) null);
            zzeto.zza = zzu;
            zzfqn<AppOpenAd> zzc2 = this.zze.zzc(new zzevw(zzeto, (zzcbk) null), new zzetl(this), null);
            this.zzh = zzc2;
            zzfqe.zzp(zzc2, new zzetn(this, zzelf, zzeto), this.zzc);
            return true;
        }
    }

    public final boolean zzb() {
        zzfqn<AppOpenAd> zzfqn = this.zzh;
        return zzfqn != null && !zzfqn.isDone();
    }

    public abstract AppOpenRequestComponentBuilder zzc(zzcvg zzcvg, zzdap zzdap, zzdgi zzdgi);

    public final void zzd(zzbdv zzbdv) {
        this.zzg.zzo(zzbdv);
    }

    public final /* synthetic */ void zze() {
        this.zzd.zzbT(zzezr.zzd(6, (String) null, (zzbdd) null));
    }
}
