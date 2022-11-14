package com.google.android.gms.internal.consent_sdk;

import android.text.TextUtils;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final /* synthetic */ class zzg implements Runnable {
    public final String zza;
    public final String zzb;
    public final zzi[] zzc;

    public zzg(String str, String str2, zzi[] zziArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zziArr;
    }

    public final void run() {
        JSONObject jSONObject;
        String str = this.zza;
        String str2 = this.zzb;
        zzi[] zziArr = this.zzc;
        if (TextUtils.isEmpty(str)) {
            Log.d("UserMessagingPlatform", "Error on action: empty action name");
            return;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.isEmpty(str2)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException unused) {
                StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline3(str2, GeneratedOutlineSupport.outline3(lowerCase, 32)));
                sb.append("Action[");
                sb.append(lowerCase);
                sb.append("]: failed to parse args: ");
                sb.append(str2);
                Log.d("UserMessagingPlatform", sb.toString());
                return;
            }
        }
        String valueOf = String.valueOf(jSONObject);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + GeneratedOutlineSupport.outline3(lowerCase, 10));
        sb2.append("Action[");
        sb2.append(lowerCase);
        sb2.append("]: ");
        sb2.append(valueOf);
        Log.d("UserMessagingPlatform", sb2.toString());
        int length = zziArr.length;
        int i = 0;
        while (i < length) {
            zzi zzi = zziArr[i];
            FutureTask futureTask = new FutureTask(new zzf(zzi, lowerCase, jSONObject));
            zzi.zza().execute(futureTask);
            try {
                if (!((Boolean) futureTask.get()).booleanValue()) {
                    i++;
                } else {
                    return;
                }
            } catch (ExecutionException e) {
                zzca.zza(GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(lowerCase, 24), "Failed to run Action[", lowerCase, "]: "), e.getCause());
            } catch (InterruptedException e2) {
                StringBuilder sb3 = new StringBuilder(GeneratedOutlineSupport.outline3(lowerCase, 33));
                sb3.append("Thread interrupted for Action[");
                sb3.append(lowerCase);
                sb3.append("]: ");
                zzca.zza(sb3.toString(), e2);
            }
        }
    }
}
