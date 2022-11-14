package com.microsoft.appcenter.http;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Map;

public class HttpResponse {
    public final Map<String, String> headers;
    public final String payload;
    public final int statusCode;

    public HttpResponse(int i, @NonNull String str, @NonNull Map<String, String> map) {
        this.payload = str;
        this.statusCode = i;
        this.headers = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HttpResponse.class != obj.getClass()) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) obj;
        if (this.statusCode != httpResponse.statusCode || !this.payload.equals(httpResponse.payload) || !this.headers.equals(httpResponse.headers)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.headers.hashCode() + GeneratedOutlineSupport.outline4(this.payload, this.statusCode * 31, 31);
    }
}
