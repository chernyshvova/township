package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzdxn;
import com.google.android.gms.internal.ads.zzdxo;
import com.google.android.gms.internal.ads.zzfqn;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzay {
    @VisibleForTesting
    public String zza = "";
    public final Object zzb = new Object();
    @GuardedBy("lock")
    public String zzc = "";
    @GuardedBy("lock")
    public String zzd = "";
    @GuardedBy("lock")
    public boolean zze = false;
    @GuardedBy("lock")
    public boolean zzf = false;
    public zzdxo zzg;

    @VisibleForTesting
    public static final String zzo(Context context, String str, String str2) {
        String str3;
        String str4;
        String str5;
        HashMap hashMap = new HashMap();
        hashMap.put(GraphRequest.USER_AGENT_HEADER, zzs.zzc().zze(context, str2));
        zzfqn<String> zzb2 = new zzbp(context).zzb(0, str, hashMap, (byte[]) null);
        try {
            return zzb2.get((long) ((Integer) zzbex.zzc().zzb(zzbjn.zzdb)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str3 = "Timeout while retrieving a response from: ".concat(valueOf);
            } else {
                str3 = new String("Timeout while retrieving a response from: ");
            }
            zzcgs.zzg(str3, e);
            zzb2.cancel(true);
            return null;
        } catch (InterruptedException e2) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                str4 = "Interrupted while retrieving a response from: ".concat(valueOf2);
            } else {
                str4 = new String("Interrupted while retrieving a response from: ");
            }
            zzcgs.zzg(str4, e2);
            zzb2.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf3 = String.valueOf(str);
            if (valueOf3.length() != 0) {
                str5 = "Error retrieving a response from: ".concat(valueOf3);
            } else {
                str5 = new String("Error retrieving a response from: ");
            }
            zzcgs.zzg(str5, e3);
            return null;
        }
    }

    private final Uri zzp(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        synchronized (this.zzb) {
            if (TextUtils.isEmpty(this.zzc)) {
                zzs.zzc();
                try {
                    str5 = new String(IOUtils.readInputStreamFully(context.openFileInput("debug_signals_id.txt"), true), "UTF-8");
                } catch (IOException unused) {
                    zzcgs.zzd("Error reading from internal storage.");
                    str5 = "";
                }
                this.zzc = str5;
                if (TextUtils.isEmpty(str5)) {
                    zzs.zzc();
                    this.zzc = UUID.randomUUID().toString();
                    zzs.zzc();
                    String str6 = this.zzc;
                    try {
                        FileOutputStream openFileOutput = context.openFileOutput("debug_signals_id.txt", 0);
                        openFileOutput.write(str6.getBytes("UTF-8"));
                        openFileOutput.close();
                    } catch (Exception e) {
                        zzcgs.zzg("Error writing to file in internal storage.", e);
                    }
                }
            }
            str4 = this.zzc;
        }
        buildUpon.appendQueryParameter("linkedDeviceId", str4);
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    public final void zza(zzdxo zzdxo) {
        this.zzg = zzdxo;
    }

    public final zzdxo zzb() {
        return this.zzg;
    }

    public final void zzc(Context context) {
        zzdxo zzdxo;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgq)).booleanValue() && (zzdxo = this.zzg) != null) {
            zzdxo.zzk(new zzav(this, context), zzdxn.DEBUG_MENU);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbjf<java.lang.String> r0 = com.google.android.gms.internal.ads.zzbjn.zzcY
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.String r0 = (java.lang.String) r0
            android.net.Uri r0 = r3.zzp(r4, r0, r5, r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = zzo(r4, r0, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            r0 = 0
            if (r6 == 0) goto L_0x0025
            java.lang.String r4 = "Not linked for in app preview."
            com.google.android.gms.internal.ads.zzcgs.zzd(r4)
            return r0
        L_0x0025:
            java.lang.String r4 = r4.trim()
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0083 }
            r6.<init>(r4)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r4 = "gct"
            java.lang.String r4 = r6.optString(r4)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = "status"
            java.lang.String r6 = r6.optString(r1)     // Catch:{ JSONException -> 0x0083 }
            r3.zza = r6     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzbjn.zzgq     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ JSONException -> 0x0083 }
            java.lang.Object r6 = r1.zzb(r6)     // Catch:{ JSONException -> 0x0083 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ JSONException -> 0x0083 }
            boolean r6 = r6.booleanValue()     // Catch:{ JSONException -> 0x0083 }
            r1 = 1
            if (r6 == 0) goto L_0x0079
            java.lang.String r6 = "0"
            java.lang.String r2 = r3.zza     // Catch:{ JSONException -> 0x0083 }
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x0083 }
            if (r6 != 0) goto L_0x0066
            java.lang.String r6 = "2"
            java.lang.String r2 = r3.zza     // Catch:{ JSONException -> 0x0083 }
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x0083 }
            if (r6 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r6 = 0
            goto L_0x0067
        L_0x0066:
            r6 = 1
        L_0x0067:
            r3.zzj(r6)     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.internal.ads.zzcgd r2 = com.google.android.gms.ads.internal.zzs.zzg()     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.ads.internal.util.zzg r2 = r2.zzl()     // Catch:{ JSONException -> 0x0083 }
            if (r1 == r6) goto L_0x0076
            java.lang.String r5 = ""
        L_0x0076:
            r2.zzL(r5)     // Catch:{ JSONException -> 0x0083 }
        L_0x0079:
            java.lang.Object r5 = r3.zzb
            monitor-enter(r5)
            r3.zzd = r4     // Catch:{ all -> 0x0080 }
            monitor-exit(r5)     // Catch:{ all -> 0x0080 }
            return r1
        L_0x0080:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0080 }
            throw r4
        L_0x0083:
            r4 = move-exception
            java.lang.String r5 = "Fail to get in app preview response json."
            com.google.android.gms.internal.ads.zzcgs.zzj(r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzay.zzd(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public final boolean zze(Context context, String str, String str2) {
        String zzo = zzo(context, zzp(context, (String) zzbex.zzc().zzb(zzbjn.zzcZ), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzo)) {
            zzcgs.zzd("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(new JSONObject(zzo.trim()).optString("debug_mode"));
            zzj(equals);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgq)).booleanValue()) {
                zzg zzl = zzs.zzg().zzl();
                if (true != equals) {
                    str = "";
                }
                zzl.zzL(str);
            }
            return equals;
        } catch (JSONException e) {
            zzcgs.zzj("Fail to get debug mode response json.", e);
            return false;
        }
    }

    public final void zzf(Context context, String str, String str2) {
        zzs.zzc();
        zzr.zzX(context, zzp(context, (String) zzbex.zzc().zzb(zzbjn.zzcX), str, str2));
    }

    public final boolean zzg(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzm()) {
            return false;
        }
        zzcgs.zzd("Sending troubleshooting signals to the server.");
        zzh(context, str, str2, str3);
        return true;
    }

    public final void zzh(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzp(context, (String) zzbex.zzc().zzb(zzbjn.zzda), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzs.zzc();
        zzr.zzN(context, str, buildUpon.build().toString());
    }

    public final String zzi() {
        String str;
        synchronized (this.zzb) {
            str = this.zzd;
        }
        return str;
    }

    public final void zzj(boolean z) {
        synchronized (this.zzb) {
            this.zzf = z;
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgq)).booleanValue()) {
                zzs.zzg().zzl().zzJ(z);
                zzdxo zzdxo = this.zzg;
                if (zzdxo != null) {
                    zzdxo.zzb(z);
                }
            }
        }
    }

    public final boolean zzk() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzf;
        }
        return z;
    }

    public final void zzl(boolean z) {
        synchronized (this.zzb) {
            this.zze = z;
        }
    }

    public final boolean zzm() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zze;
        }
        return z;
    }

    @VisibleForTesting
    public final void zzn(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzcgs.zzh("Can not create dialog without Activity Context");
        } else {
            zzr.zza.post(new zzax(this, context, str, z, z2));
        }
    }
}
