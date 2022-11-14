package com.helpshift.util;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import org.json.JSONArray;

public class StringUtil {
    public static String escapeForSql(String str) {
        return GeneratedOutlineSupport.outline17("'", str, "'");
    }

    public static String toString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ArrayList) {
            return new JSONArray((ArrayList) obj).toString();
        }
        return null;
    }
}
