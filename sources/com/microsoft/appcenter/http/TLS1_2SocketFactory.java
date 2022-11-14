package com.microsoft.appcenter.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class TLS1_2SocketFactory extends SSLSocketFactory {
    public static final String[] ENABLED_PROTOCOLS = {"TLSv1.2"};
    public final SSLSocketFactory delegate;

    public TLS1_2SocketFactory() {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext instance = SSLContext.getInstance("TLSv1.2");
            instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            sSLSocketFactory = instance.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException unused) {
        }
        this.delegate = sSLSocketFactory == null ? HttpsURLConnection.getDefaultSSLSocketFactory() : sSLSocketFactory;
    }

    public Socket createSocket() throws IOException {
        return forceTLS1_2(this.delegate.createSocket());
    }

    public final SSLSocket forceTLS1_2(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        sSLSocket.setEnabledProtocols(ENABLED_PROTOCOLS);
        return sSLSocket;
    }

    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return forceTLS1_2(this.delegate.createSocket(str, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return forceTLS1_2(this.delegate.createSocket(inetAddress, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return forceTLS1_2(this.delegate.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return forceTLS1_2(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return forceTLS1_2(this.delegate.createSocket(socket, str, i, z));
    }
}
