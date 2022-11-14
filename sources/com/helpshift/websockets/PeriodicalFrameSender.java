package com.helpshift.websockets;

import java.util.Timer;
import java.util.TimerTask;

public abstract class PeriodicalFrameSender {
    public PayloadGenerator mGenerator;
    public long mInterval;
    public boolean mScheduled;
    public Timer mTimer;
    public final String mTimerName;
    public final WebSocket mWebSocket;

    public final class Task extends TimerTask {
        public Task() {
        }

        public void run() {
            PeriodicalFrameSender.this.doTask();
        }
    }

    public PeriodicalFrameSender(WebSocket webSocket, String str, PayloadGenerator payloadGenerator) {
        this.mWebSocket = webSocket;
        this.mTimerName = str;
        this.mGenerator = payloadGenerator;
    }

    private WebSocketFrame createFrame() {
        return createFrame(generatePayload());
    }

    private byte[] generatePayload() {
        PayloadGenerator payloadGenerator = this.mGenerator;
        if (payloadGenerator == null) {
            return null;
        }
        try {
            return payloadGenerator.generate();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean schedule(Timer timer, Task task, long j) {
        try {
            timer.schedule(task, j);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public abstract WebSocketFrame createFrame(byte[] bArr);

    public void doTask() {
        synchronized (this) {
            if (this.mInterval != 0) {
                if (this.mWebSocket.isOpen()) {
                    this.mWebSocket.sendFrame(createFrame());
                    this.mScheduled = schedule(this.mTimer, new Task(), this.mInterval);
                    return;
                }
            }
            this.mScheduled = false;
        }
    }

    public long getInterval() {
        long j;
        synchronized (this) {
            j = this.mInterval;
        }
        return j;
    }

    public PayloadGenerator getPayloadGenerator() {
        PayloadGenerator payloadGenerator;
        synchronized (this) {
            payloadGenerator = this.mGenerator;
        }
        return payloadGenerator;
    }

    public void setInterval(long j) {
        if (j < 0) {
            j = 0;
        }
        synchronized (this) {
            this.mInterval = j;
        }
        if (j != 0 && this.mWebSocket.isOpen()) {
            synchronized (this) {
                if (this.mTimer == null) {
                    this.mTimer = new Timer(this.mTimerName);
                }
                if (!this.mScheduled) {
                    this.mScheduled = schedule(this.mTimer, new Task(), j);
                }
            }
        }
    }

    public void setPayloadGenerator(PayloadGenerator payloadGenerator) {
        synchronized (this) {
            this.mGenerator = payloadGenerator;
        }
    }

    public void start() {
        setInterval(getInterval());
    }

    public void stop() {
        synchronized (this) {
            if (this.mTimer != null) {
                this.mScheduled = false;
                this.mTimer.cancel();
            }
        }
    }
}
