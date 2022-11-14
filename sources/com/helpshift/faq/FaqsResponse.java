package com.helpshift.faq;

public final class FaqsResponse {
    public final Object response;
    public final int statusCode;

    public FaqsResponse(Object obj, int i) {
        this.response = obj;
        this.statusCode = i;
    }
}
