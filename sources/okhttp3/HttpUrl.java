package okhttp3;

import com.facebook.internal.Utility;
import com.playrix.gplay.billing.Base64;
import com.swrve.sdk.SwrveImp;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;

public final class HttpUrl {
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    @Nullable
    public final String fragment;
    public final String host;
    public final String password;
    public final List<String> pathSegments;
    public final int port;
    @Nullable
    public final List<String> queryNamesAndValues;
    public final String scheme;
    public final String url;
    public final String username;

    public static final class Builder {
        @Nullable
        public String encodedFragment;
        public String encodedPassword = "";
        public final List<String> encodedPathSegments;
        @Nullable
        public List<String> encodedQueryNamesAndValues;
        public String encodedUsername = "";
        @Nullable
        public String host;
        public int port = -1;
        @Nullable
        public String scheme;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        public static String canonicalizeHost(String str, int i, int i2) {
            return Util.canonicalizeHost(HttpUrl.percentDecode(str, i, i2, false));
        }

        public HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.host != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public Builder encodedQuery(@Nullable String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:105:0x020d, code lost:
            if (r1 <= 65535) goto L_0x0215;
         */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x01e8  */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x0235  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x024b  */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x0299  */
        /* JADX WARNING: Removed duplicated region for block: B:164:0x0353  */
        /* JADX WARNING: Removed duplicated region for block: B:175:0x0399  */
        /* JADX WARNING: Removed duplicated region for block: B:198:0x01e1 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0123  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01c3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public okhttp3.HttpUrl.Builder parse(@javax.annotation.Nullable okhttp3.HttpUrl r22, java.lang.String r23) {
            /*
                r21 = this;
                r0 = r21
                r1 = r22
                r10 = r23
                int r2 = r23.length()
                r8 = 0
                int r9 = okhttp3.internal.Util.skipLeadingAsciiWhitespace(r10, r8, r2)
                int r2 = r23.length()
                int r11 = okhttp3.internal.Util.skipTrailingAsciiWhitespace(r10, r9, r2)
                int r2 = r11 - r9
                r12 = 2
                r13 = 58
                r14 = -1
                if (r2 >= r12) goto L_0x0020
                goto L_0x0062
            L_0x0020:
                char r2 = r10.charAt(r9)
                r3 = 90
                r4 = 122(0x7a, float:1.71E-43)
                r5 = 65
                r6 = 97
                if (r2 < r6) goto L_0x0030
                if (r2 <= r4) goto L_0x0035
            L_0x0030:
                if (r2 < r5) goto L_0x0062
                if (r2 <= r3) goto L_0x0035
                goto L_0x0062
            L_0x0035:
                r2 = r9
            L_0x0036:
                int r2 = r2 + 1
                if (r2 >= r11) goto L_0x0062
                char r7 = r10.charAt(r2)
                if (r7 < r6) goto L_0x0042
                if (r7 <= r4) goto L_0x005f
            L_0x0042:
                if (r7 < r5) goto L_0x0046
                if (r7 <= r3) goto L_0x005f
            L_0x0046:
                r3 = 48
                if (r7 < r3) goto L_0x004e
                r3 = 57
                if (r7 <= r3) goto L_0x005f
            L_0x004e:
                r3 = 43
                if (r7 == r3) goto L_0x005f
                r3 = 45
                if (r7 == r3) goto L_0x005f
                r3 = 46
                if (r7 != r3) goto L_0x005b
                goto L_0x005f
            L_0x005b:
                if (r7 != r13) goto L_0x0062
                r15 = r2
                goto L_0x0064
            L_0x005f:
                r3 = 90
                goto L_0x0036
            L_0x0062:
                r2 = -1
                r15 = -1
            L_0x0064:
                if (r15 == r14) goto L_0x00ac
                r3 = 1
                r6 = 0
                r7 = 6
                java.lang.String r5 = "https:"
                r2 = r23
                r4 = r9
                boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r2 == 0) goto L_0x007b
                java.lang.String r2 = "https"
                r0.scheme = r2
                int r9 = r9 + 6
                goto L_0x00b2
            L_0x007b:
                r3 = 1
                r6 = 0
                r7 = 5
                java.lang.String r5 = "http:"
                r2 = r23
                r4 = r9
                boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r2 == 0) goto L_0x0090
                java.lang.String r2 = "http"
                r0.scheme = r2
                int r9 = r9 + 5
                goto L_0x00b2
            L_0x0090:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Expected URL scheme 'http' or 'https' but was '"
                java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                java.lang.String r3 = r10.substring(r8, r15)
                r2.append(r3)
                java.lang.String r3 = "'"
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x00ac:
                if (r1 == 0) goto L_0x03b3
                java.lang.String r2 = r1.scheme
                r0.scheme = r2
            L_0x00b2:
                r2 = 0
                r3 = r9
            L_0x00b4:
                r4 = 47
                r5 = 92
                if (r3 >= r11) goto L_0x00c7
                char r6 = r10.charAt(r3)
                if (r6 == r5) goto L_0x00c2
                if (r6 != r4) goto L_0x00c7
            L_0x00c2:
                int r2 = r2 + 1
                int r3 = r3 + 1
                goto L_0x00b4
            L_0x00c7:
                r3 = 63
                r6 = 35
                if (r2 >= r12) goto L_0x010f
                if (r1 == 0) goto L_0x010f
                java.lang.String r7 = r1.scheme
                java.lang.String r8 = r0.scheme
                boolean r7 = r7.equals(r8)
                if (r7 != 0) goto L_0x00da
                goto L_0x010f
            L_0x00da:
                java.lang.String r2 = r22.encodedUsername()
                r0.encodedUsername = r2
                java.lang.String r2 = r22.encodedPassword()
                r0.encodedPassword = r2
                java.lang.String r2 = r1.host
                r0.host = r2
                int r2 = r1.port
                r0.port = r2
                java.util.List<java.lang.String> r2 = r0.encodedPathSegments
                r2.clear()
                java.util.List<java.lang.String> r2 = r0.encodedPathSegments
                java.util.List r3 = r22.encodedPathSegments()
                r2.addAll(r3)
                if (r9 == r11) goto L_0x0104
                char r2 = r10.charAt(r9)
                if (r2 != r6) goto L_0x010b
            L_0x0104:
                java.lang.String r1 = r22.encodedQuery()
                r0.encodedQuery(r1)
            L_0x010b:
                r17 = r11
                goto L_0x024c
            L_0x010f:
                int r9 = r9 + r2
                r1 = 0
                r2 = 0
                r14 = r9
                r1 = -1
                r12 = 0
                r15 = 0
            L_0x0116:
                java.lang.String r2 = "@/\\?#"
                int r9 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r10, (int) r14, (int) r11, (java.lang.String) r2)
                if (r9 == r11) goto L_0x0123
                char r2 = r10.charAt(r9)
                goto L_0x0124
            L_0x0123:
                r2 = -1
            L_0x0124:
                if (r2 == r1) goto L_0x01bf
                if (r2 == r6) goto L_0x01bf
                if (r2 == r4) goto L_0x01bf
                if (r2 == r5) goto L_0x01bf
                if (r2 == r3) goto L_0x01bf
                r1 = 64
                if (r2 == r1) goto L_0x0134
                goto L_0x01b2
            L_0x0134:
                java.lang.String r8 = "%40"
                if (r12 != 0) goto L_0x0182
                int r7 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r10, (int) r14, (int) r9, (char) r13)
                r5 = 1
                r6 = 0
                r16 = 0
                r17 = 1
                r18 = 0
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r1 = r23
                r2 = r14
                r3 = r7
                r14 = r7
                r7 = r16
                r13 = r8
                r8 = r17
                r22 = r12
                r12 = r9
                r9 = r18
                java.lang.String r1 = okhttp3.HttpUrl.canonicalize(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                if (r15 == 0) goto L_0x0166
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = r0.encodedUsername
                java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline19(r2, r3, r13, r1)
            L_0x0166:
                r0.encodedUsername = r1
                if (r14 == r12) goto L_0x017e
                int r2 = r14 + 1
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 1
                r9 = 0
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r1 = r23
                r3 = r12
                java.lang.String r1 = okhttp3.HttpUrl.canonicalize(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r0.encodedPassword = r1
                r1 = 1
                goto L_0x0180
            L_0x017e:
                r1 = r22
            L_0x0180:
                r15 = 1
                goto L_0x01af
            L_0x0182:
                r13 = r8
                r22 = r12
                r12 = r9
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r1 = r0.encodedPassword
                r9.append(r1)
                r9.append(r13)
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 1
                r13 = 0
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r1 = r23
                r2 = r14
                r3 = r12
                r14 = r9
                r9 = r13
                java.lang.String r1 = okhttp3.HttpUrl.canonicalize(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r14.append(r1)
                java.lang.String r1 = r14.toString()
                r0.encodedPassword = r1
                r1 = r22
            L_0x01af:
                int r14 = r12 + 1
                r12 = r1
            L_0x01b2:
                r6 = 35
                r3 = 63
                r5 = 92
                r1 = -1
                r4 = 47
                r13 = 58
                goto L_0x0116
            L_0x01bf:
                r12 = r9
                r9 = r14
            L_0x01c1:
                if (r9 >= r12) goto L_0x01e1
                char r1 = r10.charAt(r9)
                r2 = 58
                if (r1 == r2) goto L_0x01df
                r3 = 91
                if (r1 == r3) goto L_0x01d1
                r1 = 1
                goto L_0x01dd
            L_0x01d1:
                r1 = 1
            L_0x01d2:
                int r9 = r9 + r1
                if (r9 >= r12) goto L_0x01dd
                char r3 = r10.charAt(r9)
                r4 = 93
                if (r3 != r4) goto L_0x01d2
            L_0x01dd:
                int r9 = r9 + r1
                goto L_0x01c1
            L_0x01df:
                r13 = r9
                goto L_0x01e2
            L_0x01e1:
                r13 = r12
            L_0x01e2:
                int r15 = r13 + 1
                r9 = 34
                if (r15 >= r12) goto L_0x0235
                java.lang.String r1 = canonicalizeHost(r10, r14, r13)
                r0.host = r1
                java.lang.String r4 = ""
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 1
                r16 = 0
                r1 = r23
                r2 = r15
                r3 = r12
                r17 = r11
                r11 = 34
                r9 = r16
                java.lang.String r1 = okhttp3.HttpUrl.canonicalize(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ NumberFormatException -> 0x0214 }
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0214 }
                if (r1 <= 0) goto L_0x0214
                r2 = 65535(0xffff, float:9.1834E-41)
                if (r1 > r2) goto L_0x0214
                goto L_0x0215
            L_0x0210:
                r17 = r11
                r11 = 34
            L_0x0214:
                r1 = -1
            L_0x0215:
                r0.port = r1
                r2 = -1
                if (r1 == r2) goto L_0x021b
                goto L_0x0247
            L_0x021b:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Invalid URL port: \""
                java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                java.lang.String r3 = r10.substring(r15, r12)
                r2.append(r3)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0235:
                r17 = r11
                r11 = 34
                java.lang.String r1 = canonicalizeHost(r10, r14, r13)
                r0.host = r1
                java.lang.String r1 = r0.scheme
                int r1 = okhttp3.HttpUrl.defaultPort(r1)
                r0.port = r1
            L_0x0247:
                java.lang.String r1 = r0.host
                if (r1 == 0) goto L_0x0399
                r9 = r12
            L_0x024c:
                java.lang.String r1 = "?#"
                r2 = r17
                int r1 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r10, (int) r9, (int) r2, (java.lang.String) r1)
                if (r9 != r1) goto L_0x025d
                r13 = r0
                r3 = r1
                r12 = r2
                r1 = r10
                r2 = r1
                goto L_0x0356
            L_0x025d:
                char r3 = r10.charAt(r9)
                java.lang.String r4 = ""
                r5 = 47
                if (r3 == r5) goto L_0x0281
                r5 = 92
                if (r3 != r5) goto L_0x026c
                goto L_0x0281
            L_0x026c:
                java.util.List<java.lang.String> r3 = r0.encodedPathSegments
                int r5 = r3.size()
                int r5 = r5 + -1
                r3.set(r5, r4)
                r7 = r0
                r8 = r7
                r3 = r1
                r11 = r2
                r6 = r4
                r13 = r9
                r2 = r10
                r4 = r3
                r1 = r2
                goto L_0x0297
            L_0x0281:
                r3 = 1
                java.util.List<java.lang.String> r5 = r0.encodedPathSegments
                r5.clear()
                java.util.List<java.lang.String> r5 = r0.encodedPathSegments
                r5.add(r4)
                r7 = r0
                r8 = r7
                r3 = r1
                r11 = r2
                r6 = r4
                r2 = r10
                r5 = 1
                r4 = r3
                r1 = r2
            L_0x0295:
                int r9 = r9 + r5
            L_0x0296:
                r13 = r9
            L_0x0297:
                if (r13 >= r4) goto L_0x0353
                java.lang.String r5 = "/\\"
                int r9 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r1, (int) r13, (int) r4, (java.lang.String) r5)
                if (r9 >= r4) goto L_0x02a3
                r5 = 1
                goto L_0x02a4
            L_0x02a3:
                r5 = 0
            L_0x02a4:
                r16 = 1
                r17 = 0
                r18 = 0
                r19 = 1
                r20 = 0
                java.lang.String r15 = " \"<>^`{}|/\\?#"
                r12 = r1
                r14 = r9
                java.lang.String r12 = okhttp3.HttpUrl.canonicalize(r12, r13, r14, r15, r16, r17, r18, r19, r20)
                java.lang.String r13 = "."
                boolean r13 = r12.equals(r13)
                if (r13 != 0) goto L_0x02c9
                java.lang.String r13 = "%2e"
                boolean r13 = r12.equalsIgnoreCase(r13)
                if (r13 == 0) goto L_0x02c7
                goto L_0x02c9
            L_0x02c7:
                r13 = 0
                goto L_0x02ca
            L_0x02c9:
                r13 = 1
            L_0x02ca:
                if (r13 == 0) goto L_0x02ce
                goto L_0x034e
            L_0x02ce:
                java.lang.String r13 = ".."
                boolean r13 = r12.equals(r13)
                if (r13 != 0) goto L_0x02f1
                java.lang.String r13 = "%2e."
                boolean r13 = r12.equalsIgnoreCase(r13)
                if (r13 != 0) goto L_0x02f1
                java.lang.String r13 = ".%2e"
                boolean r13 = r12.equalsIgnoreCase(r13)
                if (r13 != 0) goto L_0x02f1
                java.lang.String r13 = "%2e%2e"
                boolean r13 = r12.equalsIgnoreCase(r13)
                if (r13 == 0) goto L_0x02ef
                goto L_0x02f1
            L_0x02ef:
                r13 = 0
                goto L_0x02f2
            L_0x02f1:
                r13 = 1
            L_0x02f2:
                if (r13 == 0) goto L_0x0322
                java.util.List<java.lang.String> r12 = r8.encodedPathSegments
                int r13 = r12.size()
                int r13 = r13 + -1
                java.lang.Object r12 = r12.remove(r13)
                java.lang.String r12 = (java.lang.String) r12
                boolean r12 = r12.isEmpty()
                if (r12 == 0) goto L_0x031c
                java.util.List<java.lang.String> r12 = r8.encodedPathSegments
                boolean r12 = r12.isEmpty()
                if (r12 != 0) goto L_0x031c
                java.util.List<java.lang.String> r12 = r8.encodedPathSegments
                int r13 = r12.size()
                int r13 = r13 + -1
                r12.set(r13, r6)
                goto L_0x034e
            L_0x031c:
                java.util.List<java.lang.String> r12 = r8.encodedPathSegments
                r12.add(r6)
                goto L_0x034e
            L_0x0322:
                java.util.List<java.lang.String> r13 = r8.encodedPathSegments
                int r14 = r13.size()
                int r14 = r14 + -1
                java.lang.Object r13 = r13.get(r14)
                java.lang.String r13 = (java.lang.String) r13
                boolean r13 = r13.isEmpty()
                if (r13 == 0) goto L_0x0342
                java.util.List<java.lang.String> r13 = r8.encodedPathSegments
                int r14 = r13.size()
                int r14 = r14 + -1
                r13.set(r14, r12)
                goto L_0x0347
            L_0x0342:
                java.util.List<java.lang.String> r13 = r8.encodedPathSegments
                r13.add(r12)
            L_0x0347:
                if (r5 == 0) goto L_0x034e
                java.util.List<java.lang.String> r12 = r8.encodedPathSegments
                r12.add(r6)
            L_0x034e:
                if (r5 == 0) goto L_0x0296
                r5 = 1
                goto L_0x0295
            L_0x0353:
                r13 = r7
                r1 = r10
                r12 = r11
            L_0x0356:
                if (r3 >= r12) goto L_0x037d
                char r4 = r2.charAt(r3)
                r5 = 63
                if (r4 != r5) goto L_0x037d
                r14 = 35
                int r15 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r2, (int) r3, (int) r12, (char) r14)
                int r4 = r3 + 1
                r7 = 1
                r8 = 0
                r9 = 1
                r10 = 1
                r11 = 0
                java.lang.String r6 = " \"'<>#"
                r3 = r1
                r5 = r15
                java.lang.String r3 = okhttp3.HttpUrl.canonicalize(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                java.util.List r3 = okhttp3.HttpUrl.queryStringToNamesAndValues(r3)
                r13.encodedQueryNamesAndValues = r3
                r3 = r15
                goto L_0x037f
            L_0x037d:
                r14 = 35
            L_0x037f:
                if (r3 >= r12) goto L_0x0398
                char r2 = r2.charAt(r3)
                if (r2 != r14) goto L_0x0398
                int r4 = r3 + 1
                r7 = 1
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                java.lang.String r6 = ""
                r3 = r1
                r5 = r12
                java.lang.String r1 = okhttp3.HttpUrl.canonicalize(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                r13.encodedFragment = r1
            L_0x0398:
                return r13
            L_0x0399:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Invalid URL host: \""
                java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                java.lang.String r3 = r10.substring(r14, r13)
                r2.append(r3)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x03b3:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Expected URL scheme 'http' or 'https' but no colon was found"
                r1.<init>(r2)
                goto L_0x03bc
            L_0x03bb:
                throw r1
            L_0x03bc:
                goto L_0x03bb
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.parse(okhttp3.HttpUrl, java.lang.String):okhttp3.HttpUrl$Builder");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                sb.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            if (!(this.port == -1 && this.scheme == null)) {
                int i = this.port;
                if (i == -1) {
                    i = HttpUrl.defaultPort(this.scheme);
                }
                String str3 = this.scheme;
                if (str3 == null || i != HttpUrl.defaultPort(str3)) {
                    sb.append(':');
                    sb.append(i);
                }
            }
            List<String> list = this.encodedPathSegments;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append(list.get(i2));
            }
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                HttpUrl.namesAndValuesToQueryString(sb, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }
    }

    public HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        int i = builder.port;
        this.port = i == -1 ? defaultPort(builder.scheme) : i;
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        List<String> list = builder.encodedQueryNamesAndValues;
        String str = null;
        this.queryNamesAndValues = list != null ? percentDecode(list, true) : null;
        String str2 = builder.encodedFragment;
        this.fragment = str2 != null ? percentDecode(str2, 0, str2.length(), false) : str;
        this.url = builder.toString();
    }

    public static String canonicalize(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i3 = i2;
        String str4 = str2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str3.codePointAt(i4);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str4.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !percentEncoded(str3, i4, i3)))) || (codePointAt == 43 && z3)))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str3, i, i4);
                Buffer buffer2 = null;
                while (i4 < i3) {
                    int codePointAt2 = str3.codePointAt(i4);
                    if (!z || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                        if (codePointAt2 == 43 && z3) {
                            buffer.writeUtf8(z ? "+" : "%2B");
                        } else if (codePointAt2 < 32 || codePointAt2 == 127 || ((codePointAt2 >= 128 && z4) || str4.indexOf(codePointAt2) != -1 || (codePointAt2 == 37 && (!z || (z2 && !percentEncoded(str3, i4, i3)))))) {
                            if (buffer2 == null) {
                                buffer2 = new Buffer();
                            }
                            buffer2.writeUtf8CodePoint(codePointAt2);
                            while (!buffer2.exhausted()) {
                                byte readByte = buffer2.readByte() & Base64.EQUALS_SIGN_ENC;
                                buffer.writeByte(37);
                                buffer.writeByte((int) HEX_DIGITS[(readByte >> 4) & 15]);
                                buffer.writeByte((int) HEX_DIGITS[readByte & 15]);
                            }
                        } else {
                            buffer.writeUtf8CodePoint(codePointAt2);
                        }
                    }
                    i4 += Character.charCount(codePointAt2);
                }
                return buffer.readUtf8();
            }
            i4 += Character.charCount(codePointAt);
        }
        int i5 = i;
        return str.substring(i, i2);
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals(Utility.URL_SCHEME) ? 443 : -1;
    }

    public static HttpUrl get(String str) {
        Builder builder = new Builder();
        builder.parse((HttpUrl) null, str);
        return builder.build();
    }

    public static void namesAndValuesToQueryString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    @Nullable
    public static HttpUrl parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String percentDecode(String str, boolean z) {
        return percentDecode(str, 0, str.length(), z);
    }

    public static boolean percentEncoded(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != '%' || Util.decodeHexDigit(str.charAt(i + 1)) == -1 || Util.decodeHexDigit(str.charAt(i3)) == -1) {
            return false;
        }
        return true;
    }

    public static List<String> queryStringToNamesAndValues(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        int indexOf = this.url.indexOf(64);
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, indexOf);
    }

    public String encodedPath() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        return this.url.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), "?#"));
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i = indexOf + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, i, delimiterOffset, '/');
            arrayList.add(this.url.substring(i, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    @Nullable
    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf = this.url.indexOf(63) + 1;
        String str = this.url;
        return this.url.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), '#'));
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public Builder newBuilder() {
        String str;
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        if (this.fragment == null) {
            str = null;
        } else {
            str = this.url.substring(this.url.indexOf(35) + 1);
        }
        builder.encodedFragment = str;
        return builder;
    }

    public String toString() {
        return this.url;
    }

    public URI uri() {
        Builder newBuilder = newBuilder();
        int size = newBuilder.encodedPathSegments.size();
        for (int i = 0; i < size; i++) {
            newBuilder.encodedPathSegments.set(i, canonicalize(newBuilder.encodedPathSegments.get(i), SwrveImp.EMPTY_JSON_ARRAY, true, true, false, true));
        }
        List<String> list = newBuilder.encodedQueryNamesAndValues;
        if (list != null) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str = newBuilder.encodedQueryNamesAndValues.get(i2);
                if (str != null) {
                    newBuilder.encodedQueryNamesAndValues.set(i2, canonicalize(str, "\\^`{|}", true, true, true, true));
                }
            }
        }
        String str2 = newBuilder.encodedFragment;
        if (str2 != null) {
            newBuilder.encodedFragment = canonicalize(str2, " \"#<>\\^`{|}", true, true, false, false);
        }
        String builder = newBuilder.toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final List<String> percentDecode(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? percentDecode(str, 0, str.length(), z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String percentDecode(String str, int i, int i2, boolean z) {
        int i3;
        int i4 = i;
        while (i4 < i2) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i4);
                while (i4 < i2) {
                    int codePointAt = str.codePointAt(i4);
                    if (codePointAt == 37 && (i3 = i4 + 2) < i2) {
                        int decodeHexDigit = Util.decodeHexDigit(str.charAt(i4 + 1));
                        int decodeHexDigit2 = Util.decodeHexDigit(str.charAt(i3));
                        if (!(decodeHexDigit == -1 || decodeHexDigit2 == -1)) {
                            buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                            i4 = i3;
                            i4 += Character.charCount(codePointAt);
                        }
                    } else if (codePointAt == 43 && z) {
                        buffer.writeByte(32);
                        i4 += Character.charCount(codePointAt);
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                    i4 += Character.charCount(codePointAt);
                }
                return buffer.readUtf8();
            }
            i4++;
        }
        return str.substring(i, i2);
    }

    public static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, (Charset) null);
    }
}
