package com.facebook.internal;

import android.os.Bundle;
import com.facebook.GraphRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter.kt */
public final class BundleJSONConverter {
    public static final BundleJSONConverter INSTANCE = new BundleJSONConverter();
    public static final Map<Class<?>, Setter> SETTERS;

    /* compiled from: BundleJSONConverter.kt */
    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(Boolean.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Integer.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                bundle.putInt(str, ((Integer) obj).intValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Long.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                bundle.putLong(str, ((Long) obj).longValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Double.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(String.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                bundle.putString(str, (String) obj);
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(String[].class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                JSONArray jSONArray = new JSONArray();
                String[] strArr = (String[]) obj;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str2 = strArr[i];
                    i++;
                    jSONArray.put(str2);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        SETTERS.put(JSONArray.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                int i = 0;
                int length = jSONArray.length();
                if (length > 0) {
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
                bundle.putStringArrayList(str, arrayList);
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, "value");
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    public static final Bundle convertToBundle(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        Intrinsics.checkNotNullExpressionValue(obj, "value");
                        setter.setOnBundle(bundle, next, obj);
                    } else {
                        throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported type: ", obj.getClass()));
                    }
                }
            }
        }
        return bundle;
    }

    public static final JSONObject convertToJSON(Bundle bundle) throws JSONException {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : (List) obj) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        Intrinsics.checkNotNullExpressionValue(str, "key");
                        setter.setOnJSON(jSONObject, str, obj);
                    } else {
                        throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported type: ", obj.getClass()));
                    }
                }
            }
        }
        return jSONObject;
    }
}
