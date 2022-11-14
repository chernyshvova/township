package com.helpshift.websockets;

import java.net.InetSocketAddress;

public class Address {
    public final String mHost;
    public final int mPort;
    public transient String mString;

    public Address(String str, int i) {
        this.mHost = str;
        this.mPort = i;
    }

    public String getHostname() {
        return this.mHost;
    }

    public InetSocketAddress toInetSocketAddress() {
        return new InetSocketAddress(this.mHost, this.mPort);
    }

    public String toString() {
        if (this.mString == null) {
            this.mString = String.format("%s:%d", new Object[]{this.mHost, Integer.valueOf(this.mPort)});
        }
        return this.mString;
    }
}
