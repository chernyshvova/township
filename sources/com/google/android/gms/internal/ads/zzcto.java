package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.zzs;
import com.helpshift.analytics.AnalyticsEventKey;
import com.vungle.warren.VisionController;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcto implements zzbua<zzctr> {
    public final Context zza;
    public final zzavv zzb;
    public final PowerManager zzc;

    public zzcto(Context context, zzavv zzavv) {
        this.zza = context;
        this.zzb = zzavv;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzb(zzctr zzctr) throws JSONException {
        JSONObject jSONObject;
        boolean z;
        Integer num;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzavy zzavy = zzctr.zzf;
        if (zzavy == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzc() != null) {
            boolean z2 = zzavy.zza;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzc()).put("timestamp", zzctr.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzd()).put("isMraid", false).put("isStopped", false).put("isPaused", zzctr.zzb).put("isNative", this.zzb.zze());
            if (Build.VERSION.SDK_INT >= 20) {
                z = this.zzc.isInteractive();
            } else {
                z = this.zzc.isScreenOn();
            }
            put.put("isScreenOn", z).put("appMuted", zzs.zzh().zzd()).put("appVolume", (double) zzs.zzh().zzb()).put("deviceVolume", (double) zzad.zze(this.zza.getApplicationContext()));
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdX)).booleanValue()) {
                AudioManager audioManager = (AudioManager) this.zza.getApplicationContext().getSystemService("audio");
                if (audioManager == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(audioManager.getMode());
                }
                if (num != null) {
                    jSONObject3.put("audioMode", num);
                }
            }
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService(VisionController.WINDOW)).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzavy.zzb).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzavy.zzc.top).put("bottom", zzavy.zzc.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzavy.zzc.left).put("right", zzavy.zzc.right)).put("adBox", new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzavy.zzd.top).put("bottom", zzavy.zzd.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzavy.zzd.left).put("right", zzavy.zzd.right)).put("globalVisibleBox", new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzavy.zze.top).put("bottom", zzavy.zze.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzavy.zze.left).put("right", zzavy.zze.right)).put("globalVisibleBoxVisible", zzavy.zzf).put("localVisibleBox", new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzavy.zzg.top).put("bottom", zzavy.zzg.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzavy.zzg.left).put("right", zzavy.zzg.right)).put("localVisibleBoxVisible", zzavy.zzh).put("hitBox", new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzavy.zzi.top).put("bottom", zzavy.zzi.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzavy.zzi.left).put("right", zzavy.zzi.right)).put("screenDensity", (double) this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzctr.zza);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzaT)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzavy.zzk;
                if (list != null) {
                    for (Rect next : list) {
                        jSONArray2.put(new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, next.top).put("bottom", next.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, next.left).put("right", next.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzctr.zze)) {
                jSONObject3.put("doneReasonCode", AnalyticsEventKey.URL);
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
