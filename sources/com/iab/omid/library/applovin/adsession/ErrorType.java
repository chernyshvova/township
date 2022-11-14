package com.iab.omid.library.applovin.adsession;

public enum ErrorType {
    GENERIC("generic"),
    VIDEO("video");
    
    public final String errorType;

    /* access modifiers changed from: public */
    ErrorType(String str) {
        this.errorType = str;
    }

    public String toString() {
        return this.errorType;
    }
}
