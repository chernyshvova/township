package com.helpshift.common.platform.network;

public interface HTTPTransport {
    Response makeRequest(Request request);
}
