package com.helpshift.websockets;

public class PingSender extends PeriodicalFrameSender {
    public static final String TIMER_NAME = "PingSender";

    public PingSender(WebSocket webSocket, PayloadGenerator payloadGenerator) {
        super(webSocket, TIMER_NAME, payloadGenerator);
    }

    public WebSocketFrame createFrame(byte[] bArr) {
        return WebSocketFrame.createPingFrame(bArr);
    }
}
