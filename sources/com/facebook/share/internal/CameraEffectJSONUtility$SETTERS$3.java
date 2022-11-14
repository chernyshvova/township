package com.facebook.share.internal;

import com.facebook.GraphRequest;
import com.facebook.share.internal.CameraEffectJSONUtility;
import com.facebook.share.model.CameraEffectArguments;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CameraEffectJSONUtility.kt */
public final class CameraEffectJSONUtility$SETTERS$3 implements CameraEffectJSONUtility.Setter {
    public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(str, "key");
        if (obj != null) {
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    Object obj2 = jSONArray.get(i);
                    if (obj2 instanceof String) {
                        arrayList.add(obj2);
                        if (i2 >= length) {
                            break;
                        }
                        i = i2;
                    } else {
                        throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected type in an array: ", obj2.getClass()));
                    }
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                builder.putArgument(str, (String[]) array);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
    }

    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
        Intrinsics.checkNotNullParameter(str, "key");
        throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
    }
}
