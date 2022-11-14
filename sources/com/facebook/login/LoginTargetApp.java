package com.facebook.login;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginTargetApp.kt */
public enum LoginTargetApp {
    FACEBOOK(AccessToken.DEFAULT_GRAPH_DOMAIN),
    INSTAGRAM(FacebookSdk.INSTAGRAM);
    
    public static final Companion Companion = null;
    public final String targetApp;

    /* compiled from: LoginTargetApp.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LoginTargetApp fromString(String str) {
            LoginTargetApp[] values = LoginTargetApp.values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                LoginTargetApp loginTargetApp = values[i];
                i++;
                if (Intrinsics.areEqual(loginTargetApp.toString(), str)) {
                    return loginTargetApp;
                }
            }
            return LoginTargetApp.FACEBOOK;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: public */
    LoginTargetApp(String str) {
        this.targetApp = str;
    }

    public static final LoginTargetApp fromString(String str) {
        return Companion.fromString(str);
    }

    public String toString() {
        return this.targetApp;
    }
}
