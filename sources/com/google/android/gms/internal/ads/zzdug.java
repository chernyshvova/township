package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdug implements zzdfq, zzbcz, zzdbx, zzdbh {
    public final Context zza;
    public final zzezj zzb;
    public final zzduu zzc;
    public final zzeyq zzd;
    public final zzeye zze;
    public final zzedb zzf;
    @Nullable
    public Boolean zzg;
    public final boolean zzh = ((Boolean) zzbex.zzc().zzb(zzbjn.zzeZ)).booleanValue();

    public zzdug(Context context, zzezj zzezj, zzduu zzduu, zzeyq zzeyq, zzeye zzeye, zzedb zzedb) {
        this.zza = context;
        this.zzb = zzezj;
        this.zzc = zzduu;
        this.zzd = zzeyq;
        this.zze = zzeye;
        this.zzf = zzedb;
    }

    private final boolean zze() {
        if (this.zzg == null) {
            synchronized (this) {
                if (this.zzg == null) {
                    String str = (String) zzbex.zzc().zzb(zzbjn.zzaY);
                    zzs.zzc();
                    String zzv = zzr.zzv(this.zza);
                    boolean z = false;
                    if (!(str == null || zzv == null)) {
                        try {
                            z = Pattern.matches(str, zzv);
                        } catch (RuntimeException e) {
                            zzs.zzg().zzg(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzg = Boolean.valueOf(z);
                }
            }
        }
        return this.zzg.booleanValue();
    }

    private final zzdut zzf(String str) {
        zzdut zza2 = this.zzc.zza();
        zza2.zza(this.zzd.zzb.zzb);
        zza2.zzb(this.zze);
        zza2.zzc("action", str);
        if (!this.zze.zzt.isEmpty()) {
            zza2.zzc("ancn", this.zze.zzt.get(0));
        }
        if (this.zze.zzae) {
            zzs.zzc();
            zza2.zzc("device_connectivity", true != zzr.zzI(this.zza) ? "offline" : "online");
            zza2.zzc("event_timestamp", String.valueOf(zzs.zzj().currentTimeMillis()));
            zza2.zzc("offline_ad", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        return zza2;
    }

    private final void zzg(zzdut zzdut) {
        if (this.zze.zzae) {
            this.zzf.zze(new zzedd(zzs.zzj().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdut.zze(), 2));
            return;
        }
        zzdut.zzd();
    }

    public final void onAdClicked() {
        if (this.zze.zzae) {
            zzg(zzf("click"));
        }
    }

    public final void zza(zzbdd zzbdd) {
        zzbdd zzbdd2;
        if (this.zzh) {
            zzdut zzf2 = zzf("ifts");
            zzf2.zzc("reason", "adapter");
            int i = zzbdd.zza;
            String str = zzbdd.zzb;
            if (zzbdd.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzbdd2 = zzbdd.zzd) != null && !zzbdd2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zzbdd zzbdd3 = zzbdd.zzd;
                i = zzbdd3.zza;
                str = zzbdd3.zzb;
            }
            if (i >= 0) {
                zzf2.zzc("arec", String.valueOf(i));
            }
            String zza2 = this.zzb.zza(str);
            if (zza2 != null) {
                zzf2.zzc("areec", zza2);
            }
            zzf2.zzd();
        }
    }

    public final void zzb() {
        if (zze()) {
            zzf("adapter_impression").zzd();
        }
    }

    public final void zzbF() {
        if (zze() || this.zze.zzae) {
            zzg(zzf("impression"));
        }
    }

    public final void zzc(zzdka zzdka) {
        if (this.zzh) {
            zzdut zzf2 = zzf("ifts");
            zzf2.zzc("reason", "exception");
            if (!TextUtils.isEmpty(zzdka.getMessage())) {
                zzf2.zzc(NotificationCompat.CATEGORY_MESSAGE, zzdka.getMessage());
            }
            zzf2.zzd();
        }
    }

    public final void zzd() {
        if (this.zzh) {
            zzdut zzf2 = zzf("ifts");
            zzf2.zzc("reason", "blocked");
            zzf2.zzd();
        }
    }

    public final void zzk() {
        if (zze()) {
            zzf("adapter_shown").zzd();
        }
    }
}
