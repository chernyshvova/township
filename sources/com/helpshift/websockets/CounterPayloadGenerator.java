package com.helpshift.websockets;

public class CounterPayloadGenerator implements PayloadGenerator {
    public long mCount;

    public byte[] generate() {
        long max = Math.max(this.mCount + 1, 1);
        this.mCount = max;
        return Misc.getBytesUTF8(String.valueOf(max));
    }
}
