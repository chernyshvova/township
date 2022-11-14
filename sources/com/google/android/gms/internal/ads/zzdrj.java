package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdrj extends zzcxi {
    public final Context zzc;
    public final WeakReference<zzcmr> zzd;
    public final zzdkb zze;
    public final zzdhq zzf;
    public final zzdbq zzg;
    public final zzdcx zzh;
    public final zzcyc zzi;
    public final zzccq zzj;
    public final zzfgy zzk;
    public boolean zzl = false;

    public zzdrj(zzcxh zzcxh, Context context, @Nullable zzcmr zzcmr, zzdkb zzdkb, zzdhq zzdhq, zzdbq zzdbq, zzdcx zzdcx, zzcyc zzcyc, zzeye zzeye, zzfgy zzfgy) {
        super(zzcxh);
        this.zzc = context;
        this.zze = zzdkb;
        this.zzd = new WeakReference<>(zzcmr);
        this.zzf = zzdhq;
        this.zzg = zzdbq;
        this.zzh = zzdcx;
        this.zzi = zzcyc;
        this.zzk = zzfgy;
        zzccm zzccm = zzeye.zzm;
        this.zzj = new zzcdk(zzccm != null ? zzccm.zza : "", zzccm != null ? zzccm.zzb : 1);
    }

    public final void finalize() throws Throwable {
        try {
            zzcmr zzcmr = (zzcmr) this.zzd.get();
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeW)).booleanValue()) {
                if (!this.zzl && zzcmr != null) {
                    zzche.zze.execute(zzdri.zza(zzcmr));
                }
            } else if (zzcmr != null) {
                zzcmr.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean zza(boolean z, @Nullable Activity activity) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzar)).booleanValue()) {
            zzs.zzc();
            if (zzr.zzJ(this.zzc)) {
                zzcgs.zzi("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzd();
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzas)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzl) {
            zzcgs.zzi("The rewarded ad have been showed.");
            this.zzg.zza(zzezr.zzd(10, (String) null, (zzbdd) null));
            return false;
        }
        this.zzl = true;
        this.zzf.zza();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z, context, this.zzg);
            this.zzf.zzb();
            return true;
        } catch (zzdka e) {
            this.zzg.zzc(e);
            return false;
        }
    }

    public final boolean zzb() {
        return this.zzl;
    }

    public final zzccq zzc() {
        return this.zzj;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        zzcmr zzcmr = (zzcmr) this.zzd.get();
        return zzcmr != null && !zzcmr.zzaA();
    }

    public final Bundle zzg() {
        return this.zzh.zzb();
    }
}
