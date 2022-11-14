package okhttp3;

import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;

public final class Request {
    @Nullable
    public final RequestBody body;
    @Nullable
    public volatile CacheControl cacheControl;
    public final Headers headers;
    public final String method;
    public final Map<Class<?>, Object> tags;
    public final HttpUrl url;

    public Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        Headers.Builder builder2 = builder.headers;
        if (builder2 != null) {
            this.headers = new Headers(builder2);
            this.body = builder.body;
            this.tags = Util.immutableMap(builder.tags);
            return;
        }
        throw null;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl2 = this.cacheControl;
        if (cacheControl2 != null) {
            return cacheControl2;
        }
        CacheControl parse = CacheControl.parse(this.headers);
        this.cacheControl = parse;
        return parse;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Request{method=");
        outline24.append(this.method);
        outline24.append(", url=");
        outline24.append(this.url);
        outline24.append(", tags=");
        outline24.append(this.tags);
        outline24.append('}');
        return outline24.toString();
    }

    public static class Builder {
        @Nullable
        public RequestBody body;
        public Headers.Builder headers;
        public String method;
        public Map<Class<?>, Object> tags;
        @Nullable
        public HttpUrl url;

        public Builder() {
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder addHeader(String str, String str2) {
            Headers.Builder builder = this.headers;
            if (builder != null) {
                Headers.checkName(str);
                Headers.checkValue(str2, str);
                builder.namesAndValues.add(str);
                builder.namesAndValues.add(str2.trim());
                return this;
            }
            throw null;
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder header(String str, String str2) {
            Headers.Builder builder = this.headers;
            if (builder != null) {
                Headers.checkName(str);
                Headers.checkValue(str2, str);
                builder.removeAll(str);
                builder.namesAndValues.add(str);
                builder.namesAndValues.add(str2.trim());
                return this;
            }
            throw null;
        }

        public Builder method(String str, @Nullable RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (requestBody == null || zzam.permitsRequestBody(str)) {
                if (requestBody == null) {
                    if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline17("method ", str, " must have a request body."));
                    }
                }
                this.method = str;
                this.body = requestBody;
                return this;
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline17("method ", str, " must not have a request body."));
            }
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.url = httpUrl;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public Builder url(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("http:");
                    outline24.append(str.substring(3));
                    str = outline24.toString();
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("https:");
                    outline242.append(str.substring(4));
                    str = outline242.toString();
                }
                url(HttpUrl.get(str));
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public Builder(Request request) {
            Map<Class<?>, Object> map;
            this.tags = Collections.emptyMap();
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            if (request.tags.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = new LinkedHashMap<>(request.tags);
            }
            this.tags = map;
            this.headers = request.headers.newBuilder();
        }
    }
}
