package com.helpshift.websockets;

public abstract class WebSocketThread extends Thread {
    public final ThreadType mThreadType;
    public final WebSocket mWebSocket;

    public WebSocketThread(String str, WebSocket webSocket, ThreadType threadType) {
        super(str);
        this.mWebSocket = webSocket;
        this.mThreadType = threadType;
    }

    public void callOnThreadCreated() {
        ListenerManager listenerManager = this.mWebSocket.getListenerManager();
        if (listenerManager != null) {
            listenerManager.callOnThreadCreated(this.mThreadType, this);
        }
    }

    public void run() {
        ListenerManager listenerManager = this.mWebSocket.getListenerManager();
        if (listenerManager != null) {
            listenerManager.callOnThreadStarted(this.mThreadType, this);
        }
        runMain();
        if (listenerManager != null) {
            listenerManager.callOnThreadStopping(this.mThreadType, this);
        }
    }

    public abstract void runMain();
}
