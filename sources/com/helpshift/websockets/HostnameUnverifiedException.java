package com.helpshift.websockets;

import javax.net.ssl.SSLSocket;

public class HostnameUnverifiedException extends WebSocketException {
    public static final long serialVersionUID = 1;
    public final String mHostname;
    public final SSLSocket mSSLSocket;

    public HostnameUnverifiedException(SSLSocket sSLSocket, String str) {
        super(WebSocketError.HOSTNAME_UNVERIFIED, String.format("The certificate of the peer%s does not match the expected hostname (%s)", new Object[]{stringifyPrincipal(sSLSocket), str}));
        this.mSSLSocket = sSLSocket;
        this.mHostname = str;
    }

    public static String stringifyPrincipal(SSLSocket sSLSocket) {
        try {
            return String.format(" (%s)", new Object[]{sSLSocket.getSession().getPeerPrincipal().toString()});
        } catch (Exception unused) {
            return "";
        }
    }

    public String getHostname() {
        return this.mHostname;
    }

    public SSLSocket getSSLSocket() {
        return this.mSSLSocket;
    }
}
