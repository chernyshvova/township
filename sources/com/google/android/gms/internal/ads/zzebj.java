package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzebj implements zzdfq, zzbcz, zzdbx, zzdbh {
    public final Context zza;
    public final zzezj zzb;
    public final zzeyq zzc;
    public final zzeye zzd;
    public final zzedb zze;
    @Nullable
    public Boolean zzf;
    public final boolean zzg = ((Boolean) zzbex.zzc().zzb(zzbjn.zzeZ)).booleanValue();
    @NonNull
    public final zzfdh zzh;
    public final String zzi;

    public zzebj(Context context, zzezj zzezj, zzeyq zzeyq, zzeye zzeye, zzedb zzedb, @NonNull zzfdh zzfdh, String str) {
        this.zza = context;
        this.zzb = zzezj;
        this.zzc = zzeyq;
        this.zzd = zzeye;
        this.zze = zzedb;
        this.zzh = zzfdh;
        this.zzi = str;
    }

    private final boolean zze() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
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
                    this.zzf = Boolean.valueOf(z);
                }
            }
        }
        return this.zzf.booleanValue();
    }

    private final zzfdg zzf(String str) {
        zzfdg zza2 = zzfdg.zza(str);
        zza2.zzg(this.zzc, (zzcgh) null);
        zza2.zzi(this.zzd);
        zza2.zzc("request_id", this.zzi);
        if (!this.zzd.zzt.isEmpty()) {
            zza2.zzc("ancn", this.zzd.zzt.get(0));
        }
        if (this.zzd.zzae) {
            zzs.zzc();
            zza2.zzc("device_connectivity", true != zzr.zzI(this.zza) ? "offline" : "online");
            zza2.zzc("event_timestamp", String.valueOf(zzs.zzj().currentTimeMillis()));
            zza2.zzc("offline_ad", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        return zza2;
    }

    private final void zzg(zzfdg zzfdg) {
        if (this.zzd.zzae) {
            this.zze.zze(new zzedd(zzs.zzj().currentTimeMillis(), this.zzc.zzb.zzb.zzb, this.zzh.zzb(zzfdg), 2));
            return;
        }
        this.zzh.zza(zzfdg);
    }

    public final void onAdClicked() {
        if (this.zzd.zzae) {
            zzg(zzf("click"));
        }
    }

    public final void zza(zzbdd zzbdd) {
        zzbdd zzbdd2;
        if (this.zzg) {
            int i = zzbdd.zza;
            String str = zzbdd.zzb;
            if (zzbdd.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzbdd2 = zzbdd.zzd) != null && !zzbdd2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zzbdd zzbdd3 = zzbdd.zzd;
                i = zzbdd3.zza;
                str = zzbdd3.zzb;
            }
            String zza2 = this.zzb.zza(str);
            zzfdg zzf2 = zzf("ifts");
            zzf2.zzc("reason", "adapter");
            if (i >= 0) {
                zzf2.zzc("arec", String.valueOf(i));
            }
            if (zza2 != null) {
                zzf2.zzc("areec", zza2);
            }
            this.zzh.zza(zzf2);
        }
    }

    public final void zzb() {
        if (zze()) {
            this.zzh.zza(zzf("adapter_impression"));
        }
    }

    public final void zzbF() {
        if (zze() || this.zzd.zzae) {
            zzg(zzf("impression"));
        }
    }

    public final void zzc(zzdka zzdka) {
        if (this.zzg) {
            zzfdg zzf2 = zzf("ifts");
            zzf2.zzc("reason", "exception");
            if (!TextUtils.isEmpty(zzdka.getMessage())) {
                zzf2.zzc(NotificationCompat.CATEGORY_MESSAGE, zzdka.getMessage());
            }
            this.zzh.zza(zzf2);
        }
    }

    public final void zzd() {
        if (this.zzg) {
            zzfdh zzfdh = this.zzh;
            zzfdg zzf2 = zzf("ifts");
            zzf2.zzc("reason", "blocked");
            zzfdh.zza(zzf2);
        }
    }

    public final void zzk() {
        if (zze()) {
            this.zzh.zza(zzf("adapter_shown"));
        }
    }
}
