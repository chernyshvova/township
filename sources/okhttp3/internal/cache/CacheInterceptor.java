package okhttp3.internal.cache;

import okhttp3.Interceptor;
import okhttp3.Response;

public final class CacheInterceptor implements Interceptor {
    public final InternalCache cache;

    public CacheInterceptor(InternalCache internalCache) {
        this.cache = internalCache;
    }

    public static boolean isContentSpecificHeader(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    public static boolean isEndToEnd(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    public static Response stripBody(Response response) {
        if (response == null || response.body == null) {
            return response;
        }
        Response.Builder builder = new Response.Builder(response);
        builder.body = null;
        return builder.build();
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [okhttp3.Request, okhttp3.Response] */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014c, code lost:
        if (r4 > 0) goto L_0x014e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0287 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r27) throws java.io.IOException {
        /*
            r26 = this;
            r1 = r26
            okhttp3.internal.cache.InternalCache r0 = r1.cache
            if (r0 == 0) goto L_0x0012
            r3 = r27
            okhttp3.internal.http.RealInterceptorChain r3 = (okhttp3.internal.http.RealInterceptorChain) r3
            okhttp3.Request r3 = r3.request
            okhttp3.Response r0 = r0.get(r3)
            r3 = r0
            goto L_0x0013
        L_0x0012:
            r3 = 0
        L_0x0013:
            long r4 = java.lang.System.currentTimeMillis()
            r0 = r27
            okhttp3.internal.http.RealInterceptorChain r0 = (okhttp3.internal.http.RealInterceptorChain) r0
            okhttp3.Request r6 = r0.request
            if (r3 == 0) goto L_0x008b
            long r11 = r3.sentRequestAtMillis
            long r13 = r3.receivedResponseAtMillis
            okhttp3.Headers r15 = r3.headers
            int r7 = r15.size()
            r9 = 0
            r10 = -1
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x0037:
            if (r9 >= r7) goto L_0x009c
            java.lang.String r2 = r15.name(r9)
            java.lang.String r8 = r15.value(r9)
            r22 = r7
            java.lang.String r7 = "Date"
            boolean r7 = r7.equalsIgnoreCase(r2)
            if (r7 == 0) goto L_0x0052
            java.util.Date r16 = okhttp3.internal.http.HttpDate.parse(r8)
            r21 = r8
            goto L_0x0086
        L_0x0052:
            java.lang.String r7 = "Expires"
            boolean r7 = r7.equalsIgnoreCase(r2)
            if (r7 == 0) goto L_0x005f
            java.util.Date r17 = okhttp3.internal.http.HttpDate.parse(r8)
            goto L_0x0086
        L_0x005f:
            java.lang.String r7 = "Last-Modified"
            boolean r7 = r7.equalsIgnoreCase(r2)
            if (r7 == 0) goto L_0x006e
            java.util.Date r18 = okhttp3.internal.http.HttpDate.parse(r8)
            r20 = r8
            goto L_0x0086
        L_0x006e:
            java.lang.String r7 = "ETag"
            boolean r7 = r7.equalsIgnoreCase(r2)
            if (r7 == 0) goto L_0x0079
            r19 = r8
            goto L_0x0086
        L_0x0079:
            java.lang.String r7 = "Age"
            boolean r2 = r7.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0086
            r2 = -1
            int r10 = okhttp3.internal.http.HttpHeaders.parseSeconds(r8, r2)
        L_0x0086:
            int r9 = r9 + 1
            r7 = r22
            goto L_0x0037
        L_0x008b:
            r10 = -1
            r11 = 0
            r13 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x009c:
            java.lang.String r2 = "Warning"
            if (r3 != 0) goto L_0x00a7
            okhttp3.internal.cache.CacheStrategy r4 = new okhttp3.internal.cache.CacheStrategy
            r8 = 0
            r4.<init>(r6, r8)
            goto L_0x00c9
        L_0x00a7:
            r8 = 0
            okhttp3.HttpUrl r9 = r6.url
            java.lang.String r9 = r9.scheme
            java.lang.String r15 = "https"
            boolean r9 = r9.equals(r15)
            if (r9 == 0) goto L_0x00be
            okhttp3.Handshake r9 = r3.handshake
            if (r9 != 0) goto L_0x00be
            okhttp3.internal.cache.CacheStrategy r4 = new okhttp3.internal.cache.CacheStrategy
            r4.<init>(r6, r8)
            goto L_0x00c9
        L_0x00be:
            boolean r9 = okhttp3.internal.cache.CacheStrategy.isCacheable(r3, r6)
            if (r9 != 0) goto L_0x00cf
            okhttp3.internal.cache.CacheStrategy r4 = new okhttp3.internal.cache.CacheStrategy
            r4.<init>(r6, r8)
        L_0x00c9:
            r25 = r0
            r0 = r6
        L_0x00cc:
            r1 = 0
            goto L_0x025e
        L_0x00cf:
            okhttp3.CacheControl r8 = r6.cacheControl()
            boolean r9 = r8.noCache
            if (r9 != 0) goto L_0x0255
            okhttp3.Headers r9 = r6.headers
            java.lang.String r15 = "If-Modified-Since"
            java.lang.String r9 = r9.get(r15)
            java.lang.String r7 = "If-None-Match"
            if (r9 != 0) goto L_0x00ee
            okhttp3.Headers r9 = r6.headers
            java.lang.String r9 = r9.get(r7)
            if (r9 == 0) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            r9 = 0
            goto L_0x00ef
        L_0x00ee:
            r9 = 1
        L_0x00ef:
            if (r9 == 0) goto L_0x00f3
            goto L_0x0255
        L_0x00f3:
            okhttp3.CacheControl r9 = r3.cacheControl()
            if (r16 == 0) goto L_0x010c
            long r23 = r16.getTime()
            r25 = r0
            long r0 = r13 - r23
            r23 = r6
            r24 = r7
            r6 = 0
            long r0 = java.lang.Math.max(r6, r0)
            goto L_0x0114
        L_0x010c:
            r25 = r0
            r23 = r6
            r24 = r7
            r0 = 0
        L_0x0114:
            r6 = -1
            if (r10 == r6) goto L_0x0124
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
            r7 = r9
            long r9 = (long) r10
            long r9 = r6.toMillis(r9)
            long r0 = java.lang.Math.max(r0, r9)
            goto L_0x0125
        L_0x0124:
            r7 = r9
        L_0x0125:
            long r9 = r13 - r11
            long r4 = r4 - r13
            long r0 = r0 + r9
            long r0 = r0 + r4
            okhttp3.CacheControl r4 = r3.cacheControl()
            int r4 = r4.maxAgeSeconds
            r5 = -1
            if (r4 == r5) goto L_0x013b
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            long r9 = (long) r4
            long r4 = r5.toMillis(r9)
            goto L_0x014e
        L_0x013b:
            if (r17 == 0) goto L_0x0152
            if (r16 == 0) goto L_0x0143
            long r13 = r16.getTime()
        L_0x0143:
            long r4 = r17.getTime()
            long r4 = r4 - r13
            r9 = 0
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x0184
        L_0x014e:
            r9 = r4
            r4 = 0
            goto L_0x0187
        L_0x0152:
            if (r18 == 0) goto L_0x0184
            okhttp3.Request r4 = r3.request
            okhttp3.HttpUrl r4 = r4.url
            java.util.List<java.lang.String> r5 = r4.queryNamesAndValues
            if (r5 != 0) goto L_0x015e
            r4 = 0
            goto L_0x016c
        L_0x015e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.List<java.lang.String> r4 = r4.queryNamesAndValues
            okhttp3.HttpUrl.namesAndValuesToQueryString(r5, r4)
            java.lang.String r4 = r5.toString()
        L_0x016c:
            if (r4 != 0) goto L_0x0184
            if (r16 == 0) goto L_0x0174
            long r11 = r16.getTime()
        L_0x0174:
            long r4 = r18.getTime()
            long r11 = r11 - r4
            r4 = 0
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0186
            r9 = 10
            long r9 = r11 / r9
            goto L_0x0187
        L_0x0184:
            r4 = 0
        L_0x0186:
            r9 = r4
        L_0x0187:
            int r6 = r8.maxAgeSeconds
            r11 = -1
            if (r6 == r11) goto L_0x0197
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS
            long r13 = (long) r6
            long r12 = r12.toMillis(r13)
            long r9 = java.lang.Math.min(r9, r12)
        L_0x0197:
            int r6 = r8.minFreshSeconds
            if (r6 == r11) goto L_0x01a3
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS
            long r13 = (long) r6
            long r12 = r12.toMillis(r13)
            goto L_0x01a4
        L_0x01a3:
            r12 = r4
        L_0x01a4:
            boolean r6 = r7.mustRevalidate
            if (r6 != 0) goto L_0x01b3
            int r6 = r8.maxStaleSeconds
            if (r6 == r11) goto L_0x01b3
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            long r5 = (long) r6
            long r4 = r4.toMillis(r5)
        L_0x01b3:
            boolean r6 = r7.noCache
            if (r6 != 0) goto L_0x01f6
            long r12 = r12 + r0
            long r4 = r4 + r9
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x01f6
            okhttp3.Response$Builder r4 = new okhttp3.Response$Builder
            r4.<init>(r3)
            int r5 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x01cb
            java.lang.String r5 = "110 HttpURLConnection \"Response is stale\""
            r4.addHeader(r2, r5)
        L_0x01cb:
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x01e7
            okhttp3.CacheControl r0 = r3.cacheControl()
            int r0 = r0.maxAgeSeconds
            r1 = -1
            if (r0 != r1) goto L_0x01df
            if (r17 != 0) goto L_0x01df
            r0 = 1
            goto L_0x01e0
        L_0x01df:
            r0 = 0
        L_0x01e0:
            if (r0 == 0) goto L_0x01e7
            java.lang.String r0 = "113 HttpURLConnection \"Heuristic expiration\""
            r4.addHeader(r2, r0)
        L_0x01e7:
            okhttp3.internal.cache.CacheStrategy r0 = new okhttp3.internal.cache.CacheStrategy
            okhttp3.Response r1 = r4.build()
            r4 = 0
            r0.<init>(r4, r1)
            r1 = r4
            r4 = r0
            r0 = r23
            goto L_0x025e
        L_0x01f6:
            if (r19 == 0) goto L_0x01fb
            r15 = r24
            goto L_0x0204
        L_0x01fb:
            if (r18 == 0) goto L_0x0200
            r19 = r20
            goto L_0x0204
        L_0x0200:
            if (r16 == 0) goto L_0x024c
            r19 = r21
        L_0x0204:
            r0 = r23
            okhttp3.Headers r1 = r0.headers
            okhttp3.Headers$Builder r1 = r1.newBuilder()
            okhttp3.internal.Internal r4 = okhttp3.internal.Internal.instance
            okhttp3.OkHttpClient$1 r4 = (okhttp3.OkHttpClient.C20611) r4
            if (r4 == 0) goto L_0x024a
            java.util.List<java.lang.String> r4 = r1.namesAndValues
            r4.add(r15)
            java.util.List<java.lang.String> r4 = r1.namesAndValues
            java.lang.String r5 = r19.trim()
            r4.add(r5)
            okhttp3.Request$Builder r4 = new okhttp3.Request$Builder
            r4.<init>(r0)
            java.util.List<java.lang.String> r1 = r1.namesAndValues
            int r5 = r1.size()
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.Object[] r1 = r1.toArray(r5)
            java.lang.String[] r1 = (java.lang.String[]) r1
            okhttp3.Headers$Builder r5 = new okhttp3.Headers$Builder
            r5.<init>()
            java.util.List<java.lang.String> r6 = r5.namesAndValues
            java.util.Collections.addAll(r6, r1)
            r4.headers = r5
            okhttp3.Request r1 = r4.build()
            okhttp3.internal.cache.CacheStrategy r4 = new okhttp3.internal.cache.CacheStrategy
            r4.<init>(r1, r3)
            goto L_0x00cc
        L_0x024a:
            r1 = 0
            throw r1
        L_0x024c:
            r0 = r23
            r1 = 0
            okhttp3.internal.cache.CacheStrategy r4 = new okhttp3.internal.cache.CacheStrategy
            r4.<init>(r0, r1)
            goto L_0x025e
        L_0x0255:
            r25 = r0
            r0 = r6
            r1 = 0
            okhttp3.internal.cache.CacheStrategy r4 = new okhttp3.internal.cache.CacheStrategy
            r4.<init>(r0, r1)
        L_0x025e:
            okhttp3.Request r5 = r4.networkRequest
            if (r5 == 0) goto L_0x026f
            okhttp3.CacheControl r0 = r0.cacheControl()
            boolean r0 = r0.onlyIfCached
            if (r0 == 0) goto L_0x026f
            okhttp3.internal.cache.CacheStrategy r4 = new okhttp3.internal.cache.CacheStrategy
            r4.<init>(r1, r1)
        L_0x026f:
            okhttp3.Request r0 = r4.networkRequest
            okhttp3.Response r1 = r4.cacheResponse
            r5 = r26
            okhttp3.internal.cache.InternalCache r6 = r5.cache
            if (r6 == 0) goto L_0x027c
            r6.trackResponse(r4)
        L_0x027c:
            if (r3 == 0) goto L_0x0285
            if (r1 != 0) goto L_0x0285
            okhttp3.ResponseBody r4 = r3.body
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r4)
        L_0x0285:
            if (r0 != 0) goto L_0x02b3
            if (r1 != 0) goto L_0x02b3
            okhttp3.Response$Builder r0 = new okhttp3.Response$Builder
            r0.<init>()
            r4 = r25
            okhttp3.Request r1 = r4.request
            r0.request = r1
            okhttp3.Protocol r1 = okhttp3.Protocol.HTTP_1_1
            r0.protocol = r1
            r1 = 504(0x1f8, float:7.06E-43)
            r0.code = r1
            java.lang.String r1 = "Unsatisfiable Request (only-if-cached)"
            r0.message = r1
            okhttp3.ResponseBody r1 = okhttp3.internal.Util.EMPTY_RESPONSE
            r0.body = r1
            r1 = -1
            r0.sentRequestAtMillis = r1
            long r1 = java.lang.System.currentTimeMillis()
            r0.receivedResponseAtMillis = r1
            okhttp3.Response r0 = r0.build()
            return r0
        L_0x02b3:
            r4 = r25
            if (r0 != 0) goto L_0x02cc
            if (r1 == 0) goto L_0x02ca
            okhttp3.Response$Builder r0 = new okhttp3.Response$Builder
            r0.<init>(r1)
            okhttp3.Response r1 = stripBody(r1)
            r0.cacheResponse(r1)
            okhttp3.Response r0 = r0.build()
            return r0
        L_0x02ca:
            r6 = 0
            throw r6
        L_0x02cc:
            r6 = 0
            okhttp3.internal.connection.StreamAllocation r7 = r4.streamAllocation     // Catch:{ all -> 0x044a }
            okhttp3.internal.http.HttpCodec r8 = r4.httpCodec     // Catch:{ all -> 0x044a }
            okhttp3.internal.connection.RealConnection r9 = r4.connection     // Catch:{ all -> 0x044a }
            okhttp3.Response r3 = r4.proceed(r0, r7, r8, r9)     // Catch:{ all -> 0x044a }
            java.lang.String r4 = "networkResponse"
            if (r1 == 0) goto L_0x03a1
            int r7 = r3.code
            r8 = 304(0x130, float:4.26E-43)
            if (r7 != r8) goto L_0x039c
            okhttp3.Response$Builder r0 = new okhttp3.Response$Builder
            r0.<init>(r1)
            okhttp3.Headers r6 = r1.headers
            okhttp3.Headers r7 = r3.headers
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = 20
            r8.<init>(r9)
            int r9 = r6.size()
            r10 = 0
        L_0x02f6:
            if (r10 >= r9) goto L_0x032e
            java.lang.String r11 = r6.name(r10)
            java.lang.String r12 = r6.value(r10)
            boolean r13 = r2.equalsIgnoreCase(r11)
            if (r13 == 0) goto L_0x030f
            java.lang.String r13 = "1"
            boolean r13 = r12.startsWith(r13)
            if (r13 == 0) goto L_0x030f
            goto L_0x032b
        L_0x030f:
            boolean r13 = isContentSpecificHeader(r11)
            if (r13 != 0) goto L_0x0321
            boolean r13 = isEndToEnd(r11)
            if (r13 == 0) goto L_0x0321
            java.lang.String r13 = r7.get(r11)
            if (r13 != 0) goto L_0x032b
        L_0x0321:
            r8.add(r11)
            java.lang.String r11 = r12.trim()
            r8.add(r11)
        L_0x032b:
            int r10 = r10 + 1
            goto L_0x02f6
        L_0x032e:
            int r2 = r7.size()
            r6 = 0
        L_0x0333:
            if (r6 >= r2) goto L_0x0356
            java.lang.String r9 = r7.name(r6)
            boolean r10 = isContentSpecificHeader(r9)
            if (r10 != 0) goto L_0x0353
            boolean r10 = isEndToEnd(r9)
            if (r10 == 0) goto L_0x0353
            java.lang.String r10 = r7.value(r6)
            r8.add(r9)
            java.lang.String r9 = r10.trim()
            r8.add(r9)
        L_0x0353:
            int r6 = r6 + 1
            goto L_0x0333
        L_0x0356:
            int r2 = r8.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r2 = r8.toArray(r2)
            java.lang.String[] r2 = (java.lang.String[]) r2
            okhttp3.Headers$Builder r6 = new okhttp3.Headers$Builder
            r6.<init>()
            java.util.List<java.lang.String> r7 = r6.namesAndValues
            java.util.Collections.addAll(r7, r2)
            r0.headers = r6
            long r6 = r3.sentRequestAtMillis
            r0.sentRequestAtMillis = r6
            long r6 = r3.receivedResponseAtMillis
            r0.receivedResponseAtMillis = r6
            okhttp3.Response r2 = stripBody(r1)
            r0.cacheResponse(r2)
            okhttp3.Response r2 = stripBody(r3)
            if (r2 == 0) goto L_0x0386
            r0.checkSupportResponse(r4, r2)
        L_0x0386:
            r0.networkResponse = r2
            okhttp3.Response r0 = r0.build()
            okhttp3.ResponseBody r2 = r3.body
            r2.close()
            okhttp3.internal.cache.InternalCache r2 = r5.cache
            r2.trackConditionalCacheHit()
            okhttp3.internal.cache.InternalCache r2 = r5.cache
            r2.update(r1, r0)
            return r0
        L_0x039c:
            okhttp3.ResponseBody r2 = r1.body
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x03a1:
            okhttp3.Response$Builder r2 = new okhttp3.Response$Builder
            r2.<init>(r3)
            okhttp3.Response r1 = stripBody(r1)
            r2.cacheResponse(r1)
            okhttp3.Response r1 = stripBody(r3)
            if (r1 == 0) goto L_0x03b6
            r2.checkSupportResponse(r4, r1)
        L_0x03b6:
            r2.networkResponse = r1
            okhttp3.Response r1 = r2.build()
            okhttp3.internal.cache.InternalCache r2 = r5.cache
            if (r2 == 0) goto L_0x0449
            boolean r2 = okhttp3.internal.http.HttpHeaders.hasBody(r1)
            if (r2 == 0) goto L_0x0414
            boolean r2 = okhttp3.internal.cache.CacheStrategy.isCacheable(r1, r0)
            if (r2 == 0) goto L_0x0414
            okhttp3.internal.cache.InternalCache r0 = r5.cache
            okhttp3.internal.cache.CacheRequest r0 = r0.put(r1)
            if (r0 != 0) goto L_0x03d5
            goto L_0x0413
        L_0x03d5:
            okio.Sink r2 = r0.body()
            if (r2 != 0) goto L_0x03dc
            goto L_0x0413
        L_0x03dc:
            okhttp3.ResponseBody r3 = r1.body
            okio.BufferedSource r3 = r3.source()
            okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)
            okhttp3.internal.cache.CacheInterceptor$1 r4 = new okhttp3.internal.cache.CacheInterceptor$1
            r4.<init>(r5, r3, r0, r2)
            okhttp3.Headers r0 = r1.headers
            java.lang.String r2 = "Content-Type"
            java.lang.String r0 = r0.get(r2)
            if (r0 == 0) goto L_0x03f7
            r2 = r0
            goto L_0x03f8
        L_0x03f7:
            r2 = r6
        L_0x03f8:
            okhttp3.ResponseBody r0 = r1.body
            long r6 = r0.contentLength()
            okhttp3.Response$Builder r0 = new okhttp3.Response$Builder
            r0.<init>(r1)
            okhttp3.internal.http.RealResponseBody r1 = new okhttp3.internal.http.RealResponseBody
            okio.RealBufferedSource r3 = new okio.RealBufferedSource
            r3.<init>(r4)
            r1.<init>(r2, r6, r3)
            r0.body = r1
            okhttp3.Response r1 = r0.build()
        L_0x0413:
            return r1
        L_0x0414:
            java.lang.String r2 = r0.method
            java.lang.String r3 = "POST"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x0441
            java.lang.String r3 = "PATCH"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x0441
            java.lang.String r3 = "PUT"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x0441
            java.lang.String r3 = "DELETE"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x0441
            java.lang.String r3 = "MOVE"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x043f
            goto L_0x0441
        L_0x043f:
            r7 = 0
            goto L_0x0442
        L_0x0441:
            r7 = 1
        L_0x0442:
            if (r7 == 0) goto L_0x0449
            okhttp3.internal.cache.InternalCache r2 = r5.cache     // Catch:{ IOException -> 0x0449 }
            r2.remove(r0)     // Catch:{ IOException -> 0x0449 }
        L_0x0449:
            return r1
        L_0x044a:
            r0 = move-exception
            if (r3 == 0) goto L_0x0452
            okhttp3.ResponseBody r1 = r3.body
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x0452:
            goto L_0x0454
        L_0x0453:
            throw r0
        L_0x0454:
            goto L_0x0453
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
