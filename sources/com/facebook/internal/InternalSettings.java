package com.facebook.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: InternalSettings.kt */
public final class InternalSettings {
    public static final InternalSettings INSTANCE = new InternalSettings();
    public static final String UNITY_PREFIX = "Unity.";
    public static volatile String customUserAgent;

    public static final String getCustomUserAgent() {
        return customUserAgent;
    }

    public static final boolean isUnityApp() {
        String str = customUserAgent;
        return Intrinsics.areEqual(str == null ? null : Boolean.valueOf(CharsKt__CharKt.startsWith$default(str, UNITY_PREFIX, false, 2)), Boolean.TRUE);
    }

    public static /* synthetic */ void isUnityApp$annotations() {
    }

    public static final void setCustomUserAgent(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        customUserAgent = str;
    }
}
