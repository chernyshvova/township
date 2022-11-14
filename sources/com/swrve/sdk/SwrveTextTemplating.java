package com.swrve.sdk;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.exceptions.SwrveSDKTextTemplatingException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwrveTextTemplating {
    public static final Pattern pattern = Pattern.compile(patternMatch);
    public static final Pattern patternFallback = Pattern.compile(patternFallbackMatch);
    public static final String patternFallbackMatch = "\\|fallback=\"([^\\}]*)\"\\}";
    public static final Pattern patternJSONFallback = Pattern.compile(patternJSONFallbackMatch);
    public static final String patternJSONFallbackMatch = "\\|fallback=\\\\\"([^\\}]*)\\\\\"\\}";
    public static final String patternMatch = "\\$\\{([^\\}]*)\\}";

    public static String apply(String str, Map<String, String> map) throws SwrveSDKTextTemplatingException {
        if (str == null) {
            return str;
        }
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(0);
            String fallBack = getFallBack(group);
            String group2 = matcher.group(1);
            if (fallBack != null) {
                group2 = group2.substring(0, group2.indexOf("|fallback=\""));
            }
            if (map != null && !SwrveHelper.isNullOrEmpty(map.get(group2))) {
                str = str.replace(group, map.get(group2));
            } else if (fallBack != null) {
                str = str.replace(group, fallBack);
            } else {
                throw new SwrveSDKTextTemplatingException(GeneratedOutlineSupport.outline16("TextTemplating: Missing property value for key ", group2));
            }
        }
        return str;
    }

    public static String applytoJSON(String str, Map<String, String> map) throws SwrveSDKTextTemplatingException {
        if (str == null) {
            return str;
        }
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(0);
            String fallBackJSON = getFallBackJSON(group);
            String group2 = matcher.group(1);
            if (fallBackJSON != null) {
                group2 = group2.substring(0, group2.indexOf("|fallback=\\\""));
            }
            if (map != null && !SwrveHelper.isNullOrEmpty(map.get(group2))) {
                str = str.replace(group, map.get(group2));
            } else if (fallBackJSON != null) {
                str = str.replace(group, fallBackJSON);
            } else {
                throw new SwrveSDKTextTemplatingException(GeneratedOutlineSupport.outline16("TextTemplating: Missing property value for key ", group2));
            }
        }
        return str;
    }

    public static String getFallBack(String str) {
        Matcher matcher = patternFallback.matcher(str);
        String str2 = null;
        while (matcher.find()) {
            str2 = matcher.group(1);
        }
        return str2;
    }

    public static String getFallBackJSON(String str) {
        Matcher matcher = patternJSONFallback.matcher(str);
        String str2 = null;
        while (matcher.find()) {
            str2 = matcher.group(1);
        }
        return str2;
    }

    public static boolean hasPatternMatch(String str) {
        if (str == null) {
            return false;
        }
        return pattern.matcher(str).find();
    }
}
