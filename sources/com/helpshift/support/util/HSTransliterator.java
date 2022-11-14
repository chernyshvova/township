package com.helpshift.support.util;

import com.helpshift.util.AssetsUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import org.json.JSONException;
import org.json.JSONObject;

public class HSTransliterator {
    public static final String TAG = "Helpshift_Transliteratr";
    public static HSCharacters hsCharacters = null;
    public static boolean initDone = false;

    public static void deinit() {
        hsCharacters = null;
        initDone = false;
    }

    public static void init() {
        if (!initDone) {
            try {
                JSONObject jSONObject = new JSONObject(AssetsUtil.readFileAsString(HelpshiftContext.getApplicationContext(), "hs__data")).getJSONObject(HSCharacters.TAG);
                if (jSONObject != null) {
                    hsCharacters = new HSCharacters(jSONObject);
                    initDone = true;
                }
            } catch (JSONException e) {
                HSLogger.m3248w(TAG, "Error reading json : ", e);
            }
        }
    }

    public static boolean isLoaded() {
        return initDone;
    }

    public static String unidecode(String str) {
        if (!initDone) {
            init();
        }
        if (str == null || str.length() == 0) {
            return "";
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) <= 128) {
            if (i >= str.length()) {
                return str;
            }
            i++;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c < 128) {
                sb.append(c);
            } else {
                int i2 = c >> 8;
                char c2 = c & 255;
                HSCharacters hSCharacters = hsCharacters;
                if (hSCharacters == null || !hSCharacters.containsKey(String.valueOf(i2), c2)) {
                    sb.append("");
                } else {
                    sb.append(hsCharacters.get(String.valueOf(i2), c2));
                }
            }
        }
        return sb.toString();
    }
}
