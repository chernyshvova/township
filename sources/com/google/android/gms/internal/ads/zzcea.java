package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcea implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final Context zza;
    public final SharedPreferences zzb;
    public final zzg zzc;
    public final zzcfb zzd;
    public String zze = "";

    public zzcea(Context context, zzg zzg, zzcfb zzcfb) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzg;
        this.zza = context;
        this.zzd = zzcfb;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Context context;
        if ("IABTCF_PurposeConsents".equals(str)) {
            String string = sharedPreferences.getString("IABTCF_PurposeConsents", "");
            if (!string.isEmpty() && !this.zze.equals(string)) {
                this.zze = string;
                boolean z = false;
                if (string.charAt(0) != '1') {
                    z = true;
                }
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzao)).booleanValue()) {
                    this.zzc.zzB(z);
                    if (((Boolean) zzbex.zzc().zzb(zzbjn.zzew)).booleanValue() && z && (context = this.zza) != null) {
                        context.deleteDatabase("OfflineUpload.db");
                    }
                }
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzaj)).booleanValue()) {
                    this.zzd.zza();
                }
            }
        }
    }

    public final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
    }
}
