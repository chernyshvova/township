package okhttp3.internal;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.playrix.gplay.billing.Base64;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ResponseBody EMPTY_RESPONSE;
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Comparator<String> NATURAL_ORDER = new Comparator<String>() {
        public int compare(Object obj, Object obj2) {
            return ((String) obj).compareTo((String) obj2);
        }
    };
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
    public static final Charset UTF_16_BE = Charset.forName("UTF-16BE");
    public static final ByteString UTF_16_BE_BOM = ByteString.decodeHex("feff");
    public static final Charset UTF_16_LE = Charset.forName("UTF-16LE");
    public static final ByteString UTF_16_LE_BOM = ByteString.decodeHex("fffe");
    public static final Charset UTF_32_BE = Charset.forName("UTF-32BE");
    public static final ByteString UTF_32_BE_BOM = ByteString.decodeHex("0000ffff");
    public static final Charset UTF_32_LE = Charset.forName("UTF-32LE");
    public static final ByteString UTF_32_LE_BOM = ByteString.decodeHex("ffff0000");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final ByteString UTF_8_BOM = ByteString.decodeHex("efbbbf");
    public static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    public static final Method addSuppressedExceptionMethod;

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        Method method = null;
        EMPTY_RESPONSE = ResponseBody.create((MediaType) null, bArr);
        RequestBody.create((MediaType) null, EMPTY_BYTE_ARRAY);
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
        }
        addSuppressedExceptionMethod = method;
    }

    public static AssertionError assertionError(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static Charset bomAwareCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        if (bufferedSource.rangeEquals(0, UTF_8_BOM)) {
            bufferedSource.skip((long) UTF_8_BOM.size());
            return UTF_8;
        } else if (bufferedSource.rangeEquals(0, UTF_16_BE_BOM)) {
            bufferedSource.skip((long) UTF_16_BE_BOM.size());
            return UTF_16_BE;
        } else if (bufferedSource.rangeEquals(0, UTF_16_LE_BOM)) {
            bufferedSource.skip((long) UTF_16_LE_BOM.size());
            return UTF_16_LE;
        } else if (bufferedSource.rangeEquals(0, UTF_32_BE_BOM)) {
            bufferedSource.skip((long) UTF_32_BE_BOM.size());
            return UTF_32_BE;
        } else if (!bufferedSource.rangeEquals(0, UTF_32_LE_BOM)) {
            return charset;
        } else {
            bufferedSource.skip((long) UTF_32_LE_BOM.size());
            return UTF_32_LE;
        }
    }

    public static String canonicalizeHost(String str) {
        InetAddress inetAddress;
        int i = -1;
        boolean z = true;
        int i2 = 0;
        if (str.contains(CertificateUtil.DELIMITER)) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = decodeIpv6(str, 0, str.length());
            } else {
                inetAddress = decodeIpv6(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                int i3 = 0;
                int i4 = 0;
                while (i3 < address.length) {
                    int i5 = i3;
                    while (i5 < 16 && address[i5] == 0 && address[i5 + 1] == 0) {
                        i5 += 2;
                    }
                    int i6 = i5 - i3;
                    if (i6 > i4 && i6 >= 4) {
                        i = i3;
                        i4 = i6;
                    }
                    i3 = i5 + 2;
                }
                Buffer buffer = new Buffer();
                while (i2 < address.length) {
                    if (i2 == i) {
                        buffer.writeByte(58);
                        i2 += i4;
                        if (i2 == 16) {
                            buffer.writeByte(58);
                        }
                    } else {
                        if (i2 > 0) {
                            buffer.writeByte(58);
                        }
                        buffer.writeHexadecimalUnsignedLong((long) (((address[i2] & Base64.EQUALS_SIGN_ENC) << 8) | (address[i2 + 1] & Base64.EQUALS_SIGN_ENC)));
                        i2 += 2;
                    }
                }
                return buffer.readUtf8();
            }
            throw new AssertionError(GeneratedOutlineSupport.outline17("Invalid IPv6 address: '", str, "'"));
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            int i7 = 0;
            while (true) {
                if (i7 >= lowerCase.length()) {
                    z = false;
                    break;
                }
                char charAt = lowerCase.charAt(i7);
                if (charAt <= 31) {
                    break;
                } else if (charAt >= 127) {
                    break;
                } else if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                    break;
                } else {
                    i7++;
                }
            }
            if (z) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static int checkDuration(String str, long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline16(str, " < 0"));
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline16(str, " too large."));
            } else if (millis != 0 || j <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline16(str, " too small."));
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d7, code lost:
        if (r7 == 16) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00da, code lost:
        if (r8 != -1) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00dc, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00dd, code lost:
        r1 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r1, r1);
        java.util.Arrays.fill(r3, r8, (16 - r7) + r8, (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ef, code lost:
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f6, code lost:
        throw new java.lang.AssertionError();
     */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.InetAddress decodeIpv6(java.lang.String r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r18
            r2 = 16
            byte[] r3 = new byte[r2]
            r4 = -1
            r5 = 0
            r6 = r17
            r7 = 0
            r8 = -1
            r9 = -1
        L_0x000f:
            r10 = 0
            if (r6 >= r1) goto L_0x00d5
            if (r7 != r2) goto L_0x0015
            return r10
        L_0x0015:
            int r11 = r6 + 2
            r12 = 4
            r13 = 255(0xff, float:3.57E-43)
            if (r11 > r1) goto L_0x0032
            java.lang.String r14 = "::"
            r15 = 2
            boolean r14 = r0.regionMatches(r6, r14, r5, r15)
            if (r14 == 0) goto L_0x0032
            if (r8 == r4) goto L_0x0028
            return r10
        L_0x0028:
            int r7 = r7 + 2
            r8 = r7
            if (r11 != r1) goto L_0x002f
            goto L_0x00d5
        L_0x002f:
            r9 = r11
            goto L_0x00a2
        L_0x0032:
            if (r7 == 0) goto L_0x00a1
            java.lang.String r11 = ":"
            r14 = 1
            boolean r11 = r0.regionMatches(r6, r11, r5, r14)
            if (r11 == 0) goto L_0x0041
            int r6 = r6 + 1
            goto L_0x00a1
        L_0x0041:
            java.lang.String r11 = "."
            boolean r6 = r0.regionMatches(r6, r11, r5, r14)
            if (r6 == 0) goto L_0x00a0
            int r6 = r7 + -2
            r11 = r6
        L_0x004c:
            if (r9 >= r1) goto L_0x0094
            if (r11 != r2) goto L_0x0051
            goto L_0x0097
        L_0x0051:
            if (r11 == r6) goto L_0x005e
            char r15 = r0.charAt(r9)
            r14 = 46
            if (r15 == r14) goto L_0x005c
            goto L_0x0097
        L_0x005c:
            int r9 = r9 + 1
        L_0x005e:
            r14 = r9
            r15 = 0
        L_0x0060:
            if (r14 >= r1) goto L_0x0082
            char r5 = r0.charAt(r14)
            r2 = 48
            if (r5 < r2) goto L_0x0082
            r4 = 57
            if (r5 <= r4) goto L_0x006f
            goto L_0x0082
        L_0x006f:
            if (r15 != 0) goto L_0x0074
            if (r9 == r14) goto L_0x0074
            goto L_0x0097
        L_0x0074:
            int r15 = r15 * 10
            int r15 = r15 + r5
            int r15 = r15 - r2
            if (r15 <= r13) goto L_0x007b
            goto L_0x0097
        L_0x007b:
            int r14 = r14 + 1
            r2 = 16
            r4 = -1
            r5 = 0
            goto L_0x0060
        L_0x0082:
            int r2 = r14 - r9
            if (r2 != 0) goto L_0x0087
            goto L_0x0097
        L_0x0087:
            int r2 = r11 + 1
            byte r4 = (byte) r15
            r3[r11] = r4
            r11 = r2
            r9 = r14
            r2 = 16
            r4 = -1
            r5 = 0
            r14 = 1
            goto L_0x004c
        L_0x0094:
            int r6 = r6 + r12
            if (r11 == r6) goto L_0x0099
        L_0x0097:
            r14 = 0
            goto L_0x009a
        L_0x0099:
            r14 = 1
        L_0x009a:
            if (r14 != 0) goto L_0x009d
            return r10
        L_0x009d:
            int r7 = r7 + 2
            goto L_0x00d5
        L_0x00a0:
            return r10
        L_0x00a1:
            r9 = r6
        L_0x00a2:
            r6 = r9
            r2 = 0
        L_0x00a4:
            if (r6 >= r1) goto L_0x00b8
            char r4 = r0.charAt(r6)
            int r4 = decodeHexDigit(r4)
            r5 = -1
            if (r4 != r5) goto L_0x00b2
            goto L_0x00b8
        L_0x00b2:
            int r2 = r2 << 4
            int r2 = r2 + r4
            int r6 = r6 + 1
            goto L_0x00a4
        L_0x00b8:
            int r4 = r6 - r9
            if (r4 == 0) goto L_0x00d4
            if (r4 <= r12) goto L_0x00bf
            goto L_0x00d4
        L_0x00bf:
            int r4 = r7 + 1
            int r5 = r2 >>> 8
            r5 = r5 & r13
            byte r5 = (byte) r5
            r3[r7] = r5
            int r7 = r4 + 1
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r3[r4] = r2
            r2 = 16
            r4 = -1
            r5 = 0
            goto L_0x000f
        L_0x00d4:
            return r10
        L_0x00d5:
            r0 = 16
            if (r7 == r0) goto L_0x00eb
            r1 = -1
            if (r8 != r1) goto L_0x00dd
            return r10
        L_0x00dd:
            int r1 = r7 - r8
            int r2 = 16 - r1
            java.lang.System.arraycopy(r3, r8, r3, r2, r1)
            int r2 = 16 - r7
            int r2 = r2 + r8
            r0 = 0
            java.util.Arrays.fill(r3, r8, r2, r0)
        L_0x00eb:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r3)     // Catch:{ UnknownHostException -> 0x00f0 }
            return r0
        L_0x00f0:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            goto L_0x00f7
        L_0x00f6:
            throw r0
        L_0x00f7:
            goto L_0x00f6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static boolean discard(Source source, int i, TimeUnit timeUnit) {
        try {
            return skipAll(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String hostHeader(HttpUrl httpUrl, boolean z) {
        String str;
        if (httpUrl.host.contains(CertificateUtil.DELIMITER)) {
            str = GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline24("["), httpUrl.host, "]");
        } else {
            str = httpUrl.host;
        }
        if (!z && httpUrl.port == HttpUrl.defaultPort(httpUrl.scheme)) {
            return str;
        }
        StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, CertificateUtil.DELIMITER);
        outline26.append(httpUrl.port);
        return outline26.toString();
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int indexOf(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfControlOrNonAscii(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static String[] intersect(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean nonEmptyIntersection(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean skipAll(Source source, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192) != -1) {
                buffer.clear();
            }
            if (deadlineNanoTime == RecyclerView.FOREVER_NS) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == RecyclerView.FOREVER_NS) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == RecyclerView.FOREVER_NS) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static Headers toHeaders(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        for (Header next : list) {
            Internal.instance.addLenient(builder, next.name.utf8(), next.value.utf8());
        }
        return new Headers(builder);
    }

    public static String trimSubstring(String str, int i, int i2) {
        int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i, i2);
        return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i2));
    }

    public static int delimiterOffset(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static <T> List<T> immutableList(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!isAndroidGetsocknameError(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }
}
