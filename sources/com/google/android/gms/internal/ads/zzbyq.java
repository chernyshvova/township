package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzbyq {
    public final zzcmr zza;
    public final String zzb;

    public zzbyq(zzcmr zzcmr, String str) {
        this.zza = zzcmr;
        this.zzb = str;
    }

    public final void zzf(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.zzb);
            zzcmr zzcmr = this.zza;
            if (zzcmr != null) {
                zzcmr.zzd("onError", put);
            }
        } catch (JSONException e) {
            zzcgs.zzg("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzg(String str) {
        try {
            this.zza.zzd("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzcgs.zzg("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzh(int i, int i2, int i3, int i4) {
        try {
            this.zza.zzd("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzcgs.zzg("Error occurred while dispatching size change.", e);
        }
    }

    public final void zzi(int i, int i2, int i3, int i4) {
        try {
            this.zza.zzd("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzcgs.zzg("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzj(String str) {
        try {
            this.zza.zzd("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzcgs.zzg("Error occurred while dispatching state change.", e);
        }
    }

    public final void zzk(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zza.zzd("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzcgs.zzg("Error occurred while obtaining screen information.", e);
        }
    }
}
