package com.helpshift.common.platform.network;

import java.util.Map;
import java.util.UUID;

public class RequestData {
    public final Map<String, String> body;
    public Map<String, String> customHeaders;
    public String requestId = UUID.randomUUID().toString();

    public RequestData(Map<String, String> map) {
        this.body = map;
    }

    public Map<String, String> getCustomHeaders() {
        return this.customHeaders;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void overrideRequestId(String str) {
        this.requestId = str;
    }

    public void setCustomHeaders(Map<String, String> map) {
        this.customHeaders = map;
    }

    public RequestData(RequestData requestData) {
        this.body = requestData.body;
        this.customHeaders = requestData.customHeaders;
    }
}
