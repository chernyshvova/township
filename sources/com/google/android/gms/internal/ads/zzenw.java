package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzenw implements zzeqp<zzenv> {
    public final Context zza;
    public final zzfqo zzb;

    public zzenw(Context context, zzfqo zzfqo) {
        this.zza = context;
        this.zzb = zzfqo;
    }

    public final zzfqn<zzenv> zza() {
        return this.zzb.zzb(new zzent(this));
    }

    public final /* synthetic */ zzenv zzb() throws Exception {
        String str;
        Bundle bundle;
        zzs.zzc();
        Context context = this.zza;
        String str2 = "";
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzep)).booleanValue()) {
            str = str2;
        } else {
            str = context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", str2);
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzer)).booleanValue()) {
            str2 = this.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", str2);
        }
        zzs.zzc();
        Context context2 = this.zza;
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzeq)).booleanValue()) {
            bundle = null;
        } else {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
            bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i = 0; i < 4; i++) {
                String str3 = strArr[i];
                if (defaultSharedPreferences.contains(str3)) {
                    bundle.putString(str3, defaultSharedPreferences.getString(str3, (String) null));
                }
            }
        }
        return new zzenv(str, str2, bundle, (zzenu) null);
    }
}
