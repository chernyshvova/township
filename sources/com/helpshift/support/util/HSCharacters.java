package com.helpshift.support.util;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.util.HSJSONUtils;
import com.helpshift.util.HSLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class HSCharacters {
    public static final String TAG = "HSCharacters";
    public Map<String, List<String>> characters;

    public HSCharacters(JSONObject jSONObject) {
        try {
            this.characters = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.characters.put(next, HSJSONUtils.toList(jSONObject.getJSONArray(next)));
            }
        } catch (JSONException e) {
            String str = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("HSCharacters constructor error : ");
            outline24.append(e.getMessage());
            HSLogger.m3241e(str, outline24.toString());
        }
    }

    public boolean containsKey(String str, int i) {
        List list = this.characters.get(str);
        return list != null && i < list.size() && ((String) list.get(i)).length() > 0;
    }

    public String get(String str, int i) {
        List list = this.characters.get(str);
        if (list == null) {
            return "";
        }
        return (String) list.get(i);
    }
}
