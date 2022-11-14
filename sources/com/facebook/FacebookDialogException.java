package com.facebook;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacebookDialogException.kt */
public final class FacebookDialogException extends FacebookException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 1;
    public final int errorCode;
    public final String failingUrl;

    /* compiled from: FacebookDialogException.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FacebookDialogException(String str, int i, String str2) {
        super(str);
        this.errorCode = i;
        this.failingUrl = str2;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getFailingUrl() {
        return this.failingUrl;
    }

    public String toString() {
        StringBuilder outline26 = GeneratedOutlineSupport.outline26("{FacebookDialogException: ", "errorCode: ");
        outline26.append(this.errorCode);
        outline26.append(", message: ");
        outline26.append(getMessage());
        outline26.append(", url: ");
        outline26.append(this.failingUrl);
        outline26.append("}");
        String sb = outline26.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder()\n        .append(\"{FacebookDialogException: \")\n        .append(\"errorCode: \")\n        .append(errorCode)\n        .append(\", message: \")\n        .append(message)\n        .append(\", url: \")\n        .append(failingUrl)\n        .append(\"}\")\n        .toString()");
        return sb;
    }
}
