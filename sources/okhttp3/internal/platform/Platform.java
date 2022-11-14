package okhttp3.internal.platform;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

public class Platform {
    public static final Platform PLATFORM;
    public static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: okhttp3.internal.platform.AndroidPlatform} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: okhttp3.internal.platform.AndroidPlatform} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: okhttp3.internal.platform.Jdk9Platform} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: okhttp3.internal.platform.Platform} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: okhttp3.internal.platform.Platform} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: okhttp3.internal.platform.ConscryptPlatform} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: okhttp3.internal.platform.Platform} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: okhttp3.internal.platform.AndroidPlatform} */
    /* JADX WARNING: type inference failed for: r0v1, types: [okhttp3.internal.platform.Platform] */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        if (r0 != null) goto L_0x00bd;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007a  */
    static {
        /*
            boolean r0 = isAndroid()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0082
            okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Android10Platform.buildIfSupported()
            if (r0 == 0) goto L_0x0010
            goto L_0x00bd
        L_0x0010:
            java.lang.Class<byte[]> r0 = byte[].class
            boolean r3 = isAndroid()
            r4 = 0
            if (r3 != 0) goto L_0x001a
            goto L_0x0076
        L_0x001a:
            java.lang.String r3 = "com.android.org.conscrypt.SSLParametersImpl"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0022 }
        L_0x0020:
            r6 = r3
            goto L_0x0029
        L_0x0022:
            java.lang.String r3 = "org.apache.harmony.xnet.provider.jsse.SSLParametersImpl"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0076 }
            goto L_0x0020
        L_0x0029:
            okhttp3.internal.platform.OptionalMethod r7 = new okhttp3.internal.platform.OptionalMethod     // Catch:{ ClassNotFoundException -> 0x0076 }
            java.lang.String r3 = "setUseSessionTickets"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException -> 0x0076 }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ ClassNotFoundException -> 0x0076 }
            r5[r1] = r8     // Catch:{ ClassNotFoundException -> 0x0076 }
            r7.<init>(r4, r3, r5)     // Catch:{ ClassNotFoundException -> 0x0076 }
            okhttp3.internal.platform.OptionalMethod r8 = new okhttp3.internal.platform.OptionalMethod     // Catch:{ ClassNotFoundException -> 0x0076 }
            java.lang.String r3 = "setHostname"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException -> 0x0076 }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r5[r1] = r9     // Catch:{ ClassNotFoundException -> 0x0076 }
            r8.<init>(r4, r3, r5)     // Catch:{ ClassNotFoundException -> 0x0076 }
            java.lang.String r3 = "GMSCore_OpenSSL"
            java.security.Provider r3 = java.security.Security.getProvider(r3)     // Catch:{ ClassNotFoundException -> 0x0076 }
            if (r3 == 0) goto L_0x004c
            goto L_0x0051
        L_0x004c:
            java.lang.String r3 = "android.net.Network"
            java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0053 }
        L_0x0051:
            r3 = 1
            goto L_0x0054
        L_0x0053:
            r3 = 0
        L_0x0054:
            if (r3 == 0) goto L_0x006d
            okhttp3.internal.platform.OptionalMethod r3 = new okhttp3.internal.platform.OptionalMethod     // Catch:{ ClassNotFoundException -> 0x0076 }
            java.lang.String r5 = "getAlpnSelectedProtocol"
            java.lang.Class[] r9 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0076 }
            r3.<init>(r0, r5, r9)     // Catch:{ ClassNotFoundException -> 0x0076 }
            okhttp3.internal.platform.OptionalMethod r5 = new okhttp3.internal.platform.OptionalMethod     // Catch:{ ClassNotFoundException -> 0x0076 }
            java.lang.String r9 = "setAlpnProtocols"
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException -> 0x0076 }
            r2[r1] = r0     // Catch:{ ClassNotFoundException -> 0x0076 }
            r5.<init>(r4, r9, r2)     // Catch:{ ClassNotFoundException -> 0x0076 }
            r9 = r3
            r10 = r5
            goto L_0x006f
        L_0x006d:
            r9 = r4
            r10 = r9
        L_0x006f:
            okhttp3.internal.platform.AndroidPlatform r0 = new okhttp3.internal.platform.AndroidPlatform     // Catch:{ ClassNotFoundException -> 0x0076 }
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ ClassNotFoundException -> 0x0076 }
            goto L_0x0077
        L_0x0076:
            r0 = r4
        L_0x0077:
            if (r0 == 0) goto L_0x007a
            goto L_0x00bd
        L_0x007a:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "No platform found on Android"
            r0.<init>(r1)
            throw r0
        L_0x0082:
            java.lang.String r0 = "okhttp.platform"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.lang.String r3 = "conscrypt"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0091
            goto L_0x00a1
        L_0x0091:
            java.security.Provider[] r0 = java.security.Security.getProviders()
            r0 = r0[r1]
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "Conscrypt"
            boolean r2 = r1.equals(r0)
        L_0x00a1:
            if (r2 == 0) goto L_0x00aa
            okhttp3.internal.platform.ConscryptPlatform r0 = okhttp3.internal.platform.ConscryptPlatform.buildIfSupported()
            if (r0 == 0) goto L_0x00aa
            goto L_0x00bd
        L_0x00aa:
            okhttp3.internal.platform.Jdk9Platform r0 = okhttp3.internal.platform.Jdk9Platform.buildIfSupported()
            if (r0 == 0) goto L_0x00b1
            goto L_0x00bd
        L_0x00b1:
            okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.JdkWithJettyBootPlatform.buildIfSupported()
            if (r0 == 0) goto L_0x00b8
            goto L_0x00bd
        L_0x00b8:
            okhttp3.internal.platform.Platform r0 = new okhttp3.internal.platform.Platform
            r0.<init>()
        L_0x00bd:
            PLATFORM = r0
            java.lang.Class<okhttp3.OkHttpClient> r0 = okhttp3.OkHttpClient.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.Platform.<clinit>():void");
    }

    public static List<String> alpnProtocolNames(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.protocol);
            }
        }
        return arrayList;
    }

    public static boolean isAndroid() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) throws IOException {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public SSLContext getSSLContext() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public Object getStackTraceForCloseable(String str) {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public void log(int i, String str, @Nullable Throwable th) {
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void logCloseableLeak(String str, Object obj) {
        if (obj == null) {
            str = GeneratedOutlineSupport.outline16(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        log(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
