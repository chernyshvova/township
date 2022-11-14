package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzaj implements zzi {
    public final Application zza;
    public final zzal zzb;
    public final Executor zzc;

    public zzaj(Application application, zzal zzal, Executor executor) {
        this.zza = application;
        this.zzb = zzal;
        this.zzc = executor;
    }

    public final Executor zza() {
        return this.zzc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r9, org.json.JSONObject r10) {
        /*
            r8 = this;
            int r0 = r9.hashCode()
            r1 = 94746189(0x5a5b64d, float:1.5583492E-35)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = 113399775(0x6c257df, float:7.3103804E-35)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "write"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0025
            r9 = 0
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "clear"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0025
            r9 = 1
            goto L_0x0026
        L_0x0025:
            r9 = -1
        L_0x0026:
            java.lang.String r0 = "UserMessagingPlatform"
            if (r9 == 0) goto L_0x0093
            if (r9 == r3) goto L_0x002d
            return r2
        L_0x002d:
            java.lang.String r9 = "keys"
            org.json.JSONArray r9 = r10.optJSONArray(r9)
            if (r9 == 0) goto L_0x0074
            int r1 = r9.length()
            if (r1 != 0) goto L_0x003c
            goto L_0x0074
        L_0x003c:
            java.util.HashSet r10 = new java.util.HashSet
            r10.<init>()
            int r1 = r9.length()
        L_0x0045:
            if (r2 >= r1) goto L_0x006e
            java.lang.String r4 = r9.optString(r2)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0068
            r4 = 46
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Action[clear]: empty key at index: "
            r5.append(r4)
            r5.append(r2)
            java.lang.String r4 = r5.toString()
            android.util.Log.d(r0, r4)
            goto L_0x006b
        L_0x0068:
            r10.add(r4)
        L_0x006b:
            int r2 = r2 + 1
            goto L_0x0045
        L_0x006e:
            android.app.Application r9 = r8.zza
            com.google.android.gms.internal.consent_sdk.zzcc.zza((android.content.Context) r9, (java.util.Set<java.lang.String>) r10)
            goto L_0x0092
        L_0x0074:
            java.lang.String r9 = "Action[clear]: wrong args."
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r1 = r10.length()
            if (r1 == 0) goto L_0x0089
            java.lang.String r9 = r9.concat(r10)
            goto L_0x008f
        L_0x0089:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r9)
            r9 = r10
        L_0x008f:
            android.util.Log.d(r0, r9)
        L_0x0092:
            return r3
        L_0x0093:
            com.google.android.gms.internal.consent_sdk.zzce r9 = new com.google.android.gms.internal.consent_sdk.zzce
            android.app.Application r1 = r8.zza
            r9.<init>(r1)
            java.util.Iterator r1 = r10.keys()
        L_0x009e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0107
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r10.opt(r2)
            java.lang.String r5 = java.lang.String.valueOf(r4)
            java.lang.String r6 = java.lang.String.valueOf(r2)
            int r6 = r6.length()
            int r6 = r6 + 23
            int r7 = r5.length()
            int r7 = r7 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r7)
            java.lang.String r7 = "Writing to storage: ["
            r6.append(r7)
            r6.append(r2)
            java.lang.String r7 = "] "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            android.util.Log.d(r0, r5)
            boolean r4 = r9.zza((java.lang.String) r2, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x00ed
            com.google.android.gms.internal.consent_sdk.zzal r4 = r8.zzb
            java.util.Set r4 = r4.zzd()
            r4.add(r2)
            goto L_0x009e
        L_0x00ed:
            java.lang.String r4 = "Failed writing key: "
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r5 = r2.length()
            if (r5 == 0) goto L_0x00fe
            java.lang.String r2 = r4.concat(r2)
            goto L_0x0103
        L_0x00fe:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r4)
        L_0x0103:
            android.util.Log.d(r0, r2)
            goto L_0x009e
        L_0x0107:
            com.google.android.gms.internal.consent_sdk.zzal r10 = r8.zzb
            r10.zze()
            r9.zza()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzaj.zza(java.lang.String, org.json.JSONObject):boolean");
    }
}
