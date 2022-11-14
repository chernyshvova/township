package com.playrix.engine;

import java.util.Map;

public class JniWrapperHelpers {
    public static String getExceptionDescription(Throwable th) {
        if (th == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(th.toString());
            sb.append(" : ");
            for (StackTraceElement append : th.getStackTrace()) {
                sb.append(append);
                sb.append("->");
            }
            th = th.getCause();
            if (th == null) {
                return sb.toString();
            }
            sb.append("caused by : ");
        }
    }

    public static native void nativeThreadStart(long j);

    public static String[] stringsMapToArray(Map<String, String> map) {
        String[] strArr = new String[(map.size() * 2)];
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            int i2 = i + 1;
            strArr[i] = (String) next.getKey();
            i = i2 + 1;
            strArr[i2] = (String) next.getValue();
        }
        return strArr;
    }
}
