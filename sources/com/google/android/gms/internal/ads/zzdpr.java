package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdpr {
    public final zzeyw zza;
    public final Executor zzb;
    public final zzdsf zzc;
    public final zzdra zzd;
    public final Context zze;
    public final zzduu zzf;
    public final zzfdh zzg;
    public final zzfdz zzh;
    public final zzedb zzi;

    public zzdpr(zzeyw zzeyw, Executor executor, zzdsf zzdsf, Context context, zzduu zzduu, zzfdh zzfdh, zzfdz zzfdz, zzedb zzedb, zzdra zzdra) {
        this.zza = zzeyw;
        this.zzb = executor;
        this.zzc = zzdsf;
        this.zze = context;
        this.zzf = zzduu;
        this.zzg = zzfdh;
        this.zzh = zzfdz;
        this.zzi = zzedb;
        this.zzd = zzdra;
    }

    private final void zzh(zzcmr zzcmr) {
        zzi(zzcmr);
        zzcmr.zzab("/video", zzbpr.zzm);
        zzcmr.zzab("/videoMeta", zzbpr.zzn);
        zzcmr.zzab("/precache", new zzcky());
        zzcmr.zzab("/delayPageLoaded", zzbpr.zzq);
        zzcmr.zzab("/instrument", zzbpr.zzo);
        zzcmr.zzab("/log", zzbpr.zzh);
        zzcmr.zzab("/click", zzbpr.zzd);
        if (this.zza.zzb != null) {
            zzcmr.zzR().zzF(true);
            zzcmr.zzab("/open", new zzbqd((zzb) null, (zzbyk) null, (zzedb) null, (zzduu) null, (zzfdh) null));
        } else {
            zzcmr.zzR().zzF(false);
        }
        if (zzs.zzA().zzb(zzcmr.getContext())) {
            zzcmr.zzab("/logScionEvent", new zzbpy(zzcmr.getContext()));
        }
    }

    public static final void zzi(zzcmr zzcmr) {
        zzcmr.zzab("/videoClicked", zzbpr.zzi);
        zzcmr.zzR().zzE(true);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzce)).booleanValue()) {
            zzcmr.zzab("/getNativeAdViewSignals", zzbpr.zzt);
        }
        zzcmr.zzab("/getNativeClickMeta", zzbpr.zzu);
    }

    public final zzfqn<zzcmr> zza(JSONObject jSONObject) {
        return zzfqe.zzi(zzfqe.zzi(zzfqe.zza(null), new zzdpi(this), this.zzb), new zzdpg(this, jSONObject), this.zzb);
    }

    public final zzfqn<zzcmr> zzb(String str, String str2, zzeye zzeye, zzeyh zzeyh, zzbdp zzbdp) {
        return zzfqe.zzi(zzfqe.zza(null), new zzdph(this, zzbdp, zzeye, zzeyh, str, str2), this.zzb);
    }

    public final /* synthetic */ zzfqn zzc(Object obj) throws Exception {
        zzcmr zza2 = this.zzc.zza(zzbdp.zzb(), (zzeye) null, (zzeyh) null);
        zzchi zza3 = zzchi.zza(zza2);
        zzh(zza2);
        zza2.zzR().zzx(new zzdpj(zza3));
        zza2.loadUrl((String) zzbex.zzc().zzb(zzbjn.zzcd));
        return zza3;
    }

    public final /* synthetic */ zzfqn zzd(zzbdp zzbdp, zzeye zzeye, zzeyh zzeyh, String str, String str2, Object obj) throws Exception {
        zzcmr zza2 = this.zzc.zza(zzbdp, zzeye, zzeyh);
        zzchi zza3 = zzchi.zza(zza2);
        if (this.zza.zzb != null) {
            zzh(zza2);
            zza2.zzaf(zzcoh.zze());
        } else {
            zzdqx zza4 = this.zzd.zza();
            zzcof zzR = zza2.zzR();
            zzb zzb2 = new zzb(this.zze, (zzcdz) null, (zzcay) null);
            zzedb zzedb = this.zzi;
            zzfdz zzfdz = this.zzh;
            zzduu zzduu = this.zzf;
            zzduu zzduu2 = zzduu;
            zzfdz zzfdz2 = zzfdz;
            zzR.zzK(zza4, zza4, zza4, zza4, zza4, false, (zzbpv) null, zzb2, (zzbyr) null, (zzcdz) null, zzedb, zzfdz2, zzduu2, this.zzg, (zzbpt) null);
            zzi(zza2);
        }
        zza2.zzR().zzw(new zzdpk(this, zza2, zza3));
        zza2.zzat(str, str2, (String) null);
        return zza3;
    }

    public final /* synthetic */ void zze(zzcmr zzcmr, zzchi zzchi, boolean z) {
        if (z) {
            if (!(this.zza.zza == null || zzcmr.zzh() == null)) {
                zzcmr.zzh().zzc(this.zza.zza);
            }
            zzchi.zzb();
            return;
        }
        zzchi.zzd(new zzehd(1, "Html video Web View failed to load."));
    }

    public final /* synthetic */ zzfqn zzf(JSONObject jSONObject, zzcmr zzcmr) throws Exception {
        zzchi zza2 = zzchi.zza(zzcmr);
        if (this.zza.zzb != null) {
            zzcmr.zzaf(zzcoh.zze());
        } else {
            zzcmr.zzaf(zzcoh.zzd());
        }
        zzcmr.zzR().zzw(new zzdpl(this, zzcmr, zza2));
        zzcmr.zzr("google.afma.nativeAds.renderVideo", jSONObject);
        return zza2;
    }

    public final /* synthetic */ void zzg(zzcmr zzcmr, zzchi zzchi, boolean z) {
        if (!(this.zza.zza == null || zzcmr.zzh() == null)) {
            zzcmr.zzh().zzc(this.zza.zza);
        }
        zzchi.zzb();
    }
}
