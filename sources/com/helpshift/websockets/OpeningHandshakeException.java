package com.helpshift.websockets;

import java.util.List;
import java.util.Map;

public class OpeningHandshakeException extends WebSocketException {
    public static final long serialVersionUID = 1;
    public final byte[] mBody;
    public final Map<String, List<String>> mHeaders;
    public final StatusLine mStatusLine;

    public OpeningHandshakeException(WebSocketError webSocketError, String str, StatusLine statusLine, Map<String, List<String>> map) {
        this(webSocketError, str, statusLine, map, (byte[]) null);
    }

    public byte[] getBody() {
        return this.mBody;
    }

    public Map<String, List<String>> getHeaders() {
        return this.mHeaders;
    }

    public StatusLine getStatusLine() {
        return this.mStatusLine;
    }

    public OpeningHandshakeException(WebSocketError webSocketError, String str, StatusLine statusLine, Map<String, List<String>> map, byte[] bArr) {
        super(webSocketError, str);
        this.mStatusLine = statusLine;
        this.mHeaders = map;
        this.mBody = bArr;
    }
}
