package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.facebook.appevents.aam.MetadataRule;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.helpshift.analytics.AnalyticsEventKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfh {
    public final String zza;
    public final Bundle zzb = new Bundle();
    public boolean zzc;
    public Bundle zzd;
    public final /* synthetic */ zzfc zze;

    public zzfh(zzfc zzfc, String str, Bundle bundle) {
        this.zze = zzfc;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    private final String zzb(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    jSONObject.put(MetadataRule.FIELD_V, String.valueOf(obj));
                    if (obj instanceof String) {
                        jSONObject.put("t", AnalyticsEventKey.SEARCH_QUERY);
                    } else if (obj instanceof Long) {
                        jSONObject.put("t", AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL);
                    } else if (obj instanceof Double) {
                        jSONObject.put("t", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
                    } else {
                        this.zze.zzq().zze().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    this.zze.zzq().zze().zza("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:34|35|46) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r12.zze.zzq().zze().zza("Error reading value from SharedPreferences. Value dropped");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00a0 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza() {
        /*
            r12 = this;
            boolean r0 = r12.zzc
            if (r0 != 0) goto L_0x00cd
            r0 = 1
            r12.zzc = r0
            com.google.android.gms.measurement.internal.zzfc r1 = r12.zze
            android.content.SharedPreferences r1 = r1.zzf()
            java.lang.String r2 = r12.zza
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)
            if (r1 == 0) goto L_0x00c5
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ JSONException -> 0x00b6 }
            r2.<init>()     // Catch:{ JSONException -> 0x00b6 }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00b6 }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x00b6 }
            r1 = 0
            r4 = 0
        L_0x0022:
            int r5 = r3.length()     // Catch:{ JSONException -> 0x00b6 }
            if (r4 >= r5) goto L_0x00b3
            org.json.JSONObject r5 = r3.getJSONObject(r4)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            java.lang.String r6 = "n"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            java.lang.String r7 = "t"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            r8 = -1
            int r9 = r7.hashCode()     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            r10 = 100
            r11 = 2
            if (r9 == r10) goto L_0x005f
            r10 = 108(0x6c, float:1.51E-43)
            if (r9 == r10) goto L_0x0055
            r10 = 115(0x73, float:1.61E-43)
            if (r9 == r10) goto L_0x004b
            goto L_0x0068
        L_0x004b:
            java.lang.String r9 = "s"
            boolean r9 = r7.equals(r9)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            if (r9 == 0) goto L_0x0068
            r8 = 0
            goto L_0x0068
        L_0x0055:
            java.lang.String r9 = "l"
            boolean r9 = r7.equals(r9)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            if (r9 == 0) goto L_0x0068
            r8 = 2
            goto L_0x0068
        L_0x005f:
            java.lang.String r9 = "d"
            boolean r9 = r7.equals(r9)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            if (r9 == 0) goto L_0x0068
            r8 = 1
        L_0x0068:
            java.lang.String r9 = "v"
            if (r8 == 0) goto L_0x0098
            if (r8 == r0) goto L_0x008c
            if (r8 == r11) goto L_0x0080
            com.google.android.gms.measurement.internal.zzfc r5 = r12.zze     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzeq r5 = r5.zzq()     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zze()     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            java.lang.String r6 = "Unrecognized persisted bundle type. Type"
            r5.zza(r6, r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            goto L_0x00af
        L_0x0080:
            java.lang.String r5 = r5.getString(r9)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            long r7 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            r2.putLong(r6, r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            goto L_0x00af
        L_0x008c:
            java.lang.String r5 = r5.getString(r9)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            double r7 = java.lang.Double.parseDouble(r5)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            r2.putDouble(r6, r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            goto L_0x00af
        L_0x0098:
            java.lang.String r5 = r5.getString(r9)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            r2.putString(r6, r5)     // Catch:{ NumberFormatException | JSONException -> 0x00a0 }
            goto L_0x00af
        L_0x00a0:
            com.google.android.gms.measurement.internal.zzfc r5 = r12.zze     // Catch:{ JSONException -> 0x00b6 }
            com.google.android.gms.measurement.internal.zzeq r5 = r5.zzq()     // Catch:{ JSONException -> 0x00b6 }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zze()     // Catch:{ JSONException -> 0x00b6 }
            java.lang.String r6 = "Error reading value from SharedPreferences. Value dropped"
            r5.zza(r6)     // Catch:{ JSONException -> 0x00b6 }
        L_0x00af:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x00b3:
            r12.zzd = r2     // Catch:{ JSONException -> 0x00b6 }
            goto L_0x00c5
        L_0x00b6:
            com.google.android.gms.measurement.internal.zzfc r0 = r12.zze
            com.google.android.gms.measurement.internal.zzeq r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zze()
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            r0.zza(r1)
        L_0x00c5:
            android.os.Bundle r0 = r12.zzd
            if (r0 != 0) goto L_0x00cd
            android.os.Bundle r0 = r12.zzb
            r12.zzd = r0
        L_0x00cd:
            android.os.Bundle r0 = r12.zzd
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfh.zza():android.os.Bundle");
    }

    @WorkerThread
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.zze.zzf().edit();
        if (bundle.size() == 0) {
            edit.remove(this.zza);
        } else {
            edit.putString(this.zza, zzb(bundle));
        }
        edit.apply();
        this.zzd = bundle;
    }
}
