package com.microsoft.appcenter.http;

import java.io.IOException;

public class HttpException extends IOException {
    public final HttpResponse mHttpResponse;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpException(@androidx.annotation.NonNull com.microsoft.appcenter.http.HttpResponse r4) {
        /*
            r3 = this;
            int r0 = r4.statusCode
            java.lang.String r1 = r4.payload
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x000f
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x0023
        L_0x000f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " - "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
        L_0x0023:
            r3.<init>(r0)
            r3.mHttpResponse = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.http.HttpException.<init>(com.microsoft.appcenter.http.HttpResponse):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HttpException.class != obj.getClass()) {
            return false;
        }
        return this.mHttpResponse.equals(((HttpException) obj).mHttpResponse);
    }

    public int hashCode() {
        return this.mHttpResponse.hashCode();
    }
}
