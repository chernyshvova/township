package com.helpshift.static_classes;

public class ErrorReporting {
    public static boolean enableErrorReporting;

    public static boolean isEnabled() {
        return enableErrorReporting;
    }

    public static void shouldEnable(boolean z) {
        enableErrorReporting = z;
    }
}
