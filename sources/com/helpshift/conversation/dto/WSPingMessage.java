package com.helpshift.conversation.dto;

public class WSPingMessage implements WebSocketMessage {
    public final long pingWaitTimeMillis;

    public WSPingMessage(long j) {
        this.pingWaitTimeMillis = j;
    }
}
