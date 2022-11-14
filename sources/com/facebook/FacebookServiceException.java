package com.facebook;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacebookServiceException.kt */
public final class FacebookServiceException extends FacebookException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 1;
    public final FacebookRequestError requestError;

    /* compiled from: FacebookServiceException.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FacebookServiceException(FacebookRequestError facebookRequestError, String str) {
        super(str);
        Intrinsics.checkNotNullParameter(facebookRequestError, "requestError");
        this.requestError = facebookRequestError;
    }

    public final FacebookRequestError getRequestError() {
        return this.requestError;
    }

    public String toString() {
        StringBuilder outline26 = GeneratedOutlineSupport.outline26("{FacebookServiceException: ", "httpResponseCode: ");
        outline26.append(this.requestError.getRequestStatusCode());
        outline26.append(", facebookErrorCode: ");
        outline26.append(this.requestError.getErrorCode());
        outline26.append(", facebookErrorType: ");
        outline26.append(this.requestError.getErrorType());
        outline26.append(", message: ");
        outline26.append(this.requestError.getErrorMessage());
        outline26.append("}");
        String sb = outline26.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder()\n        .append(\"{FacebookServiceException: \")\n        .append(\"httpResponseCode: \")\n        .append(requestError.requestStatusCode)\n        .append(\", facebookErrorCode: \")\n        .append(requestError.errorCode)\n        .append(\", facebookErrorType: \")\n        .append(requestError.errorType)\n        .append(\", message: \")\n        .append(requestError.errorMessage)\n        .append(\"}\")\n        .toString()");
        return sb;
    }
}
