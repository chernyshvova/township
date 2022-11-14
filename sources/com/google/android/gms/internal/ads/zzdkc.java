package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdkc implements zzdcr, zzo {
    @Nullable
    @VisibleForTesting
    public IObjectWrapper zza;
    public final Context zzb;
    @Nullable
    public final zzcmr zzc;
    public final zzeye zzd;
    public final zzcgy zze;
    public final zzazh zzf;

    public zzdkc(Context context, @Nullable zzcmr zzcmr, zzeye zzeye, zzcgy zzcgy, zzazh zzazh) {
        this.zzb = context;
        this.zzc = zzcmr;
        this.zzd = zzeye;
        this.zze = zzcgy;
        this.zzf = zzazh;
    }

    public final void zzbE() {
        zzcmr zzcmr;
        if (this.zza != null && (zzcmr = this.zzc) != null) {
            zzcmr.zze("onSdkImpression", new ArrayMap());
        }
    }

    public final void zzbH() {
    }

    public final void zzbI() {
    }

    public final void zzbJ() {
    }

    public final void zzbK(int i) {
        this.zza = null;
    }

    public final void zzbU() {
        zzbzm zzbzm;
        zzbzn zzbzn;
        zzbzn zzbzn2;
        zzazh zzazh = this.zzf;
        if ((zzazh == zzazh.REWARD_BASED_VIDEO_AD || zzazh == zzazh.INTERSTITIAL || zzazh == zzazh.APP_OPEN) && this.zzd.zzO && this.zzc != null && zzs.zzr().zza(this.zzb)) {
            zzcgy zzcgy = this.zze;
            int i = zzcgy.zzb;
            int i2 = zzcgy.zzc;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(CodelessMatcher.CURRENT_CLASS_NAME);
            sb.append(i2);
            String sb2 = sb.toString();
            String zza2 = this.zzd.zzQ.zza();
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdr)).booleanValue()) {
                if (this.zzd.zzQ.zzb() == 1) {
                    zzbzm = zzbzm.zzc;
                    zzbzn = zzbzn.DEFINED_BY_JAVASCRIPT;
                } else {
                    if (this.zzd.zzT == 2) {
                        zzbzn2 = zzbzn.UNSPECIFIED;
                    } else {
                        zzbzn2 = zzbzn.BEGIN_TO_RENDER;
                    }
                    zzbzn = zzbzn2;
                    zzbzm = zzbzm.HTML_DISPLAY;
                }
                this.zza = zzs.zzr().zzf(sb2, this.zzc.zzG(), "", "javascript", zza2, zzbzn, zzbzm, this.zzd.zzah);
            } else {
                this.zza = zzs.zzr().zzd(sb2, this.zzc.zzG(), "", "javascript", zza2);
            }
            if (this.zza != null) {
                zzs.zzr().zzj(this.zza, (View) this.zzc);
                this.zzc.zzak(this.zza);
                zzs.zzr().zzh(this.zza);
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdu)).booleanValue()) {
                    this.zzc.zze("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }

    public final void zzca() {
    }
}
