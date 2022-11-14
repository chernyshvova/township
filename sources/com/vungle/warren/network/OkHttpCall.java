package com.vungle.warren.network;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.network.converters.Converter;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public final class OkHttpCall<T> implements Call<T> {
    public static final String TAG = "OkHttpCall";
    public final Converter<ResponseBody, T> converter;
    public Call rawCall;

    public static final class ExceptionCatchingResponseBody extends ResponseBody {
        public final ResponseBody delegate;
        @Nullable
        public IOException thrownException;

        public ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.delegate = responseBody;
        }

        public void close() {
            this.delegate.close();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public MediaType contentType() {
            return this.delegate.contentType();
        }

        public BufferedSource source() {
            return Okio.buffer((Source) new ForwardingSource(this.delegate.source()) {
                public long read(@NonNull Buffer buffer, long j) throws IOException {
                    try {
                        return super.read(buffer, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            });
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends ResponseBody {
        public final long contentLength;
        @Nullable
        public final MediaType contentType;

        public NoContentResponseBody(@Nullable MediaType mediaType, long j) {
            this.contentType = mediaType;
            this.contentLength = j;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public MediaType contentType() {
            return this.contentType;
        }

        @NonNull
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(@NonNull Call call, Converter<ResponseBody, T> converter2) {
        this.rawCall = call;
        this.converter = converter2;
    }

    /* access modifiers changed from: private */
    public Response<T> parseResponse(Response response, Converter<ResponseBody, T> converter2) throws IOException {
        ResponseBody responseBody = response.body;
        Response.Builder builder = new Response.Builder(response);
        builder.body = new NoContentResponseBody(responseBody.contentType(), responseBody.contentLength());
        Response build = builder.build();
        int i = build.code;
        if (i < 200 || i >= 300) {
            try {
                Buffer buffer = new Buffer();
                responseBody.source().readAll(buffer);
                return Response.error(ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), buffer), build);
            } finally {
                responseBody.close();
            }
        } else if (i == 204 || i == 205) {
            responseBody.close();
            return Response.success(null, build);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(responseBody);
            try {
                return Response.success(converter2.convert(exceptionCatchingResponseBody), build);
            } catch (RuntimeException e) {
                exceptionCatchingResponseBody.throwIfCaught();
                throw e;
            }
        }
    }

    public void enqueue(final Callback<T> callback) {
        this.rawCall.enqueue(new Callback() {
            private void callFailure(Throwable th) {
                try {
                    callback.onFailure(OkHttpCall.this, th);
                } catch (Throwable th2) {
                    Log.w(OkHttpCall.TAG, "Error on executing callback", th2);
                }
            }

            public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
                callFailure(iOException);
            }

            public void onResponse(@NonNull Call call, @NonNull Response response) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(response, OkHttpCall.this.converter));
                    } catch (Throwable th) {
                        Log.w(OkHttpCall.TAG, "Error on excuting callback", th);
                    }
                } catch (Throwable th2) {
                    callFailure(th2);
                }
            }
        });
    }

    public Response<T> execute() throws IOException {
        Call call;
        synchronized (this) {
            call = this.rawCall;
        }
        return parseResponse(call.execute(), this.converter);
    }
}
