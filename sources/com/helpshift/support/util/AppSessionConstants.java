package com.helpshift.support.util;

import java.io.Serializable;

public class AppSessionConstants {
    public static final String CURRENT_OPEN_SCREEN = "current_open_screen";

    public enum Screen implements Serializable {
        NEW_CONVERSATION,
        CONVERSATION,
        CONVERSATION_INFO,
        SCREENSHOT_PREVIEW
    }
}
