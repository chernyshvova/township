package com.swrve.sdk;

import com.helpshift.p042db.legacy_profile.tables.ProfileTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveResourceManager {
    public List<SwrveABTestDetails> abTestDetails = new ArrayList();
    public Map<String, SwrveResource> resources = new HashMap();

    public boolean _getAttributeAsBoolean(String str, String str2, boolean z) {
        SwrveResource resource = getResource(str);
        return resource != null ? resource.getAttributeAsBoolean(str2, z) : z;
    }

    public float _getAttributeAsFloat(String str, String str2, float f) {
        SwrveResource resource = getResource(str);
        return resource != null ? resource.getAttributeAsFloat(str2, f) : f;
    }

    public int _getAttributeAsInt(String str, String str2, int i) {
        SwrveResource resource = getResource(str);
        return resource != null ? resource.getAttributeAsInt(str2, i) : i;
    }

    public String _getAttributeAsString(String str, String str2, String str3) {
        SwrveResource resource = getResource(str);
        return resource != null ? resource.getAttributeAsString(str2, str3) : str3;
    }

    public SwrveResource _getResource(String str) {
        if (this.resources.containsKey(str)) {
            return this.resources.get(str);
        }
        return null;
    }

    public Map<String, SwrveResource> _getResources() {
        return this.resources;
    }

    public void _setResourcesFromJSON(JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            synchronized (this.resources) {
                this.resources = new HashMap();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.resources.put(jSONObject.getString(ProfileTable.Columns.COLUMN_UID), new SwrveResource(SwrveHelper.JSONToMap(jSONObject)));
                }
            }
        } catch (JSONException unused) {
            SwrveLogger.m2755i("Invalid JSON received for resources, resources not updated", new Object[0]);
        }
    }

    public List<SwrveABTestDetails> getABTestDetails() {
        return this.abTestDetails;
    }

    public boolean getAttributeAsBoolean(String str, String str2, boolean z) {
        try {
            return _getAttributeAsBoolean(str, str2, z);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return z;
        }
    }

    public float getAttributeAsFloat(String str, String str2, float f) {
        try {
            return _getAttributeAsFloat(str, str2, f);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return f;
        }
    }

    public int getAttributeAsInt(String str, String str2, int i) {
        try {
            return _getAttributeAsInt(str, str2, i);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return i;
        }
    }

    public String getAttributeAsString(String str, String str2, String str3) {
        try {
            return _getAttributeAsString(str, str2, str3);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return str3;
        }
    }

    public SwrveResource getResource(String str) {
        try {
            return _getResource(str);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public Map<String, SwrveResource> getResources() {
        try {
            return _getResources();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public void setABTestDetailsFromJSON(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                arrayList.add(new SwrveABTestDetails(next, jSONObject2.getString("name"), jSONObject2.getInt("case_index")));
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK, could not parse AB Test details", e, new Object[0]);
        }
        this.abTestDetails = arrayList;
    }

    public void setResourcesFromJSON(JSONArray jSONArray) {
        try {
            _setResourcesFromJSON(jSONArray);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }
}
