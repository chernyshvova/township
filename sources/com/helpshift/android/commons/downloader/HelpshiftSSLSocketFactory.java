package com.helpshift.android.commons.downloader;

import com.helpshift.util.HSLogger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HelpshiftSSLSocketFactory extends SSLSocketFactory {
    public static final String TAG = "hs_ssl_factory";
    public List<String> disableProtocols;
    public List<String> enableProtocols;
    public List<Socket> socketCacheList = new ArrayList();
    public SSLSocketFactory sslSocketFactory;

    public HelpshiftSSLSocketFactory(SSLSocketFactory sSLSocketFactory, List<String> list, List<String> list2) {
        this.sslSocketFactory = sSLSocketFactory;
        this.enableProtocols = list;
        this.disableProtocols = list2;
    }

    public void closeSockets() {
        try {
            for (Socket next : this.socketCacheList) {
                if (next != null) {
                    next.close();
                }
            }
        } catch (Exception e) {
            HSLogger.m3241e(TAG, "Exception on closing open sockets: " + e);
        } catch (Throwable th) {
            this.socketCacheList.clear();
            throw th;
        }
        this.socketCacheList.clear();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return updateProtocols(this.sslSocketFactory.createSocket(socket, str, i, z));
    }

    public String[] getDefaultCipherSuites() {
        return this.sslSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.sslSocketFactory.getSupportedCipherSuites();
    }

    public Socket updateProtocols(Socket socket) {
        this.socketCacheList.add(socket);
        if (socket != null && (socket instanceof SSLSocket)) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            if (enabledProtocols == null) {
                return sSLSocket;
            }
            ArrayList arrayList = new ArrayList(Arrays.asList(enabledProtocols));
            String[] supportedProtocols = sSLSocket.getSupportedProtocols();
            List arrayList2 = new ArrayList();
            if (supportedProtocols != null) {
                arrayList2 = Arrays.asList(supportedProtocols);
            }
            ArrayList arrayList3 = new ArrayList();
            List<String> list = this.enableProtocols;
            if (list != null && list.size() > 0) {
                for (String next : this.enableProtocols) {
                    if (!arrayList.contains(next) && arrayList2.contains(next)) {
                        arrayList3.add(next);
                    }
                }
            }
            arrayList.addAll(arrayList3);
            List<String> list2 = this.disableProtocols;
            if (list2 != null && list2.size() > 0) {
                arrayList.removeAll(this.disableProtocols);
            }
            sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[0]));
        }
        return socket;
    }

    public Socket createSocket() throws IOException {
        return updateProtocols(this.sslSocketFactory.createSocket());
    }

    public Socket createSocket(String str, int i) throws IOException {
        return updateProtocols(this.sslSocketFactory.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return updateProtocols(this.sslSocketFactory.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return updateProtocols(this.sslSocketFactory.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return updateProtocols(this.sslSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
    }
}
