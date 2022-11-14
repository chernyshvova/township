package com.unity3d.services.core.log;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;

public class DeviceLogEntry {
    public DeviceLogLevel _logLevel = null;
    public String _originalMessage = null;
    public StackTraceElement _stackTraceElement = null;

    public DeviceLogEntry(DeviceLogLevel deviceLogLevel, String str, StackTraceElement stackTraceElement) {
        this._logLevel = deviceLogLevel;
        this._originalMessage = str;
        this._stackTraceElement = stackTraceElement;
    }

    public DeviceLogLevel getLogLevel() {
        return this._logLevel;
    }

    public String getParsedMessage() {
        int i;
        String str;
        String str2;
        String str3 = this._originalMessage;
        StackTraceElement stackTraceElement = this._stackTraceElement;
        if (stackTraceElement != null) {
            str2 = stackTraceElement.getClassName();
            str = this._stackTraceElement.getMethodName();
            i = this._stackTraceElement.getLineNumber();
        } else {
            str2 = "UnknownClass";
            str = "unknownMethod";
            i = -1;
        }
        if (str3 != null && !str3.isEmpty()) {
            str3 = GeneratedOutlineSupport.outline16(" :: ", str3);
        }
        if (str3 == null) {
            str3 = "";
        }
        return str2 + CodelessMatcher.CURRENT_CLASS_NAME + str + "()" + (" (line:" + i + ")") + str3;
    }
}
