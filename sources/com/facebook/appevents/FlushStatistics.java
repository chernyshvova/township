package com.facebook.appevents;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlushStatistics.kt */
public final class FlushStatistics {
    public int numEvents;
    public FlushResult result = FlushResult.SUCCESS;

    public final int getNumEvents() {
        return this.numEvents;
    }

    public final FlushResult getResult() {
        return this.result;
    }

    public final void setNumEvents(int i) {
        this.numEvents = i;
    }

    public final void setResult(FlushResult flushResult) {
        Intrinsics.checkNotNullParameter(flushResult, "<set-?>");
        this.result = flushResult;
    }
}
