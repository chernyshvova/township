package com.helpshift.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HSJSONUtils {
    public static final String TAG = "HelpshiftDebug";

    public static List<String> convertJSONArrayToStringList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                arrayList.add(jSONArray.getString(i));
            } catch (JSONException e) {
                HSLogger.m3242e(TAG, "Parsing exception while convert jsonArray to string array list", e);
            }
        }
        return arrayList;
    }

    public static JSONArray doubleListToJsonArray(List<Double> list) {
        JSONArray jSONArray = new JSONArray();
        if (ListUtils.isEmpty(list)) {
            return jSONArray;
        }
        for (Double put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static Object fromJson(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return toMap((JSONObject) obj);
        }
        return obj instanceof JSONArray ? toList((JSONArray) obj) : obj;
    }

    public static JSONArray fromListOfMaps(List<HashMap> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (HashMap next : list) {
                JSONObject jSONObject = new JSONObject();
                for (Object next2 : next.keySet()) {
                    if (next2 instanceof String) {
                        jSONObject.put((String) next2, next.get(next2));
                    }
                }
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            HSLogger.m3238d(TAG, "JSON Exception in parsing complex list", (Throwable) e);
        }
        return jSONArray;
    }

    public static JSONObject fromNestedMap(Map<String, ArrayList> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), new JSONArray((Collection) next.getValue()));
            }
        } catch (JSONException e) {
            HSLogger.m3238d(TAG, "JSON Exception in parsing complex object", (Throwable) e);
        }
        return jSONObject;
    }

    public static List<Double> getDoubleListFromJSONArray(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                arrayList.add(Double.valueOf(jSONArray.getDouble(i)));
            } catch (JSONException e) {
                HSLogger.m3242e(TAG, "Parsing exception while convert jsonArray to double array list", e);
            }
        }
        return arrayList;
    }

    public static ArrayList<String> jsonArrayToStringArrayList(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getString(i));
            }
        } catch (JSONException e) {
            HSLogger.m3238d(TAG, "jsonArrayToStringArrayList", (Throwable) e);
        }
        return arrayList;
    }

    public static List<Double> jsonToDoubleArrayList(String str) {
        ArrayList arrayList = new ArrayList();
        if (StringUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    arrayList.add(Double.valueOf(Double.parseDouble(jSONArray.getString(i))));
                } catch (NumberFormatException e) {
                    HSLogger.m3242e(TAG, "Cannot parse value to double jsonToDoubleArrayList", e);
                }
            }
        } catch (JSONException e2) {
            HSLogger.m3238d(TAG, "jsonToDoubleArrayList", (Throwable) e2);
        }
        return arrayList;
    }

    public static JSONArray listToJsonArray(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (ListUtils.isEmpty(list)) {
            return jSONArray;
        }
        for (String next : list) {
            if (!StringUtils.isEmpty(next, false)) {
                jSONArray.put(next);
            }
        }
        return jSONArray;
    }

    public static ArrayList<ArrayList<String>> nestedJsonArrayToNestedArrayList(String str) {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                int length2 = jSONArray2.length();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < length2; i2++) {
                    arrayList2.add(jSONArray2.getString(i2));
                }
                arrayList.add(arrayList2);
            }
        } catch (JSONException e) {
            HSLogger.m3238d(TAG, "nestedJsonArrayToNestedArrayList", (Throwable) e);
        }
        return arrayList;
    }

    public static List toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(fromJson(jSONArray.get(i)));
        }
        return arrayList;
    }

    public static HashMap<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, fromJson(jSONObject.get(next)));
        }
        return hashMap;
    }

    public static Map<String, String> toStringMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.getString(next));
        }
        return hashMap;
    }
}
