package okhttp3;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Cookie {
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    public final String domain;
    public final long expiresAt;
    public final boolean hostOnly;
    public final boolean httpOnly;
    public final String name;
    public final String path;
    public final boolean persistent;
    public final boolean secure;
    public final String value;

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.hostOnly = z3;
        this.persistent = z4;
    }

    public static int dateCharacterOffset(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01b5, code lost:
        if ((r0.equals(r9) || (r0.endsWith(r9) && r0.charAt((r0.length() - r9.length()) - 1) == '.' && !okhttp3.internal.Util.VERIFY_AS_IP_ADDRESS.matcher(r0).matches())) == false) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01e5, code lost:
        if (r12 != false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01f4, code lost:
        if (r12 == false) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01f6, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d7, code lost:
        if (r19 <= 0) goto L_0x00ec;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:125:0x01fe */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02e4 A[LOOP:8: B:191:0x02e1->B:193:0x02e4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0359 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<okhttp3.Cookie> parseAll(okhttp3.HttpUrl r33, okhttp3.Headers r34) {
        /*
            r0 = r34
            java.lang.String r1 = "Set-Cookie"
            int r2 = r34.size()
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x000b:
            if (r5 >= r2) goto L_0x0029
            java.lang.String r7 = r0.name(r5)
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0026
            if (r6 != 0) goto L_0x001f
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 2
            r6.<init>(r7)
        L_0x001f:
            java.lang.String r7 = r0.value(r5)
            r6.add(r7)
        L_0x0026:
            int r5 = r5 + 1
            goto L_0x000b
        L_0x0029:
            if (r6 == 0) goto L_0x0030
            java.util.List r0 = java.util.Collections.unmodifiableList(r6)
            goto L_0x0034
        L_0x0030:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x0034:
            r1 = r0
            int r2 = r1.size()
            r5 = 0
            r6 = 0
        L_0x003b:
            if (r5 >= r2) goto L_0x035e
            java.lang.Object r0 = r1.get(r5)
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            long r8 = java.lang.System.currentTimeMillis()
            int r10 = r7.length()
            r11 = 59
            int r0 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (int) r4, (int) r10, (char) r11)
            r12 = 61
            int r13 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (int) r4, (int) r0, (char) r12)
            if (r13 != r0) goto L_0x005e
        L_0x005a:
            r7 = r33
            goto L_0x02ff
        L_0x005e:
            java.lang.String r15 = okhttp3.internal.Util.trimSubstring(r7, r4, r13)
            boolean r14 = r15.isEmpty()
            if (r14 != 0) goto L_0x0346
            int r14 = okhttp3.internal.Util.indexOfControlOrNonAscii(r15)
            r3 = -1
            if (r14 == r3) goto L_0x0071
            goto L_0x0346
        L_0x0071:
            int r13 = r13 + 1
            java.lang.String r16 = okhttp3.internal.Util.trimSubstring(r7, r13, r0)
            int r13 = okhttp3.internal.Util.indexOfControlOrNonAscii(r16)
            if (r13 == r3) goto L_0x007e
            goto L_0x005a
        L_0x007e:
            int r0 = r0 + 1
            r17 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r3 = 1
            r25 = r17
            r19 = -1
            r21 = 0
            r22 = 0
            r23 = 1
            r24 = 0
            r27 = 0
            r28 = 0
        L_0x0096:
            r29 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r31 = -9223372036854775808
            if (r0 >= r10) goto L_0x014c
            int r13 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (int) r0, (int) r10, (char) r11)
            int r14 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (int) r0, (int) r13, (char) r12)
            java.lang.String r0 = okhttp3.internal.Util.trimSubstring(r7, r0, r14)
            if (r14 >= r13) goto L_0x00b4
            int r14 = r14 + 1
            java.lang.String r14 = okhttp3.internal.Util.trimSubstring(r7, r14, r13)
            goto L_0x00b6
        L_0x00b4:
            java.lang.String r14 = ""
        L_0x00b6:
            java.lang.String r11 = "expires"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x00c7
            int r0 = r14.length()     // Catch:{ IllegalArgumentException -> 0x0146 }
            long r25 = parseExpires(r14, r4, r0)     // Catch:{ IllegalArgumentException -> 0x0146 }
            goto L_0x00f1
        L_0x00c7:
            java.lang.String r11 = "max-age"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x00f5
            long r19 = java.lang.Long.parseLong(r14)     // Catch:{ NumberFormatException -> 0x00da }
            r29 = 0
            int r0 = (r19 > r29 ? 1 : (r19 == r29 ? 0 : -1))
            if (r0 > 0) goto L_0x00f1
            goto L_0x00ec
        L_0x00da:
            r0 = move-exception
            r11 = r0
            java.lang.String r0 = "-?\\d+"
            boolean r0 = r14.matches(r0)     // Catch:{  }
            if (r0 == 0) goto L_0x00f4
            java.lang.String r0 = "-"
            boolean r0 = r14.startsWith(r0)     // Catch:{  }
            if (r0 == 0) goto L_0x00ef
        L_0x00ec:
            r19 = r31
            goto L_0x00f1
        L_0x00ef:
            r19 = r29
        L_0x00f1:
            r24 = 1
            goto L_0x0146
        L_0x00f4:
            throw r11     // Catch:{  }
        L_0x00f5:
            java.lang.String r11 = "domain"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x0126
            java.lang.String r0 = "."
            boolean r11 = r14.endsWith(r0)     // Catch:{ IllegalArgumentException -> 0x0146 }
            if (r11 != 0) goto L_0x0120
            boolean r0 = r14.startsWith(r0)     // Catch:{ IllegalArgumentException -> 0x0146 }
            if (r0 == 0) goto L_0x010f
            java.lang.String r14 = r14.substring(r3)     // Catch:{ IllegalArgumentException -> 0x0146 }
        L_0x010f:
            java.lang.String r0 = okhttp3.internal.Util.canonicalizeHost(r14)     // Catch:{ IllegalArgumentException -> 0x0146 }
            if (r0 == 0) goto L_0x011a
            r27 = r0
            r23 = 0
            goto L_0x0146
        L_0x011a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0146 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x0146 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0146 }
        L_0x0120:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0146 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x0146 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0146 }
        L_0x0126:
            java.lang.String r11 = "path"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x0131
            r28 = r14
            goto L_0x0146
        L_0x0131:
            java.lang.String r11 = "secure"
            boolean r11 = r0.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x013c
            r21 = 1
            goto L_0x0146
        L_0x013c:
            java.lang.String r11 = "httponly"
            boolean r0 = r0.equalsIgnoreCase(r11)
            if (r0 == 0) goto L_0x0146
            r22 = 1
        L_0x0146:
            int r0 = r13 + 1
            r11 = 59
            goto L_0x0096
        L_0x014c:
            int r0 = (r19 > r31 ? 1 : (r19 == r31 ? 0 : -1))
            if (r0 != 0) goto L_0x0155
            r7 = r33
            r17 = r31
            goto L_0x017f
        L_0x0155:
            r10 = -1
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x017b
            r10 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x0168
            r10 = 1000(0x3e8, double:4.94E-321)
            long r29 = r19 * r10
        L_0x0168:
            long r29 = r8 + r29
            int r0 = (r29 > r8 ? 1 : (r29 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0178
            int r0 = (r29 > r17 ? 1 : (r29 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x0173
            goto L_0x0178
        L_0x0173:
            r7 = r33
            r17 = r29
            goto L_0x017f
        L_0x0178:
            r7 = r33
            goto L_0x017f
        L_0x017b:
            r7 = r33
            r17 = r25
        L_0x017f:
            java.lang.String r0 = r7.host
            r8 = 46
            r9 = r27
            if (r9 != 0) goto L_0x0189
            r9 = r0
            goto L_0x01b9
        L_0x0189:
            boolean r10 = r0.equals(r9)
            if (r10 == 0) goto L_0x0190
            goto L_0x01b2
        L_0x0190:
            boolean r10 = r0.endsWith(r9)
            if (r10 == 0) goto L_0x01b4
            int r10 = r0.length()
            int r11 = r9.length()
            int r10 = r10 - r11
            int r10 = r10 - r3
            char r10 = r0.charAt(r10)
            if (r10 != r8) goto L_0x01b4
            java.util.regex.Pattern r10 = okhttp3.internal.Util.VERIFY_AS_IP_ADDRESS
            java.util.regex.Matcher r10 = r10.matcher(r0)
            boolean r10 = r10.matches()
            if (r10 != 0) goto L_0x01b4
        L_0x01b2:
            r10 = 1
            goto L_0x01b5
        L_0x01b4:
            r10 = 0
        L_0x01b5:
            if (r10 != 0) goto L_0x01b9
            goto L_0x02ff
        L_0x01b9:
            int r0 = r0.length()
            int r10 = r9.length()
            if (r0 == r10) goto L_0x0314
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r10 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.instance
            if (r10 == 0) goto L_0x0312
            java.lang.String r0 = java.net.IDN.toUnicode(r9)
            java.lang.String r11 = "\\."
            java.lang.String[] r11 = r0.split(r11)
            java.util.concurrent.atomic.AtomicBoolean r0 = r10.listRead
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x020f
            java.util.concurrent.atomic.AtomicBoolean r0 = r10.listRead
            boolean r0 = r0.compareAndSet(r4, r3)
            if (r0 == 0) goto L_0x020f
            r12 = 0
        L_0x01e2:
            r10.readTheList()     // Catch:{ InterruptedIOException -> 0x01fe, IOException -> 0x01ea }
            if (r12 == 0) goto L_0x021c
            goto L_0x01f6
        L_0x01e8:
            r0 = move-exception
            goto L_0x0205
        L_0x01ea:
            r0 = move-exception
            r13 = r0
            okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.PLATFORM     // Catch:{ all -> 0x01e8 }
            r14 = 5
            java.lang.String r8 = "Failed to read public suffix list"
            r0.log(r14, r8, r13)     // Catch:{ all -> 0x01e8 }
            if (r12 == 0) goto L_0x021c
        L_0x01f6:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x021c
        L_0x01fe:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x01e8 }
            r8 = 46
            r12 = 1
            goto L_0x01e2
        L_0x0205:
            if (r12 == 0) goto L_0x020e
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L_0x020e:
            throw r0
        L_0x020f:
            java.util.concurrent.CountDownLatch r0 = r10.readCompleteLatch     // Catch:{ InterruptedException -> 0x0215 }
            r0.await()     // Catch:{ InterruptedException -> 0x0215 }
            goto L_0x021c
        L_0x0215:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x021c:
            monitor-enter(r10)
            byte[] r0 = r10.publicSuffixListBytes     // Catch:{ all -> 0x030f }
            if (r0 == 0) goto L_0x0307
            monitor-exit(r10)     // Catch:{ all -> 0x030f }
            int r0 = r11.length
            byte[][] r8 = new byte[r0][]
            r12 = 0
        L_0x0226:
            int r13 = r11.length
            if (r12 >= r13) goto L_0x0236
            r13 = r11[r12]
            java.nio.charset.Charset r14 = okhttp3.internal.Util.UTF_8
            byte[] r13 = r13.getBytes(r14)
            r8[r12] = r13
            int r12 = r12 + 1
            goto L_0x0226
        L_0x0236:
            r12 = 0
        L_0x0237:
            if (r12 >= r0) goto L_0x0245
            byte[] r13 = r10.publicSuffixListBytes
            java.lang.String r13 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.binarySearchBytes(r13, r8, r12)
            if (r13 == 0) goto L_0x0242
            goto L_0x0246
        L_0x0242:
            int r12 = r12 + 1
            goto L_0x0237
        L_0x0245:
            r13 = 0
        L_0x0246:
            if (r0 <= r3) goto L_0x0263
            java.lang.Object r12 = r8.clone()
            byte[][] r12 = (byte[][]) r12
            r14 = 0
        L_0x024f:
            int r4 = r12.length
            int r4 = r4 - r3
            if (r14 >= r4) goto L_0x0263
            byte[] r4 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.WILDCARD_LABEL
            r12[r14] = r4
            byte[] r4 = r10.publicSuffixListBytes
            java.lang.String r4 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.binarySearchBytes(r4, r12, r14)
            if (r4 == 0) goto L_0x0260
            goto L_0x0264
        L_0x0260:
            int r14 = r14 + 1
            goto L_0x024f
        L_0x0263:
            r4 = 0
        L_0x0264:
            if (r4 == 0) goto L_0x0277
            r12 = 0
        L_0x0267:
            int r14 = r0 + -1
            if (r12 >= r14) goto L_0x0277
            byte[] r14 = r10.publicSuffixExceptionListBytes
            java.lang.String r14 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.binarySearchBytes(r14, r8, r12)
            if (r14 == 0) goto L_0x0274
            goto L_0x0278
        L_0x0274:
            int r12 = r12 + 1
            goto L_0x0267
        L_0x0277:
            r14 = 0
        L_0x0278:
            if (r14 == 0) goto L_0x0292
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "!"
            r0.append(r4)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "\\."
            java.lang.String[] r0 = r0.split(r4)
            goto L_0x02b5
        L_0x0292:
            if (r13 != 0) goto L_0x0299
            if (r4 != 0) goto L_0x0299
            java.lang.String[] r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.PREVAILING_RULE
            goto L_0x02b5
        L_0x0299:
            if (r13 == 0) goto L_0x02a2
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r13.split(r0)
            goto L_0x02a4
        L_0x02a2:
            java.lang.String[] r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.EMPTY_RULE
        L_0x02a4:
            if (r4 == 0) goto L_0x02ad
            java.lang.String r8 = "\\."
            java.lang.String[] r4 = r4.split(r8)
            goto L_0x02af
        L_0x02ad:
            java.lang.String[] r4 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.EMPTY_RULE
        L_0x02af:
            int r8 = r0.length
            int r10 = r4.length
            if (r8 <= r10) goto L_0x02b4
            goto L_0x02b5
        L_0x02b4:
            r0 = r4
        L_0x02b5:
            int r4 = r11.length
            int r8 = r0.length
            r10 = 33
            if (r4 != r8) goto L_0x02c6
            r4 = 0
            r8 = r0[r4]
            char r8 = r8.charAt(r4)
            if (r8 == r10) goto L_0x02c7
            r0 = 0
            goto L_0x02fd
        L_0x02c6:
            r4 = 0
        L_0x02c7:
            r8 = r0[r4]
            char r8 = r8.charAt(r4)
            if (r8 != r10) goto L_0x02d2
            int r4 = r11.length
            int r0 = r0.length
            goto L_0x02d5
        L_0x02d2:
            int r4 = r11.length
            int r0 = r0.length
            int r0 = r0 + r3
        L_0x02d5:
            int r4 = r4 - r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = "\\."
            java.lang.String[] r8 = r9.split(r8)
        L_0x02e1:
            int r10 = r8.length
            if (r4 >= r10) goto L_0x02f1
            r10 = r8[r4]
            r0.append(r10)
            r10 = 46
            r0.append(r10)
            int r4 = r4 + 1
            goto L_0x02e1
        L_0x02f1:
            int r4 = r0.length()
            int r4 = r4 - r3
            r0.deleteCharAt(r4)
            java.lang.String r0 = r0.toString()
        L_0x02fd:
            if (r0 != 0) goto L_0x0303
        L_0x02ff:
            r0 = 0
            r3 = 0
            r8 = 0
            goto L_0x034b
        L_0x0303:
            r4 = r28
            r3 = 0
            goto L_0x0317
        L_0x0307:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x030f }
            java.lang.String r1 = "Unable to load publicsuffixes.gz resource from the classpath."
            r0.<init>(r1)     // Catch:{ all -> 0x030f }
            throw r0     // Catch:{ all -> 0x030f }
        L_0x030f:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x030f }
            throw r0
        L_0x0312:
            r3 = 0
            throw r3
        L_0x0314:
            r3 = 0
            r4 = r28
        L_0x0317:
            if (r4 == 0) goto L_0x0326
            java.lang.String r0 = "/"
            boolean r0 = r4.startsWith(r0)
            if (r0 != 0) goto L_0x0322
            goto L_0x0326
        L_0x0322:
            r20 = r4
            r8 = 0
            goto L_0x033d
        L_0x0326:
            java.lang.String r0 = r33.encodedPath()
            r4 = 47
            int r4 = r0.lastIndexOf(r4)
            if (r4 == 0) goto L_0x0338
            r8 = 0
            java.lang.String r0 = r0.substring(r8, r4)
            goto L_0x033b
        L_0x0338:
            r8 = 0
            java.lang.String r0 = "/"
        L_0x033b:
            r20 = r0
        L_0x033d:
            okhttp3.Cookie r0 = new okhttp3.Cookie
            r14 = r0
            r19 = r9
            r14.<init>(r15, r16, r17, r19, r20, r21, r22, r23, r24)
            goto L_0x034b
        L_0x0346:
            r7 = r33
            r3 = 0
            r8 = 0
            r0 = r3
        L_0x034b:
            if (r0 != 0) goto L_0x034e
            goto L_0x0359
        L_0x034e:
            if (r6 != 0) goto L_0x0356
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r6 = r4
        L_0x0356:
            r6.add(r0)
        L_0x0359:
            int r5 = r5 + 1
            r4 = 0
            goto L_0x003b
        L_0x035e:
            if (r6 == 0) goto L_0x0365
            java.util.List r0 = java.util.Collections.unmodifiableList(r6)
            goto L_0x0369
        L_0x0365:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x0369:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.parseAll(okhttp3.HttpUrl, okhttp3.Headers):java.util.List");
    }

    public static long parseExpires(String str, int i, int i2) {
        int dateCharacterOffset = dateCharacterOffset(str, i, i2, false);
        Matcher matcher = TIME_PATTERN.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (dateCharacterOffset < i2) {
            int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i2, true);
            matcher.region(dateCharacterOffset, dateCharacterOffset2);
            if (i4 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                i6 = MONTH_PATTERN.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
            }
            dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int outline4 = GeneratedOutlineSupport.outline4(this.path, GeneratedOutlineSupport.outline4(this.domain, GeneratedOutlineSupport.outline4(this.value, GeneratedOutlineSupport.outline4(this.name, 527, 31), 31), 31), 31);
        long j = this.expiresAt;
        return ((((((((outline4 + ((int) (j ^ (j >>> 32)))) * 31) + (this.secure ^ true ? 1 : 0)) * 31) + (this.httpOnly ^ true ? 1 : 0)) * 31) + (this.persistent ^ true ? 1 : 0)) * 31) + (this.hostOnly ^ true ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.STANDARD_DATE_FORMAT.get().format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
