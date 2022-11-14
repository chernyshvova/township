package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: ImageResponseCache.kt */
public final class ImageResponseCache {
    public static final ImageResponseCache INSTANCE = new ImageResponseCache();
    public static final String TAG;
    public static FileLruCache imageCache;

    /* compiled from: ImageResponseCache.kt */
    public static final class BufferedHttpInputStream extends BufferedInputStream {
        public HttpURLConnection connection;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BufferedHttpInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
            this.connection = httpURLConnection;
        }

        public void close() throws IOException {
            super.close();
            Utility utility = Utility.INSTANCE;
            Utility.disconnectQuietly(this.connection);
        }

        public final HttpURLConnection getConnection() {
            return this.connection;
        }

        public final void setConnection(HttpURLConnection httpURLConnection) {
            Intrinsics.checkNotNullParameter(httpURLConnection, "<set-?>");
            this.connection = httpURLConnection;
        }
    }

    static {
        String simpleName = ImageResponseCache.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "ImageResponseCache::class.java.simpleName");
        TAG = simpleName;
    }

    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, Intrinsics.stringPlus("clearCache failed ", e.getMessage()));
        }
    }

    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (ImageResponseCache.class) {
            if (imageCache == null) {
                imageCache = new FileLruCache(TAG, new FileLruCache.Limits());
            }
            fileLruCache = imageCache;
            if (fileLruCache == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageCache");
                throw null;
            }
        }
        return fileLruCache;
    }

    public static final InputStream getCachedImageStream(Uri uri) {
        if (uri == null || !INSTANCE.isCDNURL(uri)) {
            return null;
        }
        try {
            FileLruCache cache = getCache();
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            return FileLruCache.get$default(cache, uri2, (String) null, 2, (Object) null);
        } catch (IOException e) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, e.toString());
            return null;
        }
    }

    public static final InputStream interceptAndCacheImageStream(HttpURLConnection httpURLConnection) throws IOException {
        Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        Uri parse = Uri.parse(httpURLConnection.getURL().toString());
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            if (!INSTANCE.isCDNURL(parse)) {
                return inputStream;
            }
            FileLruCache cache = getCache();
            String uri = parse.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
            return cache.interceptAndPut(uri, new BufferedHttpInputStream(inputStream, httpURLConnection));
        } catch (IOException unused) {
            return inputStream;
        }
    }

    private final boolean isCDNURL(Uri uri) {
        String host;
        if (uri == null || (host = uri.getHost()) == null || (!Intrinsics.areEqual(host, "fbcdn.net") && !CharsKt__CharKt.endsWith$default(host, ".fbcdn.net", false, 2) && (!CharsKt__CharKt.startsWith$default(host, "fbcdn", false, 2) || !CharsKt__CharKt.endsWith$default(host, ".akamaihd.net", false, 2)))) {
            return false;
        }
        return true;
    }

    public final String getTAG() {
        return TAG;
    }
}
