package okhttp3.internal.cache;

import javax.annotation.Nullable;
import okhttp3.Request;
import okhttp3.Response;

public final class CacheStrategy {
    @Nullable
    public final Response cacheResponse;
    @Nullable
    public final Request networkRequest;

    public CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        if (r3.cacheControl().isPrivate == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isCacheable(okhttp3.Response r3, okhttp3.Request r4) {
        /*
            int r0 = r3.code
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x0058
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x0058
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x0058
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x0058
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x0058
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x0058
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x002f
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x0058
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x0058
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x0058
            switch(r0) {
                case 300: goto L_0x0058;
                case 301: goto L_0x0058;
                case 302: goto L_0x002f;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x0057
        L_0x002f:
            okhttp3.Headers r0 = r3.headers
            java.lang.String r1 = "Expires"
            java.lang.String r0 = r0.get(r1)
            if (r0 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            if (r0 != 0) goto L_0x0058
            okhttp3.CacheControl r0 = r3.cacheControl()
            int r0 = r0.maxAgeSeconds
            r1 = -1
            if (r0 != r1) goto L_0x0058
            okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPublic
            if (r0 != 0) goto L_0x0058
            okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPrivate
            if (r0 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            return r2
        L_0x0058:
            okhttp3.CacheControl r3 = r3.cacheControl()
            boolean r3 = r3.noStore
            if (r3 != 0) goto L_0x0069
            okhttp3.CacheControl r3 = r4.cacheControl()
            boolean r3 = r3.noStore
            if (r3 != 0) goto L_0x0069
            r2 = 1
        L_0x0069:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.isCacheable(okhttp3.Response, okhttp3.Request):boolean");
    }
}
