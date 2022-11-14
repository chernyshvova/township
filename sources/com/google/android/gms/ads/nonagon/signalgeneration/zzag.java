package com.google.android.gms.ads.nonagon.signalgeneration;

import android.webkit.ValueCallback;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzcgs;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzag extends QueryInfoGenerationCallback {
    public final /* synthetic */ String zza;
    public final /* synthetic */ TaggingLibraryJsInterface zzb;

    public zzag(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zzb = taggingLibraryJsInterface;
        this.zza = str;
    }

    public final void onFailure(String str) {
        String str2;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Failed to generate query info for the tagging library, error: ".concat(valueOf);
        } else {
            str2 = new String("Failed to generate query info for the tagging library, error: ");
        }
        zzcgs.zzi(str2);
        this.zzb.zzb.evaluateJavascript(String.format("window.postMessage({'paw_id': '%1$s', 'error': '%2$s'}, '*');", new Object[]{this.zza, str}), (ValueCallback) null);
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String str;
        String query = queryInfo.getQuery();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", this.zza);
            jSONObject.put("signal", query);
            str = String.format("window.postMessage(%1$s, '*');", new Object[]{jSONObject});
        } catch (JSONException unused) {
            str = String.format("window.postMessage({'paw_id': '%1$s', 'signal': '%2$s'}, '*');", new Object[]{this.zza, queryInfo.getQuery()});
        }
        this.zzb.zzb.evaluateJavascript(str, (ValueCallback) null);
    }
}
