package com.vungle.warren.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class Response<T> {
    @Nullable
    public final T body;
    @Nullable
    public final ResponseBody errorBody;
    public final okhttp3.Response rawResponse;

    public Response(okhttp3.Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t;
        this.errorBody = responseBody;
    }

    public static <T> Response<T> error(int i, ResponseBody responseBody) {
        if (i >= 400) {
            Response.Builder builder = new Response.Builder();
            builder.code = i;
            builder.message = "Response.error()";
            builder.protocol = Protocol.HTTP_1_1;
            Request.Builder builder2 = new Request.Builder();
            builder2.url("http://localhost/");
            builder.request = builder2.build();
            return error(responseBody, builder.build());
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline14("code < 400: ", i));
    }

    public static <T> Response<T> success(@Nullable T t) {
        Response.Builder builder = new Response.Builder();
        builder.code = 200;
        builder.message = "OK";
        builder.protocol = Protocol.HTTP_1_1;
        Request.Builder builder2 = new Request.Builder();
        builder2.url("http://localhost/");
        builder.request = builder2.build();
        return success(t, builder.build());
    }

    @Nullable
    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.code;
    }

    @Nullable
    public ResponseBody errorBody() {
        return this.errorBody;
    }

    public Headers headers() {
        return this.rawResponse.headers;
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.message;
    }

    public okhttp3.Response raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(@Nullable T t, @NonNull okhttp3.Response response) {
        if (response.isSuccessful()) {
            return new Response<>(response, t, (ResponseBody) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> Response<T> error(@NonNull ResponseBody responseBody, @NonNull okhttp3.Response response) {
        if (!response.isSuccessful()) {
            return new Response<>(response, (Object) null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }
}
