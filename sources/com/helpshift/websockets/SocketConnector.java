package com.helpshift.websockets;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SocketConnector {
    public final Address mAddress;
    public final int mConnectionTimeout;
    public final String mHost;
    public final int mPort;
    public final ProxyHandshaker mProxyHandshaker;
    public final SSLSocketFactory mSSLSocketFactory;
    public Socket mSocket;

    public SocketConnector(Socket socket, Address address, int i) {
        this(socket, address, i, (ProxyHandshaker) null, (SSLSocketFactory) null, (String) null, 0);
    }

    private void doConnect() throws WebSocketException {
        boolean z = this.mProxyHandshaker != null;
        try {
            this.mSocket.connect(this.mAddress.toInetSocketAddress(), this.mConnectionTimeout);
            if (this.mSocket instanceof SSLSocket) {
                verifyHostname((SSLSocket) this.mSocket, this.mAddress.getHostname());
            }
            if (z) {
                handshake();
            }
        } catch (IOException e) {
            Object[] objArr = new Object[3];
            objArr[0] = z ? "the proxy " : "";
            objArr[1] = this.mAddress;
            objArr[2] = e.getMessage();
            throw new WebSocketException(WebSocketError.SOCKET_CONNECT_ERROR, String.format("Failed to connect to %s'%s': %s", objArr), e);
        }
    }

    private void handshake() throws WebSocketException {
        try {
            this.mProxyHandshaker.perform();
            SSLSocketFactory sSLSocketFactory = this.mSSLSocketFactory;
            if (sSLSocketFactory != null) {
                try {
                    Socket createSocket = sSLSocketFactory.createSocket(this.mSocket, this.mHost, this.mPort, true);
                    this.mSocket = createSocket;
                    try {
                        ((SSLSocket) createSocket).startHandshake();
                        if (this.mSocket instanceof SSLSocket) {
                            verifyHostname((SSLSocket) this.mSocket, this.mProxyHandshaker.getProxiedHostname());
                        }
                    } catch (IOException e) {
                        throw new WebSocketException(WebSocketError.SSL_HANDSHAKE_ERROR, String.format("SSL handshake with the WebSocket endpoint (%s) failed: %s", new Object[]{this.mAddress, e.getMessage()}), e);
                    }
                } catch (IOException e2) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to overlay an existing socket: ");
                    outline24.append(e2.getMessage());
                    throw new WebSocketException(WebSocketError.SOCKET_OVERLAY_ERROR, outline24.toString(), e2);
                }
            }
        } catch (IOException e3) {
            throw new WebSocketException(WebSocketError.PROXY_HANDSHAKE_ERROR, String.format("Handshake with the proxy server (%s) failed: %s", new Object[]{this.mAddress, e3.getMessage()}), e3);
        }
    }

    private void verifyHostname(SSLSocket sSLSocket, String str) throws HostnameUnverifiedException {
        if (!OkHostnameVerifier.INSTANCE.verify(str, sSLSocket.getSession())) {
            throw new HostnameUnverifiedException(sSLSocket, str);
        }
    }

    public void closeSilently() {
        try {
            this.mSocket.close();
        } catch (Throwable unused) {
        }
    }

    public void connect() throws WebSocketException {
        try {
            doConnect();
        } catch (WebSocketException e) {
            try {
                this.mSocket.close();
            } catch (IOException unused) {
            }
            throw e;
        }
    }

    public int getConnectionTimeout() {
        return this.mConnectionTimeout;
    }

    public Socket getSocket() {
        return this.mSocket;
    }

    public SocketConnector(Socket socket, Address address, int i, ProxyHandshaker proxyHandshaker, SSLSocketFactory sSLSocketFactory, String str, int i2) {
        this.mSocket = socket;
        this.mAddress = address;
        this.mConnectionTimeout = i;
        this.mProxyHandshaker = proxyHandshaker;
        this.mSSLSocketFactory = sSLSocketFactory;
        this.mHost = str;
        this.mPort = i2;
    }
}
