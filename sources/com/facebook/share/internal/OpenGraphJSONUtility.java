package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OpenGraphJSONUtility.kt */
public final class OpenGraphJSONUtility {
    public static final OpenGraphJSONUtility INSTANCE = new OpenGraphJSONUtility();

    /* compiled from: OpenGraphJSONUtility.kt */
    public interface PhotoJSONProcessor {
        JSONObject toJSONObject(SharePhoto sharePhoto);
    }

    private final JSONArray toJSONArray(List<?> list, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object jSONValue : list) {
            jSONArray.put(toJSONValue(jSONValue, photoJSONProcessor));
        }
        return jSONArray;
    }

    public static final JSONObject toJSONObject(ShareOpenGraphAction shareOpenGraphAction, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        if (shareOpenGraphAction == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String next : shareOpenGraphAction.keySet()) {
            jSONObject.put(next, toJSONValue(shareOpenGraphAction.get(next), photoJSONProcessor));
        }
        return jSONObject;
    }

    public static final Object toJSONValue(Object obj, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            return obj;
        }
        try {
            if (obj instanceof SharePhoto) {
                if (photoJSONProcessor == null) {
                    return null;
                }
                return photoJSONProcessor.toJSONObject((SharePhoto) obj);
            } else if (obj instanceof ShareOpenGraphObject) {
                return INSTANCE.toJSONObject((ShareOpenGraphObject) obj, photoJSONProcessor);
            } else {
                if (obj instanceof List) {
                    return INSTANCE.toJSONArray((List) obj, photoJSONProcessor);
                }
                return null;
            }
        } catch (Exception unused) {
        }
    }

    private final JSONObject toJSONObject(ShareOpenGraphObject shareOpenGraphObject, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String next : shareOpenGraphObject.keySet()) {
            jSONObject.put(next, toJSONValue(shareOpenGraphObject.get(next), photoJSONProcessor));
        }
        return jSONObject;
    }
}
