package com.helpshift.websockets;

import com.facebook.internal.Utility;
import com.facebook.internal.security.CertificateUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class ProxySettings {
    public final Map<String, List<String>> mHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    public String mHost;
    public String mId;
    public String mPassword;
    public int mPort;
    public boolean mSecure;
    public final SocketFactorySettings mSocketFactorySettings = new SocketFactorySettings();
    public final WebSocketFactory mWebSocketFactory;

    public ProxySettings(WebSocketFactory webSocketFactory) {
        this.mWebSocketFactory = webSocketFactory;
        reset();
    }

    private void setByScheme(String str) {
        if ("http".equalsIgnoreCase(str)) {
            this.mSecure = false;
        } else if (Utility.URL_SCHEME.equalsIgnoreCase(str)) {
            this.mSecure = true;
        }
    }

    private void setByUserInfo(String str) {
        String str2;
        String str3;
        if (str != null) {
            String[] split = str.split(CertificateUtil.DELIMITER, 2);
            int length = split.length;
            if (length == 1) {
                str3 = split[0];
                str2 = null;
            } else if (length == 2) {
                str3 = split[0];
                str2 = split[1];
            } else {
                return;
            }
            if (str3.length() != 0) {
                this.mId = str3;
                this.mPassword = str2;
            }
        }
    }

    public ProxySettings addHeader(String str, String str2) {
        if (!(str == null || str.length() == 0)) {
            List list = this.mHeaders.get(str);
            if (list == null) {
                list = new ArrayList();
                this.mHeaders.put(str, list);
            }
            list.add(str2);
        }
        return this;
    }

    public Map<String, List<String>> getHeaders() {
        return this.mHeaders;
    }

    public String getHost() {
        return this.mHost;
    }

    public String getId() {
        return this.mId;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public int getPort() {
        return this.mPort;
    }

    public SSLContext getSSLContext() {
        return this.mSocketFactorySettings.getSSLContext();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.mSocketFactorySettings.getSSLSocketFactory();
    }

    public SocketFactory getSocketFactory() {
        return this.mSocketFactorySettings.getSocketFactory();
    }

    public WebSocketFactory getWebSocketFactory() {
        return this.mWebSocketFactory;
    }

    public boolean isSecure() {
        return this.mSecure;
    }

    public ProxySettings reset() {
        this.mSecure = false;
        this.mHost = null;
        this.mPort = -1;
        this.mId = null;
        this.mPassword = null;
        this.mHeaders.clear();
        return this;
    }

    public SocketFactory selectSocketFactory() {
        return this.mSocketFactorySettings.selectSocketFactory(this.mSecure);
    }

    public ProxySettings setCredentials(String str, String str2) {
        return setId(str).setPassword(str2);
    }

    public ProxySettings setHost(String str) {
        this.mHost = str;
        return this;
    }

    public ProxySettings setId(String str) {
        this.mId = str;
        return this;
    }

    public ProxySettings setPassword(String str) {
        this.mPassword = str;
        return this;
    }

    public ProxySettings setPort(int i) {
        this.mPort = i;
        return this;
    }

    public ProxySettings setSSLContext(SSLContext sSLContext) {
        this.mSocketFactorySettings.setSSLContext(sSLContext);
        return this;
    }

    public ProxySettings setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.mSocketFactorySettings.setSSLSocketFactory(sSLSocketFactory);
        return this;
    }

    public ProxySettings setSecure(boolean z) {
        this.mSecure = z;
        return this;
    }

    public ProxySettings setServer(String str) {
        return str == null ? this : setServer(URI.create(str));
    }

    public ProxySettings setSocketFactory(SocketFactory socketFactory) {
        this.mSocketFactorySettings.setSocketFactory(socketFactory);
        return this;
    }

    public ProxySettings setServer(URL url) {
        if (url == null) {
            return this;
        }
        try {
            return setServer(url.toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ProxySettings setServer(URI uri) {
        if (uri == null) {
            return this;
        }
        return setServer(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort());
    }

    private ProxySettings setServer(String str, String str2, String str3, int i) {
        setByScheme(str);
        setByUserInfo(str2);
        this.mHost = str3;
        this.mPort = i;
        return this;
    }
}
