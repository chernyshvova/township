package com.helpshift.common.platform;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.dto.AnalyticsEventDTO;
import com.helpshift.cif.dto.CustomIssueFieldDTO;
import com.helpshift.common.exception.ParseException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.logger.model.LogModel;
import com.helpshift.meta.dto.BreadCrumbDTO;
import com.helpshift.meta.dto.DebugLogDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AndroidJsonifier implements Jsonifier {
    private JSONObject jsonifyAnalyticsDTO(AnalyticsEventDTO analyticsEventDTO) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ts", analyticsEventDTO.timeStamp);
        jSONObject.put("t", analyticsEventDTO.type.key);
        Map<String, Object> map = analyticsEventDTO.data;
        if (map != null && map.size() > 0) {
            jSONObject.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, jsonifyToObject(new HashMap(analyticsEventDTO.data)));
        }
        return jSONObject;
    }

    private JSONObject jsonifyBreadCrumbDTO(BreadCrumbDTO breadCrumbDTO) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", breadCrumbDTO.action);
        jSONObject.put("datetime", breadCrumbDTO.dateTime);
        return jSONObject;
    }

    private JSONObject jsonifyDebugLogDTO(DebugLogDTO debugLogDTO) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = debugLogDTO.msg;
        if (str != null) {
            jSONObject.put("message", str);
        }
        jSONObject.put("level", debugLogDTO.level);
        jSONObject.put("tag", debugLogDTO.tag);
        if (!TextUtils.isEmpty(debugLogDTO.throwable)) {
            jSONObject.put("exception", debugLogDTO.throwable);
        }
        return jSONObject;
    }

    public String jsonify(Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Exception while calling jsonify on map");
        }
    }

    public String jsonifyAnalyticsDTOList(List<AnalyticsEventDTO> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (AnalyticsEventDTO jsonifyAnalyticsDTO : list) {
                jSONArray.put(jsonifyAnalyticsDTO(jsonifyAnalyticsDTO));
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Exception while forming analytics string");
        }
    }

    public Object jsonifyBreadCrumbDTOList(List<BreadCrumbDTO> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                for (BreadCrumbDTO jsonifyBreadCrumbDTO : list) {
                    jSONArray.put(jsonifyBreadCrumbDTO(jsonifyBreadCrumbDTO));
                }
            } catch (JSONException e) {
                throw RootAPIException.wrap(e, ParseException.GENERIC, "Exception while forming breadcrumb string");
            }
        }
        return jSONArray;
    }

    public Object jsonifyCustomIssueFieldDTOList(List<CustomIssueFieldDTO> list) {
        JSONObject jSONObject = new JSONObject();
        for (CustomIssueFieldDTO next : list) {
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(next.type);
                for (String put : next.values) {
                    jSONArray.put(put);
                }
                jSONObject.put(next.key, jSONArray);
            } catch (JSONException e) {
                throw RootAPIException.wrap(e, ParseException.GENERIC, "Exception while forming custom issue field string");
            }
        }
        return jSONObject;
    }

    public Object jsonifyCustomMetaMap(Map<String, Serializable> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                Object value = next.getValue();
                if (value instanceof String[]) {
                    value = jsonifyListToJsonArray(new ArrayList(Arrays.asList((String[]) value)));
                }
                jSONObject.put((String) next.getKey(), value);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Exception while forming custom meta string");
        }
    }

    public Object jsonifyDebugLogDTOList(List<DebugLogDTO> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                for (DebugLogDTO jsonifyDebugLogDTO : list) {
                    jSONArray.put(jsonifyDebugLogDTO(jsonifyDebugLogDTO));
                }
            } catch (JSONException e) {
                throw RootAPIException.wrap(e, ParseException.GENERIC, "Exception while forming debugLog string");
            }
        }
        return jSONArray;
    }

    public <T> Object jsonifyListToJsonArray(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        for (T put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public Object jsonifyLogModelList(List<LogModel> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (LogModel next : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dt", next.timeStamp);
                jSONObject.put(AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL, next.level);
                jSONObject.put(UserDataStore.CITY, next.extras);
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, next.message);
                jSONObject.put(UserDataStore.STATE, next.stacktrace);
                if (!TextUtils.isEmpty(next.sdkVersion)) {
                    jSONObject.put(AnalyticsEventKey.FAQ_SOURCE, "sdk.android." + next.sdkVersion);
                }
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Exception while jsonifying LogModelList");
        }
    }

    public Object jsonifyToArray(String str) {
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Exception while jsonifying string to array");
        }
    }

    public Object jsonifyToObject(Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
            return jSONObject;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Exception while calling jsonify on map");
        }
    }

    public String removeKeyFromJsonObjString(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove(str2);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    public Object jsonifyToObject(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, str2);
            return jSONObject;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Exception while jsonifying single object.");
        }
    }

    public String jsonify(Collection collection) {
        return new JSONArray(collection).toString();
    }
}
