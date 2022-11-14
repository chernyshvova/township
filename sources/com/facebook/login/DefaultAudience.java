package com.facebook.login;

import com.facebook.internal.NativeProtocol;

/* compiled from: DefaultAudience.kt */
public enum DefaultAudience {
    NONE((String) null),
    ONLY_ME(NativeProtocol.AUDIENCE_ME),
    FRIENDS(NativeProtocol.AUDIENCE_FRIENDS),
    EVERYONE(NativeProtocol.AUDIENCE_EVERYONE);
    
    public final String nativeProtocolAudience;

    /* access modifiers changed from: public */
    DefaultAudience(String str) {
        this.nativeProtocolAudience = str;
    }

    public final String getNativeProtocolAudience() {
        return this.nativeProtocolAudience;
    }
}
