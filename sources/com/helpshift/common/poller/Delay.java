package com.helpshift.common.poller;

import java.util.concurrent.TimeUnit;

public class Delay {
    public final long delay;
    public final TimeUnit timeUnit;

    public Delay(long j, TimeUnit timeUnit2) {
        this.delay = j;
        this.timeUnit = timeUnit2;
    }

    /* renamed from: of */
    public static Delay m3078of(long j, TimeUnit timeUnit2) {
        return new Delay(j, timeUnit2);
    }

    public String toString() {
        return this.delay + " " + this.timeUnit;
    }
}
