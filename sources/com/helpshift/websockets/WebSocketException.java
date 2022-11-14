package com.helpshift.websockets;

public class WebSocketException extends Exception {
    public static final long serialVersionUID = 1;
    public final WebSocketError mError;

    public WebSocketException(WebSocketError webSocketError) {
        this.mError = webSocketError;
    }

    public WebSocketError getError() {
        return this.mError;
    }

    public WebSocketException(WebSocketError webSocketError, String str) {
        super(str);
        this.mError = webSocketError;
    }

    public WebSocketException(WebSocketError webSocketError, Throwable th) {
        super(th);
        this.mError = webSocketError;
    }

    public WebSocketException(WebSocketError webSocketError, String str, Throwable th) {
        super(str, th);
        this.mError = webSocketError;
    }
}
