package com.helpshift.websockets;

public class NoMoreFrameException extends WebSocketException {
    public static final long serialVersionUID = 1;

    public NoMoreFrameException() {
        super(WebSocketError.NO_MORE_FRAME, "No more WebSocket frame from the server.");
    }
}
