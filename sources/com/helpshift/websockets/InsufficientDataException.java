package com.helpshift.websockets;

public class InsufficientDataException extends WebSocketException {
    public static final long serialVersionUID = 1;
    public final int mReadByteCount;
    public final int mRequestedByteCount;

    public InsufficientDataException(int i, int i2) {
        super(WebSocketError.INSUFFICENT_DATA, "The end of the stream has been reached unexpectedly.");
        this.mRequestedByteCount = i;
        this.mReadByteCount = i2;
    }

    public int getReadByteCount() {
        return this.mReadByteCount;
    }

    public int getRequestedByteCount() {
        return this.mRequestedByteCount;
    }
}
