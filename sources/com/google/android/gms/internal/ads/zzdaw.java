package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.google.android.gms.ads.internal.zzs;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdaw extends zzbhc {
    public final String zza;
    public final String zzb;
    public final List<zzbdt> zzc;
    public final long zzd;
    public final String zze;

    public zzdaw(zzeye zzeye, String str, zzeds zzeds, zzeyh zzeyh) {
        String str2;
        String str3 = null;
        if (zzeye == null) {
            str2 = null;
        } else {
            str2 = zzeye.zzW;
        }
        this.zzb = str2;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                str3 = zzeye.zzv.getString(PathComponent.PATH_CLASS_NAME_KEY);
            } catch (JSONException unused) {
            }
        }
        this.zza = str3 != null ? str3 : str;
        this.zzc = zzeds.zze();
        this.zzd = zzs.zzj().currentTimeMillis() / 1000;
        this.zze = (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgs)).booleanValue() || zzeyh == null || TextUtils.isEmpty(zzeyh.zzh)) ? "" : zzeyh.zzh;
    }

    public final long zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzb;
    }

    @Nullable
    public final List<zzbdt> zzg() {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfJ)).booleanValue()) {
            return null;
        }
        return this.zzc;
    }
}
