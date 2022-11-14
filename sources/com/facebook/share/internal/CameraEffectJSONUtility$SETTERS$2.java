package com.facebook.share.internal;

import com.facebook.GraphRequest;
import com.facebook.share.internal.CameraEffectJSONUtility;
import com.facebook.share.model.CameraEffectArguments;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CameraEffectJSONUtility.kt */
public final class CameraEffectJSONUtility$SETTERS$2 implements CameraEffectJSONUtility.Setter {
    public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(str, "key");
        throw new IllegalArgumentException("Unexpected type from JSON");
    }

    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
        Intrinsics.checkNotNullParameter(str, "key");
        JSONArray jSONArray = new JSONArray();
        if (obj != null) {
            String[] strArr = (String[]) obj;
            int i = 0;
            int length = strArr.length;
            while (i < length) {
                String str2 = strArr[i];
                i++;
                jSONArray.put(str2);
            }
            jSONObject.put(str, jSONArray);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String?>");
    }
}
