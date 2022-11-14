package com.appsflyer.internal;

import androidx.annotation.Nullable;

/* renamed from: com.appsflyer.internal.m */
public final class C1483m {
    public final boolean AFInAppEventParameterName;
    public final long AFInAppEventType;
    public final String AFKeystoreWrapper;

    /* renamed from: com.appsflyer.internal.m$d */
    public interface C1485d {
        void AFInAppEventType(String str);

        void values(@Nullable String str, @Nullable String str2, @Nullable String str3);
    }

    public C1483m() {
    }

    public final boolean AFKeystoreWrapper() {
        return this.AFInAppEventParameterName;
    }

    public C1483m(String str, long j, boolean z) {
        this.AFKeystoreWrapper = str;
        this.AFInAppEventType = j;
        this.AFInAppEventParameterName = z;
    }
}
