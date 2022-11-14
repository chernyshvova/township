package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageDownloader.kt */
public final class ImageDownloader {
    public static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    public static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    public static final ImageDownloader INSTANCE = new ImageDownloader();
    public static final WorkQueue cacheReadQueue = new WorkQueue(2, (Executor) null, 2, (DefaultConstructorMarker) null);
    public static final WorkQueue downloadQueue = new WorkQueue(8, (Executor) null, 2, (DefaultConstructorMarker) null);
    public static Handler handler;
    public static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    /* compiled from: ImageDownloader.kt */
    public static final class CacheReadWorkItem implements Runnable {
        public final boolean allowCachedRedirects;
        public final RequestKey key;

        public CacheReadWorkItem(RequestKey requestKey, boolean z) {
            Intrinsics.checkNotNullParameter(requestKey, "key");
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        public void run() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    ImageDownloader.INSTANCE.readFromCache(this.key, this.allowCachedRedirects);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    /* compiled from: ImageDownloader.kt */
    public static final class DownloadImageWorkItem implements Runnable {
        public final RequestKey key;

        public DownloadImageWorkItem(RequestKey requestKey) {
            Intrinsics.checkNotNullParameter(requestKey, "key");
            this.key = requestKey;
        }

        public void run() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    ImageDownloader.INSTANCE.download(this.key);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    @VisibleForTesting(otherwise = 2)
    /* compiled from: ImageDownloader.kt */
    public static final class DownloaderContext {
        public boolean isCancelled;
        public ImageRequest request;
        public WorkQueue.WorkItem workItem;

        public DownloaderContext(ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            this.request = imageRequest;
        }

        public final ImageRequest getRequest() {
            return this.request;
        }

        public final WorkQueue.WorkItem getWorkItem() {
            return this.workItem;
        }

        public final boolean isCancelled() {
            return this.isCancelled;
        }

        public final void setCancelled(boolean z) {
            this.isCancelled = z;
        }

        public final void setRequest(ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, "<set-?>");
            this.request = imageRequest;
        }

        public final void setWorkItem(WorkQueue.WorkItem workItem2) {
            this.workItem = workItem2;
        }
    }

    @VisibleForTesting(otherwise = 2)
    /* compiled from: ImageDownloader.kt */
    public static final class RequestKey {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int HASH_MULTIPLIER = 37;
        public static final int HASH_SEED = 29;
        public Object tag;
        public Uri uri;

        /* compiled from: ImageDownloader.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public RequestKey(Uri uri2, Object obj) {
            Intrinsics.checkNotNullParameter(uri2, "uri");
            Intrinsics.checkNotNullParameter(obj, "tag");
            this.uri = uri2;
            this.tag = obj;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            if (requestKey.uri == this.uri && requestKey.tag == this.tag) {
                return true;
            }
            return false;
        }

        public final Object getTag() {
            return this.tag;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.tag.hashCode() + ((this.uri.hashCode() + 1073) * 37);
        }

        public final void setTag(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.tag = obj;
        }

        public final void setUri(Uri uri2) {
            Intrinsics.checkNotNullParameter(uri2, "<set-?>");
            this.uri = uri2;
        }
    }

    public static final boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            z = true;
            if (downloaderContext != null) {
                WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                if (workItem == null || !workItem.cancel()) {
                    downloaderContext.setCancelled(true);
                } else {
                    pendingRequests.remove(requestKey);
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public static final void clearCache() {
        ImageResponseCache imageResponseCache = ImageResponseCache.INSTANCE;
        ImageResponseCache.clearCache();
        UrlRedirectCache urlRedirectCache = UrlRedirectCache.INSTANCE;
        UrlRedirectCache.clearCache();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.IOException} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c2, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c4, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c5, code lost:
        r4 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void download(com.facebook.internal.ImageDownloader.RequestKey r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00dc, all -> 0x00cf }
            android.net.Uri r4 = r11.getUri()     // Catch:{ IOException -> 0x00dc, all -> 0x00cf }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00dc, all -> 0x00cf }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00dc, all -> 0x00cf }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00dc, all -> 0x00cf }
            if (r3 == 0) goto L_0x00c7
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00dc, all -> 0x00cf }
            r3.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x00c4, all -> 0x00c2 }
            int r4 = r3.getResponseCode()     // Catch:{ IOException -> 0x00c4, all -> 0x00c2 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r5) goto L_0x00aa
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x0066
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x0066
            java.io.InputStream r4 = r3.getErrorStream()     // Catch:{ IOException -> 0x00c4, all -> 0x00c2 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            r5.<init>()     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            if (r4 == 0) goto L_0x004f
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            r6.<init>(r4)     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            r7 = 128(0x80, float:1.794E-43)
            char[] r8 = new char[r7]     // Catch:{ IOException -> 0x0063, all -> 0x005f }
        L_0x003f:
            int r9 = r6.read(r8, r1, r7)     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            if (r9 <= 0) goto L_0x0049
            r5.append(r8, r1, r9)     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            goto L_0x003f
        L_0x0049:
            com.facebook.internal.Utility r7 = com.facebook.internal.Utility.INSTANCE     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            com.facebook.internal.Utility.closeQuietly(r6)     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            goto L_0x0054
        L_0x004f:
            java.lang.String r6 = "Unexpected error while downloading an image."
            r5.append(r6)     // Catch:{ IOException -> 0x0063, all -> 0x005f }
        L_0x0054:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            r6.<init>((java.lang.String) r5)     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            r5 = r0
            goto L_0x00b5
        L_0x005f:
            r11 = move-exception
            r0 = r4
            goto L_0x00d1
        L_0x0063:
            r5 = move-exception
            goto L_0x00df
        L_0x0066:
            java.lang.String r2 = "location"
            java.lang.String r2 = r3.getHeaderField(r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            boolean r4 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            if (r4 != 0) goto L_0x00a2
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            com.facebook.internal.UrlRedirectCache r4 = com.facebook.internal.UrlRedirectCache.INSTANCE     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            android.net.Uri r4 = r11.getUri()     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            com.facebook.internal.UrlRedirectCache.cacheUriRedirect(r4, r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            com.facebook.internal.ImageDownloader$DownloaderContext r4 = r10.removePendingRequest(r11)     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            if (r4 == 0) goto L_0x00a2
            boolean r5 = r4.isCancelled()     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            if (r5 != 0) goto L_0x00a2
            com.facebook.internal.ImageRequest r4 = r4.getRequest()     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            com.facebook.internal.ImageDownloader$RequestKey r5 = new com.facebook.internal.ImageDownloader$RequestKey     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            java.lang.String r6 = "redirectUri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            java.lang.Object r6 = r11.getTag()     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            r5.<init>(r2, r6)     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
            r10.enqueueCacheRead(r4, r5, r1)     // Catch:{ IOException -> 0x00a6, all -> 0x00c2 }
        L_0x00a2:
            r5 = r0
            r6 = r5
            r2 = 0
            goto L_0x00b6
        L_0x00a6:
            r5 = move-exception
            r4 = r0
            r2 = 0
            goto L_0x00df
        L_0x00aa:
            com.facebook.internal.ImageResponseCache r4 = com.facebook.internal.ImageResponseCache.INSTANCE     // Catch:{ IOException -> 0x00c4, all -> 0x00c2 }
            java.io.InputStream r4 = com.facebook.internal.ImageResponseCache.interceptAndCacheImageStream(r3)     // Catch:{ IOException -> 0x00c4, all -> 0x00c2 }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ IOException -> 0x0063, all -> 0x005f }
            r6 = r0
        L_0x00b5:
            r0 = r4
        L_0x00b6:
            com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.closeQuietly(r0)
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.disconnectQuietly(r3)
            r0 = r5
            goto L_0x00ea
        L_0x00c2:
            r11 = move-exception
            goto L_0x00d1
        L_0x00c4:
            r5 = move-exception
            r4 = r0
            goto L_0x00df
        L_0x00c7:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x00dc, all -> 0x00cf }
            java.lang.String r4 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r3.<init>(r4)     // Catch:{ IOException -> 0x00dc, all -> 0x00cf }
            throw r3     // Catch:{ IOException -> 0x00dc, all -> 0x00cf }
        L_0x00cf:
            r11 = move-exception
            r3 = r0
        L_0x00d1:
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.closeQuietly(r0)
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.disconnectQuietly(r3)
            throw r11
        L_0x00dc:
            r5 = move-exception
            r3 = r0
            r4 = r3
        L_0x00df:
            com.facebook.internal.Utility r6 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.closeQuietly(r4)
            com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.disconnectQuietly(r3)
            r6 = r5
        L_0x00ea:
            if (r2 == 0) goto L_0x00ef
            r10.issueResponse(r11, r6, r0, r1)
        L_0x00ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.download(com.facebook.internal.ImageDownloader$RequestKey):void");
    }

    public static final void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest != null) {
            RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
            synchronized (pendingRequests) {
                DownloaderContext downloaderContext = pendingRequests.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.setRequest(imageRequest);
                    downloaderContext.setCancelled(false);
                    WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                    if (workItem != null) {
                        workItem.moveToFront();
                    }
                } else {
                    INSTANCE.enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
                }
            }
        }
    }

    private final void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(requestKey, z));
    }

    private final void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(requestKey));
    }

    private final void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = new DownloaderContext(imageRequest);
            pendingRequests.put(requestKey, downloaderContext);
            downloaderContext.setWorkItem(WorkQueue.addActiveWorkItem$default(workQueue, runnable, false, 2, (Object) null));
        }
    }

    private final synchronized Handler getHandler() {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        return handler;
    }

    private final void issueResponse(RequestKey requestKey, Exception exc, Bitmap bitmap, boolean z) {
        ImageRequest.Callback callback;
        Handler handler2;
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest != null && !removePendingRequest.isCancelled()) {
            ImageRequest request = removePendingRequest.getRequest();
            if (request == null) {
                callback = null;
            } else {
                callback = request.getCallback();
            }
            ImageRequest.Callback callback2 = callback;
            if (callback2 != null && (handler2 = getHandler()) != null) {
                handler2.post(new Runnable(exc, z, bitmap, callback2) {
                    public final /* synthetic */ Exception f$1;
                    public final /* synthetic */ boolean f$2;
                    public final /* synthetic */ Bitmap f$3;
                    public final /* synthetic */ ImageRequest.Callback f$4;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                    }

                    public final void run() {
                        ImageDownloader.m3624issueResponse$lambda4(ImageRequest.this, this.f$1, this.f$2, this.f$3, this.f$4);
                    }
                });
            }
        }
    }

    /* renamed from: issueResponse$lambda-4  reason: not valid java name */
    public static final void m3624issueResponse$lambda4(ImageRequest imageRequest, Exception exc, boolean z, Bitmap bitmap, ImageRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(imageRequest, "$request");
        callback.onCompleted(new ImageResponse(imageRequest, exc, z, bitmap));
    }

    public static final void prioritizeRequest(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            if (downloaderContext != null) {
                WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                if (workItem != null) {
                    workItem.moveToFront();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void readFromCache(com.facebook.internal.ImageDownloader.RequestKey r5, boolean r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            if (r6 == 0) goto L_0x001a
            com.facebook.internal.UrlRedirectCache r6 = com.facebook.internal.UrlRedirectCache.INSTANCE
            android.net.Uri r6 = r5.getUri()
            android.net.Uri r6 = com.facebook.internal.UrlRedirectCache.getRedirectedUri(r6)
            if (r6 == 0) goto L_0x001a
            com.facebook.internal.ImageResponseCache r2 = com.facebook.internal.ImageResponseCache.INSTANCE
            java.io.InputStream r6 = com.facebook.internal.ImageResponseCache.getCachedImageStream(r6)
            if (r6 == 0) goto L_0x001b
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r6 = r1
        L_0x001b:
            if (r0 != 0) goto L_0x0027
            com.facebook.internal.ImageResponseCache r6 = com.facebook.internal.ImageResponseCache.INSTANCE
            android.net.Uri r6 = r5.getUri()
            java.io.InputStream r6 = com.facebook.internal.ImageResponseCache.getCachedImageStream(r6)
        L_0x0027:
            if (r6 == 0) goto L_0x0036
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r6)
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.closeQuietly(r6)
            r4.issueResponse(r5, r1, r2, r0)
            goto L_0x004e
        L_0x0036:
            com.facebook.internal.ImageDownloader$DownloaderContext r6 = r4.removePendingRequest(r5)
            if (r6 != 0) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            com.facebook.internal.ImageRequest r1 = r6.getRequest()
        L_0x0041:
            if (r6 == 0) goto L_0x004e
            boolean r6 = r6.isCancelled()
            if (r6 != 0) goto L_0x004e
            if (r1 == 0) goto L_0x004e
            r4.enqueueDownload(r1, r5)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.readFromCache(com.facebook.internal.ImageDownloader$RequestKey, boolean):void");
    }

    private final DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext remove;
        synchronized (pendingRequests) {
            remove = pendingRequests.remove(requestKey);
        }
        return remove;
    }

    @VisibleForTesting(otherwise = 2)
    public final Map<RequestKey, DownloaderContext> getPendingRequests() {
        return pendingRequests;
    }
}
