package com.facebook;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FacebookOperationCanceledException.kt */
public final class FacebookOperationCanceledException extends FacebookException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 1;

    /* compiled from: FacebookOperationCanceledException.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FacebookOperationCanceledException() {
    }

    public FacebookOperationCanceledException(String str) {
        super(str);
    }

    public FacebookOperationCanceledException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookOperationCanceledException(Throwable th) {
        super(th);
    }
}
