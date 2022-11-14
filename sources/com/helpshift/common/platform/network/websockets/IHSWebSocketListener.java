package com.helpshift.common.platform.network.websockets;

public interface IHSWebSocketListener {
    void onConnected(HSWebSocket hSWebSocket);

    void onDisconnected();

    void onError(HSWebSocket hSWebSocket, String str);

    void onMessage(HSWebSocket hSWebSocket, String str);
}
