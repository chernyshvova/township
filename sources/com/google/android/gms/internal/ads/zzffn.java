package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.VisionController;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffn {
    public static float zza = Resources.getSystem().getDisplayMetrics().density;
    public static WindowManager zzb;
    public static final String[] zzc = {"x", "y", "width", "height"};

    public static void zza(Context context) {
        if (context != null) {
            zza = context.getResources().getDisplayMetrics().density;
            zzb = (WindowManager) context.getSystemService(VisionController.WINDOW);
        }
    }

    public static JSONObject zzb(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) (((float) i) / zza));
            jSONObject.put("y", (double) (((float) i2) / zza));
            jSONObject.put("width", (double) (((float) i3) / zza));
            jSONObject.put("height", (double) (((float) i4) / zza));
        } catch (JSONException e) {
            zzffo.zza("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    public static void zzc(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
            sb.append("JSONException during JSONObject.put for name [");
            sb.append(str);
            sb.append("]");
            zzffo.zza(sb.toString(), e);
        }
    }

    public static void zzd(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            zzffo.zza("Error with setting ad session id", e);
        }
    }

    public static void zze(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            zzffo.zza("Error with setting not visible reason", e);
        }
    }

    public static void zzf(JSONObject jSONObject, zzffr zzffr) {
        zzfez zzb2 = zzffr.zzb();
        JSONArray jSONArray = new JSONArray();
        ArrayList<String> zzc2 = zzffr.zzc();
        int size = zzc2.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(zzc2.get(i));
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", zzb2.zzb());
            jSONObject.put("friendlyObstructionPurpose", zzb2.zzc());
            jSONObject.put("friendlyObstructionReason", zzb2.zzd());
        } catch (JSONException e) {
            zzffo.zza("Error with setting friendly obstruction", e);
        }
    }

    public static void zzg(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            zzgcg.zzb(e);
        }
    }

    public static void zzh(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (zzb != null) {
            Point point = new Point(0, 0);
            zzb.getDefaultDisplay().getRealSize(point);
            float f3 = zza;
            f2 = ((float) point.x) / f3;
            f = ((float) point.y) / f3;
        } else {
            f = 0.0f;
        }
        try {
            jSONObject.put("width", (double) f2);
            jSONObject.put("height", (double) f);
        } catch (JSONException e) {
            zzgcg.zzb(e);
        }
    }

    public static boolean zzi(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject != null && jSONObject2 != null) {
            String[] strArr = zzc;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < 4) {
                    String str = strArr[i];
                    if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                        break;
                    }
                    i++;
                } else if (jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""))) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
                    if (optJSONArray != null || optJSONArray2 != null) {
                        if (zzj(optJSONArray, optJSONArray2)) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < optJSONArray.length()) {
                                    if (!optJSONArray.optString(i2, "").equals(optJSONArray2.optString(i2, ""))) {
                                        break;
                                    }
                                    i2++;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("childViews");
                    JSONArray optJSONArray4 = jSONObject2.optJSONArray("childViews");
                    if (!(optJSONArray3 == null && optJSONArray4 == null)) {
                        if (zzj(optJSONArray3, optJSONArray4)) {
                            int i3 = 0;
                            while (i3 < optJSONArray3.length()) {
                                if (zzi(optJSONArray3.optJSONObject(i3), optJSONArray4.optJSONObject(i3))) {
                                    i3++;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean zzj(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
