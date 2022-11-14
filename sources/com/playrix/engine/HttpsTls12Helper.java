package com.playrix.engine;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HttpsTls12Helper {
    public static final String LOG_TAG = "[HttpsTls12Helper] ";
    public static final int TLS12_DISABLED = 1;
    public static final int TLS12_ENABLED = 0;
    public static final int TLS12_UNAVAILABLE = 2;

    public static class SSLSocketFactoryWithTls12 extends SSLSocketFactory {
        public final SSLSocketFactory delegate;
        public final String[] enabledProtocols;

        public SSLSocketFactoryWithTls12(SSLSocketFactory sSLSocketFactory, String[] strArr) {
            this.delegate = sSLSocketFactory;
            this.enabledProtocols = strArr;
        }

        private Socket setProtocols(Socket socket) {
            String[] strArr;
            if ((socket instanceof SSLSocket) && (strArr = this.enabledProtocols) != null && strArr.length > 0) {
                ((SSLSocket) socket).setEnabledProtocols(strArr);
            }
            return socket;
        }

        public Socket createSocket() throws IOException {
            return setProtocols(this.delegate.createSocket());
        }

        public String[] getDefaultCipherSuites() {
            return this.delegate.getDefaultCipherSuites();
        }

        public String[] getSupportedCipherSuites() {
            return this.delegate.getSupportedCipherSuites();
        }

        public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
            return setProtocols(this.delegate.createSocket(str, i));
        }

        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
            return setProtocols(this.delegate.createSocket(socket, str, i, z));
        }

        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            return setProtocols(this.delegate.createSocket(inetAddress, i));
        }

        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
            return setProtocols(this.delegate.createSocket(str, i, inetAddress, i2));
        }

        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            return setProtocols(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
        }
    }

    public static int checkTls12(SSLSocketFactory sSLSocketFactory, String str) {
        if (sSLSocketFactory == null) {
            Logger.logError("[HttpsTls12Helper] Null factory");
            return 2;
        }
        try {
            Socket createSocket = sSLSocketFactory.createSocket();
            if (createSocket instanceof SSLSocket) {
                SSLSocket sSLSocket = (SSLSocket) createSocket;
                String[] supportedProtocols = sSLSocket.getSupportedProtocols();
                String[] enabledProtocols = sSLSocket.getEnabledProtocols();
                List asList = Arrays.asList(enabledProtocols);
                List asList2 = Arrays.asList(supportedProtocols);
                if (str != null) {
                    ArrayList arrayList = new ArrayList(asList2);
                    arrayList.removeAll(asList);
                    String name = sSLSocketFactory.getClass().getName();
                    Logger.logDebug(LOG_TAG + str + " " + name + " Protocols. Enabled: " + Arrays.toString(enabledProtocols) + ", supported but not enabled: " + Arrays.toString(arrayList.toArray()));
                    List asList3 = Arrays.asList(sSLSocket.getEnabledCipherSuites());
                    ArrayList arrayList2 = new ArrayList(Arrays.asList(sSLSocket.getSupportedCipherSuites()));
                    arrayList2.removeAll(asList3);
                    Logger.logDebug(LOG_TAG + str + " " + name + " Ciphers. Enabled: " + Arrays.toString(asList3.toArray()) + ", supported but not enabled: " + Arrays.toString(arrayList2.toArray()));
                }
                if (!asList2.contains("TLSv1.2")) {
                    return 2;
                }
                return asList.contains("TLSv1.2") ^ true ? 1 : 0;
            }
        } catch (Throwable th) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HttpsTls12Helper] Error while checking protocol availability: ");
            outline24.append(th.getMessage());
            Logger.logError(outline24.toString());
        }
        return 2;
    }

    public static SSLSocketFactory enableTls12Support(SSLSocketFactory sSLSocketFactory, String str) {
        if (sSLSocketFactory != null) {
            try {
                SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket();
                List asList = Arrays.asList(sSLSocket.getSupportedProtocols());
                List<String> asList2 = Arrays.asList(sSLSocket.getEnabledProtocols());
                boolean contains = asList.contains("TLSv1.2");
                boolean contains2 = asList2.contains("TLSv1.2");
                boolean contains3 = asList.contains("TLSv1.1");
                boolean contains4 = asList2.contains("TLSv1.1");
                String name = sSLSocketFactory.getClass().getName();
                if (contains) {
                    if (!contains2) {
                        if (str != null) {
                            Logger.logDebug(LOG_TAG + str + " TLSv1.2 available, but not enabled for " + name + ", will use wrapper");
                        }
                        int size = asList2.size() + 1;
                        if (contains3 && !contains4) {
                            size++;
                        }
                        String[] strArr = new String[size];
                        int i = 0;
                        for (String str2 : asList2) {
                            strArr[i] = str2;
                            i++;
                        }
                        if (contains3 && !contains4) {
                            strArr[i] = "TLSv1.1";
                            i++;
                        }
                        strArr[i] = "TLSv1.2";
                        return new SSLSocketFactoryWithTls12(sSLSocketFactory, strArr);
                    } else if (str != null) {
                        Logger.logDebug(LOG_TAG + str + " TLSv1.2 available in " + name + ", will use without wrapper");
                    }
                } else if (str != null) {
                    Logger.logDebug(LOG_TAG + str + " TLSv1.2 unavailable in " + name + ", don't changing");
                }
            } catch (Throwable th) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("[HttpsTls12Helper] Can't adjust supported protocols: ");
                outline24.append(th.getMessage());
                Logger.logError(outline24.toString());
            }
        }
        return sSLSocketFactory;
    }
}
