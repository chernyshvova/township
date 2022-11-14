package com.facebook;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FacebookSdkNotInitializedException.kt */
public final class FacebookSdkNotInitializedException extends FacebookException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 1;

    /* compiled from: FacebookSdkNotInitializedException.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FacebookSdkNotInitializedException() {
    }

    public FacebookSdkNotInitializedException(String str) {
        super(str);
    }

    public FacebookSdkNotInitializedException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookSdkNotInitializedException(Throwable th) {
        super(th);
    }
}
