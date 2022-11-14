package com.microsoft.appcenter.ingestion.models.one;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.regex.Pattern;

public class PartAUtils {
    public static final Pattern NAME_REGEX = Pattern.compile("^[a-zA-Z0-9]((\\.(?!(\\.|$)))|[_a-zA-Z0-9]){3,99}$");

    public static String getTargetKey(String str) {
        return str.split("-")[0];
    }

    public static void setName(CommonSchemaLog commonSchemaLog, String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        } else if (NAME_REGEX.matcher(str).matches()) {
            commonSchemaLog.name = str;
        } else {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Name must match '");
            outline24.append(NAME_REGEX);
            outline24.append("' but was '");
            outline24.append(str);
            outline24.append("'.");
            throw new IllegalArgumentException(outline24.toString());
        }
    }
}
