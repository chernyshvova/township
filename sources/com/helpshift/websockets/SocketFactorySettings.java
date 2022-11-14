package com.helpshift.websockets;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class SocketFactorySettings {
    public SSLContext mSSLContext;
    public SSLSocketFactory mSSLSocketFactory;
    public SocketFactory mSocketFactory;

    public SSLContext getSSLContext() {
        return this.mSSLContext;
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.mSSLSocketFactory;
    }

    public SocketFactory getSocketFactory() {
        return this.mSocketFactory;
    }

    public SocketFactory selectSocketFactory(boolean z) {
        if (z) {
            SSLContext sSLContext = this.mSSLContext;
            if (sSLContext != null) {
                return sSLContext.getSocketFactory();
            }
            SSLSocketFactory sSLSocketFactory = this.mSSLSocketFactory;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory;
            }
            return SSLSocketFactory.getDefault();
        }
        SocketFactory socketFactory = this.mSocketFactory;
        if (socketFactory != null) {
            return socketFactory;
        }
        return SocketFactory.getDefault();
    }

    public void setSSLContext(SSLContext sSLContext) {
        this.mSSLContext = sSLContext;
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.mSSLSocketFactory = sSLSocketFactory;
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.mSocketFactory = socketFactory;
    }
}
