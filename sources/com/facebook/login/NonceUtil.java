package com.facebook.login;

import kotlin.text.CharsKt__CharKt;

/* compiled from: NonceUtil.kt */
public final class NonceUtil {
    public static final NonceUtil INSTANCE = new NonceUtil();

    public static final boolean isValidNonce(String str) {
        boolean z = false;
        if (str == null || str.length() == 0) {
            return false;
        }
        if (CharsKt__CharKt.indexOf$default((CharSequence) str, ' ', 0, false, 6) >= 0) {
            z = true;
        }
        return !z;
    }
}
