package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import org.json.JSONObject;

@UiThread
/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzbe extends WebView {
    public final Handler zza;
    public final zzbj zzb;
    public boolean zzc = false;

    public zzbe(zzbh zzbh, Handler handler, zzbj zzbj) {
        super(zzbh);
        this.zza = handler;
        this.zzb = zzbj;
    }

    public final void zza(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(jSONObject2).length() + String.valueOf(str).length() + 3);
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        this.zza.post(new zzbd(this, sb.toString()));
    }

    public static boolean zza(@Nullable String str) {
        return str != null && str.startsWith("consent://");
    }
}
