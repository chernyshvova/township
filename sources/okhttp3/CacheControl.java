package okhttp3;

import com.swrve.sdk.rest.RESTClient;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class CacheControl {
    @Nullable
    public String headerValue;
    public final boolean immutable;
    public final boolean isPrivate;
    public final boolean isPublic;
    public final int maxAgeSeconds;
    public final int maxStaleSeconds;
    public final int minFreshSeconds;
    public final boolean mustRevalidate;
    public final boolean noCache;
    public final boolean noStore;
    public final boolean noTransform;
    public final boolean onlyIfCached;
    public final int sMaxAgeSeconds;

    static {
        TimeUnit.SECONDS.toSeconds((long) Integer.MAX_VALUE);
    }

    public CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 191 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static okhttp3.CacheControl parse(okhttp3.Headers r22) {
        /*
            r0 = r22
            int r1 = r22.size()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x0150
            java.lang.String r2 = r0.name(r6)
            java.lang.String r4 = r0.value(r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0031
            if (r8 == 0) goto L_0x002f
            goto L_0x0039
        L_0x002f:
            r8 = r4
            goto L_0x003a
        L_0x0031:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0149
        L_0x0039:
            r7 = 0
        L_0x003a:
            r2 = 0
        L_0x003b:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x0149
            java.lang.String r3 = "=,;"
            int r3 = okhttp3.internal.http.HttpHeaders.skipUntil(r4, r2, r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x00a9
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x00a9
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0079
            goto L_0x00a9
        L_0x0066:
            int r0 = r4.length()
            if (r3 >= r0) goto L_0x007c
            char r0 = r4.charAt(r3)
            r5 = 32
            if (r0 == r5) goto L_0x0079
            r5 = 9
            if (r0 == r5) goto L_0x0079
            goto L_0x007c
        L_0x0079:
            int r3 = r3 + 1
            goto L_0x0066
        L_0x007c:
            int r0 = r4.length()
            if (r3 >= r0) goto L_0x0099
            char r0 = r4.charAt(r3)
            r5 = 34
            if (r0 != r5) goto L_0x0099
            int r3 = r3 + 1
            java.lang.String r0 = "\""
            int r0 = okhttp3.internal.http.HttpHeaders.skipUntil(r4, r3, r0)
            java.lang.String r3 = r4.substring(r3, r0)
            r5 = 1
            int r0 = r0 + r5
            goto L_0x00ae
        L_0x0099:
            r5 = 1
            java.lang.String r0 = ",;"
            int r0 = okhttp3.internal.http.HttpHeaders.skipUntil(r4, r3, r0)
            java.lang.String r3 = r4.substring(r3, r0)
            java.lang.String r3 = r3.trim()
            goto L_0x00ae
        L_0x00a9:
            r5 = 1
            int r3 = r3 + 1
            r0 = r3
            r3 = 0
        L_0x00ae:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00ba
            r5 = -1
            r9 = 1
            goto L_0x0144
        L_0x00ba:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c6
            r5 = -1
            r10 = 1
            goto L_0x0144
        L_0x00c6:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d5
            r5 = -1
            int r11 = okhttp3.internal.http.HttpHeaders.parseSeconds(r3, r5)
            goto L_0x0144
        L_0x00d5:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e3
            r5 = -1
            int r12 = okhttp3.internal.http.HttpHeaders.parseSeconds(r3, r5)
            goto L_0x0144
        L_0x00e3:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00ee
            r5 = -1
            r13 = 1
            goto L_0x0144
        L_0x00ee:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f9
            r5 = -1
            r14 = 1
            goto L_0x0144
        L_0x00f9:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0104
            r5 = -1
            r15 = 1
            goto L_0x0144
        L_0x0104:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0115
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = okhttp3.internal.http.HttpHeaders.parseSeconds(r3, r2)
            r5 = -1
            goto L_0x0144
        L_0x0115:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0123
            r5 = -1
            int r17 = okhttp3.internal.http.HttpHeaders.parseSeconds(r3, r5)
            goto L_0x0144
        L_0x0123:
            r5 = -1
            java.lang.String r3 = "only-if-cached"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto L_0x012f
            r18 = 1
            goto L_0x0144
        L_0x012f:
            java.lang.String r3 = "no-transform"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto L_0x013a
            r19 = 1
            goto L_0x0144
        L_0x013a:
            java.lang.String r3 = "immutable"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0144
            r20 = 1
        L_0x0144:
            r2 = r0
            r0 = r22
            goto L_0x003b
        L_0x0149:
            r5 = -1
            int r6 = r6 + 1
            r0 = r22
            goto L_0x001a
        L_0x0150:
            if (r7 != 0) goto L_0x0155
            r21 = 0
            goto L_0x0157
        L_0x0155:
            r21 = r8
        L_0x0157:
            okhttp3.CacheControl r0 = new okhttp3.CacheControl
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.parse(okhttp3.Headers):okhttp3.CacheControl");
    }

    public String toString() {
        String str = this.headerValue;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.noCache) {
                sb.append("no-cache, ");
            }
            if (this.noStore) {
                sb.append("no-store, ");
            }
            if (this.maxAgeSeconds != -1) {
                sb.append("max-age=");
                sb.append(this.maxAgeSeconds);
                sb.append(RESTClient.COMMA_SEPARATOR);
            }
            if (this.sMaxAgeSeconds != -1) {
                sb.append("s-maxage=");
                sb.append(this.sMaxAgeSeconds);
                sb.append(RESTClient.COMMA_SEPARATOR);
            }
            if (this.isPrivate) {
                sb.append("private, ");
            }
            if (this.isPublic) {
                sb.append("public, ");
            }
            if (this.mustRevalidate) {
                sb.append("must-revalidate, ");
            }
            if (this.maxStaleSeconds != -1) {
                sb.append("max-stale=");
                sb.append(this.maxStaleSeconds);
                sb.append(RESTClient.COMMA_SEPARATOR);
            }
            if (this.minFreshSeconds != -1) {
                sb.append("min-fresh=");
                sb.append(this.minFreshSeconds);
                sb.append(RESTClient.COMMA_SEPARATOR);
            }
            if (this.onlyIfCached) {
                sb.append("only-if-cached, ");
            }
            if (this.noTransform) {
                sb.append("no-transform, ");
            }
            if (this.immutable) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                str = "";
            } else {
                sb.delete(sb.length() - 2, sb.length());
                str = sb.toString();
            }
            this.headerValue = str;
        }
        return str;
    }
}
