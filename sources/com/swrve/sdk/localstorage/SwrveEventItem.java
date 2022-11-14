package com.swrve.sdk.localstorage;

public class SwrveEventItem {
    public static long eventCount;
    public String event;

    /* renamed from: id */
    public long f2794id;
    public String userId;

    public SwrveEventItem() {
        long j = eventCount;
        eventCount = 1 + j;
        this.f2794id = j;
    }
}
