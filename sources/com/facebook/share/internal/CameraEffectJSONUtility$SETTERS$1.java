package com.facebook.share.internal;

import com.facebook.GraphRequest;
import com.facebook.share.internal.CameraEffectJSONUtility;
import com.facebook.share.model.CameraEffectArguments;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CameraEffectJSONUtility.kt */
public final class CameraEffectJSONUtility$SETTERS$1 implements CameraEffectJSONUtility.Setter {
    public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(str, "key");
        if (obj != null) {
            builder.putArgument(str, (String) obj);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
        Intrinsics.checkNotNullParameter(str, "key");
        jSONObject.put(str, obj);
    }
}
