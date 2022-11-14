package com.iab.omid.library.applovin.p047d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.applovin.p045b.C2844c;
import com.iab.omid.library.applovin.walking.C2871a;
import com.vungle.warren.VisionController;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.d.b */
public class C2856b {

    /* renamed from: a */
    public static float f3427a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    public static WindowManager f3428b;

    /* renamed from: c */
    public static String[] f3429c = {"x", "y", "width", "height"};

    /* renamed from: com.iab.omid.library.applovin.d.b$a */
    public static class C2857a {

        /* renamed from: a */
        public final float f3430a;

        /* renamed from: b */
        public final float f3431b;

        public C2857a(float f, float f2) {
            this.f3430a = f;
            this.f3431b = f2;
        }
    }

    /* renamed from: a */
    public static float m3355a(int i) {
        return ((float) i) / f3427a;
    }

    /* renamed from: a */
    public static JSONObject m3356a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) m3355a(i));
            jSONObject.put("y", (double) m3355a(i2));
            jSONObject.put("width", (double) m3355a(i3));
            jSONObject.put("height", (double) m3355a(i4));
        } catch (JSONException e) {
            C2858c.m3374a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m3357a(Context context) {
        if (context != null) {
            f3427a = context.getResources().getDisplayMetrics().density;
            f3428b = (WindowManager) context.getSystemService(VisionController.WINDOW);
        }
    }

    /* renamed from: a */
    public static void m3358a(JSONObject jSONObject) {
        C2857a b = m3365b(jSONObject);
        try {
            jSONObject.put("width", (double) b.f3430a);
            jSONObject.put("height", (double) b.f3431b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m3359a(JSONObject jSONObject, C2871a.C2872a aVar) {
        C2844c a = aVar.mo36809a();
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.mo36811b()) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a.mo36729b());
            jSONObject.put("friendlyObstructionPurpose", a.mo36730c());
            jSONObject.put("friendlyObstructionReason", a.mo36731d());
        } catch (JSONException e) {
            C2858c.m3374a("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: a */
    public static void m3360a(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e) {
            C2858c.m3374a("Error with setting not visible reason", e);
        }
    }

    /* renamed from: a */
    public static void m3361a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C2858c.m3374a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m3362a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            C2858c.m3374a("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    /* renamed from: a */
    public static void m3363a(JSONObject jSONObject, JSONObject jSONObject2) {
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
    public static boolean m3364a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: b */
    public static C2857a m3365b(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (f3428b != null) {
            Point point = new Point(0, 0);
            f3428b.getDefaultDisplay().getRealSize(point);
            f2 = m3355a(point.x);
            f = m3355a(point.y);
        } else {
            f = 0.0f;
        }
        return new C2857a(f2, f);
    }

    /* renamed from: b */
    public static void m3366b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C2858c.m3374a("Error with setting not visible reason", e);
        }
    }

    /* renamed from: b */
    public static boolean m3367b(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && m3368c(jSONObject, jSONObject2) && m3370e(jSONObject, jSONObject2) && m3369d(jSONObject, jSONObject2) && m3371f(jSONObject, jSONObject2) && m3372g(jSONObject, jSONObject2);
    }

    /* renamed from: c */
    public static boolean m3368c(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f3429c) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m3369d(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")) == Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus"));
    }

    /* renamed from: e */
    public static boolean m3370e(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    /* renamed from: f */
    public static boolean m3371f(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m3364a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!optJSONArray.optString(i, "").equals(optJSONArray2.optString(i, ""))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public static boolean m3372g(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m3364a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!m3367b(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }
}
