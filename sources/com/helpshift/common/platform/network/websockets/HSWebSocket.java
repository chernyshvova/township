package com.helpshift.common.platform.network.websockets;

import com.helpshift.util.StringUtils;
import com.helpshift.websockets.WebSocket;
import com.helpshift.websockets.WebSocketException;
import com.helpshift.websockets.WebSocketFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HSWebSocket {
    public final IHSWebSocketListener listener;
    public final WebSocket mWebSocket;

    public static class Builder {
        public int connectionTimeout;
        public List<String> extensions = new ArrayList();
        public Map<String, String> headers = new HashMap();
        public IHSWebSocketListener listener;
        public List<String> protocols = new ArrayList();
        public int socketTimeout;
        public String url;

        public Builder(String str) {
            this.url = str;
        }

        public Builder addExtension(String str) {
            this.extensions.add(str);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            if (str2 != null && !StringUtils.isEmpty(str)) {
                this.headers.put(str, str2);
            }
            return this;
        }

        public Builder addProtocol(String str) {
            this.protocols.add(str);
            return this;
        }

        public HSWebSocket build() throws IOException {
            WebSocket createSocket = new WebSocketFactory().setConnectionTimeout(this.connectionTimeout).createSocket(this.url);
            createSocket.getSocket().setSoTimeout(this.socketTimeout);
            for (String addExtension : this.extensions) {
                createSocket.addExtension(addExtension);
            }
            for (String addProtocol : this.protocols) {
                createSocket.addProtocol(addProtocol);
            }
            for (String next : this.headers.keySet()) {
                createSocket.addHeader(next, this.headers.get(next));
            }
            return new HSWebSocket(createSocket, this.listener);
        }

        public Builder setConnectionTimeout(int i) {
            this.connectionTimeout = i;
            return this;
        }

        public Builder setSocketTimeout(int i) {
            this.socketTimeout = i;
            return this;
        }

        public Builder setWebSocketListener(IHSWebSocketListener iHSWebSocketListener) {
            this.listener = iHSWebSocketListener;
            return this;
        }
    }

    public HSWebSocket(WebSocket webSocket, IHSWebSocketListener iHSWebSocketListener) {
        this.mWebSocket = webSocket;
        this.listener = iHSWebSocketListener;
        webSocket.addListener(new NVWebSocketListenerImpl(this, iHSWebSocketListener));
    }

    public void connect() {
        try {
            this.mWebSocket.connect();
        } catch (WebSocketException e) {
            this.listener.onError(this, e.getMessage());
        }
    }

    public void disconnect() {
        this.mWebSocket.disconnect();
    }

    public void sendMessage(String str) {
        try {
            this.mWebSocket.sendText(str);
        } catch (Exception e) {
            this.listener.onError(this, e.getMessage());
        }
    }
}
