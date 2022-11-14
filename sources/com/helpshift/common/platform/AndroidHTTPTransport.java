package com.helpshift.common.platform;

import android.os.Build;
import com.helpshift.android.commons.downloader.HelpshiftSSLSocketFactory;
import com.helpshift.common.platform.network.HTTPTransport;
import com.helpshift.common.platform.network.Request;
import com.helpshift.common.platform.network.Response;
import com.helpshift.common.platform.network.UploadRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class AndroidHTTPTransport implements HTTPTransport {
    public static final String TAG = "Helpshift_HTTPTrnsport";

    private void closeHelpshiftSSLSocketFactorySockets(HttpsURLConnection httpsURLConnection) {
        if (Build.VERSION.SDK_INT <= 19 && httpsURLConnection != null) {
            SSLSocketFactory sSLSocketFactory = httpsURLConnection.getSSLSocketFactory();
            if (sSLSocketFactory instanceof HelpshiftSSLSocketFactory) {
                ((HelpshiftSSLSocketFactory) sSLSocketFactory).closeSockets();
            }
        }
    }

    private void fixSSLSocketProtocols(HttpsURLConnection httpsURLConnection) {
        if (Build.VERSION.SDK_INT <= 19) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("TLSv1.2");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("SSLv3");
            httpsURLConnection.setSSLSocketFactory(new HelpshiftSSLSocketFactory(httpsURLConnection.getSSLSocketFactory(), arrayList, arrayList2));
        }
    }

    private boolean isInvalidKeyForHeader(String str) {
        return "filePath".equals(str) || "originalFileName".equals(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x02c3 A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x02cb A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0107 A[SYNTHETIC, Splitter:B:69:0x0107] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x014d A[SYNTHETIC, Splitter:B:89:0x014d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.helpshift.common.platform.network.Response makeNetworkRequest(com.helpshift.common.platform.network.Request r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            java.lang.String r3 = "Error in finally closing resources"
            java.lang.String r4 = "Helpshift_HTTPTrnsport"
            java.lang.String r5 = "Network error"
            java.lang.String r7 = "https://"
            java.lang.String r8 = com.helpshift.common.domain.network.NetworkConstants.scheme     // Catch:{ UnknownHostException -> 0x02a5, SocketException -> 0x0295, SecurityException -> 0x0293, SSLPeerUnverifiedException -> 0x0283, SSLHandshakeException -> 0x0273, IOException -> 0x0263, all -> 0x025c }
            boolean r7 = r7.equals(r8)     // Catch:{ UnknownHostException -> 0x02a5, SocketException -> 0x0295, SecurityException -> 0x0293, SSLPeerUnverifiedException -> 0x0283, SSLHandshakeException -> 0x0273, IOException -> 0x0263, all -> 0x025c }
            if (r7 == 0) goto L_0x0076
            java.net.URL r7 = new java.net.URL     // Catch:{ UnknownHostException -> 0x006f, SocketException -> 0x0068, SecurityException -> 0x0066, SSLPeerUnverifiedException -> 0x005f, SSLHandshakeException -> 0x0058, IOException -> 0x0051, all -> 0x004a }
            java.lang.String r8 = r2.url     // Catch:{ UnknownHostException -> 0x006f, SocketException -> 0x0068, SecurityException -> 0x0066, SSLPeerUnverifiedException -> 0x005f, SSLHandshakeException -> 0x0058, IOException -> 0x0051, all -> 0x004a }
            r7.<init>(r8)     // Catch:{ UnknownHostException -> 0x006f, SocketException -> 0x0068, SecurityException -> 0x0066, SSLPeerUnverifiedException -> 0x005f, SSLHandshakeException -> 0x0058, IOException -> 0x0051, all -> 0x004a }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ UnknownHostException -> 0x006f, SocketException -> 0x0068, SecurityException -> 0x0066, SSLPeerUnverifiedException -> 0x005f, SSLHandshakeException -> 0x0058, IOException -> 0x0051, all -> 0x004a }
            javax.net.ssl.HttpsURLConnection r7 = (javax.net.ssl.HttpsURLConnection) r7     // Catch:{ UnknownHostException -> 0x006f, SocketException -> 0x0068, SecurityException -> 0x0066, SSLPeerUnverifiedException -> 0x005f, SSLHandshakeException -> 0x0058, IOException -> 0x0051, all -> 0x004a }
            r1.fixSSLSocketProtocols(r7)     // Catch:{ UnknownHostException -> 0x0044, SocketException -> 0x003e, SecurityException -> 0x003c, SSLPeerUnverifiedException -> 0x0036, SSLHandshakeException -> 0x0030, IOException -> 0x002a, all -> 0x0026 }
            goto L_0x0083
        L_0x0026:
            r0 = move-exception
            r2 = r0
            r6 = 0
            goto L_0x004e
        L_0x002a:
            r0 = move-exception
            r6 = r7
            r9 = 0
        L_0x002d:
            r11 = 0
            goto L_0x0240
        L_0x0030:
            r0 = move-exception
            r6 = r7
            r9 = 0
        L_0x0033:
            r11 = 0
            goto L_0x0246
        L_0x0036:
            r0 = move-exception
            r6 = r7
            r9 = 0
        L_0x0039:
            r11 = 0
            goto L_0x024c
        L_0x003c:
            r0 = move-exception
            goto L_0x003f
        L_0x003e:
            r0 = move-exception
        L_0x003f:
            r6 = r7
            r9 = 0
        L_0x0041:
            r11 = 0
            goto L_0x0254
        L_0x0044:
            r0 = move-exception
            r6 = r7
            r9 = 0
        L_0x0047:
            r11 = 0
            goto L_0x025a
        L_0x004a:
            r0 = move-exception
            r2 = r0
            r6 = 0
            r7 = 0
        L_0x004e:
            r9 = 0
            goto L_0x02b9
        L_0x0051:
            r0 = move-exception
            r7 = r0
            r6 = 0
            r9 = 0
            r11 = 0
            goto L_0x0268
        L_0x0058:
            r0 = move-exception
            r7 = r0
            r6 = 0
            r9 = 0
            r11 = 0
            goto L_0x0278
        L_0x005f:
            r0 = move-exception
            r7 = r0
            r6 = 0
            r9 = 0
            r11 = 0
            goto L_0x0288
        L_0x0066:
            r0 = move-exception
            goto L_0x0069
        L_0x0068:
            r0 = move-exception
        L_0x0069:
            r7 = r0
            r6 = 0
            r9 = 0
            r11 = 0
            goto L_0x029a
        L_0x006f:
            r0 = move-exception
            r7 = r0
            r6 = 0
            r9 = 0
            r11 = 0
            goto L_0x02aa
        L_0x0076:
            java.net.URL r7 = new java.net.URL     // Catch:{ UnknownHostException -> 0x02a5, SocketException -> 0x0295, SecurityException -> 0x0293, SSLPeerUnverifiedException -> 0x0283, SSLHandshakeException -> 0x0273, IOException -> 0x0263, all -> 0x025c }
            java.lang.String r8 = r2.url     // Catch:{ UnknownHostException -> 0x02a5, SocketException -> 0x0295, SecurityException -> 0x0293, SSLPeerUnverifiedException -> 0x0283, SSLHandshakeException -> 0x0273, IOException -> 0x0263, all -> 0x025c }
            r7.<init>(r8)     // Catch:{ UnknownHostException -> 0x02a5, SocketException -> 0x0295, SecurityException -> 0x0293, SSLPeerUnverifiedException -> 0x0283, SSLHandshakeException -> 0x0273, IOException -> 0x0263, all -> 0x025c }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ UnknownHostException -> 0x02a5, SocketException -> 0x0295, SecurityException -> 0x0293, SSLPeerUnverifiedException -> 0x0283, SSLHandshakeException -> 0x0273, IOException -> 0x0263, all -> 0x025c }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ UnknownHostException -> 0x02a5, SocketException -> 0x0295, SecurityException -> 0x0293, SSLPeerUnverifiedException -> 0x0283, SSLHandshakeException -> 0x0273, IOException -> 0x0263, all -> 0x025c }
        L_0x0083:
            com.helpshift.common.platform.network.Method r8 = r2.method     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            java.lang.String r8 = r8.name()     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            r7.setRequestMethod(r8)     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            int r8 = r2.timeout     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            r7.setConnectTimeout(r8)     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            java.util.List<com.helpshift.common.platform.network.KeyValuePair> r8 = r2.headers     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
        L_0x0097:
            boolean r9 = r8.hasNext()     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            if (r9 == 0) goto L_0x00ab
            java.lang.Object r9 = r8.next()     // Catch:{ UnknownHostException -> 0x0044, SocketException -> 0x003e, SecurityException -> 0x003c, SSLPeerUnverifiedException -> 0x0036, SSLHandshakeException -> 0x0030, IOException -> 0x002a, all -> 0x0026 }
            com.helpshift.common.platform.network.KeyValuePair r9 = (com.helpshift.common.platform.network.KeyValuePair) r9     // Catch:{ UnknownHostException -> 0x0044, SocketException -> 0x003e, SecurityException -> 0x003c, SSLPeerUnverifiedException -> 0x0036, SSLHandshakeException -> 0x0030, IOException -> 0x002a, all -> 0x0026 }
            java.lang.String r10 = r9.key     // Catch:{ UnknownHostException -> 0x0044, SocketException -> 0x003e, SecurityException -> 0x003c, SSLPeerUnverifiedException -> 0x0036, SSLHandshakeException -> 0x0030, IOException -> 0x002a, all -> 0x0026 }
            java.lang.String r9 = r9.value     // Catch:{ UnknownHostException -> 0x0044, SocketException -> 0x003e, SecurityException -> 0x003c, SSLPeerUnverifiedException -> 0x0036, SSLHandshakeException -> 0x0030, IOException -> 0x002a, all -> 0x0026 }
            r7.setRequestProperty(r10, r9)     // Catch:{ UnknownHostException -> 0x0044, SocketException -> 0x003e, SecurityException -> 0x003c, SSLPeerUnverifiedException -> 0x0036, SSLHandshakeException -> 0x0030, IOException -> 0x002a, all -> 0x0026 }
            goto L_0x0097
        L_0x00ab:
            com.helpshift.common.platform.network.Method r8 = r2.method     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            com.helpshift.common.platform.network.Method r9 = com.helpshift.common.platform.network.Method.POST     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            if (r8 == r9) goto L_0x00ba
            com.helpshift.common.platform.network.Method r8 = r2.method     // Catch:{ UnknownHostException -> 0x0044, SocketException -> 0x003e, SecurityException -> 0x003c, SSLPeerUnverifiedException -> 0x0036, SSLHandshakeException -> 0x0030, IOException -> 0x002a, all -> 0x0026 }
            com.helpshift.common.platform.network.Method r9 = com.helpshift.common.platform.network.Method.PUT     // Catch:{ UnknownHostException -> 0x0044, SocketException -> 0x003e, SecurityException -> 0x003c, SSLPeerUnverifiedException -> 0x0036, SSLHandshakeException -> 0x0030, IOException -> 0x002a, all -> 0x0026 }
            if (r8 != r9) goto L_0x00b8
            goto L_0x00ba
        L_0x00b8:
            r9 = 0
            goto L_0x00eb
        L_0x00ba:
            com.helpshift.common.platform.network.Method r8 = r2.method     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            com.helpshift.common.platform.network.Method r9 = com.helpshift.common.platform.network.Method.PUT     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            if (r8 != r9) goto L_0x00c6
            r8 = r2
            com.helpshift.common.platform.network.PUTRequest r8 = (com.helpshift.common.platform.network.PUTRequest) r8     // Catch:{ UnknownHostException -> 0x0044, SocketException -> 0x003e, SecurityException -> 0x003c, SSLPeerUnverifiedException -> 0x0036, SSLHandshakeException -> 0x0030, IOException -> 0x002a, all -> 0x0026 }
            java.lang.String r8 = r8.query     // Catch:{ UnknownHostException -> 0x0044, SocketException -> 0x003e, SecurityException -> 0x003c, SSLPeerUnverifiedException -> 0x0036, SSLHandshakeException -> 0x0030, IOException -> 0x002a, all -> 0x0026 }
            goto L_0x00cb
        L_0x00c6:
            r8 = r2
            com.helpshift.common.platform.network.POSTRequest r8 = (com.helpshift.common.platform.network.POSTRequest) r8     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            java.lang.String r8 = r8.query     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
        L_0x00cb:
            r9 = 1
            r7.setDoOutput(r9)     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            java.io.OutputStream r9 = r7.getOutputStream()     // Catch:{ UnknownHostException -> 0x0256, SocketException -> 0x0250, SecurityException -> 0x024e, SSLPeerUnverifiedException -> 0x0248, SSLHandshakeException -> 0x0242, IOException -> 0x023c, all -> 0x0235 }
            java.io.BufferedWriter r10 = new java.io.BufferedWriter     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            java.io.OutputStreamWriter r11 = new java.io.OutputStreamWriter     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            java.lang.String r12 = "UTF-8"
            r11.<init>(r9, r12)     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r10.<init>(r11)     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r10.write(r8)     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r10.flush()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r10.close()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r9.flush()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
        L_0x00eb:
            int r8 = r7.getResponseCode()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r10.<init>()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            java.util.Map r11 = r7.getHeaderFields()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            java.util.Set r12 = r11.keySet()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
        L_0x0100:
            boolean r13 = r12.hasNext()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r14 = 0
            if (r13 == 0) goto L_0x0145
            java.lang.Object r13 = r12.next()     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            boolean r15 = com.helpshift.util.StringUtils.isEmpty(r13)     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            if (r15 != 0) goto L_0x0100
            com.helpshift.common.platform.network.KeyValuePair r15 = new com.helpshift.common.platform.network.KeyValuePair     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            java.lang.Object r16 = r11.get(r13)     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            r6 = r16
            java.util.List r6 = (java.util.List) r6     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            java.lang.Object r6 = r6.get(r14)     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            r15.<init>(r13, r6)     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            r10.add(r15)     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            goto L_0x0100
        L_0x012a:
            r0 = move-exception
            r2 = r0
            r6 = 0
            goto L_0x02b9
        L_0x012f:
            r0 = move-exception
            r6 = r7
            goto L_0x002d
        L_0x0133:
            r0 = move-exception
            r6 = r7
            goto L_0x0033
        L_0x0137:
            r0 = move-exception
            r6 = r7
            goto L_0x0039
        L_0x013b:
            r0 = move-exception
            goto L_0x013e
        L_0x013d:
            r0 = move-exception
        L_0x013e:
            r6 = r7
            goto L_0x0041
        L_0x0141:
            r0 = move-exception
            r6 = r7
            goto L_0x0047
        L_0x0145:
            r6 = 200(0xc8, float:2.8E-43)
            if (r8 < r6) goto L_0x01a1
            r6 = 300(0x12c, float:4.2E-43)
            if (r8 >= r6) goto L_0x01a1
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            java.io.InputStream r12 = r7.getInputStream()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r6.<init>(r12)     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            java.lang.String r12 = "Content-Encoding"
            java.lang.Object r11 = r11.get(r12)     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            java.util.List r11 = (java.util.List) r11     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            if (r11 == 0) goto L_0x017a
            int r12 = r11.size()     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            if (r12 <= 0) goto L_0x017a
            java.lang.Object r11 = r11.get(r14)     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            java.lang.String r12 = "gzip"
            boolean r11 = r11.equalsIgnoreCase(r12)     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            if (r11 == 0) goto L_0x017a
            java.util.zip.GZIPInputStream r11 = new java.util.zip.GZIPInputStream     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            r11.<init>(r6)     // Catch:{ UnknownHostException -> 0x0141, SocketException -> 0x013d, SecurityException -> 0x013b, SSLPeerUnverifiedException -> 0x0137, SSLHandshakeException -> 0x0133, IOException -> 0x012f, all -> 0x012a }
            r6 = r11
        L_0x017a:
            java.lang.String r11 = r1.readInputStream(r6)     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r6.close()     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            com.helpshift.common.platform.network.Response r6 = new com.helpshift.common.platform.network.Response     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r6.<init>(r8, r11, r10)     // Catch:{ UnknownHostException -> 0x0231, SocketException -> 0x022d, SecurityException -> 0x022b, SSLPeerUnverifiedException -> 0x0227, SSLHandshakeException -> 0x0223, IOException -> 0x021f, all -> 0x021a }
            r11 = 0
            com.helpshift.util.IOUtils.closeQuitely(r11)
            com.helpshift.util.IOUtils.closeQuitely(r9)
            boolean r2 = r7 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x019b }
            if (r2 == 0) goto L_0x0197
            r2 = r7
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ Exception -> 0x019b }
            r1.closeHelpshiftSSLSocketFactorySockets(r2)     // Catch:{ Exception -> 0x019b }
        L_0x0197:
            r7.disconnect()     // Catch:{ Exception -> 0x019b }
            goto L_0x01a0
        L_0x019b:
            r0 = move-exception
            r2 = r0
            com.helpshift.util.HSLogger.m3242e(r4, r3, r2)
        L_0x01a0:
            return r6
        L_0x01a1:
            r11 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            r6.<init>()     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            java.lang.String r12 = "Api : "
            r6.append(r12)     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            java.lang.String r12 = r2.url     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            r6.append(r12)     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            java.lang.String r12 = " \t Status : "
            r6.append(r12)     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            r6.append(r8)     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            java.lang.String r12 = "\t Thread : "
            r6.append(r12)     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            java.lang.Thread r12 = java.lang.Thread.currentThread()     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            java.lang.String r12 = r12.getName()     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            r6.append(r12)     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            java.lang.String r6 = r6.toString()     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            com.helpshift.util.HSLogger.m3237d(r4, r6)     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            java.io.InputStream r6 = r7.getErrorStream()     // Catch:{ UnknownHostException -> 0x0218, SocketException -> 0x0216, SecurityException -> 0x0214, SSLPeerUnverifiedException -> 0x0212, SSLHandshakeException -> 0x0210, IOException -> 0x020e, all -> 0x020c }
            java.lang.String r11 = r1.readInputStream(r6)     // Catch:{ UnknownHostException -> 0x0209, SocketException -> 0x0206, SecurityException -> 0x0204, SSLPeerUnverifiedException -> 0x0201, SSLHandshakeException -> 0x01fe, IOException -> 0x01fb, all -> 0x01f7 }
            com.helpshift.common.platform.network.Response r12 = new com.helpshift.common.platform.network.Response     // Catch:{ UnknownHostException -> 0x0209, SocketException -> 0x0206, SecurityException -> 0x0204, SSLPeerUnverifiedException -> 0x0201, SSLHandshakeException -> 0x01fe, IOException -> 0x01fb, all -> 0x01f7 }
            r12.<init>(r8, r11, r10)     // Catch:{ UnknownHostException -> 0x0209, SocketException -> 0x0206, SecurityException -> 0x0204, SSLPeerUnverifiedException -> 0x0201, SSLHandshakeException -> 0x01fe, IOException -> 0x01fb, all -> 0x01f7 }
            com.helpshift.util.IOUtils.closeQuitely(r6)
            com.helpshift.util.IOUtils.closeQuitely(r9)
            boolean r2 = r7 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x01f1 }
            if (r2 == 0) goto L_0x01ed
            r2 = r7
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ Exception -> 0x01f1 }
            r1.closeHelpshiftSSLSocketFactorySockets(r2)     // Catch:{ Exception -> 0x01f1 }
        L_0x01ed:
            r7.disconnect()     // Catch:{ Exception -> 0x01f1 }
            goto L_0x01f6
        L_0x01f1:
            r0 = move-exception
            r2 = r0
            com.helpshift.util.HSLogger.m3242e(r4, r3, r2)
        L_0x01f6:
            return r12
        L_0x01f7:
            r0 = move-exception
            r2 = r0
            goto L_0x02b9
        L_0x01fb:
            r0 = move-exception
            r11 = r6
            goto L_0x0221
        L_0x01fe:
            r0 = move-exception
            r11 = r6
            goto L_0x0225
        L_0x0201:
            r0 = move-exception
            r11 = r6
            goto L_0x0229
        L_0x0204:
            r0 = move-exception
            goto L_0x0207
        L_0x0206:
            r0 = move-exception
        L_0x0207:
            r11 = r6
            goto L_0x022f
        L_0x0209:
            r0 = move-exception
            r11 = r6
            goto L_0x0233
        L_0x020c:
            r0 = move-exception
            goto L_0x021c
        L_0x020e:
            r0 = move-exception
            goto L_0x0221
        L_0x0210:
            r0 = move-exception
            goto L_0x0225
        L_0x0212:
            r0 = move-exception
            goto L_0x0229
        L_0x0214:
            r0 = move-exception
            goto L_0x022f
        L_0x0216:
            r0 = move-exception
            goto L_0x022f
        L_0x0218:
            r0 = move-exception
            goto L_0x0233
        L_0x021a:
            r0 = move-exception
            r11 = 0
        L_0x021c:
            r2 = r0
            goto L_0x02b8
        L_0x021f:
            r0 = move-exception
            r11 = 0
        L_0x0221:
            r6 = r7
            goto L_0x0240
        L_0x0223:
            r0 = move-exception
            r11 = 0
        L_0x0225:
            r6 = r7
            goto L_0x0246
        L_0x0227:
            r0 = move-exception
            r11 = 0
        L_0x0229:
            r6 = r7
            goto L_0x024c
        L_0x022b:
            r0 = move-exception
            goto L_0x022e
        L_0x022d:
            r0 = move-exception
        L_0x022e:
            r11 = 0
        L_0x022f:
            r6 = r7
            goto L_0x0254
        L_0x0231:
            r0 = move-exception
            r11 = 0
        L_0x0233:
            r6 = r7
            goto L_0x025a
        L_0x0235:
            r0 = move-exception
            r11 = 0
            r2 = r0
            r6 = r11
            r9 = r6
            goto L_0x02b9
        L_0x023c:
            r0 = move-exception
            r11 = 0
            r6 = r7
            r9 = r11
        L_0x0240:
            r7 = r0
            goto L_0x0268
        L_0x0242:
            r0 = move-exception
            r11 = 0
            r6 = r7
            r9 = r11
        L_0x0246:
            r7 = r0
            goto L_0x0278
        L_0x0248:
            r0 = move-exception
            r11 = 0
            r6 = r7
            r9 = r11
        L_0x024c:
            r7 = r0
            goto L_0x0288
        L_0x024e:
            r0 = move-exception
            goto L_0x0251
        L_0x0250:
            r0 = move-exception
        L_0x0251:
            r11 = 0
            r6 = r7
            r9 = r11
        L_0x0254:
            r7 = r0
            goto L_0x029a
        L_0x0256:
            r0 = move-exception
            r11 = 0
            r6 = r7
            r9 = r11
        L_0x025a:
            r7 = r0
            goto L_0x02aa
        L_0x025c:
            r0 = move-exception
            r11 = 0
            r2 = r0
            r6 = r11
            r7 = r6
            r9 = r7
            goto L_0x02b9
        L_0x0263:
            r0 = move-exception
            r11 = 0
            r7 = r0
            r6 = r11
            r9 = r6
        L_0x0268:
            com.helpshift.common.exception.NetworkException r8 = com.helpshift.common.exception.NetworkException.GENERIC     // Catch:{ all -> 0x02b5 }
            java.lang.String r2 = r2.url     // Catch:{ all -> 0x02b5 }
            r8.route = r2     // Catch:{ all -> 0x02b5 }
            com.helpshift.common.exception.RootAPIException r2 = com.helpshift.common.exception.RootAPIException.wrap(r7, r8, r5)     // Catch:{ all -> 0x02b5 }
            throw r2     // Catch:{ all -> 0x02b5 }
        L_0x0273:
            r0 = move-exception
            r11 = 0
            r7 = r0
            r6 = r11
            r9 = r6
        L_0x0278:
            com.helpshift.common.exception.NetworkException r8 = com.helpshift.common.exception.NetworkException.SSL_HANDSHAKE     // Catch:{ all -> 0x02b5 }
            java.lang.String r2 = r2.url     // Catch:{ all -> 0x02b5 }
            r8.route = r2     // Catch:{ all -> 0x02b5 }
            com.helpshift.common.exception.RootAPIException r2 = com.helpshift.common.exception.RootAPIException.wrap(r7, r8, r5)     // Catch:{ all -> 0x02b5 }
            throw r2     // Catch:{ all -> 0x02b5 }
        L_0x0283:
            r0 = move-exception
            r11 = 0
            r7 = r0
            r6 = r11
            r9 = r6
        L_0x0288:
            com.helpshift.common.exception.NetworkException r8 = com.helpshift.common.exception.NetworkException.SSL_PEER_UNVERIFIED     // Catch:{ all -> 0x02b5 }
            java.lang.String r2 = r2.url     // Catch:{ all -> 0x02b5 }
            r8.route = r2     // Catch:{ all -> 0x02b5 }
            com.helpshift.common.exception.RootAPIException r2 = com.helpshift.common.exception.RootAPIException.wrap(r7, r8, r5)     // Catch:{ all -> 0x02b5 }
            throw r2     // Catch:{ all -> 0x02b5 }
        L_0x0293:
            r0 = move-exception
            goto L_0x0296
        L_0x0295:
            r0 = move-exception
        L_0x0296:
            r11 = 0
            r7 = r0
            r6 = r11
            r9 = r6
        L_0x029a:
            com.helpshift.common.exception.NetworkException r8 = com.helpshift.common.exception.NetworkException.NO_CONNECTION     // Catch:{ all -> 0x02b5 }
            java.lang.String r2 = r2.url     // Catch:{ all -> 0x02b5 }
            r8.route = r2     // Catch:{ all -> 0x02b5 }
            com.helpshift.common.exception.RootAPIException r2 = com.helpshift.common.exception.RootAPIException.wrap(r7, r8, r5)     // Catch:{ all -> 0x02b5 }
            throw r2     // Catch:{ all -> 0x02b5 }
        L_0x02a5:
            r0 = move-exception
            r11 = 0
            r7 = r0
            r6 = r11
            r9 = r6
        L_0x02aa:
            com.helpshift.common.exception.NetworkException r8 = com.helpshift.common.exception.NetworkException.UNKNOWN_HOST     // Catch:{ all -> 0x02b5 }
            java.lang.String r2 = r2.url     // Catch:{ all -> 0x02b5 }
            r8.route = r2     // Catch:{ all -> 0x02b5 }
            com.helpshift.common.exception.RootAPIException r2 = com.helpshift.common.exception.RootAPIException.wrap(r7, r8, r5)     // Catch:{ all -> 0x02b5 }
            throw r2     // Catch:{ all -> 0x02b5 }
        L_0x02b5:
            r0 = move-exception
            r2 = r0
            r7 = r6
        L_0x02b8:
            r6 = r11
        L_0x02b9:
            com.helpshift.util.IOUtils.closeQuitely(r6)
            com.helpshift.util.IOUtils.closeQuitely(r9)
            boolean r5 = r7 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x02cf }
            if (r5 == 0) goto L_0x02c9
            r5 = r7
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ Exception -> 0x02cf }
            r1.closeHelpshiftSSLSocketFactorySockets(r5)     // Catch:{ Exception -> 0x02cf }
        L_0x02c9:
            if (r7 == 0) goto L_0x02d4
            r7.disconnect()     // Catch:{ Exception -> 0x02cf }
            goto L_0x02d4
        L_0x02cf:
            r0 = move-exception
            r5 = r0
            com.helpshift.util.HSLogger.m3242e(r4, r3, r5)
        L_0x02d4:
            goto L_0x02d6
        L_0x02d5:
            throw r2
        L_0x02d6:
            goto L_0x02d5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.platform.AndroidHTTPTransport.makeNetworkRequest(com.helpshift.common.platform.network.Request):com.helpshift.common.platform.network.Response");
    }

    private String readInputStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                inputStreamReader.close();
                return sb.toString();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v28, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v35, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v14, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v46, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v34, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v24, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v25, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v41, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v63, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v31, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v36, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v49, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v73, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v56, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v79, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v84, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v36, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v94, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v76, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v95, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v77, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v37, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v96, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v42, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v85, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v91, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v38, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v39, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v40, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v41, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v42, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v43, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v82, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX WARNING: type inference failed for: r7v78 */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x03b3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x03b5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x03b6, code lost:
        r3 = r0;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x03c0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x03c1, code lost:
        r3 = r0;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x03cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x03ce, code lost:
        r3 = r0;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x03d8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x03d9, code lost:
        r3 = r0;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x03e3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x03e4, code lost:
        r10 = null;
        r2 = r0;
        r7 = null;
        r16 = null;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x044c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x044d, code lost:
        r10 = null;
        r3 = r0;
        r8 = "Upload error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0451, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0452, code lost:
        r10 = null;
        r3 = r0;
        r8 = "Upload error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0456, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0459, code lost:
        r10 = null;
        r3 = r0;
        r8 = "Upload error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x045e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x045f, code lost:
        r10 = null;
        r3 = r0;
        r8 = "Upload error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0464, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0465, code lost:
        r10 = null;
        r2 = r0;
        r7 = null;
        r8 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x046e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x046f, code lost:
        r17 = "Upload error";
        r10 = null;
        r3 = r0;
        r7 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0173, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0174, code lost:
        r2 = r0;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0179, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x017a, code lost:
        r3 = r0;
        r17 = "Upload error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0181, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0182, code lost:
        r3 = r0;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0187, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0188, code lost:
        r3 = r0;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x018d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0190, code lost:
        r3 = r0;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0195, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0196, code lost:
        r3 = r0;
        r7 = r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x03e3 A[ExcHandler: all (r0v26 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:62:0x00e9] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0464 A[ExcHandler: all (r0v9 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x000c] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x046e A[ExcHandler: Exception (r0v8 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x000c] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x04ef A[SYNTHETIC, Splitter:B:298:0x04ef] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0173 A[ExcHandler: all (r0v75 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:67:0x0100] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.helpshift.common.platform.network.Response upload(com.helpshift.common.platform.network.UploadRequest r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "--*****\r\n"
            java.lang.String r4 = "Error in finally closing resources"
            java.lang.String r5 = "Helpshift_HTTPTrnsport"
            java.lang.String r6 = "Upload error"
            java.net.URL r8 = new java.net.URL     // Catch:{ UnknownHostException -> 0x04c3, SocketException -> 0x04af, SecurityException -> 0x04ad, SSLPeerUnverifiedException -> 0x0499, SSLHandshakeException -> 0x0485, Exception -> 0x046e, all -> 0x0464 }
            java.lang.String r9 = r2.url     // Catch:{ UnknownHostException -> 0x045e, SocketException -> 0x0458, SecurityException -> 0x0456, SSLPeerUnverifiedException -> 0x0451, SSLHandshakeException -> 0x044c, Exception -> 0x046e, all -> 0x0464 }
            r8.<init>(r9)     // Catch:{ UnknownHostException -> 0x045e, SocketException -> 0x0458, SecurityException -> 0x0456, SSLPeerUnverifiedException -> 0x0451, SSLHandshakeException -> 0x044c, Exception -> 0x046e, all -> 0x0464 }
            java.lang.String r9 = "\r\n"
            java.lang.String r10 = "https://"
            java.lang.String r11 = com.helpshift.common.domain.network.NetworkConstants.scheme     // Catch:{ UnknownHostException -> 0x045e, SocketException -> 0x0458, SecurityException -> 0x0456, SSLPeerUnverifiedException -> 0x0451, SSLHandshakeException -> 0x044c, Exception -> 0x046e, all -> 0x0464 }
            boolean r10 = r10.equals(r11)     // Catch:{ UnknownHostException -> 0x045e, SocketException -> 0x0458, SecurityException -> 0x0456, SSLPeerUnverifiedException -> 0x0451, SSLHandshakeException -> 0x044c, Exception -> 0x046e, all -> 0x0464 }
            if (r10 == 0) goto L_0x00a2
            java.net.URLConnection r8 = r8.openConnection()     // Catch:{ UnknownHostException -> 0x0097, SocketException -> 0x008c, SecurityException -> 0x008a, SSLPeerUnverifiedException -> 0x007f, SSLHandshakeException -> 0x0074, Exception -> 0x0068, all -> 0x005e }
            javax.net.ssl.HttpsURLConnection r8 = (javax.net.ssl.HttpsURLConnection) r8     // Catch:{ UnknownHostException -> 0x0097, SocketException -> 0x008c, SecurityException -> 0x008a, SSLPeerUnverifiedException -> 0x007f, SSLHandshakeException -> 0x0074, Exception -> 0x0068, all -> 0x005e }
            r1.fixSSLSocketProtocols(r8)     // Catch:{ UnknownHostException -> 0x0054, SocketException -> 0x004a, SecurityException -> 0x0048, SSLPeerUnverifiedException -> 0x003e, SSLHandshakeException -> 0x0034, Exception -> 0x002e, all -> 0x002a }
            goto L_0x00a8
        L_0x002a:
            r0 = move-exception
            r2 = r0
            r7 = 0
            goto L_0x0062
        L_0x002e:
            r0 = move-exception
            r3 = r0
            r17 = r6
            r7 = r8
            goto L_0x006d
        L_0x0034:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r10 = 0
            r11 = 0
        L_0x0039:
            r12 = 0
            r16 = 0
            goto L_0x0426
        L_0x003e:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r10 = 0
            r11 = 0
        L_0x0043:
            r12 = 0
            r16 = 0
            goto L_0x0431
        L_0x0048:
            r0 = move-exception
            goto L_0x004b
        L_0x004a:
            r0 = move-exception
        L_0x004b:
            r3 = r0
            r7 = r8
            r10 = 0
            r11 = 0
        L_0x004f:
            r12 = 0
            r16 = 0
            goto L_0x043e
        L_0x0054:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r10 = 0
            r11 = 0
        L_0x0059:
            r12 = 0
            r16 = 0
            goto L_0x0449
        L_0x005e:
            r0 = move-exception
            r2 = r0
            r7 = 0
            r8 = 0
        L_0x0062:
            r10 = 0
            r11 = 0
        L_0x0064:
            r16 = 0
            goto L_0x04e1
        L_0x0068:
            r0 = move-exception
            r3 = r0
            r17 = r6
            r7 = 0
        L_0x006d:
            r10 = 0
            r11 = 0
        L_0x006f:
            r12 = 0
        L_0x0070:
            r16 = 0
            goto L_0x0478
        L_0x0074:
            r0 = move-exception
            r3 = r0
            r8 = r6
            r7 = 0
            r10 = 0
            r11 = 0
        L_0x007a:
            r12 = 0
        L_0x007b:
            r16 = 0
            goto L_0x048e
        L_0x007f:
            r0 = move-exception
            r3 = r0
            r8 = r6
            r7 = 0
            r10 = 0
            r11 = 0
        L_0x0085:
            r12 = 0
        L_0x0086:
            r16 = 0
            goto L_0x04a2
        L_0x008a:
            r0 = move-exception
            goto L_0x008d
        L_0x008c:
            r0 = move-exception
        L_0x008d:
            r3 = r0
            r8 = r6
            r7 = 0
            r10 = 0
            r11 = 0
        L_0x0092:
            r12 = 0
        L_0x0093:
            r16 = 0
            goto L_0x04b8
        L_0x0097:
            r0 = move-exception
            r3 = r0
            r8 = r6
            r7 = 0
            r10 = 0
            r11 = 0
        L_0x009d:
            r12 = 0
        L_0x009e:
            r16 = 0
            goto L_0x04cc
        L_0x00a2:
            java.net.URLConnection r8 = r8.openConnection()     // Catch:{ UnknownHostException -> 0x045e, SocketException -> 0x0458, SecurityException -> 0x0456, SSLPeerUnverifiedException -> 0x0451, SSLHandshakeException -> 0x044c, Exception -> 0x046e, all -> 0x0464 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ UnknownHostException -> 0x045e, SocketException -> 0x0458, SecurityException -> 0x0456, SSLPeerUnverifiedException -> 0x0451, SSLHandshakeException -> 0x044c, Exception -> 0x046e, all -> 0x0464 }
        L_0x00a8:
            r10 = 1
            r8.setDoInput(r10)     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            r8.setDoOutput(r10)     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            r10 = 0
            r8.setUseCaches(r10)     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            com.helpshift.common.platform.network.Method r11 = r2.method     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            java.lang.String r11 = r11.name()     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            r8.setRequestMethod(r11)     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            int r11 = r2.timeout     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            r8.setConnectTimeout(r11)     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            int r11 = r2.timeout     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            r8.setReadTimeout(r11)     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            java.util.List<com.helpshift.common.platform.network.KeyValuePair> r11 = r2.headers     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
        L_0x00cc:
            boolean r12 = r11.hasNext()     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            if (r12 == 0) goto L_0x00e0
            java.lang.Object r12 = r11.next()     // Catch:{ UnknownHostException -> 0x0054, SocketException -> 0x004a, SecurityException -> 0x0048, SSLPeerUnverifiedException -> 0x003e, SSLHandshakeException -> 0x0034, Exception -> 0x002e, all -> 0x002a }
            com.helpshift.common.platform.network.KeyValuePair r12 = (com.helpshift.common.platform.network.KeyValuePair) r12     // Catch:{ UnknownHostException -> 0x0054, SocketException -> 0x004a, SecurityException -> 0x0048, SSLPeerUnverifiedException -> 0x003e, SSLHandshakeException -> 0x0034, Exception -> 0x002e, all -> 0x002a }
            java.lang.String r13 = r12.key     // Catch:{ UnknownHostException -> 0x0054, SocketException -> 0x004a, SecurityException -> 0x0048, SSLPeerUnverifiedException -> 0x003e, SSLHandshakeException -> 0x0034, Exception -> 0x002e, all -> 0x002a }
            java.lang.String r12 = r12.value     // Catch:{ UnknownHostException -> 0x0054, SocketException -> 0x004a, SecurityException -> 0x0048, SSLPeerUnverifiedException -> 0x003e, SSLHandshakeException -> 0x0034, Exception -> 0x002e, all -> 0x002a }
            r8.setRequestProperty(r13, r12)     // Catch:{ UnknownHostException -> 0x0054, SocketException -> 0x004a, SecurityException -> 0x0048, SSLPeerUnverifiedException -> 0x003e, SSLHandshakeException -> 0x0034, Exception -> 0x002e, all -> 0x002a }
            goto L_0x00cc
        L_0x00e0:
            java.io.DataOutputStream r11 = new java.io.DataOutputStream     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            java.io.OutputStream r12 = r8.getOutputStream()     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            r11.<init>(r12)     // Catch:{ UnknownHostException -> 0x0441, SocketException -> 0x0436, SecurityException -> 0x0434, SSLPeerUnverifiedException -> 0x0429, SSLHandshakeException -> 0x041e, Exception -> 0x0415, all -> 0x040e }
            r11.writeBytes(r3)     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
            java.util.Map<java.lang.String, java.lang.String> r12 = r2.data     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
            java.util.Set r13 = r12.entrySet()     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
        L_0x00f6:
            boolean r14 = r13.hasNext()     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
            java.lang.String r15 = "Content-Length: "
            java.lang.String r7 = "Content-Disposition: form-data; name=\""
            if (r14 == 0) goto L_0x019b
            java.lang.Object r14 = r13.next()     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            java.lang.Object r17 = r14.getKey()     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r10 = r17
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            boolean r17 = r1.isInvalidKeyForHeader(r10)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            if (r17 != 0) goto L_0x016d
            java.lang.Object r14 = r14.getValue()     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r17 = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r13.<init>()     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r13.append(r7)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r13.append(r10)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            java.lang.String r7 = "\"; "
            r13.append(r7)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r13.append(r9)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            java.lang.String r7 = r13.toString()     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r11.writeBytes(r7)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            java.lang.String r7 = "Content-Type: text/plain;charset=UTF-8\r\n"
            r11.writeBytes(r7)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r7.<init>()     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r7.append(r15)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            int r10 = r14.length()     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r7.append(r10)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r7.append(r9)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r11.writeBytes(r7)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r11.writeBytes(r9)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r7.<init>()     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r7.append(r14)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r7.append(r9)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r11.writeBytes(r7)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            r11.writeBytes(r3)     // Catch:{ UnknownHostException -> 0x0195, SocketException -> 0x018f, SecurityException -> 0x018d, SSLPeerUnverifiedException -> 0x0187, SSLHandshakeException -> 0x0181, Exception -> 0x0179, all -> 0x0173 }
            goto L_0x016f
        L_0x016d:
            r17 = r13
        L_0x016f:
            r13 = r17
            r10 = 0
            goto L_0x00f6
        L_0x0173:
            r0 = move-exception
            r2 = r0
            r7 = 0
        L_0x0176:
            r10 = 0
            goto L_0x0064
        L_0x0179:
            r0 = move-exception
            r3 = r0
            r17 = r6
        L_0x017d:
            r7 = r8
            r10 = 0
            goto L_0x006f
        L_0x0181:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r10 = 0
            goto L_0x0039
        L_0x0187:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r10 = 0
            goto L_0x0043
        L_0x018d:
            r0 = move-exception
            goto L_0x0190
        L_0x018f:
            r0 = move-exception
        L_0x0190:
            r3 = r0
            r7 = r8
            r10 = 0
            goto L_0x004f
        L_0x0195:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r10 = 0
            goto L_0x0059
        L_0x019b:
            java.io.File r10 = new java.io.File     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
            java.lang.String r13 = "filePath"
            java.lang.Object r13 = r12.get(r13)     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
            r10.<init>(r13)     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
            java.lang.String r13 = "originalFileName"
            java.lang.Object r13 = r12.get(r13)     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ UnknownHostException -> 0x0408, SocketException -> 0x0402, SecurityException -> 0x0400, SSLPeerUnverifiedException -> 0x03fa, SSLHandshakeException -> 0x03f4, Exception -> 0x03eb, all -> 0x03e3 }
            java.lang.String r14 = "sc"
            r17 = r6
            java.lang.String r6 = "type"
            java.lang.Object r6 = r12.get(r6)     // Catch:{ UnknownHostException -> 0x03d8, SocketException -> 0x03cd, SecurityException -> 0x03cb, SSLPeerUnverifiedException -> 0x03c0, SSLHandshakeException -> 0x03b5, Exception -> 0x03b3, all -> 0x03e3 }
            boolean r6 = r14.equals(r6)     // Catch:{ UnknownHostException -> 0x03d8, SocketException -> 0x03cd, SecurityException -> 0x03cb, SSLPeerUnverifiedException -> 0x03c0, SSLHandshakeException -> 0x03b5, Exception -> 0x03b3, all -> 0x03e3 }
            if (r6 == 0) goto L_0x01e8
            java.lang.String r6 = "screenshot"
            goto L_0x01ea
        L_0x01c3:
            r0 = move-exception
            r3 = r0
            goto L_0x017d
        L_0x01c6:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x007a
        L_0x01ce:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x0085
        L_0x01d6:
            r0 = move-exception
            goto L_0x01d9
        L_0x01d8:
            r0 = move-exception
        L_0x01d9:
            r3 = r0
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x0092
        L_0x01e0:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x009d
        L_0x01e8:
            java.lang.String r6 = "attachment"
        L_0x01ea:
            if (r13 != 0) goto L_0x01f0
            java.lang.String r13 = r10.getName()     // Catch:{ UnknownHostException -> 0x01e0, SocketException -> 0x01d8, SecurityException -> 0x01d6, SSLPeerUnverifiedException -> 0x01ce, SSLHandshakeException -> 0x01c6, Exception -> 0x01c3, all -> 0x0173 }
        L_0x01f0:
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ UnknownHostException -> 0x03d8, SocketException -> 0x03cd, SecurityException -> 0x03cb, SSLPeerUnverifiedException -> 0x03c0, SSLHandshakeException -> 0x03b5, Exception -> 0x03b3, all -> 0x03e3 }
            r12.<init>(r10)     // Catch:{ UnknownHostException -> 0x03d8, SocketException -> 0x03cd, SecurityException -> 0x03cb, SSLPeerUnverifiedException -> 0x03c0, SSLHandshakeException -> 0x03b5, Exception -> 0x03b3, all -> 0x03e3 }
            r11.writeBytes(r3)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.<init>()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.append(r7)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.append(r6)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.String r6 = "\"; filename=\""
            r3.append(r6)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.append(r13)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.String r6 = "\""
            r3.append(r6)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.append(r9)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.String r3 = r3.toString()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r11.writeBytes(r3)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.<init>()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.String r6 = "Content-Type: "
            r3.append(r6)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.String r6 = r2.mimeType     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.append(r6)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.append(r9)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.String r3 = r3.toString()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r11.writeBytes(r3)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.<init>()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.append(r15)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            long r6 = r10.length()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.append(r6)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r3.append(r9)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.String r3 = r3.toString()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r11.writeBytes(r3)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r11.writeBytes(r9)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            int r3 = r12.available()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r6 = 8192(0x2000, float:1.14794E-41)
            int r3 = java.lang.Math.min(r3, r6)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            byte[] r7 = new byte[r3]     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r10 = 0
            int r13 = r12.read(r7, r10, r3)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
        L_0x0260:
            if (r13 <= 0) goto L_0x029f
            r11.write(r7, r10, r3)     // Catch:{ UnknownHostException -> 0x0297, SocketException -> 0x028f, SecurityException -> 0x028d, SSLPeerUnverifiedException -> 0x0285, SSLHandshakeException -> 0x027d, Exception -> 0x0277, all -> 0x0272 }
            int r3 = r12.available()     // Catch:{ UnknownHostException -> 0x0297, SocketException -> 0x028f, SecurityException -> 0x028d, SSLPeerUnverifiedException -> 0x0285, SSLHandshakeException -> 0x027d, Exception -> 0x0277, all -> 0x0272 }
            int r3 = java.lang.Math.min(r3, r6)     // Catch:{ UnknownHostException -> 0x0297, SocketException -> 0x028f, SecurityException -> 0x028d, SSLPeerUnverifiedException -> 0x0285, SSLHandshakeException -> 0x027d, Exception -> 0x0277, all -> 0x0272 }
            int r13 = r12.read(r7, r10, r3)     // Catch:{ UnknownHostException -> 0x0297, SocketException -> 0x028f, SecurityException -> 0x028d, SSLPeerUnverifiedException -> 0x0285, SSLHandshakeException -> 0x027d, Exception -> 0x0277, all -> 0x0272 }
            goto L_0x0260
        L_0x0272:
            r0 = move-exception
            r2 = r0
            r7 = r12
            goto L_0x0176
        L_0x0277:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r10 = 0
            goto L_0x0070
        L_0x027d:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x007b
        L_0x0285:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x0086
        L_0x028d:
            r0 = move-exception
            goto L_0x0290
        L_0x028f:
            r0 = move-exception
        L_0x0290:
            r3 = r0
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x0093
        L_0x0297:
            r0 = move-exception
            r3 = r0
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x009e
        L_0x029f:
            r11.writeBytes(r9)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.String r3 = "--*****--\r\n"
            r11.writeBytes(r3)     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r11.flush()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            int r3 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r3 < r6) goto L_0x0316
            r6 = 300(0x12c, float:4.2E-43)
            if (r3 >= r6) goto L_0x0316
            java.io.InputStream r6 = r8.getInputStream()     // Catch:{ UnknownHostException -> 0x0297, SocketException -> 0x028f, SecurityException -> 0x028d, SSLPeerUnverifiedException -> 0x0285, SSLHandshakeException -> 0x027d, Exception -> 0x0277, all -> 0x0272 }
            if (r6 == 0) goto L_0x02c1
            java.lang.String r7 = r1.readInputStream(r6)     // Catch:{ UnknownHostException -> 0x030c, SocketException -> 0x0302, SecurityException -> 0x0300, SSLPeerUnverifiedException -> 0x02f6, SSLHandshakeException -> 0x02ec, Exception -> 0x02e4, all -> 0x02de }
            goto L_0x02c2
        L_0x02c1:
            r7 = 0
        L_0x02c2:
            com.helpshift.common.platform.network.Response r9 = new com.helpshift.common.platform.network.Response     // Catch:{ UnknownHostException -> 0x030c, SocketException -> 0x0302, SecurityException -> 0x0300, SSLPeerUnverifiedException -> 0x02f6, SSLHandshakeException -> 0x02ec, Exception -> 0x02e4, all -> 0x02de }
            r10 = 0
            r9.<init>(r3, r7, r10)     // Catch:{ UnknownHostException -> 0x030c, SocketException -> 0x0302, SecurityException -> 0x0300, SSLPeerUnverifiedException -> 0x02f6, SSLHandshakeException -> 0x02ec, Exception -> 0x02e4, all -> 0x02de }
            com.helpshift.util.IOUtils.closeQuitely(r12)
            com.helpshift.util.IOUtils.closeQuitely(r11)
            com.helpshift.util.IOUtils.closeQuitely(r6)
            com.helpshift.util.IOUtils.closeQuitely(r10)
            r8.disconnect()     // Catch:{ Exception -> 0x02d8 }
            goto L_0x02dd
        L_0x02d8:
            r0 = move-exception
            r2 = r0
            com.helpshift.util.HSLogger.m3242e(r5, r4, r2)
        L_0x02dd:
            return r9
        L_0x02de:
            r0 = move-exception
            r2 = r0
            r10 = r6
            r7 = r12
            goto L_0x0064
        L_0x02e4:
            r0 = move-exception
            r3 = r0
            r16 = r6
            r7 = r8
            r10 = 0
            goto L_0x0478
        L_0x02ec:
            r0 = move-exception
            r3 = r0
            r16 = r6
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x048e
        L_0x02f6:
            r0 = move-exception
            r3 = r0
            r16 = r6
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x04a2
        L_0x0300:
            r0 = move-exception
            goto L_0x0303
        L_0x0302:
            r0 = move-exception
        L_0x0303:
            r3 = r0
            r16 = r6
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x04b8
        L_0x030c:
            r0 = move-exception
            r3 = r0
            r16 = r6
            r7 = r8
            r8 = r17
            r10 = 0
            goto L_0x04cc
        L_0x0316:
            java.io.InputStream r6 = r8.getErrorStream()     // Catch:{ UnknownHostException -> 0x03ac, SocketException -> 0x03a5, SecurityException -> 0x03a3, SSLPeerUnverifiedException -> 0x039c, SSLHandshakeException -> 0x0395, Exception -> 0x038d, all -> 0x0385 }
            java.lang.String r7 = r1.readInputStream(r6)     // Catch:{ UnknownHostException -> 0x037a, SocketException -> 0x036f, SecurityException -> 0x036d, SSLPeerUnverifiedException -> 0x0362, SSLHandshakeException -> 0x0357, Exception -> 0x034e, all -> 0x0348 }
            com.helpshift.common.platform.network.Response r9 = new com.helpshift.common.platform.network.Response     // Catch:{ UnknownHostException -> 0x037a, SocketException -> 0x036f, SecurityException -> 0x036d, SSLPeerUnverifiedException -> 0x0362, SSLHandshakeException -> 0x0357, Exception -> 0x034e, all -> 0x0348 }
            r10 = 0
            r9.<init>(r3, r7, r10)     // Catch:{ UnknownHostException -> 0x0346, SocketException -> 0x0344, SecurityException -> 0x0342, SSLPeerUnverifiedException -> 0x0340, SSLHandshakeException -> 0x033e, Exception -> 0x033c, all -> 0x033a }
            com.helpshift.util.IOUtils.closeQuitely(r12)
            com.helpshift.util.IOUtils.closeQuitely(r11)
            com.helpshift.util.IOUtils.closeQuitely(r10)
            com.helpshift.util.IOUtils.closeQuitely(r6)
            r8.disconnect()     // Catch:{ Exception -> 0x0334 }
            goto L_0x0339
        L_0x0334:
            r0 = move-exception
            r2 = r0
            com.helpshift.util.HSLogger.m3242e(r5, r4, r2)
        L_0x0339:
            return r9
        L_0x033a:
            r0 = move-exception
            goto L_0x034a
        L_0x033c:
            r0 = move-exception
            goto L_0x0350
        L_0x033e:
            r0 = move-exception
            goto L_0x0359
        L_0x0340:
            r0 = move-exception
            goto L_0x0364
        L_0x0342:
            r0 = move-exception
            goto L_0x0371
        L_0x0344:
            r0 = move-exception
            goto L_0x0371
        L_0x0346:
            r0 = move-exception
            goto L_0x037c
        L_0x0348:
            r0 = move-exception
            r10 = 0
        L_0x034a:
            r2 = r0
            r16 = r6
            goto L_0x038a
        L_0x034e:
            r0 = move-exception
            r10 = 0
        L_0x0350:
            r3 = r0
            r7 = r8
            r16 = r10
            r10 = r6
            goto L_0x0478
        L_0x0357:
            r0 = move-exception
            r10 = 0
        L_0x0359:
            r3 = r0
            r7 = r8
            r16 = r10
            r8 = r17
            r10 = r6
            goto L_0x048e
        L_0x0362:
            r0 = move-exception
            r10 = 0
        L_0x0364:
            r3 = r0
            r7 = r8
            r16 = r10
            r8 = r17
            r10 = r6
            goto L_0x04a2
        L_0x036d:
            r0 = move-exception
            goto L_0x0370
        L_0x036f:
            r0 = move-exception
        L_0x0370:
            r10 = 0
        L_0x0371:
            r3 = r0
            r7 = r8
            r16 = r10
            r8 = r17
            r10 = r6
            goto L_0x04b8
        L_0x037a:
            r0 = move-exception
            r10 = 0
        L_0x037c:
            r3 = r0
            r7 = r8
            r16 = r10
            r8 = r17
            r10 = r6
            goto L_0x04cc
        L_0x0385:
            r0 = move-exception
            r10 = 0
            r2 = r0
            r16 = r10
        L_0x038a:
            r7 = r12
            goto L_0x04e1
        L_0x038d:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r16 = r10
            goto L_0x0478
        L_0x0395:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r16 = r10
            goto L_0x03bc
        L_0x039c:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r16 = r10
            goto L_0x03c7
        L_0x03a3:
            r0 = move-exception
            goto L_0x03a6
        L_0x03a5:
            r0 = move-exception
        L_0x03a6:
            r10 = 0
            r3 = r0
            r7 = r8
            r16 = r10
            goto L_0x03d4
        L_0x03ac:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r16 = r10
            goto L_0x03df
        L_0x03b3:
            r0 = move-exception
            goto L_0x03ee
        L_0x03b5:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r12 = r10
            r16 = r12
        L_0x03bc:
            r8 = r17
            goto L_0x048e
        L_0x03c0:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r12 = r10
            r16 = r12
        L_0x03c7:
            r8 = r17
            goto L_0x04a2
        L_0x03cb:
            r0 = move-exception
            goto L_0x03ce
        L_0x03cd:
            r0 = move-exception
        L_0x03ce:
            r10 = 0
            r3 = r0
            r7 = r8
            r12 = r10
            r16 = r12
        L_0x03d4:
            r8 = r17
            goto L_0x04b8
        L_0x03d8:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r12 = r10
            r16 = r12
        L_0x03df:
            r8 = r17
            goto L_0x04cc
        L_0x03e3:
            r0 = move-exception
            r10 = 0
            r2 = r0
            r7 = r10
            r16 = r7
            goto L_0x04e1
        L_0x03eb:
            r0 = move-exception
            r17 = r6
        L_0x03ee:
            r10 = 0
            r3 = r0
            r7 = r8
            r12 = r10
            goto L_0x0476
        L_0x03f4:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r12 = r10
            goto L_0x0424
        L_0x03fa:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r12 = r10
            goto L_0x042f
        L_0x0400:
            r0 = move-exception
            goto L_0x0403
        L_0x0402:
            r0 = move-exception
        L_0x0403:
            r10 = 0
            r3 = r0
            r7 = r8
            r12 = r10
            goto L_0x043c
        L_0x0408:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r12 = r10
            goto L_0x0447
        L_0x040e:
            r0 = move-exception
            r10 = 0
            r2 = r0
            r7 = r10
            r11 = r7
            goto L_0x046a
        L_0x0415:
            r0 = move-exception
            r17 = r6
            r10 = 0
            r3 = r0
            r7 = r8
            r11 = r10
            goto L_0x0475
        L_0x041e:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r11 = r10
            r12 = r11
        L_0x0424:
            r16 = r12
        L_0x0426:
            r8 = r6
            goto L_0x048e
        L_0x0429:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r11 = r10
            r12 = r11
        L_0x042f:
            r16 = r12
        L_0x0431:
            r8 = r6
            goto L_0x04a2
        L_0x0434:
            r0 = move-exception
            goto L_0x0437
        L_0x0436:
            r0 = move-exception
        L_0x0437:
            r10 = 0
            r3 = r0
            r7 = r8
            r11 = r10
            r12 = r11
        L_0x043c:
            r16 = r12
        L_0x043e:
            r8 = r6
            goto L_0x04b8
        L_0x0441:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r7 = r8
            r11 = r10
            r12 = r11
        L_0x0447:
            r16 = r12
        L_0x0449:
            r8 = r6
            goto L_0x04cc
        L_0x044c:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r8 = r6
            goto L_0x0489
        L_0x0451:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r8 = r6
            goto L_0x049d
        L_0x0456:
            r0 = move-exception
            goto L_0x0459
        L_0x0458:
            r0 = move-exception
        L_0x0459:
            r10 = 0
            r3 = r0
            r8 = r6
            goto L_0x04b3
        L_0x045e:
            r0 = move-exception
            r10 = 0
            r3 = r0
            r8 = r6
            goto L_0x04c7
        L_0x0464:
            r0 = move-exception
            r10 = 0
            r2 = r0
            r7 = r10
            r8 = r7
            r11 = r8
        L_0x046a:
            r16 = r11
            goto L_0x04e1
        L_0x046e:
            r0 = move-exception
            r17 = r6
            r10 = 0
            r3 = r0
            r7 = r10
            r11 = r7
        L_0x0475:
            r12 = r11
        L_0x0476:
            r16 = r12
        L_0x0478:
            com.helpshift.common.exception.NetworkException r6 = com.helpshift.common.exception.NetworkException.GENERIC     // Catch:{ all -> 0x04d7 }
            java.lang.String r2 = r2.url     // Catch:{ all -> 0x04d7 }
            r6.route = r2     // Catch:{ all -> 0x04d7 }
            r8 = r17
            com.helpshift.common.exception.RootAPIException r2 = com.helpshift.common.exception.RootAPIException.wrap(r3, r6, r8)     // Catch:{ all -> 0x04d7 }
            throw r2     // Catch:{ all -> 0x04d7 }
        L_0x0485:
            r0 = move-exception
            r8 = r6
            r10 = 0
            r3 = r0
        L_0x0489:
            r7 = r10
            r11 = r7
            r12 = r11
            r16 = r12
        L_0x048e:
            com.helpshift.common.exception.NetworkException r6 = com.helpshift.common.exception.NetworkException.SSL_HANDSHAKE     // Catch:{ all -> 0x04d7 }
            java.lang.String r2 = r2.url     // Catch:{ all -> 0x04d7 }
            r6.route = r2     // Catch:{ all -> 0x04d7 }
            com.helpshift.common.exception.RootAPIException r2 = com.helpshift.common.exception.RootAPIException.wrap(r3, r6, r8)     // Catch:{ all -> 0x04d7 }
            throw r2     // Catch:{ all -> 0x04d7 }
        L_0x0499:
            r0 = move-exception
            r8 = r6
            r10 = 0
            r3 = r0
        L_0x049d:
            r7 = r10
            r11 = r7
            r12 = r11
            r16 = r12
        L_0x04a2:
            com.helpshift.common.exception.NetworkException r6 = com.helpshift.common.exception.NetworkException.SSL_PEER_UNVERIFIED     // Catch:{ all -> 0x04d7 }
            java.lang.String r2 = r2.url     // Catch:{ all -> 0x04d7 }
            r6.route = r2     // Catch:{ all -> 0x04d7 }
            com.helpshift.common.exception.RootAPIException r2 = com.helpshift.common.exception.RootAPIException.wrap(r3, r6, r8)     // Catch:{ all -> 0x04d7 }
            throw r2     // Catch:{ all -> 0x04d7 }
        L_0x04ad:
            r0 = move-exception
            goto L_0x04b0
        L_0x04af:
            r0 = move-exception
        L_0x04b0:
            r8 = r6
            r10 = 0
            r3 = r0
        L_0x04b3:
            r7 = r10
            r11 = r7
            r12 = r11
            r16 = r12
        L_0x04b8:
            com.helpshift.common.exception.NetworkException r6 = com.helpshift.common.exception.NetworkException.NO_CONNECTION     // Catch:{ all -> 0x04d7 }
            java.lang.String r2 = r2.url     // Catch:{ all -> 0x04d7 }
            r6.route = r2     // Catch:{ all -> 0x04d7 }
            com.helpshift.common.exception.RootAPIException r2 = com.helpshift.common.exception.RootAPIException.wrap(r3, r6, r8)     // Catch:{ all -> 0x04d7 }
            throw r2     // Catch:{ all -> 0x04d7 }
        L_0x04c3:
            r0 = move-exception
            r8 = r6
            r10 = 0
            r3 = r0
        L_0x04c7:
            r7 = r10
            r11 = r7
            r12 = r11
            r16 = r12
        L_0x04cc:
            com.helpshift.common.exception.NetworkException r6 = com.helpshift.common.exception.NetworkException.UNKNOWN_HOST     // Catch:{ all -> 0x04d7 }
            java.lang.String r2 = r2.url     // Catch:{ all -> 0x04d7 }
            r6.route = r2     // Catch:{ all -> 0x04d7 }
            com.helpshift.common.exception.RootAPIException r2 = com.helpshift.common.exception.RootAPIException.wrap(r3, r6, r8)     // Catch:{ all -> 0x04d7 }
            throw r2     // Catch:{ all -> 0x04d7 }
        L_0x04d7:
            r0 = move-exception
            r2 = r0
            r8 = r7
            r7 = r12
            r18 = r16
            r16 = r10
            r10 = r18
        L_0x04e1:
            com.helpshift.util.IOUtils.closeQuitely(r7)
            com.helpshift.util.IOUtils.closeQuitely(r11)
            com.helpshift.util.IOUtils.closeQuitely(r10)
            com.helpshift.util.IOUtils.closeQuitely(r16)
            if (r8 == 0) goto L_0x04f8
            r8.disconnect()     // Catch:{ Exception -> 0x04f3 }
            goto L_0x04f8
        L_0x04f3:
            r0 = move-exception
            r3 = r0
            com.helpshift.util.HSLogger.m3242e(r5, r4, r3)
        L_0x04f8:
            goto L_0x04fa
        L_0x04f9:
            throw r2
        L_0x04fa:
            goto L_0x04f9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.platform.AndroidHTTPTransport.upload(com.helpshift.common.platform.network.UploadRequest):com.helpshift.common.platform.network.Response");
    }

    public Response makeRequest(Request request) {
        if (request instanceof UploadRequest) {
            return upload((UploadRequest) request);
        }
        return makeNetworkRequest(request);
    }
}
