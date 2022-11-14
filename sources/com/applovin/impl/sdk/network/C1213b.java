package com.applovin.impl.sdk.network;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.C1311r;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.network.b */
public class C1213b {

    /* renamed from: a */
    public static final List<String> f2278a = Arrays.asList(new String[]{"5.0/i", "4.0/ad", "1.0/mediate"});

    /* renamed from: b */
    public final C1188m f2279b;

    /* renamed from: c */
    public final C1314v f2280c;

    /* renamed from: d */
    public C1215b f2281d;

    /* renamed from: com.applovin.impl.sdk.network.b$a */
    public static class C1214a {

        /* renamed from: a */
        public long f2282a;

        /* renamed from: b */
        public long f2283b;

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m2211a(long j) {
            this.f2282a = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m2213b(long j) {
            this.f2283b = j;
        }

        /* renamed from: a */
        public long mo11096a() {
            return this.f2282a;
        }

        /* renamed from: b */
        public long mo11097b() {
            return this.f2283b;
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.b$b */
    public static class C1215b {

        /* renamed from: a */
        public final long f2284a = System.currentTimeMillis();

        /* renamed from: b */
        public final String f2285b;

        /* renamed from: c */
        public final long f2286c;

        /* renamed from: d */
        public final long f2287d;

        public C1215b(String str, long j, long j2) {
            this.f2285b = str;
            this.f2286c = j;
            this.f2287d = j2;
        }

        /* renamed from: a */
        public long mo11098a() {
            return this.f2284a;
        }

        /* renamed from: b */
        public String mo11099b() {
            return this.f2285b;
        }

        /* renamed from: c */
        public long mo11100c() {
            return this.f2286c;
        }

        /* renamed from: d */
        public long mo11101d() {
            return this.f2287d;
        }

        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("RequestMeasurement{timestampMillis=");
            outline24.append(this.f2284a);
            outline24.append(", urlHostAndPathString='");
            GeneratedOutlineSupport.outline33(outline24, this.f2285b, '\'', ", responseSize=");
            outline24.append(this.f2286c);
            outline24.append(", connectionTimeMillis=");
            outline24.append(this.f2287d);
            outline24.append('}');
            return outline24.toString();
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.b$c */
    public interface C1216c<T> {
        /* renamed from: a */
        void mo10008a(int i, String str, T t);

        /* renamed from: a */
        void mo10010a(T t, int i);
    }

    public C1213b(C1188m mVar) {
        this.f2279b = mVar;
        this.f2280c = mVar.mo10922B();
    }

    /* renamed from: a */
    private int m2202a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return -1009;
        }
        if (th instanceof SocketTimeoutException) {
            return -1001;
        }
        if (th instanceof IOException) {
            return -100;
        }
        return th instanceof JSONException ? -104 : -1;
    }

    /* renamed from: a */
    private <T> T m2203a(String str, T t) throws JSONException, SAXException, ClassCastException {
        if (t == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (t instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (t instanceof C1310q) {
                return C1311r.m2643a(str, this.f2279b);
            }
            if (t instanceof String) {
                return str;
            }
            C1314v vVar = this.f2280c;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to process response of type '");
            outline24.append(t.getClass().getName());
            outline24.append("'");
            vVar.mo11376e("ConnectionManager", outline24.toString());
        }
        return t;
    }

    /* renamed from: a */
    private String m2204a(String str) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("#");
        outline24.append(str.hashCode());
        outline24.append(" \"");
        outline24.append(StringUtils.getHostAndPath(str));
        outline24.append("\"");
        return outline24.toString();
    }

    /* renamed from: a */
    private HttpURLConnection m2205a(String str, String str2, Map<String, String> map, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(i < 0 ? ((Integer) this.f2279b.mo10946a(C1085b.f1665cR)).intValue() : i);
        if (i < 0) {
            i = ((Integer) this.f2279b.mo10946a(C1085b.f1666cS)).intValue();
        }
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m2206a(int i, String str) {
        if (((Boolean) this.f2279b.mo10946a(C1085b.f1581am)).booleanValue()) {
            try {
                C1221e.m2265a(i, str, this.f2279b.mo10932L());
            } catch (Throwable th) {
                C1314v B = this.f2279b.mo10922B();
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to track response code for ");
                outline24.append(m2204a(str));
                B.mo11373b("ConnectionManager", outline24.toString(), th);
            }
        }
    }

    /* renamed from: a */
    private void m2207a(String str, String str2, int i, long j) {
        C1314v vVar = this.f2280c;
        vVar.mo11374c("ConnectionManager", "Successful " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + C1264h.m2529f(this.f2279b) + " to " + m2204a(str2));
    }

    /* renamed from: a */
    private void m2208a(String str, String str2, int i, long j, Throwable th) {
        C1314v vVar = this.f2280c;
        vVar.mo11373b("ConnectionManager", "Failed " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + C1264h.m2529f(this.f2279b) + " to " + m2204a(str2), th);
    }

    /* renamed from: a */
    public C1215b mo11094a() {
        return this.f2281d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:135:0x035d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x036b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x036c, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x036f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0381, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0382, code lost:
        r13 = r4;
        r25 = r5;
        r26 = r10;
        r10 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0274, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0275, code lost:
        r18 = r4;
        r4 = r6;
        r26 = r10;
        r7 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:99:0x028b, B:137:0x0366] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x036f A[ExcHandler: MalformedURLException (e java.net.MalformedURLException), PHI: r10 r13 r25 r26 
      PHI: (r10v22 int) = (r10v23 int), (r10v23 int), (r10v24 int), (r10v24 int), (r10v24 int), (r10v24 int), (r10v24 int), (r10v24 int), (r10v24 int), (r10v24 int) binds: [B:137:0x0366, B:138:?, B:99:0x028b, B:133:0x0354, B:134:?, B:126:0x0323, B:127:?, B:129:0x034b, B:130:?, B:106:0x02a7] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r13v13 java.io.InputStream) = (r13v14 java.io.InputStream), (r13v14 java.io.InputStream), (r13v15 java.io.InputStream), (r13v15 java.io.InputStream), (r13v15 java.io.InputStream), (r13v15 java.io.InputStream), (r13v15 java.io.InputStream), (r13v15 java.io.InputStream), (r13v15 java.io.InputStream), (r13v15 java.io.InputStream) binds: [B:137:0x0366, B:138:?, B:99:0x028b, B:133:0x0354, B:134:?, B:126:0x0323, B:127:?, B:129:0x034b, B:130:?, B:106:0x02a7] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r25v14 java.net.HttpURLConnection) = (r25v15 java.net.HttpURLConnection), (r25v15 java.net.HttpURLConnection), (r25v16 java.net.HttpURLConnection), (r25v16 java.net.HttpURLConnection), (r25v16 java.net.HttpURLConnection), (r25v16 java.net.HttpURLConnection), (r25v16 java.net.HttpURLConnection), (r25v16 java.net.HttpURLConnection), (r25v16 java.net.HttpURLConnection), (r25v16 java.net.HttpURLConnection) binds: [B:137:0x0366, B:138:?, B:99:0x028b, B:133:0x0354, B:134:?, B:126:0x0323, B:127:?, B:129:0x034b, B:130:?, B:106:0x02a7] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r26v19 java.lang.String) = (r26v20 java.lang.String), (r26v20 java.lang.String), (r26v21 java.lang.String), (r26v21 java.lang.String), (r26v21 java.lang.String), (r26v21 java.lang.String), (r26v21 java.lang.String), (r26v21 java.lang.String), (r26v21 java.lang.String), (r26v21 java.lang.String) binds: [B:137:0x0366, B:138:?, B:99:0x028b, B:133:0x0354, B:134:?, B:126:0x0323, B:127:?, B:129:0x034b, B:130:?, B:106:0x02a7] A[DONT_GENERATE, DONT_INLINE], Splitter:B:99:0x028b] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0381 A[ExcHandler: MalformedURLException (e java.net.MalformedURLException), Splitter:B:87:0x025d] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x043c A[SYNTHETIC, Splitter:B:197:0x043c] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0450 A[Catch:{ all -> 0x0468 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0465  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void mo11095a(com.applovin.impl.sdk.network.C1217c<T> r28, com.applovin.impl.sdk.network.C1213b.C1214a r29, com.applovin.impl.sdk.network.C1213b.C1216c<T> r30) {
        /*
            r27 = this;
            r8 = r27
            r7 = r29
            r9 = r30
            if (r28 == 0) goto L_0x04b3
            java.lang.String r0 = r28.mo11103a()
            java.lang.String r10 = r28.mo11106b()
            if (r0 == 0) goto L_0x04ab
            if (r10 == 0) goto L_0x04a3
            if (r9 == 0) goto L_0x049b
            java.lang.String r1 = r0.toLowerCase()
            java.lang.String r2 = "http"
            boolean r1 = r1.startsWith(r2)
            java.lang.String r11 = "ConnectionManager"
            r12 = 0
            if (r1 != 0) goto L_0x0044
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Requested postback submission to non HTTP endpoint "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = "; skipping..."
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.applovin.impl.sdk.C1314v.m2663i(r11, r0)
            r1 = -900(0xfffffffffffffc7c, float:NaN)
            r9.mo10008a(r1, r0, r12)
            return
        L_0x0044:
            com.applovin.impl.sdk.m r1 = r8.f2279b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.p027c.C1085b.f1667cT
            java.lang.Object r1 = r1.mo10946a(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x006d
            java.lang.String r1 = "https://"
            boolean r2 = r0.contains(r1)
            if (r2 != 0) goto L_0x006d
            com.applovin.impl.sdk.m r2 = r8.f2279b
            com.applovin.impl.sdk.v r2 = r2.mo10922B()
            java.lang.String r3 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r2.mo11375d(r11, r3)
            java.lang.String r2 = "http://"
            java.lang.String r0 = r0.replace(r2, r1)
        L_0x006d:
            java.util.HashMap r1 = new java.util.HashMap
            r13 = 2
            r1.<init>(r13)
            boolean r14 = r28.mo11121n()
            com.applovin.impl.sdk.m r2 = r8.f2279b
            long r2 = com.applovin.impl.sdk.utils.Utils.getServerAdjustedUnixTimestampMillis(r2)
            java.util.Map r4 = r28.mo11108c()
            if (r4 == 0) goto L_0x008d
            java.util.Map r4 = r28.mo11108c()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0093
        L_0x008d:
            int r4 = r28.mo11116i()
            if (r4 < 0) goto L_0x00e8
        L_0x0093:
            java.util.Map r4 = r28.mo11108c()
            com.applovin.impl.sdk.m r5 = r8.f2279b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r6 = com.applovin.impl.sdk.p027c.C1085b.f1734di
            java.lang.Object r5 = r5.mo10946a(r6)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r4 == 0) goto L_0x00bc
            int r6 = r28.mo11116i()
            if (r6 < 0) goto L_0x00bc
            int r6 = r28.mo11116i()
            if (r6 <= 0) goto L_0x00bc
            int r6 = r28.mo11116i()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r15 = "current_retry_attempt"
            r4.put(r15, r6)
        L_0x00bc:
            boolean r5 = r5.booleanValue()
            if (r14 == 0) goto L_0x00e4
            java.lang.String r4 = com.applovin.impl.sdk.utils.Utils.encodeUrlMap(r4, r5)
            com.applovin.impl.sdk.m r5 = r8.f2279b
            java.lang.String r5 = r5.mo11010z()
            java.lang.String r5 = com.applovin.impl.sdk.utils.C1302l.m2600a((java.lang.String) r4, (java.lang.String) r5, (long) r2)
            boolean r6 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r4)
            if (r6 == 0) goto L_0x00dd
            if (r5 != 0) goto L_0x00dd
            java.lang.String r6 = "query"
            r1.put(r6, r4)
        L_0x00dd:
            java.lang.String r4 = "p"
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.appendQueryParameter(r0, r4, r5)
            goto L_0x00e8
        L_0x00e4:
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.appendQueryParameters(r0, r4, r5)
        L_0x00e8:
            r15 = r0
            long r16 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r15)     // Catch:{ all -> 0x0432 }
            java.util.List<java.lang.String> r5 = f2278a     // Catch:{ all -> 0x0432 }
            java.lang.Boolean r0 = com.applovin.impl.sdk.utils.StringUtils.endsWith(r0, r5)     // Catch:{ all -> 0x0432 }
            com.applovin.impl.sdk.v r5 = r8.f2280c     // Catch:{ all -> 0x0432 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0432 }
            r6.<init>()     // Catch:{ all -> 0x0432 }
            java.lang.String r4 = "Sending "
            r6.append(r4)     // Catch:{ all -> 0x0432 }
            r6.append(r10)     // Catch:{ all -> 0x0432 }
            java.lang.String r4 = " request to id=#"
            r6.append(r4)     // Catch:{ all -> 0x0432 }
            int r4 = r15.hashCode()     // Catch:{ all -> 0x0432 }
            r6.append(r4)     // Catch:{ all -> 0x0432 }
            java.lang.String r4 = " \""
            r6.append(r4)     // Catch:{ all -> 0x0432 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0432 }
            if (r0 == 0) goto L_0x011f
            r0 = r15
            goto L_0x0123
        L_0x011f:
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r15)     // Catch:{ all -> 0x0432 }
        L_0x0123:
            r6.append(r0)     // Catch:{ all -> 0x0432 }
            java.lang.String r0 = "\"..."
            r6.append(r0)     // Catch:{ all -> 0x0432 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0432 }
            r5.mo11374c(r11, r0)     // Catch:{ all -> 0x0432 }
            java.util.Map r0 = r28.mo11109d()     // Catch:{ all -> 0x0432 }
            int r4 = r28.mo11117j()     // Catch:{ all -> 0x0432 }
            java.net.HttpURLConnection r5 = r8.m2205a((java.lang.String) r15, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r0, (int) r4)     // Catch:{ all -> 0x0432 }
            org.json.JSONObject r0 = r28.mo11110e()     // Catch:{ all -> 0x0429 }
            if (r0 == 0) goto L_0x0239
            if (r14 == 0) goto L_0x0171
            org.json.JSONObject r0 = r28.mo11110e()     // Catch:{ all -> 0x0168 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r4 = r8.f2279b     // Catch:{ all -> 0x0168 }
            java.lang.String r4 = r4.mo11010z()     // Catch:{ all -> 0x0168 }
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1302l.m2600a((java.lang.String) r0, (java.lang.String) r4, (long) r2)     // Catch:{ all -> 0x0168 }
            if (r0 != 0) goto L_0x0179
            java.lang.String r2 = "body"
            org.json.JSONObject r3 = r28.mo11110e()     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0168 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0168 }
            goto L_0x0179
        L_0x0168:
            r0 = move-exception
            r26 = r10
            r7 = r12
            r18 = r7
            r4 = 0
            goto L_0x0236
        L_0x0171:
            org.json.JSONObject r0 = r28.mo11110e()     // Catch:{ all -> 0x022f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x022f }
        L_0x0179:
            r2 = r0
            boolean r0 = r28.mo11122o()     // Catch:{ all -> 0x022f }
            java.lang.String r3 = "UTF-8"
            if (r0 == 0) goto L_0x01c0
            if (r2 == 0) goto L_0x01c0
            int r0 = r2.length()     // Catch:{ all -> 0x022f }
            com.applovin.impl.sdk.m r4 = r8.f2279b     // Catch:{ all -> 0x022f }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r6 = com.applovin.impl.sdk.p027c.C1085b.f1801ex     // Catch:{ all -> 0x022f }
            java.lang.Object r4 = r4.mo10946a(r6)     // Catch:{ all -> 0x022f }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x022f }
            int r4 = r4.intValue()     // Catch:{ all -> 0x022f }
            if (r0 <= r4) goto L_0x01c0
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r3)     // Catch:{ all -> 0x01a5 }
            byte[] r0 = r2.getBytes(r0)     // Catch:{ all -> 0x01a5 }
            byte[] r0 = com.applovin.impl.sdk.utils.Utils.gzip(r0)     // Catch:{ all -> 0x01a5 }
            goto L_0x01c1
        L_0x01a5:
            r0 = move-exception
            com.applovin.impl.sdk.v r4 = r8.f2280c     // Catch:{ all -> 0x022f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
            r6.<init>()     // Catch:{ all -> 0x022f }
            java.lang.String r12 = "Failed to gzip POST body for request "
            r6.append(r12)     // Catch:{ all -> 0x022f }
            java.lang.String r12 = r8.m2204a((java.lang.String) r15)     // Catch:{ all -> 0x022f }
            r6.append(r12)     // Catch:{ all -> 0x022f }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x022f }
            r4.mo11373b(r11, r6, r0)     // Catch:{ all -> 0x022f }
        L_0x01c0:
            r0 = 0
        L_0x01c1:
            com.applovin.impl.sdk.v r4 = r8.f2280c     // Catch:{ all -> 0x022f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
            r6.<init>()     // Catch:{ all -> 0x022f }
            java.lang.String r12 = "Request to "
            r6.append(r12)     // Catch:{ all -> 0x022f }
            java.lang.String r12 = r8.m2204a((java.lang.String) r15)     // Catch:{ all -> 0x022f }
            r6.append(r12)     // Catch:{ all -> 0x022f }
            java.lang.String r12 = " is "
            r6.append(r12)     // Catch:{ all -> 0x022f }
            r6.append(r2)     // Catch:{ all -> 0x022f }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x022f }
            r4.mo11372b(r11, r6)     // Catch:{ all -> 0x022f }
            java.lang.String r4 = "Content-Type"
            java.lang.String r6 = "application/json; charset=utf-8"
            r5.setRequestProperty(r4, r6)     // Catch:{ all -> 0x022f }
            r4 = 1
            r5.setDoOutput(r4)     // Catch:{ all -> 0x022f }
            boolean r4 = r28.mo11122o()     // Catch:{ all -> 0x022f }
            if (r4 == 0) goto L_0x020c
            if (r0 == 0) goto L_0x020c
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r3 = "gzip"
            r5.setRequestProperty(r2, r3)     // Catch:{ all -> 0x022f }
            int r2 = r0.length     // Catch:{ all -> 0x022f }
            r5.setFixedLengthStreamingMode(r2)     // Catch:{ all -> 0x022f }
            java.io.OutputStream r2 = r5.getOutputStream()     // Catch:{ all -> 0x022f }
            r2.write(r0)     // Catch:{ all -> 0x022f }
            r2.close()     // Catch:{ all -> 0x022f }
            goto L_0x0239
        L_0x020c:
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r3)     // Catch:{ all -> 0x022f }
            byte[] r0 = r2.getBytes(r0)     // Catch:{ all -> 0x022f }
            int r0 = r0.length     // Catch:{ all -> 0x022f }
            r5.setFixedLengthStreamingMode(r0)     // Catch:{ all -> 0x022f }
            java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ all -> 0x022f }
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x022f }
            java.io.OutputStream r4 = r5.getOutputStream()     // Catch:{ all -> 0x022f }
            java.lang.String r6 = "UTF8"
            r3.<init>(r4, r6)     // Catch:{ all -> 0x022f }
            r0.<init>(r3)     // Catch:{ all -> 0x022f }
            r0.print(r2)     // Catch:{ all -> 0x022f }
            r0.close()     // Catch:{ all -> 0x022f }
            goto L_0x0239
        L_0x022f:
            r0 = move-exception
            r26 = r10
            r4 = 0
            r7 = 0
            r18 = 0
        L_0x0236:
            r10 = r5
            goto L_0x043a
        L_0x0239:
            boolean r0 = r1.isEmpty()     // Catch:{ all -> 0x0423 }
            java.lang.String r12 = "request"
            if (r0 != 0) goto L_0x0253
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r15)     // Catch:{ all -> 0x022f }
            r1.put(r12, r0)     // Catch:{ all -> 0x022f }
            com.applovin.impl.sdk.m r0 = r8.f2279b     // Catch:{ all -> 0x022f }
            com.applovin.sdk.AppLovinEventService r0 = r0.mo11007w()     // Catch:{ all -> 0x022f }
            java.lang.String r2 = "ref"
            r0.trackEvent(r2, r1)     // Catch:{ all -> 0x022f }
        L_0x0253:
            int r6 = r5.getResponseCode()     // Catch:{ MalformedURLException -> 0x03c3, all -> 0x03b6 }
            if (r6 <= 0) goto L_0x0397
            java.io.InputStream r4 = r5.getInputStream()     // Catch:{ MalformedURLException -> 0x0390, all -> 0x0389 }
            r8.m2206a((int) r6, (java.lang.String) r15)     // Catch:{ MalformedURLException -> 0x0381, all -> 0x0372 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x0381, all -> 0x0372 }
            long r2 = r0 - r16
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 < r0) goto L_0x035f
            r0 = 400(0x190, float:5.6E-43)
            if (r6 >= r0) goto L_0x035f
            if (r7 == 0) goto L_0x027c
            r7.m2211a(r2)     // Catch:{ MalformedURLException -> 0x0381, all -> 0x0274 }
            goto L_0x027c
        L_0x0274:
            r0 = move-exception
            r18 = r4
            r4 = r6
            r26 = r10
            r7 = 0
            goto L_0x0236
        L_0x027c:
            r1 = r27
            r23 = r2
            r2 = r10
            r3 = r15
            r13 = r4
            r4 = r6
            r25 = r5
            r26 = r10
            r10 = r6
            r5 = r16
            r1.m2207a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (long) r5)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            com.applovin.impl.sdk.m r0 = r8.f2279b     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1264h.m2513a((java.io.InputStream) r13, (com.applovin.impl.sdk.C1188m) r0)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            com.applovin.impl.sdk.m r1 = r8.f2279b     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            android.content.Context r1 = r1.mo10932L()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            boolean r1 = com.applovin.impl.sdk.utils.Utils.isDspDemoApp(r1)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            if (r1 == 0) goto L_0x02be
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x02a6
            r2 = r0
            goto L_0x02a7
        L_0x02a6:
            r2 = r1
        L_0x02a7:
            org.json.JSONObject r3 = r28.mo11110e()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            if (r3 == 0) goto L_0x02b5
            org.json.JSONObject r1 = r28.mo11110e()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r1 = r1.toString()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
        L_0x02b5:
            com.applovin.impl.sdk.m r3 = r8.f2279b     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            com.applovin.impl.sdk.i r3 = r3.mo10969ag()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r3.mo10899a(r2, r15, r1)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
        L_0x02be:
            if (r0 == 0) goto L_0x0354
            com.applovin.impl.sdk.v r1 = r8.f2280c     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r1.mo11370a((java.lang.String) r11, (java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            if (r7 == 0) goto L_0x02cf
            int r1 = r0.length()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            long r1 = (long) r1     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r7.m2213b(r1)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
        L_0x02cf:
            boolean r1 = r28.mo11123p()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            if (r1 == 0) goto L_0x02e9
            com.applovin.impl.sdk.network.b$b r1 = new com.applovin.impl.sdk.network.b$b     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r20 = r28.mo11103a()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            int r2 = r0.length()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            long r2 = (long) r2     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r19 = r1
            r21 = r2
            r19.<init>(r20, r21, r23)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r8.f2281d = r1     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
        L_0x02e9:
            if (r14 == 0) goto L_0x0315
            com.applovin.impl.sdk.m r1 = r8.f2279b     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r1 = r1.mo11010z()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r1 = com.applovin.impl.sdk.utils.C1302l.m2599a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            if (r1 != 0) goto L_0x0314
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r3 = 2
            r2.<init>(r3)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r3 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r15)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r2.put(r12, r3)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r3 = "response"
            r2.put(r3, r0)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            com.applovin.impl.sdk.m r0 = r8.f2279b     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            com.applovin.sdk.AppLovinEventService r0 = r0.mo11007w()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r3 = "rdf"
            r0.trackEvent(r3, r2)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
        L_0x0314:
            r0 = r1
        L_0x0315:
            java.lang.Object r1 = r28.mo11113g()     // Catch:{ all -> 0x0322 }
            java.lang.Object r0 = r8.m2203a((java.lang.String) r0, r1)     // Catch:{ all -> 0x0322 }
            r9.mo10010a(r0, r10)     // Catch:{ all -> 0x0322 }
            goto L_0x0407
        L_0x0322:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r1.<init>()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r2 = "Unable to parse response from "
            r1.append(r2)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r2 = r8.m2204a((java.lang.String) r15)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r1.append(r2)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            java.lang.String r1 = r1.toString()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            com.applovin.impl.sdk.v r2 = r8.f2280c     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r2.mo11373b(r11, r1, r0)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            com.applovin.impl.sdk.m r0 = r8.f2279b     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            com.applovin.impl.sdk.d.g r0 = r0.mo10939T()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            com.applovin.impl.sdk.d.f r2 = com.applovin.impl.sdk.p028d.C1103f.f1931i     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r0.mo10757a(r2)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r0 = -800(0xfffffffffffffce0, float:NaN)
            r2 = 0
            r9.mo10008a(r0, r1, r2)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x0350 }
            goto L_0x0407
        L_0x0350:
            r0 = move-exception
            r7 = r2
            goto L_0x03ee
        L_0x0354:
            java.lang.Object r0 = r28.mo11113g()     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            r9.mo10010a(r0, r10)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x035d }
            goto L_0x0407
        L_0x035d:
            r0 = move-exception
            goto L_0x0379
        L_0x035f:
            r13 = r4
            r25 = r5
            r26 = r10
            r10 = r6
            r1 = 0
            r9.mo10008a(r10, r1, r1)     // Catch:{ MalformedURLException -> 0x036f, all -> 0x036b }
            goto L_0x0407
        L_0x036b:
            r0 = move-exception
            r7 = r1
            goto L_0x03ee
        L_0x036f:
            r0 = move-exception
            goto L_0x03ca
        L_0x0372:
            r0 = move-exception
            r13 = r4
            r25 = r5
            r26 = r10
            r10 = r6
        L_0x0379:
            r4 = r10
            r18 = r13
            r10 = r25
            r7 = 0
            goto L_0x043a
        L_0x0381:
            r0 = move-exception
            r13 = r4
            r25 = r5
            r26 = r10
            r10 = r6
            goto L_0x03ca
        L_0x0389:
            r0 = move-exception
            r25 = r5
            r26 = r10
            r10 = r6
            goto L_0x03b0
        L_0x0390:
            r0 = move-exception
            r25 = r5
            r26 = r10
            r10 = r6
            goto L_0x03c9
        L_0x0397:
            r25 = r5
            r26 = r10
            r10 = r6
            r7 = 0
            r1 = r27
            r2 = r26
            r3 = r15
            r4 = r10
            r5 = r16
            r1.m2208a(r2, r3, r4, r5, r7)     // Catch:{ MalformedURLException -> 0x03b4, all -> 0x03af }
            r1 = 0
            r9.mo10008a(r10, r1, r1)     // Catch:{ MalformedURLException -> 0x03b4, all -> 0x03af }
            r12 = 0
            goto L_0x0408
        L_0x03af:
            r0 = move-exception
        L_0x03b0:
            r4 = r10
            r10 = r25
            goto L_0x03be
        L_0x03b4:
            r0 = move-exception
            goto L_0x03c9
        L_0x03b6:
            r0 = move-exception
            r25 = r5
            r26 = r10
            r10 = r25
            r4 = 0
        L_0x03be:
            r7 = 0
            r18 = 0
            goto L_0x043a
        L_0x03c3:
            r0 = move-exception
            r25 = r5
            r26 = r10
            r10 = 0
        L_0x03c9:
            r13 = 0
        L_0x03ca:
            r11 = -901(0xfffffffffffffc7b, float:NaN)
            r8.m2206a((int) r11, (java.lang.String) r15)     // Catch:{ all -> 0x041a }
            java.lang.Object r1 = r28.mo11113g()     // Catch:{ all -> 0x041a }
            if (r1 == 0) goto L_0x03f4
            r1 = r27
            r2 = r26
            r3 = r15
            r4 = r10
            r5 = r16
            r7 = r0
            r1.m2208a(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x03ec }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x03ec }
            r7 = 0
            r9.mo10008a(r11, r0, r7)     // Catch:{ all -> 0x03ea }
            goto L_0x0407
        L_0x03ea:
            r0 = move-exception
            goto L_0x03ee
        L_0x03ec:
            r0 = move-exception
            r7 = 0
        L_0x03ee:
            r4 = r10
            r18 = r13
            r10 = r25
            goto L_0x043a
        L_0x03f4:
            r7 = 0
            r1 = r27
            r2 = r26
            r3 = r15
            r4 = r10
            r5 = r16
            r1.m2207a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (long) r5)     // Catch:{ all -> 0x0416 }
            java.lang.Object r0 = r28.mo11113g()     // Catch:{ all -> 0x0416 }
            r9.mo10010a(r0, r11)     // Catch:{ all -> 0x0416 }
        L_0x0407:
            r12 = r13
        L_0x0408:
            com.applovin.impl.sdk.m r0 = r8.f2279b
            com.applovin.impl.sdk.utils.Utils.close(r12, r0)
            com.applovin.impl.sdk.m r0 = r8.f2279b
            r1 = r25
            com.applovin.impl.sdk.utils.Utils.disconnect(r1, r0)
            goto L_0x048a
        L_0x0416:
            r0 = move-exception
            r1 = r25
            goto L_0x041e
        L_0x041a:
            r0 = move-exception
            r1 = r25
            r7 = 0
        L_0x041e:
            r4 = r10
            r18 = r13
            r10 = r1
            goto L_0x043a
        L_0x0423:
            r0 = move-exception
            r1 = r5
            r26 = r10
            r7 = 0
            goto L_0x042e
        L_0x0429:
            r0 = move-exception
            r1 = r5
            r26 = r10
            r7 = r12
        L_0x042e:
            r10 = r1
            r18 = r7
            goto L_0x0439
        L_0x0432:
            r0 = move-exception
            r26 = r10
            r7 = r12
            r10 = r7
            r18 = r10
        L_0x0439:
            r4 = 0
        L_0x043a:
            if (r4 != 0) goto L_0x0440
            int r4 = r8.m2202a((java.lang.Throwable) r0)     // Catch:{ all -> 0x048d }
        L_0x0440:
            r11 = r4
            r8.m2206a((int) r11, (java.lang.String) r15)     // Catch:{ all -> 0x048d }
            java.io.InputStream r1 = r10.getErrorStream()     // Catch:{ all -> 0x046a }
            com.applovin.impl.sdk.m r2 = r8.f2279b     // Catch:{ all -> 0x0468 }
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1264h.m2513a((java.io.InputStream) r1, (com.applovin.impl.sdk.C1188m) r2)     // Catch:{ all -> 0x0468 }
            if (r2 == 0) goto L_0x0465
            if (r14 == 0) goto L_0x045c
            com.applovin.impl.sdk.m r3 = r8.f2279b     // Catch:{ all -> 0x0468 }
            java.lang.String r3 = r3.mo11010z()     // Catch:{ all -> 0x0468 }
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1302l.m2599a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0468 }
        L_0x045c:
            java.lang.Object r3 = r28.mo11113g()     // Catch:{ all -> 0x0468 }
            java.lang.Object r12 = r8.m2203a((java.lang.String) r2, r3)     // Catch:{ all -> 0x0468 }
            goto L_0x0466
        L_0x0465:
            r12 = r7
        L_0x0466:
            r13 = r1
            goto L_0x046d
        L_0x0468:
            r18 = r1
        L_0x046a:
            r12 = r7
            r13 = r18
        L_0x046d:
            r1 = r27
            r2 = r26
            r3 = r15
            r4 = r11
            r5 = r16
            r7 = r0
            r1.m2208a(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x048b }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x048b }
            r9.mo10008a(r11, r0, r12)     // Catch:{ all -> 0x048b }
            com.applovin.impl.sdk.m r0 = r8.f2279b
            com.applovin.impl.sdk.utils.Utils.close(r13, r0)
            com.applovin.impl.sdk.m r0 = r8.f2279b
            com.applovin.impl.sdk.utils.Utils.disconnect(r10, r0)
        L_0x048a:
            return
        L_0x048b:
            r0 = move-exception
            goto L_0x0490
        L_0x048d:
            r0 = move-exception
            r13 = r18
        L_0x0490:
            com.applovin.impl.sdk.m r1 = r8.f2279b
            com.applovin.impl.sdk.utils.Utils.close(r13, r1)
            com.applovin.impl.sdk.m r1 = r8.f2279b
            com.applovin.impl.sdk.utils.Utils.disconnect(r10, r1)
            throw r0
        L_0x049b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No callback specified"
            r0.<init>(r1)
            throw r0
        L_0x04a3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No method specified"
            r0.<init>(r1)
            throw r0
        L_0x04ab:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No endpoint specified"
            r0.<init>(r1)
            throw r0
        L_0x04b3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No request specified"
            r0.<init>(r1)
            goto L_0x04bc
        L_0x04bb:
            throw r0
        L_0x04bc:
            goto L_0x04bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1213b.mo11095a(com.applovin.impl.sdk.network.c, com.applovin.impl.sdk.network.b$a, com.applovin.impl.sdk.network.b$c):void");
    }
}
