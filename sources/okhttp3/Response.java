package okhttp3;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.Headers;

public final class Response implements Closeable {
    @Nullable
    public final ResponseBody body;
    @Nullable
    public volatile CacheControl cacheControl;
    @Nullable
    public final Response cacheResponse;
    public final int code;
    @Nullable
    public final Handshake handshake;
    public final Headers headers;
    public final String message;
    @Nullable
    public final Response networkResponse;
    @Nullable
    public final Response priorResponse;
    public final Protocol protocol;
    public final long receivedResponseAtMillis;
    public final Request request;
    public final long sentRequestAtMillis;

    public Response(Builder builder) {
        this.request = builder.request;
        this.protocol = builder.protocol;
        this.code = builder.code;
        this.message = builder.message;
        this.handshake = builder.handshake;
        Headers.Builder builder2 = builder.headers;
        if (builder2 != null) {
            this.headers = new Headers(builder2);
            this.body = builder.body;
            this.networkResponse = builder.networkResponse;
            this.cacheResponse = builder.cacheResponse;
            this.priorResponse = builder.priorResponse;
            this.sentRequestAtMillis = builder.sentRequestAtMillis;
            this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
            return;
        }
        throw null;
    }

    @Nullable
    public ResponseBody body() {
        return this.body;
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

    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public int code() {
        return this.code;
    }

    public Headers headers() {
        return this.headers;
    }

    public boolean isSuccessful() {
        int i = this.code;
        return i >= 200 && i < 300;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Response{protocol=");
        outline24.append(this.protocol);
        outline24.append(", code=");
        outline24.append(this.code);
        outline24.append(", message=");
        outline24.append(this.message);
        outline24.append(", url=");
        outline24.append(this.request.url);
        outline24.append('}');
        return outline24.toString();
    }

    public static class Builder {
        @Nullable
        public ResponseBody body;
        @Nullable
        public Response cacheResponse;
        public int code;
        @Nullable
        public Handshake handshake;
        public Headers.Builder headers;
        public String message;
        @Nullable
        public Response networkResponse;
        @Nullable
        public Response priorResponse;
        @Nullable
        public Protocol protocol;
        public long receivedResponseAtMillis;
        @Nullable
        public Request request;
        public long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
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

        public Response build() {
            if (this.request == null) {
                throw new IllegalStateException("request == null");
            } else if (this.protocol == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.code < 0) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("code < 0: ");
                outline24.append(this.code);
                throw new IllegalStateException(outline24.toString());
            } else if (this.message != null) {
                return new Response(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public Builder cacheResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        public final void checkSupportResponse(String str, Response response) {
            if (response.body != null) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline16(str, ".body != null"));
            } else if (response.networkResponse != null) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline16(str, ".networkResponse != null"));
            } else if (response.cacheResponse != null) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline16(str, ".cacheResponse != null"));
            } else if (response.priorResponse != null) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline16(str, ".priorResponse != null"));
            }
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2.newBuilder();
            return this;
        }

        public Builder(Response response) {
            this.code = -1;
            this.request = response.request;
            this.protocol = response.protocol;
            this.code = response.code;
            this.message = response.message;
            this.handshake = response.handshake;
            this.headers = response.headers.newBuilder();
            this.body = response.body;
            this.networkResponse = response.networkResponse;
            this.cacheResponse = response.cacheResponse;
            this.priorResponse = response.priorResponse;
            this.sentRequestAtMillis = response.sentRequestAtMillis;
            this.receivedResponseAtMillis = response.receivedResponseAtMillis;
        }
    }
}
