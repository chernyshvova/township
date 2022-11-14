package com.swrve.sdk.rest;

import java.util.List;
import java.util.Map;

public class RESTResponseLog {
    public final String body;
    public final int code;
    public final int eventsCount;
    public final String headers;
    public final int requestCount;
    public final long time;

    public RESTResponseLog(int i, int i2, int i3, long j, String str, Map<String, List<String>> map) {
        this.code = i;
        this.eventsCount = i2;
        this.requestCount = i3;
        this.time = j;
        if (str == null || str.length() <= 250) {
            this.body = str;
        } else {
            this.body = str.substring(0, 250);
        }
        if (map == null || map.toString().length() <= 250) {
            this.headers = map.toString();
        } else {
            this.headers = map.toString().substring(0, 250);
        }
    }
}
