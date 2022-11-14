package com.facebook.internal;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageResponse.kt */
public final class ImageResponse {
    public final Bitmap bitmap;
    public final Exception error;
    public final boolean isCachedRedirect;
    public final ImageRequest request;

    public ImageResponse(ImageRequest imageRequest, Exception exc, boolean z, Bitmap bitmap2) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        this.request = imageRequest;
        this.error = exc;
        this.isCachedRedirect = z;
        this.bitmap = bitmap2;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Exception getError() {
        return this.error;
    }

    public final ImageRequest getRequest() {
        return this.request;
    }

    public final boolean isCachedRedirect() {
        return this.isCachedRedirect;
    }
}
