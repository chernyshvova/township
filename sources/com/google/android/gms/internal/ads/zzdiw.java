package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdiw extends zzcxi {
    public final Context zzc;
    public final WeakReference<zzcmr> zzd;
    public final zzdhq zze;
    public final zzdkb zzf;
    public final zzcyc zzg;
    public final zzfgy zzh;
    public final zzdbq zzi;
    public boolean zzj = false;

    public zzdiw(zzcxh zzcxh, Context context, @Nullable zzcmr zzcmr, zzdhq zzdhq, zzdkb zzdkb, zzcyc zzcyc, zzfgy zzfgy, zzdbq zzdbq) {
        super(zzcxh);
        this.zzc = context;
        this.zzd = new WeakReference<>(zzcmr);
        this.zze = zzdhq;
        this.zzf = zzdkb;
        this.zzg = zzcyc;
        this.zzh = zzfgy;
        this.zzi = zzdbq;
    }

    public final void finalize() throws Throwable {
        try {
            zzcmr zzcmr = (zzcmr) this.zzd.get();
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeW)).booleanValue()) {
                if (!this.zzj && zzcmr != null) {
                    zzche.zze.execute(zzdiv.zza(zzcmr));
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
                zzcgs.zzi("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzd();
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzas)).booleanValue()) {
                    this.zzh.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgH)).booleanValue() && this.zzj) {
            zzcgs.zzi("The interstitial ad has been showed.");
            this.zzi.zza(zzezr.zzd(10, (String) null, (zzbdd) null));
        }
        if (!this.zzj) {
            this.zze.zza();
            Context context = activity;
            if (activity == null) {
                context = this.zzc;
            }
            try {
                this.zzf.zza(z, context, this.zzi);
                this.zze.zzb();
                this.zzj = true;
                return true;
            } catch (zzdka e) {
                this.zzi.zzc(e);
            }
        }
        return false;
    }

    public final boolean zzb() {
        return this.zzg.zzg();
    }
}
