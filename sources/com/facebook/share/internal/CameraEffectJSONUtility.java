package com.facebook.share.internal;

import com.android.billingclient.api.zzam;
import com.facebook.share.model.CameraEffectArguments;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CameraEffectJSONUtility.kt */
public final class CameraEffectJSONUtility {
    public static final CameraEffectJSONUtility INSTANCE = new CameraEffectJSONUtility();
    public static final HashMap<Class<?>, Setter> SETTERS = zzam.hashMapOf(new Pair(String.class, new CameraEffectJSONUtility$SETTERS$1()), new Pair(String[].class, new CameraEffectJSONUtility$SETTERS$2()), new Pair(JSONArray.class, new CameraEffectJSONUtility$SETTERS$3()));

    /* compiled from: CameraEffectJSONUtility.kt */
    public interface Setter {
        void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    public static final CameraEffectArguments convertToCameraEffectArguments(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        CameraEffectArguments.Builder builder = new CameraEffectArguments.Builder();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != JSONObject.NULL) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter != null) {
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    setter.setOnArgumentsBuilder(builder, next, obj);
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported type: ", obj.getClass()));
                }
            }
        }
        return builder.build();
    }

    public static final JSONObject convertToJSON(CameraEffectArguments cameraEffectArguments) throws JSONException {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String next : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(next);
            if (obj != null) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter != null) {
                    setter.setOnJSON(jSONObject, next, obj);
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported type: ", obj.getClass()));
                }
            }
        }
        return jSONObject;
    }
}
