package com.iab.omid.library.vungle.p053d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.android.billingclient.api.zzam;
import com.iab.omid.library.vungle.p051b.C2894c;
import com.iab.omid.library.vungle.walking.C2914a;
import com.vungle.warren.VisionController;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.d.b */
public class C2904b {

    /* renamed from: a */
    public static float f3523a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    public static WindowManager f3524b;

    /* renamed from: c */
    public static String[] f3525c = {"x", "y", "width", "height"};

    /* renamed from: a */
    public static float m3497a(int i) {
        return ((float) i) / f3523a;
    }

    /* renamed from: a */
    public static JSONObject m3498a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) m3497a(i));
            jSONObject.put("y", (double) m3497a(i2));
            jSONObject.put("width", (double) m3497a(i3));
            jSONObject.put("height", (double) m3497a(i4));
        } catch (JSONException e) {
            zzam.m26a("Error with creating viewStateObject", (Exception) e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m3499a(Context context) {
        f3523a = context.getResources().getDisplayMetrics().density;
        f3524b = (WindowManager) context.getSystemService(VisionController.WINDOW);
    }

    /* renamed from: a */
    public static void m3500a(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (f3524b != null) {
            Point point = new Point(0, 0);
            f3524b.getDefaultDisplay().getRealSize(point);
            f2 = m3497a(point.x);
            f = m3497a(point.y);
        } else {
            f = 0.0f;
        }
        try {
            jSONObject.put("width", (double) f2);
            jSONObject.put("height", (double) f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m3502a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            zzam.m26a("Error with setting ad session id", (Exception) e);
        }
    }

    /* renamed from: a */
    public static void m3503a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            zzam.m26a("JSONException during JSONObject.put for name [" + str + "]", (Exception) e);
        }
    }

    /* renamed from: a */
    public static void m3504a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m3505a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m3506b(@androidx.annotation.NonNull org.json.JSONObject r10, @androidx.annotation.Nullable org.json.JSONObject r11) {
        /*
            r0 = 1
            if (r10 != 0) goto L_0x0006
            if (r11 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 0
            if (r10 == 0) goto L_0x00a4
            if (r11 != 0) goto L_0x000d
            goto L_0x00a4
        L_0x000d:
            java.lang.String[] r2 = f3525c
            int r3 = r2.length
            r4 = 0
        L_0x0011:
            if (r4 >= r3) goto L_0x0026
            r5 = r2[r4]
            double r6 = r10.optDouble(r5)
            double r8 = r11.optDouble(r5)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0023
            r2 = 0
            goto L_0x0027
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0026:
            r2 = 1
        L_0x0027:
            if (r2 == 0) goto L_0x00a2
            java.lang.String r2 = "adSessionId"
            java.lang.String r3 = ""
            java.lang.String r4 = r10.optString(r2, r3)
            java.lang.String r2 = r11.optString(r2, r3)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x00a2
            java.lang.String r2 = "isFriendlyObstructionFor"
            org.json.JSONArray r4 = r10.optJSONArray(r2)
            org.json.JSONArray r2 = r11.optJSONArray(r2)
            if (r4 != 0) goto L_0x004b
            if (r2 != 0) goto L_0x004b
        L_0x0049:
            r2 = 1
            goto L_0x006c
        L_0x004b:
            boolean r5 = m3505a((org.json.JSONArray) r4, (org.json.JSONArray) r2)
            if (r5 != 0) goto L_0x0053
        L_0x0051:
            r2 = 0
            goto L_0x006c
        L_0x0053:
            r5 = 0
        L_0x0054:
            int r6 = r4.length()
            if (r5 >= r6) goto L_0x0049
            java.lang.String r6 = r4.optString(r5, r3)
            java.lang.String r7 = r2.optString(r5, r3)
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0069
            goto L_0x0051
        L_0x0069:
            int r5 = r5 + 1
            goto L_0x0054
        L_0x006c:
            if (r2 == 0) goto L_0x00a2
            java.lang.String r2 = "childViews"
            org.json.JSONArray r10 = r10.optJSONArray(r2)
            org.json.JSONArray r11 = r11.optJSONArray(r2)
            if (r10 != 0) goto L_0x007e
            if (r11 != 0) goto L_0x007e
        L_0x007c:
            r10 = 1
            goto L_0x009f
        L_0x007e:
            boolean r2 = m3505a((org.json.JSONArray) r10, (org.json.JSONArray) r11)
            if (r2 != 0) goto L_0x0086
        L_0x0084:
            r10 = 0
            goto L_0x009f
        L_0x0086:
            r2 = 0
        L_0x0087:
            int r3 = r10.length()
            if (r2 >= r3) goto L_0x007c
            org.json.JSONObject r3 = r10.optJSONObject(r2)
            org.json.JSONObject r4 = r11.optJSONObject(r2)
            boolean r3 = m3506b(r3, r4)
            if (r3 != 0) goto L_0x009c
            goto L_0x0084
        L_0x009c:
            int r2 = r2 + 1
            goto L_0x0087
        L_0x009f:
            if (r10 == 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r0 = 0
        L_0x00a3:
            return r0
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iab.omid.library.vungle.p053d.C2904b.m3506b(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    /* renamed from: a */
    public static void m3501a(JSONObject jSONObject, C2914a.C2915a aVar) {
        C2894c cVar = aVar.f3559a;
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.f3560b) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            if (cVar != null) {
                jSONObject.put("friendlyObstructionClass", (Object) null);
                jSONObject.put("friendlyObstructionPurpose", (Object) null);
                jSONObject.put("friendlyObstructionReason", (Object) null);
                return;
            }
            throw null;
        } catch (JSONException e) {
            zzam.m26a("Error with setting friendly obstruction", (Exception) e);
        }
    }
}
