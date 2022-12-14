package com.facebook;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacebookGraphResponseException.kt */
public final class FacebookGraphResponseException extends FacebookException {
    public final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse2, String str) {
        super(str);
        this.graphResponse = graphResponse2;
    }

    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    public String toString() {
        GraphResponse graphResponse2 = this.graphResponse;
        FacebookRequestError error = graphResponse2 == null ? null : graphResponse2.getError();
        StringBuilder sb = new StringBuilder();
        sb.append("{FacebookGraphResponseException: ");
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().append(\"{FacebookGraphResponseException: \")");
        String message = getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(" ");
        }
        if (error != null) {
            sb.append("httpResponseCode: ");
            sb.append(error.getRequestStatusCode());
            sb.append(", facebookErrorCode: ");
            sb.append(error.getErrorCode());
            sb.append(", facebookErrorType: ");
            sb.append(error.getErrorType());
            sb.append(", message: ");
            sb.append(error.getErrorMessage());
            sb.append("}");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "errorStringBuilder.toString()");
        return sb2;
    }
}
