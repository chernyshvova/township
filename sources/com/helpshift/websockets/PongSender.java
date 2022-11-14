package com.helpshift.websockets;

public class PongSender extends PeriodicalFrameSender {
    public static final String TIMER_NAME = "PongSender";

    public PongSender(WebSocket webSocket, PayloadGenerator payloadGenerator) {
        super(webSocket, TIMER_NAME, payloadGenerator);
    }

    public WebSocketFrame createFrame(byte[] bArr) {
        return WebSocketFrame.createPongFrame(bArr);
    }
}
