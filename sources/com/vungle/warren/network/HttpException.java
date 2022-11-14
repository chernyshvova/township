package com.vungle.warren.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

public class HttpException extends RuntimeException {
    public final int code;
    public final String message;
    public final transient Response<?> response;

    public HttpException(Response<?> response2) {
        super(getMessage(response2));
        this.code = response2.code();
        this.message = response2.message();
        this.response = response2;
    }

    public static String getMessage(@NonNull Response<?> response2) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("HTTP ");
        outline24.append(response2.code());
        outline24.append(" ");
        outline24.append(response2.message());
        return outline24.toString();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public Response<?> response() {
        return this.response;
    }
}
