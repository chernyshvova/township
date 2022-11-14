package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.core.content.p002pm.PackageInfoCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzl {
    public final zzn zza;
    public final Activity zzb;
    public final ConsentDebugSettings zzc;
    public final ConsentRequestParameters zzd;

    public zzl(zzn zzn, Activity activity, ConsentDebugSettings consentDebugSettings, ConsentRequestParameters consentRequestParameters) {
        this.zza = zzn;
        this.zzb = activity;
        this.zzc = consentDebugSettings;
        this.zzd = consentRequestParameters;
    }

    /* access modifiers changed from: private */
    public final zzbn zza() throws zzk {
        ArrayList arrayList;
        String str;
        zzbn zzbn = new zzbn();
        zzbn.zza = zzc();
        zza zza2 = this.zza.zzb.zza();
        if (zza2 != null) {
            zzbn.zzb = zza2.zza;
            zzbn.zzi = Boolean.valueOf(zza2.zzb);
        }
        if (!this.zzc.zza) {
            arrayList = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList();
            int i = this.zzc.zzb;
            if (i != 1) {
                arrayList = arrayList2;
                if (i == 2) {
                    arrayList2.add(zzbs.GEO_OVERRIDE_NON_EEA);
                    arrayList = arrayList2;
                }
            } else {
                arrayList2.add(zzbs.GEO_OVERRIDE_EEA);
                arrayList = arrayList2;
            }
        }
        zzbn.zzn = arrayList;
        Application zza3 = this.zza.zza;
        Set<String> zzc2 = this.zza.zzc.zzc();
        HashMap hashMap = new HashMap();
        for (String next : zzc2) {
            zzcb zza4 = zzcc.zza((Context) zza3, next);
            if (zza4 == null) {
                String valueOf = String.valueOf(next);
                Log.d("UserMessagingPlatform", valueOf.length() != 0 ? "Fetching request info: failed for key: ".concat(valueOf) : new String("Fetching request info: failed for key: "));
            } else {
                Object obj = zza3.getSharedPreferences(zza4.zza, 0).getAll().get(zza4.zzb);
                if (obj == null) {
                    String valueOf2 = String.valueOf(next);
                    Log.d("UserMessagingPlatform", valueOf2.length() != 0 ? "Stored info not exists: ".concat(valueOf2) : new String("Stored info not exists: "));
                } else {
                    if (obj instanceof Boolean) {
                        str = ((Boolean) obj).booleanValue() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } else if (obj instanceof Number) {
                        str = obj.toString();
                    } else if (obj instanceof String) {
                        str = (String) obj;
                    } else {
                        String valueOf3 = String.valueOf(next);
                        Log.d("UserMessagingPlatform", valueOf3.length() != 0 ? "Failed to fetch stored info: ".concat(valueOf3) : new String("Failed to fetch stored info: "));
                    }
                    hashMap.put(next, str);
                }
            }
        }
        zzbn.zzj = hashMap;
        zzbn.zzd = null;
        zzbn.zzg = null;
        throw null;
    }

    private final zzbp zzb() {
        PackageInfo packageInfo;
        Application zza2 = this.zza.zza;
        String str = null;
        try {
            packageInfo = this.zza.zza.getPackageManager().getPackageInfo(zza2.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        zzbp zzbp = new zzbp();
        zzbp.zza = zza2.getPackageName();
        CharSequence applicationLabel = this.zza.zza.getPackageManager().getApplicationLabel(this.zza.zza.getApplicationInfo());
        if (applicationLabel != null) {
            str = applicationLabel.toString();
        }
        zzbp.zzb = str;
        if (packageInfo != null) {
            zzbp.zzc = Long.toString(PackageInfoCompat.getLongVersionCode(packageInfo));
        }
        return zzbp;
    }

    private final String zzc() throws zzk {
        throw null;
    }
}
